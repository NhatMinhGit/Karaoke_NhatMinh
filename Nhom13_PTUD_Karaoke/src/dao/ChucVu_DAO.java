package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ChucVu;

public interface ChucVu_DAO extends Remote{
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	
	public List<ChucVu>	layDanhSachChucVu() throws RemoteException;
	public boolean themChucVu(ChucVu cv) throws RemoteException;
	public boolean capNhatChucVu(ChucVu cv) throws RemoteException;
	public ChucVu timChucVuTheoMa(String maChucVu) throws RemoteException;
}
