/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Admin
 */

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.ChucVu_DAO;
import dao.DangNhap_DAO;
import dao.NhanVien_DAO;
import dao.Impl.ChucVuImpl;
import dao.Impl.DangNhapImpl;
import dao.Impl.NhanVienImpl;
import entity.ChucVu;
import entity.NhanVien;
import java.sql.SQLException;
public class Server {
	public static void main(String[] args) throws IOException, NamingException, SQLException{
		ChucVu cv = new ChucVu("QL","Quan ly");
		NhanVien nv = new NhanVien("NV1",cv,"Huynh Cong Vuong","Nam","24/09/2003","0867723677","Binh Dinh","123456");
		
		
		Hashtable<String, String> env = new Hashtable<String, String>();
	    env.put("java.security.policy", "rmi/policy.policy");
		LocateRegistry.createRegistry(2024);
		System.out.println("Server started on port 2024.");
		Context ctx = new InitialContext(env);
		NhanVien_DAO nhanVienDao = new NhanVienImpl();
		ChucVu_DAO chucVuDao = new ChucVuImpl();
		DangNhap_DAO dangNhapDao = new DangNhapImpl();
		
		ctx.bind("rmi://localhost:2024/nhanVien", nhanVienDao);
		ctx.bind("rmi://localhost:2024/chucVu", chucVuDao);
		ctx.bind("rmi://localhost:2024/dangNhap", dangNhapDao);
		if(nhanVienDao.layDanhSachNhanVien().size() == 0)
		{
			nhanVienDao.themNhanVien(nv);
		}
		
		System.out.println("Connected to server");
	}
}
