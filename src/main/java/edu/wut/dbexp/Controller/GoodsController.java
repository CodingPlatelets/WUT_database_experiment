package edu.wut.dbexp.Controller;

import com.alibaba.fastjson.JSON;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Reponse.CommonReturnType;
import edu.wut.dbexp.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenka
 * @use 商品操作逻辑
 * @date 2021/5/219:07
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
     * @return
     */
    @PostMapping("/query/one")
    public CommonReturnType test(@RequestParam("goodsId")String goodsId){
        Goods goods = goodsService.searchGoods(goodsId);
        return  CommonReturnType.create(JSON.toJSONString(goods),"success");
    }
}

