package edu.wut.dbexp.Service.Impl;

import edu.wut.dbexp.Dao.AdministratorDao;
import edu.wut.dbexp.Dao.UserDao;
import edu.wut.dbexp.DataObject.User;
import edu.wut.dbexp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenkan
 * @date 2021/5/21 13:15
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final AdministratorDao administratorDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, AdministratorDao administratorDao) {
        this.userDao = userDao;
        this.administratorDao = administratorDao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(User user) throws Exception{
        return userDao.addUser(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUser(User user) throws Exception{
        return userDao.updateUser(user);
    }

    @Override
    public boolean existUser(String phoneNumber) {
        return userDao.existUser(phoneNumber);
    }

    @Override
    public boolean deleteUser(String phoneNumber) {
        return userDao.deleteUser(phoneNumber);
    }

    @Override
    public boolean login(String userName, String userPwd) {
        return administratorDao.selectByUserName(userName, userPwd);
    }

    @Override
    public User searchUser(String phoneNumber) {
        return userDao.searchUser(phoneNumber);
    }
}

