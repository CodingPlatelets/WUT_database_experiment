package edu.wut.dbexp.Dao;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DruidUtil {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public Connection getConnecttion() throws SQLException {
        DruidDataSource dataSource=new DruidDataSource();
        try {
            conn=dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public int executeUpdate(String preparedSql, Object[] param) {
        int num = 0;
        try {
            this.pstmt = this.conn.prepareStatement(preparedSql);
            if (param != null) {
                for(int i = 1; i <= param.length; ++i) {
                    this.pstmt.setObject(i, param[i - 1]);
                }
            }
            num = this.pstmt.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return num;
    }

    public ResultSet executeQuery(String preparedSql, Object[] param) {
        try {
            this.pstmt = this.conn.prepareStatement(preparedSql);
            if (param != null) {
                for(int i = 1; i <= param.length; ++i) {
                    this.pstmt.setObject(i, param[i - 1]);
                }
            }
            this.rs = this.pstmt.executeQuery();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return this.rs;
    }
    public void closeAll() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException var4) {
                var4.printStackTrace();
            }
        }

        if (this.pstmt != null) {
            try {
                this.pstmt.close();
            } catch (SQLException var3) {
                var3.printStackTrace();
            }
        }

        if (this.rs != null) {
            try {
                this.rs.close();
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }

}
