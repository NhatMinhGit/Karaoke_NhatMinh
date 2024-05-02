
package UI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import connectdb.ConnectDB;
import dao.CTDichVu_DAO;
import dao.CTHoaDon_DAO;
import dao.DichVu_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.KhuyenMai_DAO;
import dao.LoaiDichVu_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.CT_DichVu;
import entity.CT_HoaDon;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.LoaiDichVu;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class GUILapHoaDon extends javax.swing.JFrame {
    Phong_DAO phong_dao = new Phong_DAO();
    KhachHang_DAO khachHang_dao = new KhachHang_DAO();
    KhuyenMai_DAO khuyenMai_dao = new KhuyenMai_DAO();
    DichVu_DAO dichVu_dao = new DichVu_DAO();
    LoaiDichVu_DAO loaiDichVu_dao = new LoaiDichVu_DAO();
    HoaDon_DAO hoaDon_dao = new HoaDon_DAO();
    PhieuDatPhong_DAO phieuDatPhong_dao = new PhieuDatPhong_DAO();
    CTDichVu_DAO ctDichVu_dao = new CTDichVu_DAO();
    CTHoaDon_DAO ctHoaDon_dao = new CTHoaDon_DAO();
    DefaultTableModel dftblHoaDon, dftblChiTiet, dftblDichVu;
    
    public GUILapHoaDon() {
        try {
            ConnectDB.getInstance().connect();
	} catch (SQLException e) {
            e.printStackTrace();
	}
        initComponents();
        setSize(1520, 780);
        setLocationRelativeTo(null);
        dlgHoaDon.setLocationRelativeTo(null);
        Time();
        Date();
    }

    private void Time() {
        new Thread(){
            public void run(){
                while (true) {                    
                    Calendar now = Calendar.getInstance();
                    int h = now.get(Calendar.HOUR_OF_DAY);
                    int m = now.get(Calendar.MINUTE);
                    int s = now.get(Calendar.SECOND);
                    lblTime.setText(h + ":" + m + ":" + s);
                }
            }   
        }.start();
    }
    
    private void Date() {
        new Thread(){
            public void run(){
                while (true) {                    
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date currentDate = new Date();
                    lblDate.setText(df.format(currentDate));
                }
            }   
        }.start();
    }
        
    public void docDuLieuTuDataVaoBangPhong() throws SQLException {  
        DefaultTableModel modelDSP = (DefaultTableModel) tblDanhSachPhong.getModel();
        ArrayList<PhieuDatPhong> listPDP = phieuDatPhong_dao.layPhieuDatPhongChuaThanhToan();
        modelDSP.setRowCount(0);
        for (PhieuDatPhong x : listPDP) {
            modelDSP.addRow(new Object[] {
                x.getPhong().getMaPhong(),
                x.getPhong().getTenPhong(),
                x.getPhong().getLoaiPhong().getTenLoaiPhong(),
                x.getPhong().getGiaPhong(),
                x.getGioNhanPhong(),
                x.getKhachHang().getTenKhachHang(),
                x.getNhanVien().getTenNhanVien()
            });
        }
    }
    
    private void layDuLieuLenCbTenDichVu() throws SQLException {
		List<DichVu> dv = dichVu_dao.getAllDichVu();
		for (DichVu x : dv) {
			cbTenDichVu.addItem(x.getTenDV());
		}
    }
    
    private void layDuLieuLenCbLoaiDichVu() throws SQLException {
		List<LoaiDichVu> ldv = loaiDichVu_dao.layDanhSachLoaiDichVu();
		for (LoaiDichVu x : ldv) {
			cbLoaiDichVu.addItem(x.getTenLoaiDV());
		}
    }
    
    private void layDuLieuLenBangChiTiet(){
        ArrayList<CT_DichVu> DSCTDV = new ArrayList<>();
        dftblHoaDon = (DefaultTableModel) tblDanhSachChiTietPhong.getModel();
        dftblHoaDon.setRowCount(0);
        int stt=1;
        double tongTien = 0;
        String maHoaDon = lblMaHoaDon.getText();
        
        DSCTDV = ctDichVu_dao.layDanhSachDichVu(maHoaDon);
        for(CT_DichVu ctDV : DSCTDV) { 
            dftblHoaDon.addRow(new Object[] {stt,ctDV.getDichVu().getTenDV(), ctDV.getDichVu().getGiaBan(),
            ctDV.getSoLuong(),ctDV.getDichVu().getDonViTinh(), ctDV.getThanhTien()});
            tongTien += ctDV.getThanhTien();
            lblTongTienDichVu.setText(tongTien + " VND");
            stt++;
        }

    }
    private boolean kiemTraTienThua() {
        String tienNhanTuKhach = txtTienNhan.getText().trim();
        String tongTien = lblTongTien.getText();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        if (tienNhanTuKhach.isEmpty() || tongTien.isEmpty()) {
            lblTienThua.setText("");
            return false;
        }

        double tienThanhToan = Double.parseDouble(tongTien.replaceAll("[^\\d.]", ""));

        if (tienNhanTuKhach.matches("\\d*\\.?\\d*")) {
            double tienNhan = Double.parseDouble(tienNhanTuKhach);
            double tienThua = tienNhan - tienThanhToan;

            if (tienThua >= 0) {
                lblTienThua.setText(nf.format(tienThua));
            } else {
                lblTienThua.setText("");
            }
        } else {
            lblTienThua.setText("");
        }
        return true;
    }
 private void lamMoi(){
     tblDanhSachPhong.clearSelection();
        dftblChiTiet = (DefaultTableModel) tblDanhSachChiTietPhong.getModel();
        dftblChiTiet.setRowCount(0);
        txtMaPhong.setEditable(true);
        txtMaPhong.setText("");
        lblThoiLuongPhong.setText("");
        lblGiaPhong.setText("");
        lblPhong.setText("");
        lblKhachHang.setText("");
        lblNhanVien.setText("");
        lblMaHoaDon.setText("");   
        txtSoLuong.setText("");
        lblTongTienDichVu.setText("");
        txtMaPhong.requestFocus();
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgHoaDon = new javax.swing.JDialog();
        lblGiaTriTenQuan = new javax.swing.JLabel();
        lblHDSoDienThoai = new javax.swing.JLabel();
        lblHDMaHD = new javax.swing.JLabel();
        lblHDMaHoaDon = new javax.swing.JLabel();
        lblHoaDonTinhTien = new javax.swing.JLabel();
        lblHDKhachHang = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblHDNV = new javax.swing.JLabel();
        lblHDNhanVien = new javax.swing.JLabel();
        lblGioBatDau = new javax.swing.JLabel();
        lblHDGioBatDau = new javax.swing.JLabel();
        lblHDGioKetThuc = new javax.swing.JLabel();
        lblGioKetThuc = new javax.swing.JLabel();
        pnlDanhSachDichVu = new javax.swing.JPanel();
        scrDanhSachDichVu = new javax.swing.JScrollPane();
        tblDanhSachDichVu = new javax.swing.JTable();
        lblChietKhau = new javax.swing.JLabel();
        lblHDChietKhau = new javax.swing.JLabel();
        lblTienNhan = new javax.swing.JLabel();
        lblThueVAT = new javax.swing.JLabel();
        lblVAT = new javax.swing.JLabel();
        lblTienDV = new javax.swing.JLabel();
        lblTongTienPhong = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        lblTienThoi = new javax.swing.JLabel();
        lblTienThanhToan = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnQuayLai = new javax.swing.JButton();
        lblPhanCach = new javax.swing.JLabel();
        lblHDDiaChi = new javax.swing.JLabel();
        lblHDNL = new javax.swing.JLabel();
        lblHDNgayLap = new javax.swing.JLabel();
        lblMaGG = new javax.swing.JLabel();
        txtTienNhan = new javax.swing.JTextField();
        txtMaGiamGia = new javax.swing.JTextField();
        lblTienP = new javax.swing.JLabel();
        lblTCong = new javax.swing.JLabel();
        lblTongCong = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        btnKiemTra = new javax.swing.JButton();
        btnXacNhanThanhToan = new javax.swing.JButton();
        chkXuatHD = new javax.swing.JCheckBox();
        pnlThongTinChiTietPhong = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblGiaPhongHat = new javax.swing.JLabel();
        scrDanhSachDichVuHD1 = new javax.swing.JScrollPane();
        tblDanhSachChiTietPhong = new javax.swing.JTable();
        lblPhong = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        lblHoaDon = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblGiaPhong = new javax.swing.JLabel();
        lblTenPhong = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblThoiLuong = new javax.swing.JLabel();
        lblThoiLuongPhong = new javax.swing.JLabel();
        pnlDanhSachPhong = new javax.swing.JPanel();
        scrDanhSachPhong2 = new javax.swing.JScrollPane();
        tblDanhSachPhong = new javax.swing.JTable();
        pnTime = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTimPhong = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnTimPhong = new javax.swing.JButton();
        pnTieuDe = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        btnChuyenPhong = new javax.swing.JButton();
        pnDichVu = new javax.swing.JPanel();
        lblLoaiDichVu = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        cbLoaiDichVu = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        btnThemDichVu = new javax.swing.JButton();
        btnCapNhatDichVu = new javax.swing.JButton();
        btnXoaDichVu = new javax.swing.JButton();
        lblTenDichVu = new javax.swing.JLabel();
        cbTenDichVu = new javax.swing.JComboBox<>();
        lblTongTienDV = new javax.swing.JLabel();
        lblTongTienDichVu = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        mnuTong = new javax.swing.JMenuBar();
        mnHeThong = new javax.swing.JMenu();
        mniTrangChu = new javax.swing.JMenuItem();
        mniTroGiup = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        mnuPhong = new javax.swing.JMenu();
        mniCapNhatPhong = new javax.swing.JMenuItem();
        mniCapNhatLoaiPhong = new javax.swing.JMenuItem();
        mniTimKiemPhong = new javax.swing.JMenuItem();
        mniDatPhong = new javax.swing.JMenuItem();
        mnuNhanVien = new javax.swing.JMenu();
        mniCapNhatNhanVien = new javax.swing.JMenuItem();
        mniTimKiemNhanVien = new javax.swing.JMenuItem();
        mnuKhachHang = new javax.swing.JMenu();
        mniCapNhatKhachHang = new javax.swing.JMenuItem();
        mniTimKiemKhachHang = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mniThongKeDoanhThu = new javax.swing.JMenuItem();
        mniThongKeDoanhThuTheoKhachHang = new javax.swing.JMenuItem();
        mnuHoaDon = new javax.swing.JMenu();
        mniLapHoaDon = new javax.swing.JMenuItem();
        mniThanhToan = new javax.swing.JMenuItem();
        mnuDichVu = new javax.swing.JMenu();
        mniCapNhatDichVu = new javax.swing.JMenuItem();
        mniTimKiemDichVu = new javax.swing.JMenuItem();
        mnuKhuyenMai = new javax.swing.JMenu();
        mniCapNhatKhuyenMai = new javax.swing.JMenuItem();
        mniTimKiemKhuyenMai = new javax.swing.JMenuItem();

        dlgHoaDon.setMinimumSize(new java.awt.Dimension(675, 795));
        dlgHoaDon.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dlgHoaDonComponentShown(evt);
            }
        });
        dlgHoaDon.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGiaTriTenQuan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGiaTriTenQuan.setText("Karaoke MMM");
        dlgHoaDon.getContentPane().add(lblGiaTriTenQuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        lblHDSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDSoDienThoai.setText("Điện thoại: (028) 62 68 9999 - 0978.007.007");
        dlgHoaDon.getContentPane().add(lblHDSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 30));

        lblHDMaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDMaHD.setText("Hóa đơn:");
        dlgHoaDon.getContentPane().add(lblHDMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        lblHDMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDMaHoaDon.setText("HD001");
        dlgHoaDon.getContentPane().add(lblHDMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, 30));

        lblHoaDonTinhTien.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblHoaDonTinhTien.setText("HOÁ ĐƠN TÍNH TIỀN");
        dlgHoaDon.getContentPane().add(lblHoaDonTinhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        lblHDKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDKhachHang.setText("Tên KH");
        dlgHoaDon.getContentPane().add(lblHDKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, 30));

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenKH.setText("Khách hàng:");
        dlgHoaDon.getContentPane().add(lblTenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 30));

        lblHDNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDNV.setText("Nhân viên:");
        dlgHoaDon.getContentPane().add(lblHDNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 40));

        lblHDNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDNhanVien.setText("Tên NV");
        dlgHoaDon.getContentPane().add(lblHDNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, 40));

        lblGioBatDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGioBatDau.setText("Giờ bắt đầu:");
        dlgHoaDon.getContentPane().add(lblGioBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, 40));

        lblHDGioBatDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDGioBatDau.setText("20/10/2023");
        dlgHoaDon.getContentPane().add(lblHDGioBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, 40));

        lblHDGioKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDGioKetThuc.setText("21/10/2023");
        dlgHoaDon.getContentPane().add(lblHDGioKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, 30));

        lblGioKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGioKetThuc.setText("Giờ kết thúc:");
        dlgHoaDon.getContentPane().add(lblGioKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, 30));

        pnlDanhSachDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH DỊCH VỤ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlDanhSachDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblDanhSachDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên dịch vụ", "Đơn giá", "Số lượng / thời lượng", "Đơn vị tính", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachDichVu.setRowHeight(25);
        scrDanhSachDichVu.setViewportView(tblDanhSachDichVu);
        if (tblDanhSachDichVu.getColumnModel().getColumnCount() > 0) {
            tblDanhSachDichVu.getColumnModel().getColumn(0).setMinWidth(5);
            tblDanhSachDichVu.getColumnModel().getColumn(0).setMaxWidth(1000);
            tblDanhSachDichVu.getColumnModel().getColumn(3).setResizable(false);
            tblDanhSachDichVu.getColumnModel().getColumn(4).setMinWidth(80);
            tblDanhSachDichVu.getColumnModel().getColumn(4).setMaxWidth(1000);
        }

        pnlDanhSachDichVu.add(scrDanhSachDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 22, 650, 280));

        dlgHoaDon.getContentPane().add(pnlDanhSachDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 226, 660, 310));

        lblChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblChietKhau.setText("Chiết khấu:");
        dlgHoaDon.getContentPane().add(lblChietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, -1));

        lblHDChietKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHDChietKhau.setText("0%");
        dlgHoaDon.getContentPane().add(lblHDChietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, -1, 20));

        lblTienNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienNhan.setText("Tiền nhận:");
        dlgHoaDon.getContentPane().add(lblTienNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, -1, -1));

        lblThueVAT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblThueVAT.setText("Thuế VAT:");
        dlgHoaDon.getContentPane().add(lblThueVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 650, -1, -1));

        lblVAT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVAT.setText("10.0%");
        dlgHoaDon.getContentPane().add(lblVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, -1, -1));

        lblTienDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienDV.setText("Tiền dịch vụ:");
        dlgHoaDon.getContentPane().add(lblTienDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, -1, -1));

        lblTongTienPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTienPhong.setText("1,230,000 VND");
        dlgHoaDon.getContentPane().add(lblTongTienPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, -1, -1));

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dlgHoaDon.getContentPane().add(lblTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, -1, -1));

        lblTienThoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienThoi.setText("Tiền thừa:");
        dlgHoaDon.getContentPane().add(lblTienThoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        lblTienThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienThanhToan.setForeground(new java.awt.Color(255, 51, 51));
        lblTienThanhToan.setText("Tiền thanh toán:");
        dlgHoaDon.getContentPane().add(lblTienThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 680, -1, -1));

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 51, 51));
        lblTongTien.setText("1,482,000 VND");
        dlgHoaDon.getContentPane().add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 680, -1, -1));

        btnQuayLai.setBackground(new java.awt.Color(51, 153, 255));
        btnQuayLai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnQuayLai.setForeground(new java.awt.Color(255, 255, 255));
        btnQuayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DangXuat.png"))); // NOI18N
        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });
        dlgHoaDon.getContentPane().add(btnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, 150, 33));

        lblPhanCach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhanCach.setText("_ _ _ _ _ _ _ _ _ _ _ _ _");
        dlgHoaDon.getContentPane().add(lblPhanCach, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, 20));

        lblHDDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDDiaChi.setText("Địa chỉ: 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Thành phố Hồ Chí Minh");
        dlgHoaDon.getContentPane().add(lblHDDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 20));

        lblHDNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDNL.setText("Ngày lập:");
        dlgHoaDon.getContentPane().add(lblHDNL, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, 30));

        lblHDNgayLap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHDNgayLap.setText("NgayLap");
        dlgHoaDon.getContentPane().add(lblHDNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, 30));

        lblMaGG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaGG.setText("Mã giảm giá:");
        dlgHoaDon.getContentPane().add(lblMaGG, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        txtTienNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTienNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNhanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienNhanKeyTyped(evt);
            }
        });
        dlgHoaDon.getContentPane().add(txtTienNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 614, 130, -1));

        txtMaGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dlgHoaDon.getContentPane().add(txtMaGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 554, 130, -1));

        lblTienP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienP.setText("Tiền phòng:");
        dlgHoaDon.getContentPane().add(lblTienP, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, -1, -1));

        lblTCong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTCong.setText("Tổng cộng:");
        dlgHoaDon.getContentPane().add(lblTCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, -1, -1));

        lblTongCong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongCong.setText("1,230,000 VND");
        dlgHoaDon.getContentPane().add(lblTongCong, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, -1, -1));

        lblTienDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienDichVu.setText("1,230,000 VND");
        dlgHoaDon.getContentPane().add(lblTienDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, -1, -1));

        btnKiemTra.setBackground(new java.awt.Color(204, 204, 204));
        btnKiemTra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKiemTra.setText("Kiểm tra");
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });
        dlgHoaDon.getContentPane().add(btnKiemTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, -1, -1));

        btnXacNhanThanhToan.setBackground(new java.awt.Color(255, 0, 51));
        btnXacNhanThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXacNhanThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hoadon.png"))); // NOI18N
        btnXacNhanThanhToan.setText("Xác nhận thanh toán");
        btnXacNhanThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanThanhToanActionPerformed(evt);
            }
        });
        dlgHoaDon.getContentPane().add(btnXacNhanThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 710, 240, 33));

        chkXuatHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkXuatHD.setText("Xuất hóa đơn");
        chkXuatHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkXuatHDActionPerformed(evt);
            }
        });
        dlgHoaDon.getContentPane().add(chkXuatHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 714, -1, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Design by MMM");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlThongTinChiTietPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN TẠM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        pnlThongTinChiTietPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTenNhanVien.setText("Tên nhân viên:");
        pnlThongTinChiTietPhong.add(lblTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        lblGiaPhongHat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblGiaPhongHat.setText("Giá phòng:");
        pnlThongTinChiTietPhong.add(lblGiaPhongHat, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        tblDanhSachChiTietPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblDanhSachChiTietPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên dịch vụ", "Đơn giá", "Số lượng", "Đơn vị tính", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachChiTietPhong.setRowHeight(25);
        tblDanhSachChiTietPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachChiTietPhongMouseClicked(evt);
            }
        });
        scrDanhSachDichVuHD1.setViewportView(tblDanhSachChiTietPhong);
        if (tblDanhSachChiTietPhong.getColumnModel().getColumnCount() > 0) {
            tblDanhSachChiTietPhong.getColumnModel().getColumn(0).setMinWidth(10);
            tblDanhSachChiTietPhong.getColumnModel().getColumn(0).setMaxWidth(1000);
            tblDanhSachChiTietPhong.getColumnModel().getColumn(1).setResizable(false);
            tblDanhSachChiTietPhong.getColumnModel().getColumn(3).setResizable(false);
            tblDanhSachChiTietPhong.getColumnModel().getColumn(4).setMinWidth(80);
            tblDanhSachChiTietPhong.getColumnModel().getColumn(4).setMaxWidth(1000);
        }

        pnlThongTinChiTietPhong.add(scrDanhSachDichVuHD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 370));

        lblPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinChiTietPhong.add(lblPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 50));

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinChiTietPhong.add(lblKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTenKhachHang.setText("Tên Khách Hàng:");
        pnlThongTinChiTietPhong.add(lblTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        lblHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblHoaDon.setText("Mã hóa đơn:");
        pnlThongTinChiTietPhong.add(lblHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinChiTietPhong.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        lblGiaPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinChiTietPhong.add(lblGiaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        lblTenPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTenPhong.setText("Phòng:");
        pnlThongTinChiTietPhong.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, 50));

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinChiTietPhong.add(lblMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 30));

        lblThoiLuong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblThoiLuong.setText("Thời lượng:");
        pnlThongTinChiTietPhong.add(lblThoiLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, 40));

        lblThoiLuongPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinChiTietPhong.add(lblThoiLuongPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, 40));

        getContentPane().add(pnlThongTinChiTietPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 680, 530));
        pnlThongTinChiTietPhong.getAccessibleContext().setAccessibleName("THÔNG TIN KHÁCH HÀNG\n\n");

        pnlDanhSachPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHÒNG ĐANG SỬ DỤNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        pnlDanhSachPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Tên Phòng", "Loại phòng", "Giá phòng", "Giờ nhận phòng", "Tên khách hàng", "Tên nhân viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachPhong.setRowHeight(25);
        tblDanhSachPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhongMouseClicked(evt);
            }
        });
        scrDanhSachPhong2.setViewportView(tblDanhSachPhong);
        if (tblDanhSachPhong.getColumnModel().getColumnCount() > 0) {
            tblDanhSachPhong.getColumnModel().getColumn(0).setMinWidth(40);
            tblDanhSachPhong.getColumnModel().getColumn(0).setMaxWidth(1000);
            tblDanhSachPhong.getColumnModel().getColumn(1).setMinWidth(100);
            tblDanhSachPhong.getColumnModel().getColumn(1).setMaxWidth(1000);
            tblDanhSachPhong.getColumnModel().getColumn(2).setMinWidth(80);
            tblDanhSachPhong.getColumnModel().getColumn(2).setMaxWidth(1000);
            tblDanhSachPhong.getColumnModel().getColumn(3).setMinWidth(70);
            tblDanhSachPhong.getColumnModel().getColumn(3).setMaxWidth(1000);
            tblDanhSachPhong.getColumnModel().getColumn(4).setMinWidth(150);
            tblDanhSachPhong.getColumnModel().getColumn(4).setMaxWidth(1000);
            tblDanhSachPhong.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlDanhSachPhong.add(scrDanhSachPhong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 790, 360));

        pnTime.setBackground(new java.awt.Color(255, 255, 255));
        pnTime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTime.setText("18 : 28 :45");
        pnTime.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDate.setText("11/04/2023");
        pnTime.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 20));

        pnlDanhSachPhong.add(pnTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, -1));

        lblTimPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTimPhong.setText("Tìm phòng:");
        pnlDanhSachPhong.add(lblTimPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, 30));

        txtMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnlDanhSachPhong.add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 160, 30));

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.setIconTextGap(8);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnlDanhSachPhong.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        btnTimPhong.setBackground(new java.awt.Color(204, 204, 204));
        btnTimPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-24.png"))); // NOI18N
        btnTimPhong.setText("TÌM");
        btnTimPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongActionPerformed(evt);
            }
        });
        pnlDanhSachPhong.add(btnTimPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 100, 40));

        getContentPane().add(pnlDanhSachPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 810, 460));
        pnlDanhSachPhong.getAccessibleContext().setAccessibleDescription("");

        pnTieuDe.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDe.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDe.setText("LẬP HOÁ ĐƠN");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addGap(661, 661, 661)
                .addComponent(lblTieuDe)
                .addContainerGap(701, Short.MAX_VALUE))
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1517, 50));

        btnChuyenPhong.setBackground(new java.awt.Color(0, 153, 153));
        btnChuyenPhong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnChuyenPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/forward-button.png"))); // NOI18N
        btnChuyenPhong.setText("Chuyển phòng");
        btnChuyenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhongActionPerformed(evt);
            }
        });
        getContentPane().add(btnChuyenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 650, 180, 40));

        pnDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn Dịch Vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        pnDichVu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLoaiDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLoaiDichVu.setText("Loại dịch vụ");
        pnDichVu.add(lblLoaiDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 30));

        lblSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuong.setText("Số lượng:");
        pnDichVu.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 30));

        cbLoaiDichVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cbLoaiDichVu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiDichVuItemStateChanged(evt);
            }
        });
        pnDichVu.add(cbLoaiDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 270, -1));

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnDichVu.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 160, -1));

        btnThemDichVu.setBackground(new java.awt.Color(0, 204, 255));
        btnThemDichVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnThemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dichvu.png"))); // NOI18N
        btnThemDichVu.setText("Thêm dịch vụ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });
        pnDichVu.add(btnThemDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 180, 40));

        btnCapNhatDichVu.setBackground(new java.awt.Color(255, 153, 0));
        btnCapNhatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCapNhatDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnCapNhatDichVu.setText("Cập nhật dịch vụ");
        btnCapNhatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatDichVuActionPerformed(evt);
            }
        });
        pnDichVu.add(btnCapNhatDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, 40));

        btnXoaDichVu.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thoat.png"))); // NOI18N
        btnXoaDichVu.setText("XÓA DỊCH VỤ");
        btnXoaDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDichVuActionPerformed(evt);
            }
        });
        pnDichVu.add(btnXoaDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 180, 40));

        lblTenDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenDichVu.setText("Tên dịch vụ:");
        pnDichVu.add(lblTenDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 30));

        cbTenDichVu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnDichVu.add(cbTenDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 270, -1));

        getContentPane().add(pnDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 810, 190));

        lblTongTienDV.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTongTienDV.setText("Tổng tiền :");
        getContentPane().add(lblTongTienDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 590, -1, -1));

        lblTongTienDichVu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        getContentPane().add(lblTongTienDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 590, 210, 20));

        btnThanhToan.setBackground(new java.awt.Color(153, 255, 153));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hoadon.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        getContentPane().add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 650, 180, 40));

        mnuTong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mnHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system.png"))); // NOI18N
        mnHeThong.setText("Hệ Thống");
        mnHeThong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniTrangChu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/24-hours.png"))); // NOI18N
        mniTrangChu.setText("Trang chủ");
        mniTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTrangChuActionPerformed(evt);
            }
        });
        mnHeThong.add(mniTrangChu);

        mniTroGiup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        mniTroGiup.setText("Trợ giúp");
        mniTroGiup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTroGiupActionPerformed(evt);
            }
        });
        mnHeThong.add(mniTroGiup);

        mniDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DangXuat.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mnHeThong.add(mniDangXuat);

        mnuTong.add(mnHeThong);

        mnuPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home.png"))); // NOI18N
        mnuPhong.setText("Phòng");
        mnuPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniCapNhatPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniCapNhatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu.png"))); // NOI18N
        mniCapNhatPhong.setText("Cập nhật phòng");
        mniCapNhatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniCapNhatPhong);

        mniCapNhatLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniCapNhatLoaiPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/description.png"))); // NOI18N
        mniCapNhatLoaiPhong.setText("Cập nhật loại phòng");
        mniCapNhatLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatLoaiPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniCapNhatLoaiPhong);

        mniTimKiemPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTimKiemPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-24.png"))); // NOI18N
        mniTimKiemPhong.setText("Tìm kiếm phòng");
        mniTimKiemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniTimKiemPhong);

        mniDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/televisions.png"))); // NOI18N
        mniDatPhong.setText("Đặt phòng");
        mniDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDatPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniDatPhong);

        mnuTong.add(mnuPhong);

        mnuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nhanvien.png"))); // NOI18N
        mnuNhanVien.setText("Nhân viên");
        mnuNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniCapNhatNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniCapNhatNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/adminLogin.png"))); // NOI18N
        mniCapNhatNhanVien.setText("Cập nhật nhân viên");
        mniCapNhatNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatNhanVienActionPerformed(evt);
            }
        });
        mnuNhanVien.add(mniCapNhatNhanVien);

        mniTimKiemNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTimKiemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-service.png"))); // NOI18N
        mniTimKiemNhanVien.setText("Tìm kiếm nhân viên");
        mniTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemNhanVienActionPerformed(evt);
            }
        });
        mnuNhanVien.add(mniTimKiemNhanVien);

        mnuTong.add(mnuNhanVien);

        mnuKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khachHang.png"))); // NOI18N
        mnuKhachHang.setText("Khách hàng");
        mnuKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniCapNhatKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniCapNhatKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        mniCapNhatKhachHang.setText("Cập nhật khách hàng");
        mniCapNhatKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatKhachHangActionPerformed(evt);
            }
        });
        mnuKhachHang.add(mniCapNhatKhachHang);

        mniTimKiemKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTimKiemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/help (1).png"))); // NOI18N
        mniTimKiemKhachHang.setText("Tìm kiếm khách hàng");
        mniTimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemKhachHangActionPerformed(evt);
            }
        });
        mnuKhachHang.add(mniTimKiemKhachHang);

        mnuTong.add(mnuKhachHang);

        mnuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thongke.png"))); // NOI18N
        mnuThongKe.setText("Thống Kê");
        mnuThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniThongKeDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniThongKeDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bar-chart.png"))); // NOI18N
        mniThongKeDoanhThu.setText("Thống kê doanh thu");
        mniThongKeDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeDoanhThuActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniThongKeDoanhThu);

        mniThongKeDoanhThuTheoKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniThongKeDoanhThuTheoKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/budget.png"))); // NOI18N
        mniThongKeDoanhThuTheoKhachHang.setText("Thống kê doanh thu theo khách hàng");
        mniThongKeDoanhThuTheoKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeDoanhThuTheoKhachHangActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniThongKeDoanhThuTheoKhachHang);

        mnuTong.add(mnuThongKe);

        mnuHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hoadon.png"))); // NOI18N
        mnuHoaDon.setText("Hoá đơn");
        mnuHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniLapHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bill (1).png"))); // NOI18N
        mniLapHoaDon.setText("Lập hoá đơn");
        mniLapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLapHoaDonActionPerformed(evt);
            }
        });
        mnuHoaDon.add(mniLapHoaDon);

        mniThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money-bag.png"))); // NOI18N
        mniThanhToan.setText("Thanh toán");
        mniThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThanhToanActionPerformed(evt);
            }
        });
        mnuHoaDon.add(mniThanhToan);

        mnuTong.add(mnuHoaDon);

        mnuDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dichvu.png"))); // NOI18N
        mnuDichVu.setText("Dịch vụ");
        mnuDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniCapNhatDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniCapNhatDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/storeNav.png"))); // NOI18N
        mniCapNhatDichVu.setText("Cập nhật dịch vụ");
        mniCapNhatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatDichVuActionPerformed(evt);
            }
        });
        mnuDichVu.add(mniCapNhatDichVu);

        mniTimKiemDichVu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTimKiemDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/invoices.png"))); // NOI18N
        mniTimKiemDichVu.setText("Tìm kiếm dịch vụ");
        mniTimKiemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemDichVuActionPerformed(evt);
            }
        });
        mnuDichVu.add(mniTimKiemDichVu);

        mnuTong.add(mnuDichVu);

        mnuKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khuyenmai.png"))); // NOI18N
        mnuKhuyenMai.setText("Khuyến mãi");
        mnuKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniCapNhatKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniCapNhatKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/promotion.png"))); // NOI18N
        mniCapNhatKhuyenMai.setText("Cập nhật khuyến mãi");
        mniCapNhatKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatKhuyenMaiActionPerformed(evt);
            }
        });
        mnuKhuyenMai.add(mniCapNhatKhuyenMai);

        mniTimKiemKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTimKiemKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-24.png"))); // NOI18N
        mniTimKiemKhuyenMai.setText("Tìm kiếm khuyến mãi");
        mniTimKiemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemKhuyenMaiActionPerformed(evt);
            }
        });
        mnuKhuyenMai.add(mniTimKiemKhuyenMai);

        mnuTong.add(mnuKhuyenMai);

        setJMenuBar(mnuTong);

        pack();
    }// </editor-fold>//GEN-END:initComponents
                                       
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    try {
        layDuLieuLenCbLoaiDichVu();
        layDuLieuLenCbTenDichVu();
        docDuLieuTuDataVaoBangPhong();
        System.out.println("Doc Thanh Cong");
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.out.println("Loi: " + ex.getMessage());
    }
    }//GEN-LAST:event_formComponentShown

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
        dftblHoaDon = (DefaultTableModel) tblDanhSachChiTietPhong.getModel();
        int row = tblDanhSachPhong.getSelectedRow();
        if(row >= 0){
                DichVu dichVu = new DichVu();
                HoaDon hoaDon= new HoaDon();
                String tenKhachHang = tblDanhSachPhong.getValueAt(row, 5).toString();
                String maHoaDon = lblMaHoaDon.getText();
                String tenDichVu = cbTenDichVu.getSelectedItem().toString();
                dichVu = dichVu_dao.timDichVuTheoTen(tenDichVu);
                hoaDon = hoaDon_dao.timHoaDonTheoMa(maHoaDon);
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                
                CT_DichVu ctDV = new CT_DichVu(hoaDon, dichVu, soLuong);
                if(ctDichVu_dao.kiemTraDichVuDaCo(maHoaDon, tenDichVu)){
                    JOptionPane.showMessageDialog(this, "Dịch vụ muốn thêm đã có!");
                }else{
                    if(ctDichVu_dao.themChiTietDichVu(ctDV)){
                        JOptionPane.showMessageDialog(this, "Thêm dịch vụ thành công");
                        layDuLieuLenBangChiTiet();
                    }
                }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn phòng muốn thêm dịch vụ");
        }
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnChuyenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenPhongActionPerformed

    private void tblDanhSachChiTietPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachChiTietPhongMouseClicked
        dftblChiTiet = (DefaultTableModel) tblDanhSachChiTietPhong.getModel();
        int row = tblDanhSachChiTietPhong.getSelectedRow();
        DichVu dichVu = null;
        if(row >= 0){
            txtSoLuong.setText(tblDanhSachChiTietPhong.getValueAt(row, 3).toString());
            String tenDichVu = (String) tblDanhSachChiTietPhong.getValueAt(row, 1);
            cbTenDichVu.setSelectedItem(tenDichVu);
            dichVu = dichVu_dao.timDichVuTheoTen(tenDichVu);                  
            cbLoaiDichVu.setSelectedItem(dichVu.getLoaiDV() .getTenLoaiDV());
        }
    }//GEN-LAST:event_tblDanhSachChiTietPhongMouseClicked

    private void tblDanhSachPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhongMouseClicked
        HoaDon hoaDon = null;
        String maHoaDon = "";
        int row = tblDanhSachPhong.getSelectedRow();
        int thoiLuong = 0; 
        if (row >= 0) {
            try {            
                String thoiGianVaoTuBang = (String) tblDanhSachPhong.getValueAt(row, 4);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date thoiGianVao = sdf.parse(thoiGianVaoTuBang);
                Date thoiGianRa = new Date();
                long thoiGianSuDungMillis = thoiGianRa.getTime() - thoiGianVao.getTime();
                if (thoiGianSuDungMillis < 0) {
                    thoiGianSuDungMillis = 0;
                }
                long thoiGianSuDungPhut = TimeUnit.MILLISECONDS.toMinutes(thoiGianSuDungMillis);
                String thoiLuongFormatted = String.format("%02d giờ : %02d phút", thoiGianSuDungPhut / 60, thoiGianSuDungPhut % 60);
                
                lblThoiLuongPhong.setText(thoiLuongFormatted);
                String tenPhong = tblDanhSachPhong.getValueAt(row, 1).toString();
                String giaPhong = tblDanhSachPhong.getValueAt(row, 3).toString();
                lblGiaPhong.setText(giaPhong);
                lblPhong.setText(tenPhong);
                String tenKhachHang = tblDanhSachPhong.getValueAt(row, 5).toString();
                String tenNhanVien = tblDanhSachPhong.getValueAt(row, 6).toString();
                lblKhachHang.setText(tenKhachHang);
                lblNhanVien.setText(tenNhanVien);
                String maPhong = tblDanhSachPhong.getValueAt(row, 0).toString();
                maHoaDon = hoaDon_dao.timMaHoaDonTheoMaPhong(maPhong);
                hoaDon = hoaDon_dao.timHoaDonTheoMa(maHoaDon);
                
                Phong phong = new Phong();
                phong = phong_dao.timPhongTheoMaPhong(maPhong);
                CT_HoaDon ctHD = new CT_HoaDon(hoaDon, phong, thoiLuong);
                if(!ctHoaDon_dao.kiemTraPhongDaCo(maHoaDon, maPhong)){
                    ctHoaDon_dao.themChiTietHoaDon(ctHD);
                }
                thoiLuong = (int) thoiGianSuDungPhut;
                ctHoaDon_dao.capNhatThoiLuongPhong(maHoaDon, maPhong, thoiLuong);
                lblMaHoaDon.setText(maHoaDon);
                layDuLieuLenBangChiTiet();
                txtMaPhong.setText(maPhong);
                txtMaPhong.setEditable(false);
            } catch (ParseException ex) {
                Logger.getLogger(GUILapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }	
        
    }//GEN-LAST:event_tblDanhSachPhongMouseClicked
    public void XuatHoaDon() {
        try {
            // TODO add your handling code here:
            Document doc = new Document();
            String maHD = lblHDMaHoaDon.getText();
            
            //PdfFont font = PdfFontFactory.createFont("UniArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            PdfWriter.getInstance(doc, new FileOutputStream(maHD+".pdf"));
            doc.open();
            doc.add(new Paragraph("Ten quan : Karaoke MMM"));
            doc.add(new Paragraph("Ngay thanh toan : Nguyen Van Bao, p4, Q.Go Vap, TP.HCM"));
            Paragraph prMaHD = new Paragraph("Ma hoa don : "+ maHD);
            doc.add(prMaHD);
            Paragraph title = new Paragraph("Hoa don tinh tien",FontFactory.getFont(FontFactory.COURIER,30));
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
            LocalDateTime localTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String ngayThanhToan = localTime.format(formatter);
            
            Paragraph prNgayThanhToan = new Paragraph("Ngay thanh toan :"+ngayThanhToan);
            doc.add(prNgayThanhToan);
            doc.add(new Paragraph("\n\n"));           
            String tenNV = lblHDNhanVien.getText();
            Paragraph prTenNV = new Paragraph("Nhan vien : "+ tenNV);
            String gioNP = lblHDGioBatDau.getText();
            Paragraph prGioNhanPhong = new Paragraph("Gio nhan phong : " + gioNP);
            
            Phrase dong1 = new Phrase();

            // Thêm đoạn văn bản đầu tiên và đặt căng đều cho nó
            dong1.add(prTenNV);
            dong1.add(new Paragraph("                                                 "));
            dong1.add(prGioNhanPhong);
            // Thêm đoạn Phrase vào Document
            doc.add(dong1);
            
            Phrase dong2 = new Phrase();
            String tenKH = lblHDKhachHang.getText();
            Paragraph prKhachHang = new Paragraph("\nKhach hang : " + tenKH);
            String gioTP = lblHDGioKetThuc.getText();
            Paragraph prGioTraPhong = new Paragraph("Gio tra phong : " + gioTP);
            dong2.add(prKhachHang);
            dong2.add(new Paragraph("                                                 "));
            dong2.add(prGioTraPhong);

            doc.add(dong2);           
            doc.add(new Paragraph("\n"));
            //Add table
            PdfPTable tblThongTinHD = new PdfPTable(5);
            PdfPCell cell = new PdfPCell(new Paragraph("Thong tin hoa don",FontFactory.getFont(FontFactory.TIMES_BOLD,18)));
            cell.setColspan(5);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tblThongTinHD.addCell(cell);
            
            tblThongTinHD.addCell("Ma dich vu");
            tblThongTinHD.addCell("Ten dich vu");
            tblThongTinHD.addCell("So luong");
            tblThongTinHD.addCell("Don vi tinh");
            tblThongTinHD.addCell("Gia ban");
            for(int i=0;i<tblDanhSachDichVu.getRowCount();i++)
            {
                String maDV = tblDanhSachDichVu.getValueAt(i, 1).toString();
                String tenDV = tblDanhSachDichVu.getValueAt(i, 2).toString();
                String soLuong = tblDanhSachDichVu.getValueAt(i, 3).toString();
                String donViTinh = tblDanhSachDichVu.getValueAt(i, 4).toString();
                String giaBan = tblDanhSachDichVu.getValueAt(i, 5).toString();
                tblThongTinHD.addCell(maDV);
                tblThongTinHD.addCell(tenDV);
                tblThongTinHD.addCell(soLuong);
                tblThongTinHD.addCell(donViTinh);
                tblThongTinHD.addCell(giaBan);
            }
            doc.add(tblThongTinHD);
            doc.add(new Paragraph("\n\n\n"));
            String chietKhau = lblHDChietKhau.getText();
            Paragraph prChietKhau = new Paragraph("Chiet khau : "+ chietKhau);
            String tienThanhToan = lblTongTien.getText();
            Paragraph prThanhTien = new Paragraph("Thanh thanh toan : " + tienThanhToan);
            
            Phrase dong3 = new Phrase();

            // Thêm đoạn văn bản đầu tiên và đặt căng đều cho nó
            dong3.add(prChietKhau);
            dong3.add(new Paragraph("                                                                       "));
            dong3.add(prThanhTien);
            // Thêm đoạn Phrase vào Document
            doc.add(dong3);
            
            Phrase dong4 = new Phrase();
            String tienNhan = txtTienNhan.getText();
            Paragraph prTienNhan = new Paragraph("\nTien nhan : " + tienNhan);
            String tienThoi = lblTienThua.getText();
            Paragraph prTienThoi = new Paragraph("\nTien thoi : " + tienThoi);
            dong4.add(prTienNhan);
            dong4.add(new Paragraph("                                                         "));
            dong4.add(prTienThoi);
            

            doc.add(dong4);  
            
            doc.close();
            JOptionPane.showMessageDialog(null, "Xuất file PDF thành công");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Xuất file PDF không thành công");
        }

    }
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = tblDanhSachPhong.getSelectedRow();
        ArrayList<CT_DichVu> DSCTDV = new ArrayList<>();
        ArrayList<CT_HoaDon> DSCTHD = new ArrayList<>();
        dftblDichVu = (DefaultTableModel) tblDanhSachDichVu.getModel();
        DecimalFormat dft = new DecimalFormat("#");
        dftblDichVu.setRowCount(0);
        float tienThueVAT = 0;
        float thueVAT = 10;
        double tongTienDichVu = 0;
        double tongTienPhong = 0;
        double tongCong = 0;
        double tongTien = 0;
        HoaDon hoaDon = null;
        int stt=1;
        if (row >= 0) {
            String maPhong = tblDanhSachPhong.getValueAt(row, 0).toString();
            dlgHoaDon.setVisible(true);
            String maHoaDon = lblMaHoaDon.getText();
            lblHDMaHoaDon.setText(maHoaDon);
            
            hoaDon = hoaDon_dao.timHoaDonTheoMa(maHoaDon);
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayLapHD = hoaDon.getNgayLapHD();
            String ngayLapHoaDon = df.format(ngayLapHD);
            lblHDNgayLap.setText(ngayLapHoaDon);
            
            String tenNhanVien = lblNhanVien.getText();
            lblHDNhanVien.setText(tenNhanVien);
            
            String tenKhachHang = lblKhachHang.getText();
            lblHDKhachHang.setText(tenKhachHang);
            
            SimpleDateFormat dfg = new SimpleDateFormat("HH:mm:ss");
            Date gioNhanPhong = hoaDon.getGioNhanPhong();
            String gioBatDau = dfg.format(gioNhanPhong);
            lblHDGioBatDau.setText(gioBatDau);

            java.sql.Timestamp gioTraPhong = new java.sql.Timestamp(new Date().getTime());
            String gioKetThuc = dfg.format(gioTraPhong);
            lblHDGioKetThuc.setText(gioKetThuc);
            hoaDon_dao.capNhatGioTraPhong(maHoaDon, (Timestamp) gioTraPhong);
            long thoiLuongMillis = gioTraPhong.getTime() - gioNhanPhong.getTime();
            long thoiGianSuDungPhut = TimeUnit.MILLISECONDS.toMinutes(thoiLuongMillis);
            
            ctHoaDon_dao.capNhatThoiLuongPhong(maHoaDon, maPhong, (int) thoiGianSuDungPhut);
            
            ctHoaDon_dao.layDanhSachCTHoaDon(maHoaDon).clear();
            DSCTHD = ctHoaDon_dao.layDanhSachCTHoaDon(maHoaDon);
            for(CT_HoaDon ctHD : DSCTHD) { 
                dftblDichVu.addRow(new Object[] {stt,ctHD.getPhong().getTenPhong(), ctHD.getPhong().getGiaPhong(),
                ctHD.getThoiLuong()+" phút","Tiếng", ctHD.thanhTien()});
                tongTienPhong += ctHD.thanhTien();
                lblTongTienPhong.setText(dft.format(tongTienPhong)+ " đ");
                stt++;
            }

            ctDichVu_dao.layDanhSachDichVu(maHoaDon).clear();
            DSCTDV = ctDichVu_dao.layDanhSachDichVu(maHoaDon);
            for(CT_DichVu ctDV : DSCTDV) { 
                dftblDichVu.addRow(new Object[] {stt,ctDV.getDichVu().getTenDV(), ctDV.getDichVu().getGiaBan(),
                ctDV.getSoLuong(),ctDV.getDichVu().getDonViTinh(), ctDV.getThanhTien()});
                tongTienDichVu += ctDV.getThanhTien();
                lblTienDichVu.setText(dft.format(tongTienDichVu) + " đ");
                stt++;
            }
            tongCong = tongTienDichVu + tongTienPhong;
            tienThueVAT = (float) ((thueVAT / 100) * tongCong);
            lblTongCong.setText(dft.format(tongCong)+ " đ");
            tongTien = tongCong + tienThueVAT;
            lblTongTien.setText(dft.format(tongTien) +" đ");   
        }else{
            JOptionPane.showMessageDialog(this, "Chưa chọn phòng để thanh toán");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void mniTimKiemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemKhuyenMaiActionPerformed
        GUITimKiemKhuyenMai tkkm = new GUITimKiemKhuyenMai();
        tkkm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemKhuyenMaiActionPerformed

    private void mniCapNhatKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatKhuyenMaiActionPerformed
        GUICapNhatKhuyenMai cnkm = new GUICapNhatKhuyenMai();
        cnkm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatKhuyenMaiActionPerformed

    private void mniTimKiemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemDichVuActionPerformed
        GUITimKiemDichVu tkdv = new GUITimKiemDichVu();
        tkdv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemDichVuActionPerformed

    private void mniCapNhatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatDichVuActionPerformed
        GUICapNhatDichVu cndv = new GUICapNhatDichVu();
        cndv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatDichVuActionPerformed

    private void mniThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThanhToanActionPerformed
        GUITimKiemHoaDon tt = new GUITimKiemHoaDon();
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniThanhToanActionPerformed

    private void mniLapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLapHoaDonActionPerformed
        GUILapHoaDon lhd = new GUILapHoaDon();
        lhd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniLapHoaDonActionPerformed

    private void mniThongKeDoanhThuTheoKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeDoanhThuTheoKhachHangActionPerformed
        GUIThongKeKhachHang tkdtkh = new GUIThongKeKhachHang();
        tkdtkh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniThongKeDoanhThuTheoKhachHangActionPerformed

    private void mniThongKeDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeDoanhThuActionPerformed
        GUIThongKeDoanhThu tkdt = new GUIThongKeDoanhThu();
        tkdt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniThongKeDoanhThuActionPerformed

    private void mniTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemKhachHangActionPerformed
        GUITimKiemKhachHang tkkh = new GUITimKiemKhachHang();
        tkkh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemKhachHangActionPerformed

    private void mniCapNhatKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatKhachHangActionPerformed
        GUICapNhatKhachHang cnkh = new GUICapNhatKhachHang();
        cnkh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatKhachHangActionPerformed

    private void mniTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemNhanVienActionPerformed
        GUITimKiemNhanVien tknv = new GUITimKiemNhanVien();
        tknv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemNhanVienActionPerformed

    private void mniCapNhatNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatNhanVienActionPerformed
        GUICapNhatNhanVien cnnv = new GUICapNhatNhanVien();
        cnnv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatNhanVienActionPerformed

    private void mniDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDatPhongActionPerformed
        // TODO add your handling code here:
        GUIDatPhong ttdp = new GUIDatPhong();
        ttdp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniDatPhongActionPerformed

    private void mniTimKiemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemPhongActionPerformed
        GUITimKiemPhong tkp = new GUITimKiemPhong();
        tkp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemPhongActionPerformed

    private void mniCapNhatLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatLoaiPhongActionPerformed
        GUICapNhatLoaiPhong cnlp = new GUICapNhatLoaiPhong();
        cnlp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatLoaiPhongActionPerformed

    private void mniCapNhatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatPhongActionPerformed
        GUICapNhatPhong cnp = new GUICapNhatPhong();
        cnp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatPhongActionPerformed

    private void mniTroGiupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTroGiupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniTroGiupActionPerformed

    private void mniTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTrangChuActionPerformed
        GUITrangChu tc = new GUITrangChu();
        tc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTrangChuActionPerformed

    private void cbLoaiDichVuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiDichVuItemStateChanged
        List<String> dsTenDichVu = dichVu_dao.locDichVuTheoMaLDV((String) cbLoaiDichVu.getSelectedItem());
        cbTenDichVu.removeAllItems();
        for (String dv : dsTenDichVu) {
            cbTenDichVu.addItem(dv);
        }          
    }//GEN-LAST:event_cbLoaiDichVuItemStateChanged

    private void btnXoaDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDichVuActionPerformed
        dftblChiTiet = (DefaultTableModel) tblDanhSachChiTietPhong.getModel();
        int row = tblDanhSachChiTietPhong.getSelectedRow();
        if(row >= 0){
            String maHoaDon = lblMaHoaDon.getText();
            String tenDichVu = tblDanhSachChiTietPhong.getValueAt(row, 1).toString();
            int xoa = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dịch vụ không?", "Xác nhận Xóa", JOptionPane.YES_NO_OPTION);

            if (xoa == JOptionPane.YES_OPTION) {
                if (ctDichVu_dao.xoaChiTietDichVu(maHoaDon, tenDichVu)) {
                    JOptionPane.showMessageDialog(this, "Xóa dịch vụ thành công");
                    layDuLieuLenBangChiTiet();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn 1 dịch vụ trước khi xóa");
        }
    }//GEN-LAST:event_btnXoaDichVuActionPerformed

    private void btnCapNhatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatDichVuActionPerformed
         dftblChiTiet = (DefaultTableModel) tblDanhSachChiTietPhong.getModel();
        int row = tblDanhSachChiTietPhong.getSelectedRow();
        if(row >= 0){
            String maHoaDon = lblMaHoaDon.getText();
            String tenDichVu = (String) cbTenDichVu.getSelectedItem();
            int soLuongMoi = Integer.parseInt(txtSoLuong.getText());
            if(ctDichVu_dao.capNhatSoLuongDichVu(maHoaDon, tenDichVu, soLuongMoi)){
                JOptionPane.showMessageDialog(this, "Cập nhật dịch vụ thành công");
                layDuLieuLenBangChiTiet();
            }else{
                JOptionPane.showMessageDialog(this, "Cập nhật dịch vụ thất bại");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Chọn dịch vụ muốn cập nhật");
        }
    }//GEN-LAST:event_btnCapNhatDichVuActionPerformed

    private void btnTimPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimPhongActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        dlgHoaDon.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
        DecimalFormat dft = new DecimalFormat("#");
        double tienThueVAT = 0;
        float thueVAT = 10;
        double tienChietKhau = 0;
        double tongCong = 0;
        double tongTien = 0;
        String maGiamGia = txtMaGiamGia.getText().toString().trim();
        KhuyenMai khuyenMai = null;
        try {
            khuyenMai = khuyenMai_dao.timKhuyenMaiTheoMaGG(maGiamGia);
        } catch (Exception e) {

        }
        if (khuyenMai == null) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không tồn tại! Bạn có thể nhập lại hoặc bỏ trống");
            txtMaGiamGia.requestFocus();
            return;
        }
        if (!khuyenMai.getNgayBatDau().before(new Date()) || !khuyenMai.getNgayKetThuc().after(new Date())) {
            JOptionPane.showMessageDialog(this, String.format("Mã giảm giá chỉ áp dụng từ ngày %s Đến %s",
                                khuyenMai.getNgayBatDau().toLocaleString(), khuyenMai.getNgayKetThuc().toLocaleString()));
            txtMaGiamGia.requestFocus();
            return;
        }
        String tongCongTienDichVuVaPhong = lblTongCong.getText();
        String tongCongTien = tongCongTienDichVuVaPhong.replaceAll("[^\\d.]", "");
        tongCong = (float) Double.parseDouble(tongCongTien);
        lblHDChietKhau.setText(khuyenMai.getChietKhau() + "%");
        tienThueVAT = (thueVAT / 100) * tongCong;
        tienChietKhau = ((khuyenMai.getChietKhau()/100)*tongCong);  
        tongTien = tongCong + tienThueVAT - tienChietKhau;
        lblTongTien.setText(dft.format(tongTien) +" đ");
    }//GEN-LAST:event_btnKiemTraActionPerformed

    private void txtTienNhanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKeyTyped
        kiemTraTienThua();
    }//GEN-LAST:event_txtTienNhanKeyTyped

    private void txtTienNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKeyReleased
        kiemTraTienThua();
    }//GEN-LAST:event_txtTienNhanKeyReleased

    private void dlgHoaDonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dlgHoaDonComponentShown
        // TODO add your handling code here:
       
    }//GEN-LAST:event_dlgHoaDonComponentShown

    private void btnXacNhanThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanThanhToanActionPerformed
        // TODO add your handling code here:
        KhuyenMai khuyenMai = null;
        float chietKhau = 0;
        if (!kiemTraTienThua()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền nhận hoặc số tiền nhận không hợp lệ");
            return;
        }
        int xacnhan = JOptionPane.showConfirmDialog(this,"Xác nhận tính tiền phòng: " + lblPhong.getText(), "Thông báo", JOptionPane.YES_NO_OPTION);
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }
        String maHoaDon = lblHDMaHoaDon.getText();
        String maGiamGia = txtMaGiamGia.getText();
        if(maGiamGia.trim().length()>0){
            khuyenMai = khuyenMai_dao.timKhuyenMaiTheoMaGG(maGiamGia);
        }else{
            maGiamGia = "KM";
            khuyenMai = khuyenMai_dao.timKhuyenMaiTheoMaGG(maGiamGia);
        }

        String tongTienStr = lblTongTien.getText().replaceAll("[^\\d.]+", "");
        double tongTien = Double.parseDouble(tongTienStr);

        String chietKhauStr = lblHDChietKhau.getText().replace("%", "");
        if(chietKhauStr.trim().length()>0){
            chietKhau = Float.parseFloat(chietKhauStr);
        }else{
            chietKhau = 0;
        }
        String tienKhachTraStr = txtTienNhan.getText();
        double tienKhachTra = Double.parseDouble(tienKhachTraStr);

        HoaDon hoaDon = new HoaDon(maHoaDon, khuyenMai, tongTien, chietKhau, tienKhachTra);
        if(chkXuatHD.isSelected())
        {
            XuatHoaDon();
        }
        if (hoaDon_dao.capNhatHoaDon(hoaDon)) {
            try {
                dlgHoaDon.setVisible(false);
                hoaDon = hoaDon_dao.timHoaDonTheoMa(maHoaDon);
                String maPhong = hoaDon.getPhong().getMaPhong();
                String maPhieuDatPhong = phieuDatPhong_dao.timMaPhieuDatPhongTheoMaPhong(maPhong);
                phieuDatPhong_dao.capNhatPhieuDatPhong(maPhieuDatPhong, maPhong);
                JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
                lamMoi();
                phieuDatPhong_dao.layPhieuDatPhongChuaThanhToan().clear();
                docDuLieuTuDataVaoBangPhong();
            } catch (SQLException ex) {
                Logger.getLogger(GUILapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Thanh toán không thành công!");
        }
    }//GEN-LAST:event_btnXacNhanThanhToanActionPerformed

    private void chkXuatHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkXuatHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkXuatHDActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILapHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatDichVu;
    private javax.swing.JButton btnChuyenPhong;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnTimPhong;
    private javax.swing.JButton btnXacNhanThanhToan;
    private javax.swing.JButton btnXoaDichVu;
    private javax.swing.JComboBox<String> cbLoaiDichVu;
    private javax.swing.JComboBox<String> cbTenDichVu;
    private javax.swing.JCheckBox chkXuatHD;
    private javax.swing.JDialog dlgHoaDon;
    private javax.swing.JLabel lblChietKhau;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGiaPhong;
    private javax.swing.JLabel lblGiaPhongHat;
    private javax.swing.JLabel lblGiaTriTenQuan;
    private javax.swing.JLabel lblGioBatDau;
    private javax.swing.JLabel lblGioKetThuc;
    private javax.swing.JLabel lblHDChietKhau;
    private javax.swing.JLabel lblHDDiaChi;
    private javax.swing.JLabel lblHDGioBatDau;
    private javax.swing.JLabel lblHDGioKetThuc;
    private javax.swing.JLabel lblHDKhachHang;
    private javax.swing.JLabel lblHDMaHD;
    private javax.swing.JLabel lblHDMaHoaDon;
    private javax.swing.JLabel lblHDNL;
    private javax.swing.JLabel lblHDNV;
    private javax.swing.JLabel lblHDNgayLap;
    private javax.swing.JLabel lblHDNhanVien;
    private javax.swing.JLabel lblHDSoDienThoai;
    private javax.swing.JLabel lblHoaDon;
    private javax.swing.JLabel lblHoaDonTinhTien;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblLoaiDichVu;
    private javax.swing.JLabel lblMaGG;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhanCach;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTCong;
    private javax.swing.JLabel lblTenDichVu;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTenPhong;
    private javax.swing.JLabel lblThoiLuong;
    private javax.swing.JLabel lblThoiLuongPhong;
    private javax.swing.JLabel lblThueVAT;
    private javax.swing.JLabel lblTienDV;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienNhan;
    private javax.swing.JLabel lblTienP;
    private javax.swing.JLabel lblTienThanhToan;
    private javax.swing.JLabel lblTienThoi;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTimPhong;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTongCong;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTienDV;
    private javax.swing.JLabel lblTongTienDichVu;
    private javax.swing.JLabel lblTongTienPhong;
    private javax.swing.JLabel lblVAT;
    private javax.swing.JMenu mnHeThong;
    private javax.swing.JMenuItem mniCapNhatDichVu;
    private javax.swing.JMenuItem mniCapNhatKhachHang;
    private javax.swing.JMenuItem mniCapNhatKhuyenMai;
    private javax.swing.JMenuItem mniCapNhatLoaiPhong;
    private javax.swing.JMenuItem mniCapNhatNhanVien;
    private javax.swing.JMenuItem mniCapNhatPhong;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDatPhong;
    private javax.swing.JMenuItem mniLapHoaDon;
    private javax.swing.JMenuItem mniThanhToan;
    private javax.swing.JMenuItem mniThongKeDoanhThu;
    private javax.swing.JMenuItem mniThongKeDoanhThuTheoKhachHang;
    private javax.swing.JMenuItem mniTimKiemDichVu;
    private javax.swing.JMenuItem mniTimKiemKhachHang;
    private javax.swing.JMenuItem mniTimKiemKhuyenMai;
    private javax.swing.JMenuItem mniTimKiemNhanVien;
    private javax.swing.JMenuItem mniTimKiemPhong;
    private javax.swing.JMenuItem mniTrangChu;
    private javax.swing.JMenuItem mniTroGiup;
    private javax.swing.JMenu mnuDichVu;
    private javax.swing.JMenu mnuHoaDon;
    private javax.swing.JMenu mnuKhachHang;
    private javax.swing.JMenu mnuKhuyenMai;
    private javax.swing.JMenu mnuNhanVien;
    private javax.swing.JMenu mnuPhong;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenuBar mnuTong;
    private javax.swing.JPanel pnDichVu;
    private javax.swing.JPanel pnTieuDe;
    private javax.swing.JPanel pnTime;
    private javax.swing.JPanel pnlDanhSachDichVu;
    private javax.swing.JPanel pnlDanhSachPhong;
    private javax.swing.JPanel pnlThongTinChiTietPhong;
    private javax.swing.JScrollPane scrDanhSachDichVu;
    private javax.swing.JScrollPane scrDanhSachDichVuHD1;
    private javax.swing.JScrollPane scrDanhSachPhong2;
    private javax.swing.JTable tblDanhSachChiTietPhong;
    private javax.swing.JTable tblDanhSachDichVu;
    private javax.swing.JTable tblDanhSachPhong;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTienNhan;
    // End of variables declaration//GEN-END:variables
}
