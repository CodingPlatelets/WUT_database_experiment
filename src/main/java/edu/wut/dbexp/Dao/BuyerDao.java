package edu.wut.dbexp.Dao;

import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.User;

public interface BuyerDao {

    boolean buyGood(User user, Good good);

    boolean deleteLogger(String goodId);
}
