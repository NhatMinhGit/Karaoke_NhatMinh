/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectdb.ConnectDB;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.LoaiPhong;
import entity.Phong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ad
 */
public class DichVu_DAO {
	public ArrayList<DichVu> getAllDichVu() throws SQLException
	{
            
		ArrayList<DichVu> dsDV = new ArrayList<DichVu>();
		
			//ket noi
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT DichVu.MaDichVu,DichVu.TenDichVu,DichVu.SoLuongDichVu, DichVu.GiaBan, DichVu.DonViTinh, DichVu.trangThaiDichVu, LoaiDichVu.TenLoaiDichVu \n" +
                        "FROM DichVu \n" +
                        "JOIN LoaiDichVu \n" +
                        "ON LoaiDichVu.MaLoaiDichVu = DichVu.MaLDV;";
			Statement stmt = con.createStatement();
			//Thuc thi cau lenh SQL tra ve doi tuong ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			//Duyet tren tung ket qua tra ve
			while(rs.next())
			{
                                String maDichVu = rs.getString(1);                                        
                                String tenDichVu = rs.getString(2);
                                int soLuongDV = rs.getInt(3);
                                double giaBan = rs.getDouble(4);
                                String donViTinh = rs.getString(5);
                                Boolean trangThaiDichVu = rs.getBoolean(6);
                                LoaiDichVu tenLoaiDV = new LoaiDichVu(rs.getString(7));
                                DichVu dv = new DichVu(maDichVu, tenDichVu, soLuongDV , giaBan, donViTinh,trangThaiDichVu,tenLoaiDV );
				dsDV.add(dv);
			}
            
            return dsDV;
	}
        public boolean themDichVu(DichVu x)
	{
		//ket noi ConnectDB
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n =0;
		String sql ="INSERT INTO DichVu(MaDichVu,TenDichVu,SoLuongDichVu,GiaBan,DonViTinh,trangThaiDichVu) VALUES(?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,x.getMaDV());
                        stmt.setString(2,x.getLoaiDV().getMaLoaiDV());
			stmt.setString(3, x.getTenDV());
			stmt.setInt(4, x.getSoLuong());
                        stmt.setDouble(5, x.getGiaBan());
			stmt.setString(6, x.getDonViTinh());
                        stmt.setBoolean(7, x.isTrangThaiDV());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
        }
        public ArrayList<DichVu> locDichVuTheoMaDV(String maDV)
		{
			ArrayList<DichVu> dsp = new ArrayList<DichVu>();
			//ket noi 
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "SELECT DichVu.MaDichVu,DichVu.TenDichVu,DichVu.SoLuongDichVu, DichVu.GiaBan, DichVu.DonViTinh, DichVu.trangThaiDichVu, LoaiDichVu.TenLoaiDichVu \n" +
                                "FROM DichVu \n" +
                                "JOIN LoaiDichVu \n" +
                                "ON LoaiDichVu.MaLoaiDichVu = DichVu.MaLDV WHERE DichVu.MaDichVu = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maDV);                          
				//thuc thi cau lenh sql tra ve doi tuong ResultSet
				ResultSet rs = stmt.executeQuery();
				//Duyet tren ket qua tra ve
				while(rs.next())
				{
					String maDichVu = rs.getString(1);                                        
                                        String tenDichVu = rs.getString(2);
                                        int soLuongDV = rs.getInt(3);
                                        double giaBan = rs.getDouble(4);
                                        String donViTinh = rs.getString(5);
					Boolean trangThaiDichVu = rs.getBoolean(6);
                                        LoaiDichVu tenLoaiDV = new LoaiDichVu(rs.getString(7));
					
					DichVu x = new DichVu(maDichVu,tenDichVu, soLuongDV,giaBan, donViTinh,trangThaiDichVu,tenLoaiDV);
					
					//them nv x vao dsnv
					dsp.add(x);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsp;
		}
        public ArrayList<DichVu> locDichVuTheoTenDV(String tenDV)
		{
			ArrayList<DichVu> dsp = new ArrayList<DichVu>();
			//ket noi 
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "SELECT DichVu.MaDichVu,DichVu.TenDichVu,DichVu.SoLuongDichVu, DichVu.GiaBan, DichVu.DonViTinh, DichVu.trangThaiDichVu, LoaiDichVu.TenLoaiDichVu \n" +
                                "FROM DichVu \n" +
                                "JOIN LoaiDichVu \n" +
                                "ON LoaiDichVu.MaLoaiDichVu = DichVu.MaLDV WHERE DichVu.TenDichVu = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, tenDV);                          
				//thuc thi cau lenh sql tra ve doi tuong ResultSet
				ResultSet rs = stmt.executeQuery();
				//Duyet tren ket qua tra ve
				while(rs.next())
				{
					String maDichVu = rs.getString(1);                                        
                                        String tenDichVu = rs.getString(2);
                                        int soLuongDV = rs.getInt(3);
                                        double giaBan = rs.getDouble(4);
                                        String donViTinh = rs.getString(5);
					Boolean trangThaiDichVu = rs.getBoolean(6);
                                        LoaiDichVu tenLoaiDV = new LoaiDichVu(rs.getString(7));
					
					DichVu x = new DichVu(maDichVu,tenDichVu, soLuongDV,giaBan, donViTinh,trangThaiDichVu,tenLoaiDV);
					
					//them nv x vao dsnv
					dsp.add(x);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsp;
		}
        public List<String> locDichVuTheoMaLDV(String tenLoaiDichVu) {
    List<String> dsTenDichVu = new ArrayList<String>();
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement stmt = null;
    try {
        String sql = "SELECT dv.TenDichVu " +
                     "FROM DichVu dv JOIN LoaiDichVu ldv ON dv.MaLDV = ldv.MaLoaiDichVu " +
                     "WHERE ldv.TenLoaiDichVu = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, tenLoaiDichVu);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            dsTenDichVu.add(rs.getString("TenDichVu"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    } 
    return dsTenDichVu;
}
        public ArrayList<DichVu> locDichVuTheoMaVaTenDV(String maDV,String tenDV)
		{
			ArrayList<DichVu> dsp = new ArrayList<DichVu>();
			//ket noi 
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			try {
				String sql = "SELECT DichVu.MaDichVu,DichVu.TenDichVu,DichVu.SoLuongDichVu, DichVu.GiaBan, DichVu.DonViTinh, DichVu.trangThaiDichVu, LoaiDichVu.MaLoaiDichVu, LoaiDichVu.TenLoaiDichVu \n" +
                                "FROM DichVu \n" +
                                "JOIN LoaiDichVu \n" +
                                "ON LoaiDichVu.MaLoaiDichVu = DichVu.MaLDV WHERE DichVu.MaDichVu = ? or DichVu.TenDichVu = ?";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, maDV);     
                                stmt.setString(2, tenDV); 
				//thuc thi cau lenh sql tra ve doi tuong ResultSet
				ResultSet rs = stmt.executeQuery();
				//Duyet tren ket qua tra ve
				while(rs.next())
				{
					String maDichVu = rs.getString("MaDichVu");                                        
                                        String tenDichVu = rs.getString("TenDichVu");
                                        int soLuongDV = rs.getInt("SoLuongDichVu");
                                        double giaBan = rs.getDouble("GiaBan");
                                        String donViTinh = rs.getString("DonViTinh");
					Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                                        String maLoaiDV = rs.getString("MaLoaiDichVu");
					String tenLoaiDV = rs.getString("TenLoaiDichVu");
                                                
                                        LoaiDichVu loaiDichVu = new LoaiDichVu(maLoaiDV, tenLoaiDV);
					DichVu x = new DichVu(maDichVu,tenDichVu, soLuongDV,giaBan, donViTinh,trangThaiDichVu,loaiDichVu);
					
					//them nv x vao dsnv
					dsp.add(x);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dsp;
		}
    public DichVu timDichVuTheoTen(String tenDV) {
        DichVu dichVu = null;
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection con = connectDB.getConnection();
        PreparedStatement stmt = null;
        String sql = "SELECT DichVu.MaDichVu,DichVu.TenDichVu,DichVu.SoLuongDichVu, DichVu.GiaBan, DichVu.DonViTinh, DichVu.trangThaiDichVu, LoaiDichVu.MaLoaiDichVu, LoaiDichVu.TenLoaiDichVu \n" +
"                                FROM DichVu \n" +
"                                JOIN LoaiDichVu \n" +
"                                ON LoaiDichVu.MaLoaiDichVu = DichVu.MaLDV WHERE DichVu.TenDichVu =?";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tenDV);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String maDichVu = rs.getString("MaDichVu");                                        
                String tenDichVu = rs.getString("TenDichVu");
                int soLuongDV = rs.getInt("SoLuongDichVu");
                double giaBan = rs.getDouble("GiaBan");
                String donViTinh = rs.getString("DonViTinh");
		Boolean trangThaiDichVu = rs.getBoolean("trangThaiDichVu");
                String maLoaiDV = rs.getString("MaLoaiDichVu");
		String tenLoaiDV = rs.getString("TenLoaiDichVu");
                                                
                LoaiDichVu loaiDichVu = new LoaiDichVu(maLoaiDV, tenLoaiDV);
		dichVu = new DichVu(maDichVu,tenDichVu, soLuongDV,giaBan, donViTinh,trangThaiDichVu,loaiDichVu);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        return dichVu;
    }
}
