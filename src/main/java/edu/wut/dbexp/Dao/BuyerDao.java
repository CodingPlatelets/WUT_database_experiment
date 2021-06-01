package edu.wut.dbexp.Dao;

import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.User;

public interface BuyerDao {

    boolean buyGood(User user, Good good);

    boolean refundGood(User user,Good good);

    boolean deleteLogger(User user,Good good);
}
