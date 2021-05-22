package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Dao.DruidUtil;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Goods;
import org.junit.Test;
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
import java.util.Map;

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
        String sql = "insert into goods (goodAttributes, goodsId, stock, description) values(?,?,?,?)";
        try {
            return jdbcTemplate.update(sql,
                    goods.getGoodAttributes(),
                    goods.getGoodsId(),
                    goods.getStock(),
                    goods.getDescription()) == 1;
        } catch (DataAccessException e) {
            return false;
        }
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
        try {
            return jdbcTemplate.query(
                    "select * from goods", new BeanPropertyRowMapper<>(Goods.class));
        } catch (DataAccessException dataAccessException) {
            return null;
        }
    }

    @Override
    public List<Goods> selectedByStock(int num) {
        try {
            return jdbcTemplate.query(
                    "select * from goods where stock< ?", new BeanPropertyRowMapper<>(Goods.class),num);
        } catch (DataAccessException dataAccessException) {
            return null;
        }
    }
}

