package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Dao.DruidUtil;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Goods;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

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

    private DruidUtil druidUtil;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodsDaoImpl(DruidUtil druidUtil, JdbcTemplate jdbcTemplate) {
        this.druidUtil = druidUtil;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean addGoods(Goods goods) {
        String sql = "insert into goods values(?,?,?,?,?)";
        Object[] param = new Object[]{
                goods.getGoodAttributes(), goods.getGoodsId(),
                goods.getStock(), goods.getDescription(),
                goods.getSaleDate()
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
    public Goods searchGoods(String goodsId) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from goods where goodsId=?",
                    new BeanPropertyRowMapper<>(Goods.class),
                    goodsId);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Goods> getAllGoods() {
//        List<Goods> allGoodsList = new ArrayList<>();
//        String sql = "select * from goods";
//        ResultSet resultSet = druidUtil.executeQuery(sql, null);
//        while (true) {
//            try {
//                if (!resultSet.next()) {
//                    break;
//                }
//                Goods goods = new Goods(resultSet.getInt(1), resultSet.getString(2),
//                        resultSet.getInt(3), resultSet.getString(4),
//                        resultSet.getDate(5));
//                allGoodsList.add(goods);
//            } catch (SQLException sqlException) {
//                sqlException.printStackTrace();
//            }
//        }
//        return allGoodsList;
        return null;
    }

    @Override
    public List<Goods> selectedByStock(int num) {
//        List<Goods> goodsList = new ArrayList<>();
//        String sql = "select * from goods where stock<?";
//        Object[] param = new Object[]{
//                num
//        };
//        ResultSet resultSet = druidUtil.executeQuery(sql, param);
//        while (true) {
//            try {
//                if (!resultSet.next()) {
//                    break;
//                }
//                Goods goods = new Goods(resultSet.getInt(1), resultSet.getString(2),
//                        resultSet.getInt(3), resultSet.getString(4),
//                        resultSet.getDate(5));
//                goodsList.add(goods);
//            } catch (SQLException sqlException) {
//                sqlException.printStackTrace();
//            }
//        }
//        return goodsList;
        return null;
    }
}

