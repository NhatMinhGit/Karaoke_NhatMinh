package UI;

import connectdb.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;
import entity.PhanQuyen;
import java.awt.Font;
import java.awt.List;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUITimKiemKhachHang extends javax.swing.JFrame {

    private DefaultTableModel model;
    private KhachHang_DAO khachHang_dao = new KhachHang_DAO();

    public GUITimKiemKhachHang() {
        initComponents();
        setSize(1520, 780);
        setLocationRelativeTo(null);
        // Khởi tạo kết nối CSDL
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
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        model = (DefaultTableModel) tblDanhSachKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> dsKH = khachHang_dao.layDanhSachKhachHang();
        for (KhachHang kh : dsKH) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
        }
        //model.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupRad = new javax.swing.ButtonGroup();
        pnlDanhSachKhachHang = new javax.swing.JPanel();
        scrDanhSachKhachHang = new javax.swing.JScrollPane();
        tblDanhSachKhachHang = new javax.swing.JTable();
        pnTimKiem = new javax.swing.JPanel();
        lblMaKhachHang = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        lblSoDT = new javax.swing.JLabel();
        lblSoCCCD = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        txtSoCCCD = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        lblGioiTinh = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        pnTieuDe = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
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
        setTitle("Karaoke MMM");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        pnlDanhSachKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        scrDanhSachKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        scrDanhSachKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tblDanhSachKhachHang.setAutoCreateRowSorter(true);
        tblDanhSachKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblDanhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày Sinh", "Số điện thoại", "Số CCCD", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSachKhachHang.setGridColor(new java.awt.Color(255, 255, 255));
        tblDanhSachKhachHang.setRowHeight(25);
        tblDanhSachKhachHang.setSelectionBackground(new java.awt.Color(0, 204, 255));
        tblDanhSachKhachHang.setShowGrid(true);
        scrDanhSachKhachHang.setViewportView(tblDanhSachKhachHang);
        tblDanhSachKhachHang.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblDanhSachKhachHang.getColumnModel().getColumnCount() > 0) {
            tblDanhSachKhachHang.getColumnModel().getColumn(0).setMinWidth(150);
            tblDanhSachKhachHang.getColumnModel().getColumn(0).setMaxWidth(1000);
            tblDanhSachKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(2).setMinWidth(100);
            tblDanhSachKhachHang.getColumnModel().getColumn(2).setMaxWidth(300);
            tblDanhSachKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(4).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(5).setResizable(false);
            tblDanhSachKhachHang.getColumnModel().getColumn(6).setMinWidth(400);
            tblDanhSachKhachHang.getColumnModel().getColumn(6).setMaxWidth(1000);
        }

        javax.swing.GroupLayout pnlDanhSachKhachHangLayout = new javax.swing.GroupLayout(pnlDanhSachKhachHang);
        pnlDanhSachKhachHang.setLayout(pnlDanhSachKhachHangLayout);
        pnlDanhSachKhachHangLayout.setHorizontalGroup(
            pnlDanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDanhSachKhachHang)
        );
        pnlDanhSachKhachHangLayout.setVerticalGroup(
            pnlDanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDanhSachKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pnTimKiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMaKhachHang.setText("Mã khách hàng:");
        pnTimKiem.add(lblMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTenKhachHang.setText("Tên khách hàng:");
        pnTimKiem.add(lblTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 30));

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnTimKiem.add(txtMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 210, 40));

        txtTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTenKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHangActionPerformed(evt);
            }
        });
        pnTimKiem.add(txtTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 210, 40));

        lblSoDT.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoDT.setText("Số điện thoại:");
        pnTimKiem.add(lblSoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

        lblSoCCCD.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoCCCD.setText("Số CCCD:");
        pnTimKiem.add(lblSoCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 111, -1));

        txtSoDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSoDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDTActionPerformed(evt);
            }
        });
        pnTimKiem.add(txtSoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 210, 40));

        txtSoCCCD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSoCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoCCCDActionPerformed(evt);
            }
        });
        pnTimKiem.add(txtSoCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 210, 40));

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.setIconTextGap(15);
        btnLamMoi.setMargin(new java.awt.Insets(5, 14, 3, 14));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        pnTimKiem.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, 220, 60));

        btnTimKiem.setBackground(new java.awt.Color(255, 0, 51));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnTimKiem.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 90, 220, 60));

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblGioiTinh.setText("Giới tính:");
        pnTimKiem.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, -1, -1));

        GroupRad.add(radNam);
        radNam.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        radNam.setText("Nam");
        radNam.setMargin(new java.awt.Insets(2, 2, 15, 2));
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });
        pnTimKiem.add(radNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, -1, 40));

        GroupRad.add(radNu);
        radNu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        radNu.setText("Nữ");
        radNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNuActionPerformed(evt);
            }
        });
        pnTimKiem.add(radNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 61, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("DANH SÁCH KHÁCH KHÁCH HÀNG:");
        pnTimKiem.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        pnTieuDe.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDe.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDe.setText("QUẢN LÍ THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addGap(544, 544, 544)
                .addComponent(lblTieuDe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTieuDe)
                .addContainerGap(18, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDanhSachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlDanhSachKhachHang.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDichVuActionPerformed
        // TODO add your handling code here:
        GUITimKiemDichVu ttdv = new GUITimKiemDichVu();
        ttdv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniDichVuActionPerformed

    private void mniKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniKhuyenMaiActionPerformed

    private void mniThongKeDoanhThuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeDoanhThuKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniThongKeDoanhThuKhachHangActionPerformed

    private void mniPhongKaraokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPhongKaraokeActionPerformed
        // TODO add your handling code here:
        GUICapNhatPhong ttp = new GUICapNhatPhong();
        ttp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniPhongKaraokeActionPerformed

    private void mniHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHoaDonActionPerformed
        // TODO add your handling code here:
        GUITimKiemHoaDon tthd = new GUITimKiemHoaDon();
        tthd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniHoaDonActionPerformed

    private void txtTenKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHangActionPerformed

    private void txtSoCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoCCCDActionPerformed

    private void txtSoDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDTActionPerformed

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed
    // Nút làm mới các text
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtSoDT.setText("");
        txtSoCCCD.setText("");
        GroupRad.clearSelection();
        txtMaKhachHang.requestFocus();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        model = (DefaultTableModel) tblDanhSachKhachHang.getModel();
        model.setRowCount(0);
        ArrayList<KhachHang> dsKH = null;
        try {
            khachHang_dao.layDanhSachKhachHang().clear();
            dsKH = khachHang_dao.layDanhSachKhachHang();
        } catch (SQLException ex) {
            Logger.getLogger(GUITimKiemKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (KhachHang kh : dsKH) {
            model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            docDuLieuVaoBang();
            System.out.println("Doc Thanh Cong");
        } catch (SQLException ex) {
            System.out.println("Loi");
        }
    }//GEN-LAST:event_formComponentShown
    // Nút tìm kiếm
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // Khai báo các giá trị cần thiết
        ArrayList<KhachHang> dskh = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        KhachHang kh = null;
        String ma = txtMaKhachHang.getText();
        String ten = txtTenKhachHang.getText();
        String soDT = txtSoDT.getText();
        String soCCCD = txtSoCCCD.getText();
        String gioiTinh = "";
        if (radNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (radNu.isSelected()) {
            gioiTinh = "Nữ";
        }
        // Lỗi kiểm tra không tìm nhiều giá trị cùng lúc
        if (ma.trim().length() > 0 && ten.trim().length() > 0 || ma.trim().length() > 0 && ten.trim().length() > 0 && soDT.trim().length() > 0) {
            JOptionPane.showMessageDialog(this, "Chi tim kiem tren text 1 gia tri can tim");
        } else {
            //Tìm theo mã
            if (ma.trim().length() > 0) {
                kh = khachHang_dao.timKhachHangTheoMaKH(ma);
                if (kh != null) {
                    model.setRowCount(0);
                    model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
                } else {
                    JOptionPane.showMessageDialog(this, "Khong tim thay du lieu");
                }
            }
            // Tìm theo tên
            if (ten.trim().length() > 0) {
                kh = khachHang_dao.timKhachHangTheoTenKH(ten);
                if (kh != null) {
                    model.setRowCount(0);
                    model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
                } else {
                    JOptionPane.showMessageDialog(this, "Khong tim thay du lieu");
                }
            }
            // Tìm theo số điện thoại
            if (soDT.trim().length() > 0) {
                kh = khachHang_dao.timKhachHangTheoSoDT(soDT);
                if (kh != null) {
                    model.setRowCount(0);
                    model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
                } else {
                    JOptionPane.showMessageDialog(this, "Khong tim thay du lieu");
                }
            }
            // Tìm theo số căn cước công dân
            if (soCCCD.trim().length() > 0) {
                kh = khachHang_dao.timKhachHangTheoSoCCCD(soCCCD);
                if (kh != null) {
                    model.setRowCount(0);
                    model.addRow(new Object[]{kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getGioiTinh(), df.format(kh.getNgaySinh()), kh.getSoDT(), kh.getSoCCCD(), kh.getDiaChi()});
                } else {
                    JOptionPane.showMessageDialog(this, "Khong tim thay du lieu");
                }
            }
            // Tìm kiếm theo giới tính
            if (!gioiTinh.isEmpty()) {
                khachHang_dao.getDSKHGioiTinh().clear();
                model.setRowCount(0);
                try {
                    dskh = khachHang_dao.timKhachHangTheoGioiTinh(gioiTinh);
                    if (dskh.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Khong tim thay du lieu");
                    } else {
                        for (KhachHang kh1 : dskh) {
                            model.addRow(new Object[]{kh1.getMaKhachHang(), kh1.getTenKhachHang(), kh1.getGioiTinh(), df.format(kh1.getNgaySinh()), kh1.getSoDT(), kh1.getSoCCCD(), kh1.getDiaChi()});
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi trong quá trình tìm kiếm: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void radNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNuActionPerformed

    }//GEN-LAST:event_radNuActionPerformed

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUITimKiemKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupRad;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaKhachHang;
    private javax.swing.JLabel lblSoCCCD;
    private javax.swing.JLabel lblSoDT;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTieuDe;
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
    private javax.swing.JPanel pnTieuDe;
    private javax.swing.JPanel pnTimKiem;
    private javax.swing.JPanel pnlDanhSachKhachHang;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JScrollPane scrDanhSachKhachHang;
    private javax.swing.JTable tblDanhSachKhachHang;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoCCCD;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
