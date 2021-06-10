package edu.wut.dbexp.Service.Impl;

import edu.wut.dbexp.Dao.BuyerDao;
import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.Dao.UserDao;
import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.User;
import edu.wut.dbexp.Service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zxcvbnm
 */

@Service
public class BuyerServiceImpl implements BuyerService {

    private BuyerDao buyerDao;


    @Autowired
    public BuyerServiceImpl(BuyerDao buyerDao) {
        this.buyerDao = buyerDao;
    }

    @Override
    public boolean buyGood(User user, Good good) {
        return buyerDao.buyGood(user,good);
    }
    @Override
    public boolean deleteLogger(String goodId) { return buyerDao.deleteLogger(goodId); }
}
