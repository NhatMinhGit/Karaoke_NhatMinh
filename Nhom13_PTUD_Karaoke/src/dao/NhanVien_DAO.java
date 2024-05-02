package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import entity.NhanVien;

public interface NhanVien_DAO extends Remote{
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	public boolean themNhanVien(NhanVien x) throws RemoteException;
	public boolean capNhatNhanVien(NhanVien x)throws RemoteException;
	public NhanVien timNhanVienTheoMa(String maNhanVien) throws RemoteException;
	public List<NhanVien> timNhanVienTheoTen(String tenNhanVien) throws RemoteException;
	public List<NhanVien> timNhanVienTheoChucVu(String maChucVu) throws RemoteException;
	public List<NhanVien> layDanhSachNhanVien() throws RemoteException;
	
	
}
