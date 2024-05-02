/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectdb.ConnectDB;
import entity.LoaiPhong;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface LoaiPhong_DAO extends Remote{

 
    public List<LoaiPhong> layDanhSachLoaiPhong() throws RemoteException;
    public boolean themLoaiPhong(LoaiPhong x) throws RemoteException;
    public boolean capNhatLoaiPhong(LoaiPhong x) throws RemoteException;

}
