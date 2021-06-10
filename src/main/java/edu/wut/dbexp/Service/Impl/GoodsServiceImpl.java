package edu.wut.dbexp.Service.Impl;


import edu.wut.dbexp.Dao.GoodsDao;
import edu.wut.dbexp.DataObject.Good;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.DataObject.User;
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
    public boolean insertGood(int goodAttributes) {
        goodsDao.insertGood(goodAttributes);
        return goodsDao.updateGoodStock(goodAttributes,goodsDao.searchGoods(goodAttributes).getStock()+1);
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

    @Override
    public Goods searchGoods(int goodsAttributes) {
        return goodsDao.searchGoods(goodsAttributes);
    }

    @Override
    public Good queryOneGoodByAttributes(int goodAttributes) {
        return goodsDao.queryOneGoodByAttributes(goodAttributes);
    }

    @Override
    public boolean refundGood(Good good) {
        return goodsDao.refundGood(good);
    }

    @Override
    public List<Good> getAllGood(){return goodsDao.getAllGood();}

}
