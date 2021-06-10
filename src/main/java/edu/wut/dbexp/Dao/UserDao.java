package edu.wut.dbexp.Dao;

import edu.wut.dbexp.DataObject.User;

/**
 * @author wenka
 * @date 2021/5/219:12
 */
public interface UserDao {
    /***
     * 添加用户
     * @param user 添加的用户
     * @return 是否添加成功
     */
    boolean addUser(User user);

    /***
     * 更新用户信息
     * @param user 要修改的用户信息
     * @return 是否修改成功
     */
    boolean updateUser(User user);

    /***
     * 查询用户是否存在
     * @param id 用户id
     * @return 以id为id的用户是否存在
     */
    boolean existUser(String phoneNumber);

    /***
     * 删除指定id的用户
     * @param id 用户id
     * @return 是否成功删除
     */
    boolean deleteUser(String phoneNumber);

    /***
     * 根据用户id查找用户
     * @param id 用户id
     * @return id为该id的用户信息
     */
    User searchUser(String phoneNumber);

}
