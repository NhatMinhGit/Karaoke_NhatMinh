/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import connectdb.ConnectDB;
import dao.LoaiPhong_DAO;
import entity.LoaiPhong;
import entity.NhanVien;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author Admin
 */
public class LoaiPhongImpl extends UnicastRemoteObject implements LoaiPhong_DAO{
    
    private EntityManager em;

    public LoaiPhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("KaraokeMMM").createEntityManager();
    }
    
    
    
    public List<LoaiPhong> layDanhSachLoaiPhong() {
        EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			List<LoaiPhong> list = em.createNativeQuery("select * from LoaiPhong lp", LoaiPhong.class).getResultList();
			tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return null;	
    }

    public boolean themLoaiPhong(LoaiPhong loaiPhong) {
        EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(loaiPhong);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
    }

    public boolean capNhatLoaiPhong(LoaiPhong x) {
            EntityTransaction tx = em.getTransaction();
            try {
		tx.begin();
		String query = "UPDATE LoaiPhong lp SET lp.tenLoaiPhong = :tenLoaiPhong WHERE lp.maLoaiPhong = :maLoaiPhong";
		NativeQuery<LoaiPhong> lp = (NativeQuery<LoaiPhong>) em.createNativeQuery(query, LoaiPhong.class);
		lp.setParameter("maLoaiPhong", x.getMaLoaiPhong());
		lp.setParameter("tenLoaiPhong", x.getTenLoaiPhong());
		lp.executeUpdate();
		tx.commit();
		return true;
            } catch (Exception e) {
		tx.rollback();
		e.printStackTrace();
            }
            return false;
    }
}
