package edu.wut.dbexp.Service.Impl;

import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wenkan
 * @date 2021/5/21 13:15
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Override
    public boolean addGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        return false;
    }

    @Override
    public Goods searchGoods(String id) {
        return null;
    }

    @Override
    public List<Goods> allGoods() {
        return null;
    }

    @Override
    public List<Goods> selectedGoods(int num) {
        return null;
    }
}

