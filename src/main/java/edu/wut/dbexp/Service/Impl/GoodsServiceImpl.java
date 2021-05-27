package edu.wut.dbexp.Service.Impl;


import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lxx
 */
@Service("UserService")
public class GoodsServiceImpl implements GoodsService {

    GoodsDao goodsDao;

    @Autowired
    public GoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addGoods(Goods[] goods) throws Exception {
        for (var good : goods) {
            if (!goodsDao.addGoods(good)) {
                return false;
            }
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateGoods(Goods goods) throws Exception {
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteGoods(Goods goods) throws Exception {
        return false;
    }

    @Override
    public Goods searchGoods(String id) {
        return goodsDao.searchGoods(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public List<Goods> selectedByStock(int num) {
        return goodsDao.selectedByStock(num);
    }
}
