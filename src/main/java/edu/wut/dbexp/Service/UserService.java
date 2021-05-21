package edu.wut.dbexp.Service;

import edu.wut.dbexp.DataObject.User;

/**
 * @author wenkan
 * @date 2021/5/21 9:08
 */
public interface UserService {
     boolean addUser(User user);

     boolean updateUser(User user);

     boolean existUser(User user);

     boolean deleteUser(User user);
}
