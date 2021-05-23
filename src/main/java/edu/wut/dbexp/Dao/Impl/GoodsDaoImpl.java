package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Utils.DruidUtil;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wenkan
 * @date 2021/5/21 21:57
 */
@Repository("GoodsDao")
public class GoodsDaoImpl implements GoodsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GoodsDaoImpl(JdbcTemplate jdbcTemplate) {
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
        String sql = "insert into goods values(?,?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, goods.getGoodAttributes(),
                    goods.getGoodsId(),
                    goods.getStock(),
                    goods.getDescription(),
                    goods.getSaleStatus(),
                    goods.getSaleDate(),
                    goods.getReturnAvailable()) > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean deleteGoods(String goodsId) {
        String sql = "delete from goods where goodsId=?";
        try {
            return jdbcTemplate.update(sql, goodsId) > 0;
        } catch (DataAccessException e) {
            return false;
        }
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
                    "select * from goods where stock< ?", new BeanPropertyRowMapper<>(Goods.class), num);
        } catch (DataAccessException dataAccessException) {
            return null;
        }
    }
}

