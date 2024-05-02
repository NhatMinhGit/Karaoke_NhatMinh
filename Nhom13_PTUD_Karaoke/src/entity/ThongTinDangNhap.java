package entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ThongTinDangNhap implements Serializable {
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	private static String maNhanVien;
    private static String tenNhanVien;
	public static String getMaNhanVien() {
		return maNhanVien;
	}
	public static void setMaNhanVien(String maNhanVien) {
		ThongTinDangNhap.maNhanVien = maNhanVien;
	}
	public static String getTenNhanVien() {
		return tenNhanVien;
	}
	public static void setTenNhanVien(String tenNhanVien) {
		ThongTinDangNhap.tenNhanVien = tenNhanVien;
	}
    
    
}
