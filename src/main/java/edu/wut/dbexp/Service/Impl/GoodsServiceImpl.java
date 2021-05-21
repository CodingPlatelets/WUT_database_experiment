package edu.wut.dbexp.Service.Impl;


import edu.wut.dbexp.Dao.DruidUtil;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxx
 */
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
    public List<Goods> getAllGoods() {
        return null;
    }

    @Override
    public List<Goods> selectedByStock(int num) {
        return null;
    }
}
