package edu.wut.dbexp.Dao;

/**
 * @author wenka
 * @date 2021/5/2214:20
 */
public interface AdministratorDao {
    public boolean selectByUserName(String userName, String userPwd);
}
