
package dao;

import connectdb.ConnectDB;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author ad
 */

public interface PhieuDatPhong_DAO extends Remote{

        public List<PhieuDatPhong> layDanhSachNhanVien() throws RemoteException;
        public boolean themPhieuDatPhong(PhieuDatPhong phieuDatPhong) throws RemoteException;
        public boolean capNhatPhieuDatPhong(PhieuDatPhong x) throws RemoteException;
        public PhieuDatPhong layPhieuDatPhongChuaThanhToan(String trangThaiPhieu) throws RemoteException;
        public PhieuDatPhong layPhieuDatPhongDatTruoc(String trangThaiPhieu) throws RemoteException;
        public boolean themPhieuDatPhongTruoc(PhieuDatPhong x) throws RemoteException;
        public boolean huyPhieuDatPhong(PhieuDatPhong x) throws RemoteException;
        public Phong timMaPhieuDatPhongTheoMaPhong(String maPhieuDatPhong,String maPhong) throws RemoteException;          
           
}
