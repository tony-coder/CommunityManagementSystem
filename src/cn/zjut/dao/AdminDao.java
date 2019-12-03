package cn.zjut.dao;

import cn.zjut.bean.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao implements BaseDao {
    public Admin queryAdminPwd(String name) {
        String sql = "select * from admin where name =?";
        Admin admin = new Admin();
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            try (ResultSet rst = pstmt.executeQuery()) {
                if (rst.next()) {
                    admin.setId(rst.getString("id"));
                    admin.setName(rst.getString("name"));
                    admin.setPassword(rst.getString("password"));
                    conn.close();
                    return admin;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
