package edu.wut.dbexp.Dao.Impl;

import edu.wut.dbexp.Dao.UserDao;
import edu.wut.dbexp.DataObject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author wenkan
 * @date 2021/5/22 14:34
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addUser(User user) {

        String sql = "insert into user values(?,?,?,?,?,?)";
        try {
            return jdbcTemplate.update(sql, user.getId(),
                    user.getUserName(),
                    user.getVipStatus(),
                    user.getBalance(),
                    user.getPhoneNumber(),
                    user.getGender()) > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        deleteUser(user.getId());
        return addUser(user);
    }

    @Override
    public boolean existUser(String phoneNumber) {
        return searchUser(phoneNumber) != null;
    }

    @Override
    public boolean deleteUser(String phoneNumber) {
        String sql = "delete from user where phoneNumber=?";
        try {
            return jdbcTemplate.update(sql, phoneNumber) > 0;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public User searchUser(String phoneNumber) {
        String sql = "select * from user where phoneNumber=?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), phoneNumber);
        } catch (DataAccessException e) {
            return null;
        }
    }
}

