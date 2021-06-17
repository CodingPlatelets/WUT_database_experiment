package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Dao.BuyerDao;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Repository("BuyerDao")
public class BuyerDaoImpl implements BuyerDao {

    private JdbcTemplate jdbcTemplate;
    private GoodsDao goodsDao;


    @Autowired
    public BuyerDaoImpl(JdbcTemplate jdbcTemplate, GoodsDao goodsDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.goodsDao = goodsDao;
    }

    @Override
    public boolean buyGood(User user, Good good) {
        if(user!=null) {
            String sql = "insert into logger values(?,?)";
            try{
                return jdbcTemplate.update(sql,user.getId(),good.getGoodId())== 1;
            }
            catch (DataAccessException e){
                return false;
            }
        }
        else {
            String sql = "insert into logger values(?,?)";
            try {
                return jdbcTemplate.update(sql, null, good.getGoodId()) == 1;
            } catch (DataAccessException e) {
                return false;
            }

        }
    }



    @Override
    public boolean deleteLogger(String goodId) {
        String sql="delete from logger where goodId=?";
        try{
            return jdbcTemplate.update(sql,goodId)==1;
        }
        catch (DataAccessException e){
            return false;
        }
    }

}
