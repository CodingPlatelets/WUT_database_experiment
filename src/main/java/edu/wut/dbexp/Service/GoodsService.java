package edu.wut.dbexp.Service;

import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.Goods;

import java.util.List;

/**
 * @author wenkan
 * @date 2021/5/21 9:09
 */
public interface GoodsService {
    /**
     *This is a method for adding goods 添加某一类商品
     * @param goods 商品
     * @return 添加是否成功
     */
    boolean addGoods(Goods goods);

    /**
     *This is a method for updating goods 更新某一类商品的描述
     * @param goods 商品
     * @return 更新是否成功
     */
    boolean updateGoods(Goods goods);

    /**
     * 提供更新某一类商品的库存，只能后端调用，并且只有在good操作之后才会调用
     * @param goodId
     * @return
     */
    boolean deleteGood(String goodId);

    /**
     *This is a method for querying good 搜索某一个商品
     * @param goodId 商品独一无二的Id
     * @return 根据Id搜索到的货物
     */
    Good searchGood(String goodId);

    /**
     * 更新某一个商品的信息，更新属性，售出日期，售出状态，原始价格，是否卖出
     * @param good
     * @return
     */
    boolean updateGood(Good good);

    /**
     * 用于插入一个新的商品
     * @param good
     * @return
     */
    boolean insertGood(Good good);

    /**
     * This is a method for getting all goods
     * 获取全部货物
     * @return 全部货物
     */
    List<Goods> getAllGoods();

    /**
     *This is a method for getting goods whose stock is less than num
     * @param num 货物数量
     * @return 仓库中少于num件的货物种类信息
     */
    List<Goods> selectedByStock(int num);

    List<Good> getAllGoodFromAttribute(int attribute);

    Goods searchGoods(int goodsAttributes);


}
