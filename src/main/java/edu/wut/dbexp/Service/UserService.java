package edu.wut.dbexp.Service;

import edu.wut.dbexp.DataObject.User;

/**
 * @author wenkan
 * @date 2021/5/21 9:08
 */
public interface UserService {
    /***
     * 添加用户
     * @param user 添加的用户信息
     * @return 是否添加成功
     */
    boolean addUser(User user) throws Exception;

    /***
     * 更新用户信息
     * @param user 更新的用户信息
     * @return 是否更新成功
     */
    boolean updateUser(User user) throws Exception;

    /***
     * 用户是否存在
     * @param id 用户id
     * @return 是否存在
     */
    boolean existUser(String id);

    /***
     * 删除用户
     * @param id 删除的用户id
     * @return 用户是否成功删除
     */
    boolean deleteUser(String phoneNumber);

    /***
     * 登录
     * @param userName 用户名
     * @param userPwd 密码
     * @return 登录是否成功
     */
    boolean login(String userName, String userPwd);

    /***
     * 使用id查找用户并返回用户信息
     * @param id 用户id
     * @return id为输入的id的用户信息
     */
    User searchUser(String phoneNumber);
}
