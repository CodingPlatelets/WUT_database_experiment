package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Dao.AdministratorDao;
import edu.wut.dbexp.DataObject.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author wenkan
 * @date 2021/5/22 14:23
 */
@Repository("AdministratorDao")
public class AdministratorDaoImpl implements AdministratorDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdministratorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean selectByUserName(String userName, String userPwd) {
        Administrator ad = null;
        try {
            ad = jdbcTemplate.queryForObject(
                    "select userName from Administrator where userName = ? And userPwd=? ",
                    new BeanPropertyRowMapper<>(Administrator.class), userName, userPwd);
        } catch (DataAccessException e) {
            System.out.println(e);
        }
        return ad != null;
    }
}

