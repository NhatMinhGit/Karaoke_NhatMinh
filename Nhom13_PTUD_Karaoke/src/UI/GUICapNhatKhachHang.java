package UI;

import connectdb.ConnectDB;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import entity.KhachHang;
import dao.KhachHang_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import entity.PhanQuyen;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUICapNhatKhachHang extends javax.swing.JFrame {
    private String soDienThoai;
    private KhachHang_DAO khachHang_dao = new KhachHang_DAO();
    private DefaultTableModel model;

    public GUICapNhatKhachHang() {
        initComponents();
        setSize(1520, 780);
        setLocationRelativeTo(null);
        txtMaKhachHang.setEditable(false);
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

    public void docDuLieuVaoBang() throws SQLException {
        model = (DefaultTableModel) tblDanhSachKhachHang.getModel();
        model.setRowCount(0);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<KhachHang> dsKH = khachHang_dao.layDanhSachKhachHang();
        for (KhachHang kh : dsKH) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
        }
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
        txtSoDT.setText(soDienThoai);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupRad = new javax.swing.ButtonGroup();
        pnlDanhSachKhachHang = new javax.swing.JPanel();
        scrDanhSachNhanVien = new javax.swing.JScrollPane();
        tblDanhSachKhachHang = new javax.swing.JTable();
        pnCapNhat = new javax.swing.JPanel();
        lblMaKhachHang = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        lblSoDT = new javax.swing.JLabel();
        lblSoCCCD = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblTenKhachHang = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoCCCD = new javax.swing.JTextField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        dateNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnDatPhong = new javax.swing.JButton();
        pnTieuDe = new javax.swing.JPanel();
        lblTieuDe1 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Design by MMM");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tblDanhSachKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblDanhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số điện thoại", "Số CCCD", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachKhachHang.setRowHeight(25);
        tblDanhSachKhachHang.setSelectionBackground(new java.awt.Color(51, 153, 255));
        tblDanhSachKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachKhachHangMouseClicked(evt);
            }
        });
        scrDanhSachNhanVien.setViewportView(tblDanhSachKhachHang);
        if (tblDanhSachKhachHang.getColumnModel().getColumnCount() > 0) {
            tblDanhSachKhachHang.getColumnModel().getColumn(0).setMinWidth(150);
            tblDanhSachKhachHang.getColumnModel().getColumn(0).setMaxWidth(1000);
            tblDanhSachKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(2).setMinWidth(100);
            tblDanhSachKhachHang.getColumnModel().getColumn(2).setMaxWidth(1000);
            tblDanhSachKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(4).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(5).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(6).setMinWidth(400);
        }

        javax.swing.GroupLayout pnlDanhSachKhachHangLayout = new javax.swing.GroupLayout(pnlDanhSachKhachHang);
        pnlDanhSachKhachHang.setLayout(pnlDanhSachKhachHangLayout);
        pnlDanhSachKhachHangLayout.setHorizontalGroup(
            pnlDanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSachKhachHangLayout.createSequentialGroup()
                .addComponent(scrDanhSachNhanVien)
                .addContainerGap())
        );
        pnlDanhSachKhachHangLayout.setVerticalGroup(
            pnlDanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDanhSachNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pnCapNhat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMaKhachHang.setText("Mã khách hàng:");
        pnCapNhat.add(lblMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNgaySinh.setText("Ngày sinh:");
        pnCapNhat.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, 30));

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaKhachHang.setEnabled(false);
        pnCapNhat.add(txtMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 230, 40));

        lblSoDT.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoDT.setText("Số điện thoại:");
        pnCapNhat.add(lblSoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        lblSoCCCD.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoCCCD.setText("Số CCCD:");
        pnCapNhat.add(lblSoCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 111, -1));

        txtSoDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDTActionPerformed(evt);
            }
        });
        pnCapNhat.add(txtSoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 230, 40));

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDiaChi.setText("Địa chỉ:");
        pnCapNhat.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 90, -1));

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiaChi.setText("TP,HCM");
        pnCapNhat.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 390, 40));

        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTenKhachHang.setText("Tên khách hàng:");
        pnCapNhat.add(lblTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblGioiTinh.setText("Giới tính:");
        pnCapNhat.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 20));

        txtTenKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnCapNhat.add(txtTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 220, 40));

        txtSoCCCD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSoCCCD.setText("0712345678914");
        pnCapNhat.add(txtSoCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 220, 40));

        groupRad.add(radNam);
        radNam.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        radNam.setText("Nam");
        pnCapNhat.add(radNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, 20));

        groupRad.add(radNu);
        radNu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        radNu.setText("Nữ");
        pnCapNhat.add(radNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 20));

        btnThem.setBackground(new java.awt.Color(204, 204, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnCapNhat.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 60, 200, 50));

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnCapNhat.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 200, 50));

        btnCapNhat.setBackground(new java.awt.Color(255, 153, 102));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        pnCapNhat.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 120, 200, 50));

        dateNgaySinh.setDateFormatString("dd/MM/yyyy");
        dateNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateNgaySinh.setPreferredSize(new java.awt.Dimension(64, 30));
        pnCapNhat.add(dateNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 220, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("DANH SÁCH KHÁCH KHÁCH HÀNG:");
        pnCapNhat.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        btnDatPhong.setBackground(new java.awt.Color(102, 51, 0));
        btnDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDatPhong.setForeground(new java.awt.Color(242, 242, 242));
        btnDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/room.png"))); // NOI18N
        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });
        pnCapNhat.add(btnDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 120, 200, 50));

        pnTieuDe.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDe1.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe1.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDe1.setText("QUẢN LÍ THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(lblTieuDe1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTieuDe1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        mnuTong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mnHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system.png"))); // NOI18N
        mnHeThong.setText("Hệ Thống");
        mnHeThong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        mniTrangChu.setText("Trang chủ");
        mniTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTrangChuActionPerformed(evt);
            }
        });
        mnHeThong.add(mniTrangChu);

        mniTroGiup.setText("Trợ giúp");
        mniTroGiup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTroGiupActionPerformed(evt);
            }
        });
        mnHeThong.add(mniTroGiup);

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

        mniCapNhatPhong.setText("Cập nhật phòng");
        mniCapNhatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniCapNhatPhong);

        mniCapNhatLoaiPhong.setText("Cập nhật loại phòng");
        mniCapNhatLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatLoaiPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniCapNhatLoaiPhong);

        mniTimKiemPhong.setText("Tìm kiếm phòng");
        mniTimKiemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniTimKiemPhong);

        mniDatPhong.setText("Đặt phòng");
        mniDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDatPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniDatPhong);

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

        mniCapNhatNhanVien.setText("Cập nhật nhân viên");
        mniCapNhatNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatNhanVienActionPerformed(evt);
            }
        });
        mnuNhanVien.add(mniCapNhatNhanVien);

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

        mniCapNhatKhachHang.setText("Cập nhật khách hàng");
        mniCapNhatKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatKhachHangActionPerformed(evt);
            }
        });
        mnuKhachHang.add(mniCapNhatKhachHang);

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

        mniThongKeDoanhThu.setText("Thống kê doanh thu");
        mniThongKeDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeDoanhThuActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniThongKeDoanhThu);

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

        mniLapHoaDon.setText("Lập hoá đơn");
        mniLapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLapHoaDonActionPerformed(evt);
            }
        });
        mnuHoaDon.add(mniLapHoaDon);

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

        mniCapNhatDichVu.setText("Cập nhật dịch vụ");
        mniCapNhatDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatDichVuActionPerformed(evt);
            }
        });
        mnuDichVu.add(mniCapNhatDichVu);

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

        mniCapNhatKhuyenMai.setText("Cập nhật khuyến mãi");
        mniCapNhatKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCapNhatKhuyenMaiActionPerformed(evt);
            }
        });
        mnuKhuyenMai.add(mniCapNhatKhuyenMai);

        mniTimKiemKhuyenMai.setText("Tìm kiếm khuyến mãi");
        mniTimKiemKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTimKiemKhuyenMaiActionPerformed(evt);
            }
        });
        mnuKhuyenMai.add(mniTimKiemKhuyenMai);

        mnuTong.add(mnuKhuyenMai);

        setJMenuBar(mnuTong);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlDanhSachKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCapNhat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1519, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDanhSachKhachHang.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    // Sự kiện thêm database khi mở 
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            docDuLieuVaoBang();
            System.out.println("Doc Thanh Cong");
        } catch (SQLException ex) {
            System.out.println("Loi");
        }
    }//GEN-LAST:event_formComponentShown
    // Nút thêm khách hàng
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String gioiTinh = "";
        if (txtTenKhachHang.getText().equals("") || txtSoDT.getText().equals("")
                || txtSoCCCD.getText().equals("") || txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        if (radNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (radNu.isSelected()) {
            gioiTinh = "Nữ";
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        String maKH = khachHang_dao.generateMaKhachHang();
        String tenKH = txtTenKhachHang.getText();
        Date ngaySinh = dateNgaySinh.getDate(); // Updated to use dateNgaySinh
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
            return;
        }
        String soDT = txtSoDT.getText();
        String soCCCD = txtSoCCCD.getText();
        String diaChi = txtDiaChi.getText();

        KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, soDT, soCCCD, diaChi);
        model = (DefaultTableModel) tblDanhSachKhachHang.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).equals(maKH)) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
                return;
            }
        }
        try {
            khachHang_dao.themKhachHang(kh);
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed
    // Nút làm mới
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtSoDT.setText("");
        txtSoCCCD.setText("");
        txtDiaChi.setText("");
        groupRad.clearSelection();
        dateNgaySinh.setDate(null);
        txtTenKhachHang.requestFocus();
    }//GEN-LAST:event_btnLamMoiActionPerformed
    // CLick chuột vào thông tin cần cập nhật hiện thông tin khách hàng
    private void tblDanhSachKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachKhachHangMouseClicked
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            int row = tblDanhSachKhachHang.getSelectedRow();
            txtMaKhachHang.setText(model.getValueAt(row, 0).toString());
            txtTenKhachHang.setText(model.getValueAt(row, 1).toString());
            radNam.setSelected("Nam".equals(model.getValueAt(row, 2).toString()));
            radNu.setSelected(!"Nam".equals(model.getValueAt(row, 2).toString()));
            String dateString = model.getValueAt(row, 3).toString();
            Date date = df.parse(dateString);
            dateNgaySinh.setDate(date);
            txtSoDT.setText(model.getValueAt(row, 4).toString());
            txtSoCCCD.setText(model.getValueAt(row, 5).toString());
            txtDiaChi.setText(model.getValueAt(row, 6).toString());
        } catch (ParseException ex) {
            Logger.getLogger(GUICapNhatKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblDanhSachKhachHangMouseClicked
    // Nút cập nhật thông tin khách hàng
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String gioiTinh = "";
        if (txtTenKhachHang.getText().equals("") || txtSoDT.getText().equals("")
                || txtSoCCCD.getText().equals("") || txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        if (radNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (radNu.isSelected()) {
            gioiTinh = "Nữ";
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn giới tính");
            return;
        }
        String maKH = txtMaKhachHang.getText();
        String tenKH = txtTenKhachHang.getText();
        Date ngaySinh = dateNgaySinh.getDate();
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
            return;
        }
        String soDT = txtSoDT.getText();
        String soCCCD = txtSoCCCD.getText();
        String diaChi = txtDiaChi.getText();
        KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, soDT, soCCCD, diaChi);
        try {
            boolean sua = khachHang_dao.suaThongTinKhachHang(kh);
            if (sua) {
                model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                khachHang_dao.layDanhSachKhachHang().clear();
                docDuLieuVaoBang();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật thông tin khách hàng.");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
        GUIDatPhong ttdp = new GUIDatPhong();
        String soDT = txtSoDT.getText();
        ttdp.setSoDienThoai(soDT);
        ttdp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDatPhongActionPerformed

    private void txtSoDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDTActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICapNhatKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private com.toedter.calendar.JDateChooser dateNgaySinh;
    private javax.swing.ButtonGroup groupRad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaKhachHang;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoCCCD;
    private javax.swing.JLabel lblSoDT;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTieuDe1;
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
    private javax.swing.JPanel pnCapNhat;
    private javax.swing.JPanel pnTieuDe;
    private javax.swing.JPanel pnlDanhSachKhachHang;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JScrollPane scrDanhSachNhanVien;
    private javax.swing.JTable tblDanhSachKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoCCCD;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
