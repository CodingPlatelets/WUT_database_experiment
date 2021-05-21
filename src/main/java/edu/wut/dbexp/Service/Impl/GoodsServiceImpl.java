package edu.wut.dbexp.Service.Impl;

import com.alibaba.druid.pool.DruidDataSource;
import edu.wut.dbexp.DataObject.Goods;
import edu.wut.dbexp.Service.GoodsService;
import edu.wut.dbexp.Util.DruidUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public boolean addGoods(Goods goods) {
        DruidUtil druidUtil=new DruidUtil();
        Connection connection;
        try {
            connection=druidUtil.getConnecttion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql="insert into goods values(?,?,?,?,?)";
        Object param[]=new Object[]{
                goods.getGoodAttributes(),goods.getId(),
                goods.getStock(),goods.getDescription(),
                goods.getInStockDate()
        };
        int success=druidUtil.executeUpdate(sql,param);
        druidUtil.closeAll();
        if(success>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        return false;
    }

    @Override
    public Goods searchGoods(String id) {
        DruidUtil druidUtil=new DruidUtil();
        Connection connection;
        try {
            connection=druidUtil.getConnecttion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql="select * from goods where id="+id;
        ResultSet resultSet=druidUtil.executeQuery(sql,null);
        Goods goods = null;
        try {
            goods=new Goods(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getInt(3),resultSet.getString(4),
                    resultSet.getDate(5));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }

    @Override
    public List<Goods> allGoods() {
        List<Goods> allgoods=new ArrayList<>();
        DruidUtil druidUtil=new DruidUtil();
        Connection connection;
        try {
            connection=druidUtil.getConnecttion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql="select * from goods";
        ResultSet resultSet=druidUtil.executeQuery(sql,null);
        while(true) {
            try {
                if (!resultSet.next()) break;
                Goods goods=new Goods(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getString(4),
                        resultSet.getDate(5));
                allgoods.add(goods);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return allgoods;
    }

    @Override
    public List<Goods> selectedGoods(int num) {
        List<Goods> selectedgoods=new ArrayList<>();
        DruidUtil druidUtil=new DruidUtil();
        Connection connection;
        try {
            connection=druidUtil.getConnecttion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql="select * from goods where stock<"+num;
        ResultSet resultSet=druidUtil.executeQuery(sql,null);
        while(true) {
            try {
                if (!resultSet.next()) break;
                Goods goods=new Goods(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getString(4),
                        resultSet.getDate(5));
                selectedgoods.add(goods);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return selectedgoods;
    }
}
