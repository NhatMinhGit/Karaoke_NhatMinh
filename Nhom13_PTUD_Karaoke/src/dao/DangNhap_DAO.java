package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DangNhap_DAO extends Remote{
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	public boolean kiemTraDangNhap(String soDienThoai, String matKhau) throws RemoteException;
	public String layChucVu(String soDienThoai, String matKhau) throws RemoteException;
	 public void layTenNhanVien(String soDienThoai, String matKhau)	throws RemoteException;
	 public void layMaNhanVien(String soDienThoai, String matKhau)	throws RemoteException;
}
