/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectdb.ConnectDB;
import entity.LoaiDichVu;
import entity.LoaiPhong;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LoaiDichVu_DAO {
    public ArrayList<LoaiDichVu> layDanhSachLoaiDichVu() throws SQLException {
        ArrayList<LoaiDichVu> dsLDV = new ArrayList<>();
        ConnectDB.getConnection();
        Connection con = ConnectDB.getConnection();
        String sql = "SELECT * FROM LoaiDichVu";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            LoaiDichVu ldv = new LoaiDichVu();
            ldv.setMaLoaiDV(rs.getString(1));
            ldv.setTenLoaiDV(rs.getString(2));
            dsLDV.add(ldv);
        }
        return dsLDV;
    }
}
