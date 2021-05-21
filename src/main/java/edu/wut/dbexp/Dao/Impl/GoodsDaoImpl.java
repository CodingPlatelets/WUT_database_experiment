package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Dao.DruidUtil;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wenkan
 * @date 2021/5/21 21:57
 */
@Repository("GoodsDao")
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    DruidUtil druidUtil;

    @Override
    public boolean addGoods(Goods goods) {
        String sql = "insert into goods values(?,?,?,?,?)";
        Object[] param = new Object[]{
                goods.getGoodAttributes(), goods.getId(),
                goods.getStock(), goods.getDescription(),
                goods.getInStockDate()
        };
        int success = druidUtil.executeUpdate(sql, param);
        druidUtil.closeAll();
        return success > 0;
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
        String sql = "select * from goods where id=?";
        Object[] param = new Object[]{
                id
        };
        ResultSet resultSet = druidUtil.executeQuery(sql, param);
        Goods goods = null;
        try {
            goods = new Goods(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getInt(3), resultSet.getString(4),
                    resultSet.getDate(5));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return goods;
    }

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> allGoodsList = new ArrayList<>();
        String sql = "select * from goods";
        ResultSet resultSet = druidUtil.executeQuery(sql, null);
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }
                Goods goods = new Goods(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getDate(5));
                allGoodsList.add(goods);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return allGoodsList;
    }

    @Override
    public List<Goods> selectedByStock(int num) {
        List<Goods> goodsList = new ArrayList<>();
        String sql = "select * from goods where stock<?";
        Object[] param = new Object[]{
                num
        };
        ResultSet resultSet = druidUtil.executeQuery(sql, param);
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }
                Goods goods = new Goods(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getDate(5));
                goodsList.add(goods);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return goodsList;
    }
}

