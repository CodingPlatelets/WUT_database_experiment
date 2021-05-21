package edu.wut.dbexp.Dao;

import edu.wut.dbexp.DataObject.Goods;

import java.util.List;

/**
 * @author wenka
 * @date 2021/5/219:12
 */
public interface GoodsDao {
    /**
     *This is a method for adding goods
     * @param goods 商品
     * @return 添加是否成功
     */
    boolean addGoods(Goods goods);

    /**
     *This is a method for updating goods
     * @param goods 商品
     * @return 更新是否成功
     */
    boolean updateGoods(Goods goods);

    /**
     *This is a method for deleting goods
     * @param goods 商品
     * @return 删除是否成功
     */
    boolean deleteGoods(Goods goods);

    /**
     *This is a method for querying goods
     * @param goodsId 商品独一无二的Id
     * @return 根据Id搜索到的货物
     */
    Goods searchGoods(String goodsId);

    /**
     * This is a method for getting all goods
     * 获取全部货物
     * @return 全部货物
     */
    List<Goods> getAllGoods();

    /**
     *This is a method for getting goods whose stock is less than num
     * @param num
     * @return 仓库中少于num件的货物信息
     */
    List<Goods> selectedByStock(int num);
}

