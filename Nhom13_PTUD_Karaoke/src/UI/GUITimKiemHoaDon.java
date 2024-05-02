/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import connectdb.ConnectDB;
import dao.CTDichVu_DAO;
import dao.CTHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.CT_DichVu;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.PhanQuyen;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.TextSyntax;
import javax.print.attribute.standard.DocumentName;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;


public class GUITimKiemHoaDon extends javax.swing.JFrame {
    HoaDon_DAO hoaDon_dao = new HoaDon_DAO();
    CTHoaDon_DAO ctHoaDon_dao = new CTHoaDon_DAO();
    CTDichVu_DAO ctDichVu_dao = new CTDichVu_DAO();
    DefaultTableModel dftblDichVu;
    public GUITimKiemHoaDon() {
        initComponents();
        setSize(1520, 780);
        setLocationRelativeTo(null);
        dlgHoaDon.setLocationRelativeTo(null);
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        kiemTraQuyen();
    }

    private void kiemTraQuyen() {
        if (PhanQuyen.coQuyenCapNhatNhanVien()) {
            // Hiển thị các chức năng cho quản lý
            mnuNhanVien.setEnabled(true);
        } else {
            // Ẩn hoặc làm mờ các chức năng cho nhân viên
            mnuNhanVien.setEnabled(false);
        }
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
        lblTienP = new javax.swing.JLabel();
        lblTCong = new javax.swing.JLabel();
        lblTongCong = new javax.swing.JLabel();
        lblTienDichVu = new javax.swing.JLabel();
        lblHDTienNhan = new javax.swing.JLabel();
        btnXuatHoaDon = new javax.swing.JButton();
        pnlThongTinHoaDon = new javax.swing.JPanel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblNgayLapHoaDon = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        txtNgayLapHoaDon = new com.toedter.calendar.JDateChooser();
        btnTimKiem = new javax.swing.JButton();
        btnHienThiChiTiet = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlDanhSachHoaDon = new javax.swing.JPanel();
        scrDanhSachHoaDon = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new javax.swing.JTable();
        pnlTieuDe = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        mniDatPhongCho = new javax.swing.JMenuItem();
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

        pnlDanhSachDichVu.add(scrDanhSachDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 22, 650, 300));

        dlgHoaDon.getContentPane().add(pnlDanhSachDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 226, 660, 330));

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
        dlgHoaDon.getContentPane().add(lblThueVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, 30));

        lblVAT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVAT.setText("10.0%");
        dlgHoaDon.getContentPane().add(lblVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, 30));

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
        dlgHoaDon.getContentPane().add(lblTienThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 650, -1, -1));

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 51, 51));
        lblTongTien.setText("1,482,000 VND");
        dlgHoaDon.getContentPane().add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 650, -1, -1));

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
        dlgHoaDon.getContentPane().add(btnQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 690, 150, 40));

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

        lblHDTienNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHDTienNhan.setText("2");
        dlgHoaDon.getContentPane().add(lblHDTienNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, -1, -1));

        btnXuatHoaDon.setBackground(new java.awt.Color(255, 255, 153));
        btnXuatHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/payment.png"))); // NOI18N
        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });
        dlgHoaDon.getContentPane().add(btnXuatHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, -1, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnlThongTinHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaHoaDon.setText("Mã hoá đơn:");
        pnlThongTinHoaDon.add(lblMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        lblNgayLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNgayLapHoaDon.setText("Ngày lập HD:");
        pnlThongTinHoaDon.add(lblNgayLapHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 40));

        txtMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(txtMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 258, 40));

        txtNgayLapHoaDon.setDateFormatString("dd/MM/yyyy");
        txtNgayLapHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pnlThongTinHoaDon.add(txtNgayLapHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 200, 40));

        btnTimKiem.setBackground(new java.awt.Color(255, 0, 51));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 200, 50));

        btnHienThiChiTiet.setBackground(new java.awt.Color(204, 204, 204));
        btnHienThiChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHienThiChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/view.png"))); // NOI18N
        btnHienThiChiTiet.setText("XEM CHI TIẾT");
        btnHienThiChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiChiTietActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnHienThiChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 210, 50));

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.setIconTextGap(15);
        btnLamMoi.setMargin(new java.awt.Insets(5, 14, 3, 14));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnlThongTinHoaDon.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, 190, 50));

        getContentPane().add(pnlThongTinHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 1500, 90));

        tblDanhSachHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Ngày lập hoá đơn", "Nhân viên", "Khách hàng", "Mã phòng", "Giờ trả phòng", "Tiền nhận", "Chiết khấu", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachHoaDon.setRowHeight(30);
        tblDanhSachHoaDon.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tblDanhSachHoaDonComponentAdded(evt);
            }
        });
        tblDanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachHoaDonMouseClicked(evt);
            }
        });
        scrDanhSachHoaDon.setViewportView(tblDanhSachHoaDon);
        if (tblDanhSachHoaDon.getColumnModel().getColumnCount() > 0) {
            tblDanhSachHoaDon.getColumnModel().getColumn(1).setMinWidth(100);
            tblDanhSachHoaDon.getColumnModel().getColumn(2).setMinWidth(30);
        }

        javax.swing.GroupLayout pnlDanhSachHoaDonLayout = new javax.swing.GroupLayout(pnlDanhSachHoaDon);
        pnlDanhSachHoaDon.setLayout(pnlDanhSachHoaDonLayout);
        pnlDanhSachHoaDonLayout.setHorizontalGroup(
            pnlDanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 1510, Short.MAX_VALUE)
        );
        pnlDanhSachHoaDonLayout.setVerticalGroup(
            pnlDanhSachHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDanhSachHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        getContentPane().add(pnlDanhSachHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1510, 480));

        pnlTieuDe.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDe.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDe.setText("QUẢN LÝ THÔNG TIN HÓA ĐƠN");

        javax.swing.GroupLayout pnlTieuDeLayout = new javax.swing.GroupLayout(pnlTieuDe);
        pnlTieuDe.setLayout(pnlTieuDeLayout);
        pnlTieuDeLayout.setHorizontalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDeLayout.createSequentialGroup()
                .addGap(622, 622, 622)
                .addComponent(lblTieuDe)
                .addContainerGap(550, Short.MAX_VALUE))
        );
        pnlTieuDeLayout.setVerticalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblTieuDe)
                .addGap(28, 28, 28))
        );

        getContentPane().add(pnlTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("DANH SÁCH HÓA ĐƠN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 40));

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
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
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

        mniDatPhongCho.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniDatPhongCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lich_lam.png"))); // NOI18N
        mniDatPhongCho.setText("Đặt phòng chờ");
        mniDatPhongCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDatPhongChoActionPerformed(evt);
            }
        });
        mnuPhong.add(mniDatPhongCho);

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

    private void tblDanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonMouseClicked

    }//GEN-LAST:event_tblDanhSachHoaDonMouseClicked

    private void tblDanhSachHoaDonComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tblDanhSachHoaDonComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachHoaDonComponentAdded

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void mniTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTrangChuActionPerformed
        GUITrangChu tc = new GUITrangChu();
        tc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTrangChuActionPerformed

    private void mniTroGiupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTroGiupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniTroGiupActionPerformed

    private void mniCapNhatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatPhongActionPerformed
        GUICapNhatPhong cnp = new GUICapNhatPhong();
        cnp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatPhongActionPerformed

    private void mniCapNhatLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatLoaiPhongActionPerformed
        GUICapNhatLoaiPhong cnlp = new GUICapNhatLoaiPhong();
        cnlp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatLoaiPhongActionPerformed

    private void mniTimKiemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemPhongActionPerformed
        GUITimKiemPhong tkp = new GUITimKiemPhong();
        tkp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemPhongActionPerformed

    private void mniDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDatPhongActionPerformed
        // TODO add your handling code here:
        GUIDatPhong ttdp = new GUIDatPhong();
        ttdp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniDatPhongActionPerformed

    private void mniDatPhongChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDatPhongChoActionPerformed

    }//GEN-LAST:event_mniDatPhongChoActionPerformed

    private void mniCapNhatNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatNhanVienActionPerformed
        GUICapNhatNhanVien cnnv = new GUICapNhatNhanVien();
        cnnv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatNhanVienActionPerformed

    private void mniTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemNhanVienActionPerformed
        GUITimKiemNhanVien tknv = new GUITimKiemNhanVien();
        tknv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemNhanVienActionPerformed

    private void mniCapNhatKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatKhachHangActionPerformed
        GUICapNhatKhachHang cnkh = new GUICapNhatKhachHang();
        cnkh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatKhachHangActionPerformed

    private void mniTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemKhachHangActionPerformed
        GUITimKiemKhachHang tkkh = new GUITimKiemKhachHang();
        tkkh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemKhachHangActionPerformed

    private void mniThongKeDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeDoanhThuActionPerformed
        GUIThongKeDoanhThu tkdt = new GUIThongKeDoanhThu();
        tkdt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniThongKeDoanhThuActionPerformed

    private void mniThongKeDoanhThuTheoKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeDoanhThuTheoKhachHangActionPerformed
        GUIThongKeKhachHang tkdtkh = new GUIThongKeKhachHang();
        tkdtkh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniThongKeDoanhThuTheoKhachHangActionPerformed

    private void mniLapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLapHoaDonActionPerformed
        GUILapHoaDon lhd = new GUILapHoaDon();
        lhd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniLapHoaDonActionPerformed

    private void mniThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThanhToanActionPerformed
        GUITimKiemHoaDon tt = new GUITimKiemHoaDon();
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniThanhToanActionPerformed

    private void mniCapNhatDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatDichVuActionPerformed
        GUICapNhatDichVu cndv = new GUICapNhatDichVu();
        cndv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatDichVuActionPerformed

    private void mniTimKiemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemDichVuActionPerformed
        GUITimKiemDichVu tkdv = new GUITimKiemDichVu();
        tkdv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemDichVuActionPerformed

    private void mniCapNhatKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCapNhatKhuyenMaiActionPerformed
        GUICapNhatKhuyenMai cnkm = new GUICapNhatKhuyenMai();
        cnkm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniCapNhatKhuyenMaiActionPerformed

    private void mniTimKiemKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTimKiemKhuyenMaiActionPerformed
        GUITimKiemKhuyenMai tkkm = new GUITimKiemKhuyenMai();
        tkkm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniTimKiemKhuyenMaiActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblDanhSachHoaDon.getModel();
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        SimpleDateFormat dfg = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String maHoaDon = txtMaHoaDon.getText();
        Date ngayLapHoaDon = txtNgayLapHoaDon.getDate();
        if(maHoaDon.trim().length()==0 && ngayLapHoaDon==null){
            JOptionPane.showMessageDialog(this, "Ban chua nhap ma hoa don!");
            return;
        }else if(maHoaDon.trim().length()>0 && ngayLapHoaDon!=null){
            JOptionPane.showMessageDialog(this, "Khong tim cung luc ma va ngay!");
            return;
        }
        if(maHoaDon.trim().length()>0){
            if(hoaDon_dao.kiemTraHoaDonTonTai(maHoaDon)){
                model.setRowCount(0);
                danhSachHoaDon = hoaDon_dao.timChiTietHoaDonTheoMa(maHoaDon);
                for (HoaDon hoaDon : danhSachHoaDon) {
                    Object[] row = new Object[]{
                            hoaDon.getMaHD(),
                            df.format(hoaDon.getNgayLapHD()),
                            hoaDon.getNhanVien().getTenNhanVien(),
                            hoaDon.getTenKhachHang(),
                            hoaDon.getPhong().getMaPhong(),
                            dfg.format(hoaDon.getGioTraPhong()),
                            hoaDon.getTienKhachTra(),
                            hoaDon.getChietKhau(),
                            hoaDon.getTongTien()
                    };
                    model.addRow(row);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Ma hoa don sai hoac khong ton tai!");
            }
        }
        if(ngayLapHoaDon!=null){
            model.setRowCount(0);
            danhSachHoaDon = hoaDon_dao.timChiTietHoaDonTheoNgay(new java.sql.Date(ngayLapHoaDon.getTime()));
            for (HoaDon hoaDon : danhSachHoaDon) {
                Object[] row = new Object[]{
                        hoaDon.getMaHD(),
                        df.format(hoaDon.getNgayLapHD()),
                        hoaDon.getNhanVien().getTenNhanVien(),
                        hoaDon.getTenKhachHang(),
                        hoaDon.getPhong().getMaPhong(),
                        dfg.format(hoaDon.getGioTraPhong()),
                        hoaDon.getTienKhachTra(),
                        hoaDon.getChietKhau(),
                        hoaDon.getTienKhachTra(),
                        hoaDon.getTongTien()
                };
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnHienThiChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiChiTietActionPerformed
        int row = tblDanhSachHoaDon.getSelectedRow();
        ArrayList<CT_DichVu> DSCTDV = new ArrayList<>();
        ArrayList<CT_HoaDon> DSCTHD = new ArrayList<>();
        dftblDichVu = (DefaultTableModel) tblDanhSachDichVu.getModel();
        DecimalFormat dft = new DecimalFormat("#");
        dftblDichVu.setRowCount(0);
        float tienThueVAT = 0;
        float thueVAT = 10;
        double tongTienDichVu = 0, tongTienPhong = 0, tienChietKhau = 0, tongCong = 0, tongTien = 0, tienThua = 0;
        HoaDon hoaDon = null;
        int stt=1;
        if (row >= 0) {
            String maPhong = tblDanhSachHoaDon.getValueAt(row, 4).toString();
            dlgHoaDon.setVisible(true);
            String maHoaDon = tblDanhSachHoaDon.getValueAt(row, 0).toString();
            lblHDMaHoaDon.setText(maHoaDon);
            
            hoaDon = hoaDon_dao.timHoaDonTheoMa(maHoaDon);
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayLapHD = hoaDon.getNgayLapHD();
            String ngayLapHoaDon = df.format(ngayLapHD);
            lblHDNgayLap.setText(ngayLapHoaDon);
            
            String tenNhanVien = tblDanhSachHoaDon.getValueAt(row, 2).toString();
            lblHDNhanVien.setText(tenNhanVien);
            
            String tenKhachHang = tblDanhSachHoaDon.getValueAt(row, 3).toString();
            lblHDKhachHang.setText(tenKhachHang);
   
            SimpleDateFormat dfg = new SimpleDateFormat("HH:mm:ss");
            Date gioNhanPhongDate = hoaDon.getGioNhanPhong();
            String gioNhanPhong = dfg.format(gioNhanPhongDate);
            lblHDGioBatDau.setText(gioNhanPhong);

            String gioTraPhong = tblDanhSachHoaDon.getValueAt(row, 5).toString();
            lblHDGioKetThuc.setText(gioTraPhong);

            ctHoaDon_dao.layDanhSachCTHoaDon(maHoaDon).clear();
            DSCTHD = ctHoaDon_dao.layDanhSachCTHoaDon(maHoaDon);
            for(CT_HoaDon ctHD : DSCTHD) { 
                dftblDichVu.addRow(new Object[] {stt,ctHD.getPhong().getTenPhong(), ctHD.getPhong().getGiaPhong(),
                ctHD.getThoiLuong()+" phút","Gio", ctHD.thanhTien()});
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
            String chietKhauStr = tblDanhSachHoaDon.getValueAt(row, 7).toString();
            float chietKhau = Float.parseFloat(chietKhauStr);
            String tienNhanSTr =tblDanhSachHoaDon.getValueAt(row, 6).toString();
            float tienNhan = Float.parseFloat(tienNhanSTr);
            lblHDTienNhan.setText(tienNhan + " đ");
            tongCong = tongTienDichVu + tongTienPhong;
            tienThueVAT = (float) ((thueVAT / 100) * tongCong);
            lblTongCong.setText(dft.format(tongCong)+ " đ");
            tienChietKhau = (chietKhau/100)*tongCong;  
            tongTien = tongCong + tienThueVAT - tienChietKhau;
            lblTongTien.setText(dft.format(tongTien) +" đ");
            tienThua = tienNhan - tongTien;
            lblTienThua.setText(dft.format(tienThua) + " đ");
        }else{
            JOptionPane.showMessageDialog(this, "Chưa chọn phòng để thanh toán");
        }
    }//GEN-LAST:event_btnHienThiChiTietActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        dlgHoaDon.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    private void dlgHoaDonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dlgHoaDonComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_dlgHoaDonComponentShown

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        try {
            // TODO add your handling code here:
            Document doc = new Document();
            String maHD = lblHDMaHoaDon.getText();
            
            //PdfFont font = PdfFontFactory.createFont("UniArial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            String desktopPath = System.getProperty("user.home") + "/Downloads/Nhom13_PTUD/Karaoke/src/PDF/";
            PdfWriter.getInstance(doc, new FileOutputStream(desktopPath+maHD+".pdf"));
            doc.open();
            Paragraph tenQuan = new Paragraph("Karaoke MMM",FontFactory.getFont(FontFactory.COURIER,25,Font.BOLD));
            Paragraph soDT = new Paragraph("Dien thoai : (076) 5599 103 - 0978.007.007",FontFactory.getFont(FontFactory.COURIER));
            Paragraph diaChi = new Paragraph("Dia chi : Nguyen Van Bao, p4, Q.Go Vap, TP.HCM",FontFactory.getFont(FontFactory.COURIER));
            Paragraph crss = new Paragraph("-------------------------------------------------------------");
            Paragraph title = new Paragraph("Hoa don tinh tien",FontFactory.getFont(FontFactory.COURIER,35,Font.BOLD));
            tenQuan.setAlignment(Element.ALIGN_CENTER);
            diaChi.setAlignment(Element.ALIGN_CENTER);
            title.setAlignment(Element.ALIGN_CENTER);
            crss.setAlignment(Element.ALIGN_CENTER);
            soDT.setAlignment(Element.ALIGN_CENTER);
            doc.add(tenQuan);
            doc.add(soDT);
            doc.add(diaChi);
            doc.add(crss);
            doc.add(title);
            doc.add(new Paragraph("\n"));

            String ngayThanhToan = lblHDNgayLap.getText();
            
            Paragraph prNgayThanhToan = new Paragraph("Ngay lap :"+ngayThanhToan);         
            String gioNP = lblHDGioBatDau.getText();
            Paragraph prMaHD = new Paragraph("Ma hoa don : "+ maHD);
            
            String tenNV = lblHDNhanVien.getText();
            Paragraph prTenNV = new Paragraph("Nhan vien : "+ tenNV);
            String gioBatDau = lblHDGioKetThuc.getText();
            Paragraph prGioBatDau = new Paragraph("Gio bat dau : " + gioBatDau);
       
            String tenKH = lblHDKhachHang.getText();
            Paragraph prKhachHang = new Paragraph("Khach hang : " + tenKH);
            String gioKetThuc = lblHDGioKetThuc.getText();
            Paragraph prGioKetThuc = new Paragraph("Gio ket thuc : " + gioKetThuc); 
            PdfPTable tblThongTinHoaDon = new PdfPTable(2);
            tblThongTinHoaDon.setWidthPercentage(100);
            float[] columnWidths = {70f, 50f}; // Phân chia độ rộng cho 2 cột, có thể điều chỉnh theo ý muốn
            tblThongTinHoaDon.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell();
            cell1.addElement(prMaHD);
            cell1.addElement(prTenNV);
            cell1.addElement(prKhachHang);
            cell1.setBorder(Rectangle.NO_BORDER);

            PdfPCell cell2 = new PdfPCell();
            cell2.addElement(prNgayThanhToan);
            cell2.addElement(prGioBatDau);
            cell2.addElement(prGioKetThuc);            
            cell2.setBorder(Rectangle.NO_BORDER);

            tblThongTinHoaDon.addCell(cell1);
            tblThongTinHoaDon.addCell(cell2);
            doc.add(tblThongTinHoaDon);
            doc.add(new Paragraph("\n\n"));
            //Add table
            PdfPTable tblThongTinHD = new PdfPTable(6);
            Paragraph tblTitle = new Paragraph("Thong tin hoa don");
            tblTitle.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cell = new PdfPCell(tblTitle);
            cell.setColspan(8);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tblThongTinHD.addCell(cell);
            tblThongTinHD.addCell("Stt");
            tblThongTinHD.addCell("Ten dich vu");
            tblThongTinHD.addCell("Don gia");
            tblThongTinHD.addCell("So luong");
            tblThongTinHD.addCell("Don vi tinh");
            tblThongTinHD.addCell("Thanh tien");
            for(int i=0;i<tblDanhSachDichVu.getRowCount();i++)
            {
                String stt = tblDanhSachDichVu.getValueAt(i, 0).toString();
                String maDV = tblDanhSachDichVu.getValueAt(i, 1).toString();
                String tenDV = tblDanhSachDichVu.getValueAt(i, 2).toString();
                String soLuong = tblDanhSachDichVu.getValueAt(i, 3).toString();
                String donViTinh = tblDanhSachDichVu.getValueAt(i, 4).toString();
                String giaBan = tblDanhSachDichVu.getValueAt(i, 5).toString();
                tblThongTinHD.addCell(stt);
                tblThongTinHD.addCell(maDV);
                tblThongTinHD.addCell(tenDV);
                tblThongTinHD.addCell(soLuong);
                tblThongTinHD.addCell(donViTinh);
                tblThongTinHD.addCell(giaBan);
            }
            doc.add(tblThongTinHD);
            doc.add(new Paragraph("\n\n\n"));
            Phrase dong4 = new Phrase();
            String chietKhau = lblHDChietKhau.getText();
            Paragraph prChietKhau = new Paragraph("Chiet khau : "+ chietKhau);
            
            String thueVAT = lblVAT.getText();
            Paragraph prThueVAT = new Paragraph("Thue VAT : " + thueVAT);
            // Thêm đoạn văn bản đầu tiên và đặt căng đều cho nó
            
            String tienNhan = lblHDTienNhan.getText();
            Paragraph prTienNhan = new Paragraph("Tien nhan : " + tienNhan);
            String tienThoi = lblTienThua.getText();
            Paragraph prTienThoi = new Paragraph("Tien thoi : " + tienThoi);

            
            Phrase dong5 = new Phrase();
            String tienDichVu = lblTienDichVu.getText();
            Paragraph prTienDichVu = new Paragraph("Tien dich vu : " + tienDichVu);
            String tienPhong = lblTongTienPhong.getText();
            Paragraph prTienPhong = new Paragraph("Tien phong : " + tienPhong);
            String tongCong = lblTongCong.getText();
            Paragraph prTongCong = new Paragraph("Tong cong : " + tongCong);
            
            String tongTien = lblTongTien.getText();
            Paragraph prTongTien = new Paragraph("Tong tien : " + tongTien);
            
            
            PdfPTable tblChiTietHoaDon = new PdfPTable(2);
            tblChiTietHoaDon.setWidthPercentage(100);
            float[] cotRongTblThongTin = {70f, 50f}; // Phân chia độ rộng cho 2 cột, có thể điều chỉnh theo ý muốn
            tblChiTietHoaDon.setWidths(columnWidths);

            PdfPCell cot1TblThongTin = new PdfPCell();
            cot1TblThongTin.addElement(prChietKhau);
            cot1TblThongTin.addElement(prTienNhan);
            cot1TblThongTin.addElement(prTienThoi);
            cot1TblThongTin.addElement(prThueVAT);
            cot1TblThongTin.setBorder(Rectangle.NO_BORDER);

            PdfPCell cot2TblThongTin = new PdfPCell();                       
            cot2TblThongTin.addElement(prTienDichVu);
            cot2TblThongTin.addElement(prTienPhong);
            cot2TblThongTin.addElement(prTongCong);            
            cot2TblThongTin.addElement(prTongTien);
            cot2TblThongTin.setBorder(Rectangle.NO_BORDER);

            tblChiTietHoaDon.addCell(cot1TblThongTin);
            tblChiTietHoaDon.addCell(cot2TblThongTin);
            doc.add(tblChiTietHoaDon);
            doc.add(new Paragraph("\n\n"));
            Paragraph end = new Paragraph("Cam on quy khach",FontFactory.getFont(FontFactory.COURIER,25));
            end.setAlignment(Element.ALIGN_CENTER);
            doc.add(end);
            doc.close();
            JOptionPane.showMessageDialog(null, "Xuất file PDF thành công");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Xuất file PDF không thành công");
        }
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaHoaDon.setText("");
        txtNgayLapHoaDon.setDate(null);
        txtMaHoaDon.requestFocus();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel model = (DefaultTableModel) tblDanhSachHoaDon.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUITimKiemHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThiChiTiet;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JDialog dlgHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblChietKhau;
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
    private javax.swing.JLabel lblHDTienNhan;
    private javax.swing.JLabel lblHoaDonTinhTien;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNgayLapHoaDon;
    private javax.swing.JLabel lblPhanCach;
    private javax.swing.JLabel lblTCong;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblThueVAT;
    private javax.swing.JLabel lblTienDV;
    private javax.swing.JLabel lblTienDichVu;
    private javax.swing.JLabel lblTienNhan;
    private javax.swing.JLabel lblTienP;
    private javax.swing.JLabel lblTienThanhToan;
    private javax.swing.JLabel lblTienThoi;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTongCong;
    private javax.swing.JLabel lblTongTien;
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
    private javax.swing.JMenuItem mniDatPhongCho;
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
    private javax.swing.JPanel pnlDanhSachDichVu;
    private javax.swing.JPanel pnlDanhSachHoaDon;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private javax.swing.JPanel pnlTieuDe;
    private javax.swing.JScrollPane scrDanhSachDichVu;
    private javax.swing.JScrollPane scrDanhSachHoaDon;
    private javax.swing.JTable tblDanhSachDichVu;
    private javax.swing.JTable tblDanhSachHoaDon;
    private javax.swing.JTextField txtMaHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayLapHoaDon;
    // End of variables declaration//GEN-END:variables
}
