package edu.wut.dbexp.Controller;

import com.alibaba.fastjson.JSON;
import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.DataObject.User;
import edu.wut.dbexp.Error.EmBusinessError;
import edu.wut.dbexp.Reponse.CommonReturnType;
import edu.wut.dbexp.Service.BuyerService;
import edu.wut.dbexp.Service.GoodsService;
import edu.wut.dbexp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zxcvbnm
 */
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    private final GoodsService goodsService;
    private final BuyerService buyerService;
    private final UserService userService;

    @Autowired
    public BuyerController(GoodsService goodsService, BuyerService buyerService, UserService userService) {
        this.goodsService = goodsService;
        this.buyerService = buyerService;
        this.userService = userService;
    }

    @Transactional
    @PostMapping("/buy")
    public CommonReturnType buyGood(@RequestParam("goodId")  String goodId,
                                    @RequestParam("phoneNumber") String phoneNumber,
                                    @RequestParam("price") double price
                                    ) throws Exception {
        User user=userService.searchUser(phoneNumber);
        Good good=goodsService.searchGood(goodId);
        if(goodsService.searchGood(goodId) == null){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"This good is not exist");
        }
        if(!userService.existUser(phoneNumber)){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"user is not exist");
        }
        if(user.getBalance()<price){
            return  CommonReturnType.create(EmBusinessError.LACK_INFO,"balance is not enough");
        }
        double expense = price*Math.max(1-user.getVipStatus()*1.0/10000,0.8);
        user.setBalance(user.getBalance()-expense);
        user.setVipStatus(user.getVipStatus()+(int)expense);
        userService.updateUser(user);
        if(buyerService.buyGood(user,good)){
            good.setSalePrice(expense);
            good.setIsSale(true);
            good.setSaleDate(new Timestamp(System.currentTimeMillis()));
            goodsService.updateGood(good);
            Goods goods = goodsService.searchGoods(good.getGoodAttributes());
            goods.setStock(goods.getStock()-1);
            goodsService.updateGoods(goods);
            return CommonReturnType.create(expense,"success");
        }
        else{
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"fail");
        }
    }

    @Transactional
    @PostMapping("/buyNoVip")
    public CommonReturnType buyGoodNonVip(@RequestParam("goodId")  String goodId,
                                    @RequestParam("price") double price
    ) throws Exception {
        Good good = goodsService.searchGood(goodId);
        if (buyerService.buyGood(null, good)) {
            good.setSalePrice(price);
            good.setIsSale(true);
            good.setSaleDate(new Timestamp(System.currentTimeMillis()));
            goodsService.updateGood(good);
            Goods goods = goodsService.searchGoods(good.getGoodAttributes());
            goods.setStock(goods.getStock() - 1);
            goodsService.updateGoods(goods);
            return CommonReturnType.create(price, "success");
        } else {
            return CommonReturnType.create(EmBusinessError.LACK_INFO, "fail");
        }
    }
    @RequestMapping("/refund")
    public CommonReturnType refund(@RequestParam("goodId")  String goodId,
                                   @RequestParam("phoneNumber") String phoneNumber
                                   ) throws Exception {

        if(goodsService.searchGood(goodId) == null){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"This good is not exist");
        }
        if(!userService.existUser(phoneNumber)){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"user is not exist");
        }
        Good good = goodsService.searchGood(goodId);
        User user = userService.searchUser(phoneNumber);
        if(buyerService.deleteLogger(goodId)){
            double expense=goodsService.searchGood(goodId).getSalePrice();
            user.setBalance(user.getBalance()+expense);
            user.setVipStatus(user.getVipStatus()-(int)expense);
            userService.updateUser(user);
            good.setIsSale(false);
            goodsService.updateGood(good);
            Goods goods = goodsService.searchGoods(good.getGoodAttributes());
            goods.setStock(goods.getStock()+1);
            goodsService.updateGoods(goods);
            return CommonReturnType.create(null,"success");
        }
        else {
            return CommonReturnType.create(EmBusinessError.LACK_INFO, "fail");
        }
    }

    @RequestMapping("/refundNoVip")
    public CommonReturnType refundNoVip(@RequestParam("goodId")  String goodId) throws Exception {

        if(goodsService.searchGood(goodId) == null){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"This good is not exist");
        }
        Good good = goodsService.searchGood(goodId);
        if(buyerService.deleteLogger(goodId)){
            double expense=goodsService.searchGood(goodId).getSalePrice();
            good.setIsSale(false);
            goodsService.updateGood(good);
            Goods goods = goodsService.searchGoods(good.getGoodAttributes());
            goods.setStock(goods.getStock()+1);
            goodsService.updateGoods(goods);
            return CommonReturnType.create(null,"success");
        }
        else {
            return CommonReturnType.create(EmBusinessError.LACK_INFO, "fail");
        }
    }

    @RequestMapping("/turnover")
    public CommonReturnType turnover(@RequestParam("date") Long date){
        List<Good> allGood = goodsService.getAllGood();
        List<Good> goods=new ArrayList<>();
        for(int i=0;i<allGood.size();++i){
            if(date<allGood.get(i).getSaleDate().getTime()){
                goods.add(allGood.get(i));
            }
        }
        return CommonReturnType.create(JSON.toJSONString(goods),"success");
    }
}
