package edu.wut.dbexp.Service;

import edu.wut.dbexp.DataObject.Goods;

import java.util.List;

/**
 * @author wenka
 * @date 2021/5/219:09
 */
public interface GoodsService {
    boolean addGoods(Goods goods);

    boolean updateGoods(Goods goods);

    boolean deleteGoods(Goods goods);

    Goods searchGoods(String id);      //通过货物编号查找相应货物信息并返回

    List<Goods> allGoods();

    List<Goods> selectedGoods(int num); //返回仓库中少于num件的货物信息
}
