package edu.wut.dbexp.Service;

/**
 * @author wenka
 * @date 2021/5/219:08
 */
public interface UserService {
     boolean addUser(User user);

     boolean updateUser(User user);

     boolean existUser(User user);

     boolean deleteUser(User user);
}
