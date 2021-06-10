package edu.wut.dbexp.Controller;

import com.alibaba.fastjson.JSON;
import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Error.EmBusinessError;
import edu.wut.dbexp.Reponse.CommonReturnType;
import edu.wut.dbexp.Service.GoodsService;
import edu.wut.dbexp.Utils.IdUtils;
import edu.wut.dbexp.Utils.MathUtils;
import io.swagger.v3.core.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wenkan
 * @use 商品操作逻辑
 * @date 2021/5/21 9:07
 */
@RestController
@RequestMapping(value = "dbexp/goods")
@CrossOrigin
public class GoodsController {

    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 查询某个商品
     *
     * @return 返回某个商品信息
     */
    @PostMapping("/query/good")
    public CommonReturnType queryForOneGood(@RequestParam("goodId") String goodId) {
        Good good = goodsService.searchGood(goodId);
        if(goodsService.refundGood(good)&&good.getIsSale()){
            good.setCanRefund(true);
        }
        else{
            good.setCanRefund(false);
        }
        return CommonReturnType.create(JSON.toJSONString(good), "success");
    }

    @PostMapping("/query/goodByAttributes")
    public CommonReturnType queryGoodByAttributes(@RequestParam("goodAttributes") int goodAttributes){
        if(goodsService.queryOneGoodByAttributes(goodAttributes)!=null){
            String goodStr = JSON.toJSONString(goodsService.queryOneGoodByAttributes(goodAttributes));
            String goodsStr = JSON.toJSONString(goodsService.searchGoods(goodAttributes));
            return CommonReturnType.create(goodStr,"success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO,"fail");
    }
    
    @GetMapping("/query/all/goods")
    public CommonReturnType queryForAllGoods() {
        if (goodsService.getAllGoods() != null) {
            return CommonReturnType.create(JSON.toJSONString(goodsService.getAllGoods()), "success");
        } else {
            return CommonReturnType.create(EmBusinessError.UNKNOWN_ERROR, "unKnownError");
        }
    }
    @PostMapping("/query/all/good")
    public CommonReturnType queryFromAttribute(@RequestParam("attribute") int attribute){
        return goodsService.getAllGoodFromAttribute(attribute) != null ?
                CommonReturnType.create(goodsService.getAllGoodFromAttribute(attribute),"success") :
                CommonReturnType.create(EmBusinessError.PARAMETER_VALIDATION_ERROR,"no such attribute");
    }

    @PostMapping("/query/stock")
    public CommonReturnType queryByStock(@RequestParam("numbers") int num) {
        if (goodsService.selectedByStock(num) != null) {
            return CommonReturnType.create(JSON.toJSONString(goodsService.selectedByStock(num)), "success");
        } else {
            return CommonReturnType.create(EmBusinessError.UNKNOWN_ERROR, "unKnownError");
        }
    }

    @PostMapping("/query/goods")
    public CommonReturnType queryGoods(@RequestParam("goodAttributes") int goodAttributes){
        if(goodsService.searchGoods(goodAttributes)!=null){
            return CommonReturnType.create(JSON.toJSONString(goodsService.searchGoods(goodAttributes)),"success");
        }
        else{
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"goods don't exist");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/add/goods")
    public CommonReturnType addGood(@RequestParam("goodAttributes") Integer goodAttributes,
                                    @RequestParam("originPrice") double originPrice,
                                    @RequestParam("description") String description,
                                    @RequestParam("stock") int stock) throws Exception {

        Goods goods = new Goods();
        goods.setGoodAttributes(goodAttributes);
        goods.setDescription(description);
        goods.setOriginPrice(originPrice);
        goods.setStock(0);


        if (goodsService.addGoods(goods)) {
            for (int i=0 ; i<stock ; ++i){
                goodsService.insertGood(goodAttributes);
            }
            return CommonReturnType.create(null, "success");
        } else {
            return CommonReturnType.create(EmBusinessError.LACK_INFO, "check your data");
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/update/good")
    public CommonReturnType updateGood(@RequestParam("goodAttributes") Integer goodAttributes,
                                       @RequestParam("saleDate") Timestamp saleDate
                                       )throws Exception {
        String goodId = IdUtils.getPrimaryKey();
        Good good = new Good();
        good.setGoodAttributes(goodAttributes);
        good.setGoodId(goodId);
        good.setSaleDate(saleDate);
        if (goodsService.updateGood(good)) {
            return CommonReturnType.create(null, "success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO, "update goods failed");
    }

    @PostMapping("/update/goods")
    public CommonReturnType updateGoods(@RequestParam("goodAttributes") int goodAttributes,
                                        @RequestParam("description") String description,
                                        @RequestParam("stock") int stock,
                                        @RequestParam("originPrice") double originPrice){
        if(stock<goodsService.searchGoods(goodAttributes).getStock()){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"error");
        }
        int oldStock=goodsService.searchGoods(goodAttributes).getStock();
        Goods goods=new Goods(goodAttributes,stock,originPrice,description);
        if(goodsService.updateGoods(goods)){
            for (int i=oldStock;i<stock;++i){
                goodsService.insertGood(goodAttributes);
            }
            return CommonReturnType.create(null,"success");
        }
        return CommonReturnType.create(EmBusinessError.LACK_INFO,"fail");
    }
}

