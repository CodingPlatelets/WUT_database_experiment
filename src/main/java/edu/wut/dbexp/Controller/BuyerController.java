package edu.wut.dbexp.Controller;

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

import java.sql.Timestamp;

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
                                    @RequestParam("id") String id,
                                    @RequestParam("price") double price
                                    ) throws Exception {
        User user=userService.searchUser(id);
        Good good=goodsService.searchGood(goodId);
        if(goodsService.searchGood(goodId) == null){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"This good is not exist");
        }
        if(!userService.existUser(id)){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"user is not exist");
        }
        if(user.getBalance()<price){
            return  CommonReturnType.create(EmBusinessError.LACK_INFO,"balance is not enough");
        }
        user.setBalance(user.getBalance()-price);
        userService.updateUser(user);
        if(buyerService.buyGood(user,good)){
            good.setSale(true);
            goodsService.updateGood(good);
            Goods goods = goodsService.searchGoods(good.getGoodAttributes());
            goods.setStock(goods.getStock()-1);
            goodsService.updateGoods(goods);
            return CommonReturnType.create(price,"success");
        }
        else{
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"fail");
        }
    }

    @RequestMapping("/refund")
    public CommonReturnType refund(@RequestParam("goodId")  String goodId,
                                   @RequestParam("goodAttributes") Integer goodAttributes,
                                   @RequestParam("saleStatus") Boolean saleStatus,
                                   @RequestParam("saleDate") Timestamp saleDate,
                                   @RequestParam("isSale") boolean isSale,
                                   @RequestParam("originPrice") double originPrice,
                                   @RequestParam("id") String id,
                                   @RequestParam("username") String username,
                                   @RequestParam("vipStatus") int vipStatus,
                                   @RequestParam("balance") double balance,
                                   @RequestParam("phoneNumber") String phoneNumber,
                                   @RequestParam("gender") int gender) throws Exception {
        Good good = new Good(goodId, goodAttributes, saleDate, isSale);
        User user = new User(id, username, vipStatus, balance, phoneNumber, gender);
        if(goodsService.searchGood(goodId) == null){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"This good is not exist");
        }
        if(!userService.existUser(id)){
            return CommonReturnType.create(EmBusinessError.LACK_INFO,"user is not exist");
        }
        if(buyerService.refundGood(user,good)){
            user.setBalance(user.getBalance()+goodsService.searchGoods(goodAttributes).getOriginPrice());
            userService.updateUser(user);
            good.setSale(false);
            goodsService.updateGood(good);
            Goods goods = goodsService.searchGoods(goodAttributes);
            goods.setStock(goods.getStock()+1);
            goodsService.updateGoods(goods);
            return CommonReturnType.create(null,"success");
        }
        else {
            return CommonReturnType.create(EmBusinessError.LACK_INFO, "fail");
        }
    }
}
