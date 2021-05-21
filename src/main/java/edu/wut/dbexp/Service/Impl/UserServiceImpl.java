package edu.wut.dbexp.Service.Impl;

import edu.wut.dbexp.DataObject.User;
import edu.wut.dbexp.Service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wenkan
 * @date 2021/5/21 13:15
 */
@Service
public class UserServiceImpl implements UserService {
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
}

