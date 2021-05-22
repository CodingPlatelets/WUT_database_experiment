package edu.wut.dbexp.Service.Impl;

import edu.wut.dbexp.Dao.AdministratorDao;
import edu.wut.dbexp.Dao.UserDao;
import edu.wut.dbexp.DataObject.User;
import edu.wut.dbexp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenkan
 * @date 2021/5/21 13:15
 */
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private AdministratorDao administratorDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, AdministratorDao administratorDao) {
        this.userDao = userDao;
        this.administratorDao = administratorDao;
    }




    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean existUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean login(String userName, String userPwd) {
        return administratorDao.selectByUserName(userName,userPwd);
    }
}

