package edu.wut.dbexp.Service;


import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.User;

public interface BuyerService {
    /***
     * user buy good
     * @param user
     * @param good
     * @return success or fail
     */
    boolean buyGood(User user, Good good);

    boolean refundGood(User user,Good good);
}
