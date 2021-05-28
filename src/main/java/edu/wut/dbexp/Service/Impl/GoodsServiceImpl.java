package edu.wut.dbexp.Service.Impl;


import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lxx
 */
@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    GoodsDao goodsDao;

    @Autowired
    public GoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteGood(String goodId) {
        return goodsDao.deleteGood(goodId);
    }

    @Override
    public Good searchGood(String goodId) {
        return goodsDao.searchGood(goodId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateGood(Good good) {
        return goodsDao.updateGood(good);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertGood(Good good) {
        goodsDao.insertGood(good);
        return goodsDao.updateGoodStock(good.getGoodAttributes(),goodsDao.searchGoods(good.getGoodAttributes()).getStock()+1);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    @Override
    public List<Goods> selectedByStock(int num) {
        return goodsDao.selectedByStock(num);
    }

    @Override
    public List<Good> getAllGoodFromAttribute(int attribute) {
        return goodsDao.getAllGoodFromAttribute(attribute);
    }
}
