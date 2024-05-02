
package UI;

import connectdb.ConnectDB;
import dao.KhuyenMai_DAO;
import entity.KhuyenMai;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUICapNhatKhuyenMai extends javax.swing.JFrame {
    private KhuyenMai_DAO khuyenMai_dao = new KhuyenMai_DAO();
    private DefaultTableModel model = new DefaultTableModel();
    
    public GUICapNhatKhuyenMai() {
        initComponents();
        setSize(1520, 780);
        setLocationRelativeTo(null);
        // Khởi tạo kết nối CSDL
	try {
            ConnectDB.getInstance().connect();
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }

    public void docDuLieuVaoBang() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        model.setRowCount(0);
        ArrayList<KhuyenMai> dsKM = khuyenMai_dao.layDanhSachKhuyenMai();
        for (KhuyenMai km : dsKM) {
            model.addRow(new Object[] {km.getMaKhuyenMai(), km.getMaGiamGia(), km.getChietKhau(), km.getSoLuong(), df.format(km.getNgayBatDau()), df.format(km.getNgayKetThuc()), km.getMoTa()});
        }
        model.fireTableDataChanged();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCapNhat = new javax.swing.JPanel();
        lblMaKhachHang = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        lblSoDT1 = new javax.swing.JLabel();
        lblSoCCD = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtChietKhau = new javax.swing.JTextField();
        lblSoDT2 = new javax.swing.JLabel();
        lblSoDT3 = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JTextField();
        cbSoLuong = new javax.swing.JComboBox<>();
        btnCapNhat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        dateNgayBD = new com.toedter.calendar.JDateChooser();
        dateNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        pnTieuDe = new javax.swing.JPanel();
        lblTieuDe1 = new javax.swing.JLabel();
        pnlDanhSachKhachHang = new javax.swing.JPanel();
        scrDanhSachNhanVien = new javax.swing.JScrollPane();
        tblDanhSachKhuyenMai = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karaoke MMM\n");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblCapNhat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMaKhachHang.setText("Mã khuyến mãi:");
        lblCapNhat.add(lblMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 21, -1, -1));

        lblNgaySinh.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNgaySinh.setText("Ngày bắt đầu:");
        lblCapNhat.add(lblNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 35));

        txtMaKhuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCapNhat.add(txtMaKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 260, 40));

        lblSoDT1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoDT1.setText("Chiết khấu:");
        lblCapNhat.add(lblSoDT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lblSoCCD.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoCCD.setText("Ngày kết thúc:");
        lblCapNhat.add(lblSoCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCapNhat.add(txtMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 260, 40));

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDiaChi.setText("Mô tả:");
        lblCapNhat.add(lblDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        txtChietKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCapNhat.add(txtChietKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 260, 40));

        lblSoDT2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoDT2.setText("Mã giảm giá:");
        lblCapNhat.add(lblSoDT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        lblSoDT3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSoDT3.setText("Số lượng:");
        lblCapNhat.add(lblSoDT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 10, -1, -1));

        txtMaGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCapNhat.add(txtMaGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 260, 40));

        cbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        cbSoLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200" }));
        lblCapNhat.add(cbSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 100, 30));

        btnCapNhat.setBackground(new java.awt.Color(255, 153, 102));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        lblCapNhat.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 140, 210, 50));

        btnThem.setBackground(new java.awt.Color(204, 204, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        lblCapNhat.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 140, 210, 50));

        btnLamMoi.setBackground(new java.awt.Color(51, 204, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        lblCapNhat.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 70, 200, 50));

        dateNgayBD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCapNhat.add(dateNgayBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 260, 40));

        dateNgayKT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCapNhat.add(dateNgayKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 260, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("DANH SÁCH KHÁCH KHUYẾN MÃI:");
        lblCapNhat.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 26));

        pnTieuDe.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDe1.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDe1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe1.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDe1.setText("QUẢN LÍ THÔNG TIN KHUYẾN MÃI");

        javax.swing.GroupLayout pnTieuDeLayout = new javax.swing.GroupLayout(pnTieuDe);
        pnTieuDe.setLayout(pnTieuDeLayout);
        pnTieuDeLayout.setHorizontalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTieuDeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTieuDe1)
                .addGap(556, 556, 556))
        );
        pnTieuDeLayout.setVerticalGroup(
            pnTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTieuDeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTieuDe1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        scrDanhSachNhanVien.setBorder(null);

        tblDanhSachKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblDanhSachKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Mã giảm giá", "Chiết khấu", "Số lượng khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachKhuyenMai.setRowHeight(25);
        tblDanhSachKhuyenMai.setSelectionBackground(new java.awt.Color(51, 153, 255));
        tblDanhSachKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachKhuyenMaiMouseClicked(evt);
            }
        });
        scrDanhSachNhanVien.setViewportView(tblDanhSachKhuyenMai);

        javax.swing.GroupLayout pnlDanhSachKhachHangLayout = new javax.swing.GroupLayout(pnlDanhSachKhachHang);
        pnlDanhSachKhachHang.setLayout(pnlDanhSachKhachHangLayout);
        pnlDanhSachKhachHangLayout.setHorizontalGroup(
            pnlDanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachKhachHangLayout.createSequentialGroup()
                .addComponent(scrDanhSachNhanVien)
                .addContainerGap())
        );
        pnlDanhSachKhachHangLayout.setVerticalGroup(
            pnlDanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrDanhSachNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 1518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlDanhSachKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Nút thêm                                   
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // Khởi tạo
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        int soLuong = 0;
        double chietKhau = 0.0;
        String maKM = txtMaKhuyenMai.getText();
        String maGG = txtMaGiamGia.getText();
        Date ngayBD = dateNgayBD.getDate();
        Date ngayKT = dateNgayKT.getDate();
        try {
            String chietKhauStr = txtChietKhau.getText();
            if (!chietKhauStr.isEmpty()) {
                chietKhau = Double.parseDouble(chietKhauStr);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nhap chiet khau");
        }
        if (ngayBD == null && ngayKT == null) {
            JOptionPane.showMessageDialog(this, "Vui long chon ngay bat dau va ngay ket thuc");
            return;
        }
        try {
            String soLuongStr = cbSoLuong.getSelectedItem().toString();
            if (!soLuongStr.isEmpty()) {
                soLuong = Integer.parseInt(soLuongStr);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Chon so luong");
        }
        String moTa = txtMoTa.getText();
        // Kiểm tra rỗng
        if (txtMaKhuyenMai.getText().equals("") ||txtMaGiamGia.getText().equals("")||txtChietKhau.getText().equals("")||txtMoTa.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        KhuyenMai km = new KhuyenMai(maKM, maGG, chietKhau, soLuong, ngayBD, ngayKT, moTa);
        model = (DefaultTableModel)tblDanhSachKhuyenMai.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).equals(maKM)) {
                JOptionPane.showMessageDialog(this, "Ma khuyen mai da ton tai");
                return;
            }
        }
        try {
            khuyenMai_dao.themKhuyenMai(km);
            model.addRow(new Object[]{km.getMaKhuyenMai(), km.getMaGiamGia(), km.getChietKhau(), km.getSoLuong(), df.format(km.getNgayBatDau()), df.format(km.getNgayKetThuc()), km.getMoTa()});
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed
    // Nút làm mới
    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMaKhuyenMai.setText("");
        txtMaGiamGia.setText("");
        txtChietKhau.setText("");
        txtMoTa.setText("");
        dateNgayBD.setDate(null);
        dateNgayKT.setDate(null);
        txtMaKhuyenMai.requestFocus();
        txtMaKhuyenMai.setEditable(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed
    // Đẩy dữ liệu lên bảng khi mở fame
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {       
            docDuLieuVaoBang();
            System.out.println("Doc Thanh Cong");
        } catch (SQLException ex) {
            System.out.println("Loi");
        }
    }//GEN-LAST:event_formComponentShown
    // Click chuột vào dòng thông tin trong bảng
    private void tblDanhSachKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachKhuyenMaiMouseClicked
        int row = tblDanhSachKhuyenMai.getSelectedRow();
        if (row >= 0) {
            DefaultTableModel model = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();

            String maKhuyenMai = model.getValueAt(row, 0).toString();
            String maGiamGia = model.getValueAt(row, 1).toString();
            String chietKhau = model.getValueAt(row, 2).toString();
            String soLuong = cbSoLuong.getSelectedItem().toString();
            String dateBDString = model.getValueAt(row, 4).toString(); // Định dạng: "dd/MM/yyyy"
            String dateKTString = model.getValueAt(row, 5).toString(); // Định dạng: "dd/MM/yyyy"
            String moTa = model.getValueAt(row, 6).toString();

            txtMaKhuyenMai.setText(maKhuyenMai);
            txtMaGiamGia.setText(maGiamGia);
            txtChietKhau.setText(chietKhau);
            cbSoLuong.setSelectedItem(soLuong);
            txtMoTa.setText(moTa);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayBatDau = null;
            Date ngayKetThuc = null;
            try {
                ngayBatDau = dateFormat.parse(dateBDString);
            } catch (ParseException ex) {
                Logger.getLogger(GUICapNhatKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ngayKetThuc = dateFormat.parse(dateKTString);
            } catch (ParseException ex) {
                Logger.getLogger(GUICapNhatKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
            }
            dateNgayBD.setDate(ngayBatDau);
            dateNgayKT.setDate(ngayKetThuc);
            txtMaKhuyenMai.setEditable(false);
        }
    }//GEN-LAST:event_tblDanhSachKhuyenMaiMouseClicked
    // Nút cập nhật thông tin khuyến mãi
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        model = (DefaultTableModel) tblDanhSachKhuyenMai.getModel();
        String maKhuyenMai = txtMaKhuyenMai.getText();
        String maGiamGia = txtMaGiamGia.getText();
        String chietKhau = txtChietKhau.getText();
        String soLuong = cbSoLuong.getSelectedItem().toString();
        Date ngayBatDau = dateNgayBD.getDate();
        Date ngayKetThuc = dateNgayKT.getDate();
        String moTa = txtMoTa.getText();
        
        KhuyenMai km = new KhuyenMai(maKhuyenMai, maGiamGia, Double.parseDouble(chietKhau), Integer.parseInt(soLuong), ngayBatDau, ngayKetThuc, moTa);
        try {
            boolean success = khuyenMai_dao.suaThongTinKhuyenMai(km); // Chú ý kiểm tra kết quả cập nhật
            if (success) {
                model.addRow(new Object[] {km.getMaKhuyenMai(), km.getMaGiamGia(), km.getChietKhau(), km.getSoLuong(), df.format(km.getNgayBatDau()), df.format(km.getNgayKetThuc()), km.getMoTa()});
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                khuyenMai_dao.layDanhSachKhuyenMai().clear();
                docDuLieuVaoBang();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật thông tin khách hàng.");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICapNhatKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbSoLuong;
    private com.toedter.calendar.JDateChooser dateNgayBD;
    private com.toedter.calendar.JDateChooser dateNgayKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel lblCapNhat;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaKhachHang;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSoCCD;
    private javax.swing.JLabel lblSoDT1;
    private javax.swing.JLabel lblSoDT2;
    private javax.swing.JLabel lblSoDT3;
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
    private javax.swing.JPanel pnlDanhSachKhachHang;
    private javax.swing.JScrollPane scrDanhSachNhanVien;
    private javax.swing.JTable tblDanhSachKhuyenMai;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMoTa;
    // End of variables declaration//GEN-END:variables
}
