package edu.wut.dbexp.Utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DruidUtil {


    private DruidDataSource dataSource;

    @Autowired
    public DruidUtil(DruidDataSource dataSource) {
        this.dataSource = dataSource;
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Connection getConnecttion() {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public int executeUpdate(String preparedSql, Object[] param) {
        int num = 0;
        try {
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 1; i <= param.length; ++i) {
                    pstmt.setObject(i, param[i - 1]);
                }
            }
            num = pstmt.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return num;
    }

    public ResultSet executeQuery(String preparedSql, Object[] param) {
        try {
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 1; i <= param.length; ++i) {
                    pstmt.setObject(i, param[i - 1]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return this.rs;
    }

    public void closeAll() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException var3) {
                var3.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

}
