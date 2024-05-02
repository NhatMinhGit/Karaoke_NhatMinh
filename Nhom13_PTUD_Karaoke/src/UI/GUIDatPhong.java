
package UI;

import connectdb.ConnectDB;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.LoaiPhong_DAO;
import dao.NhanVien_DAO;
import dao.PhieuDatPhong_DAO;
import dao.Phong_DAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.ThongTinDangNhap;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duong Ngo Manh
 */
public class GUIDatPhong extends javax.swing.JFrame {
    private String soDienThoai;
    KhachHang_DAO khachHang_dao = new KhachHang_DAO();
    PhieuDatPhong_DAO pdp_dao = new PhieuDatPhong_DAO();
    NhanVien_DAO nv_dao = new NhanVien_DAO();
    HoaDon_DAO hoaDon_dao = new HoaDon_DAO();
    Phong_DAO p_dao = new Phong_DAO();
    LoaiPhong_DAO lp_dao = new LoaiPhong_DAO();
    DefaultTableModel dftblPDP, dftblPC, dftblPindlg;

    /**
     * Creates new form GUIThongTinPhong
     */
    public GUIDatPhong() {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setSize(1520, 780);
        setLocationRelativeTo(null);
        initComponents();
        dongHoNgay();
        dongHoGio();
        // hiển thị tên nhân viên đang đăng nhập lên label
        String tenNhanVien = ThongTinDangNhap.getTenNhanVien();
        if (tenNhanVien != null) {
            lblTenNhanVien.setText("Xin chào, " + tenNhanVien + "!");
        }
        // hiển thị mã nhân viên đang đăng nhập lên label
        String maNhanVien = ThongTinDangNhap.getMaNhanVien();
        if (maNhanVien != null) {
            lblNhanVien.setText(maNhanVien);
        }
        dlgDatPhongCho.setLocationRelativeTo(null);
    }

    private void dongHoGio() {
        new Thread() {
            public void run() {
                while (true) {
                    Calendar ca = new GregorianCalendar();
                    int hour = ca.get(Calendar.HOUR);
                    int min = ca.get(Calendar.MINUTE);
                    int sec = ca.get(Calendar.SECOND);
                    lblTime.setText(hour + ":" + min + ":" + sec);
                }
            }
        }.start();
    }

    private void dongHoNgay() {
        new Thread() {
            public void run() {
                while (true) {
                    Calendar ca = new GregorianCalendar();
                    int day = ca.get(Calendar.DATE);
                    int month = ca.get(Calendar.MONTH) + 1;
                    int year = ca.get(Calendar.YEAR);
                    lblDate.setText(day + "/" + month + "/" + year);
                }
            }
        }.start();
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
        txtSoDienThoai.setText(soDienThoai);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgDatPhongCho = new javax.swing.JDialog();
        pnlDanhSachPhong = new javax.swing.JPanel();
        scrDanhSachPhongDatTruoc = new javax.swing.JScrollPane();
        tblDanhSachPhongDatTruoc = new javax.swing.JTable();
        btnNhanPhongDatTruoc = new javax.swing.JButton();
        btnHuyPhieuDatTruoc = new javax.swing.JButton();
        btnDatPhongTruoc = new javax.swing.JButton();
        btnLamMoiIndlg = new javax.swing.JButton();
        lblNgayDatTruoc = new javax.swing.JLabel();
        dateNgayDatPhong = new com.toedter.calendar.JDateChooser();
        pnlDanhSachPhieuDatTruoc = new javax.swing.JPanel();
        scrDanhSachPhieuDatPhongTruoc = new javax.swing.JScrollPane();
        tblDanhSachPhieuDatPhongTruoc = new javax.swing.JTable();
        pnlThongTinKhachHang1 = new javax.swing.JPanel();
        txtPSoDienThoai = new javax.swing.JTextField();
        lblPTenKhachHang = new javax.swing.JLabel();
        lblPSoDienThoai = new javax.swing.JLabel();
        btnPKiemTraSDT = new javax.swing.JButton();
        txtPMaKhachHang = new javax.swing.JTextField();
        lblPMaKhachHang = new javax.swing.JLabel();
        txtPTenKhachHang = new javax.swing.JTextField();
        btnTimPhong = new javax.swing.JButton();
        pnlTieuDe = new javax.swing.JPanel();
        lblTieuDeDatTruoc = new javax.swing.JLabel();
        pnlTieuDe3 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        pnlDanhSachPhong1 = new javax.swing.JPanel();
        scrDanhSachPhong = new javax.swing.JScrollPane();
        tblDanhSachPhongCho = new javax.swing.JTable();
        pnlDanhSachPhieuDatPhong = new javax.swing.JPanel();
        scrDanhSachPhong2 = new javax.swing.JScrollPane();
        tblDanhSachPhieuDatPhong = new javax.swing.JTable();
        lblMaNhanVien = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        btnDatPhongCho = new javax.swing.JButton();
        btnHuyPhongCho = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        pnlThongTinKhachHang = new javax.swing.JPanel();
        txtSoDienThoai = new javax.swing.JTextField();
        lblTenKhachHang = new javax.swing.JLabel();
        lblNgayLap3 = new javax.swing.JLabel();
        btnKiemTraSDT = new javax.swing.JButton();
        txtMaKhachHang = new javax.swing.JTextField();
        lblNgayLap1 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        btnDatPhongNgay = new javax.swing.JButton();
        lblNhanVien = new javax.swing.JLabel();
        pnTime = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
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

        dlgDatPhongCho.setPreferredSize(new java.awt.Dimension(1100, 700));
        dlgDatPhongCho.setSize(new java.awt.Dimension(1113, 600));
        dlgDatPhongCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlgDatPhongChoMouseClicked(evt);
            }
        });
        dlgDatPhongCho.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                dlgDatPhongChoComponentShown(evt);
            }
        });
        dlgDatPhongCho.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDanhSachPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỌN PHÒNG\n\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlDanhSachPhong.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlDanhSachPhongComponentShown(evt);
            }
        });
        pnlDanhSachPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachPhongDatTruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Tên phòng", "Loại phòng", "Giá phòng", "Số người tối đa", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachPhongDatTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhongDatTruocMouseClicked(evt);
            }
        });
        tblDanhSachPhongDatTruoc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblDanhSachPhongDatTruocComponentShown(evt);
            }
        });
        scrDanhSachPhongDatTruoc.setViewportView(tblDanhSachPhongDatTruoc);

        pnlDanhSachPhong.add(scrDanhSachPhongDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 710, 230));

        dlgDatPhongCho.getContentPane().add(pnlDanhSachPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 56, 730, 260));

        btnNhanPhongDatTruoc.setBackground(new java.awt.Color(153, 255, 255));
        btnNhanPhongDatTruoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNhanPhongDatTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/danhmuc.png"))); // NOI18N
        btnNhanPhongDatTruoc.setText("Nhận Phòng");
        btnNhanPhongDatTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanPhongDatTruocActionPerformed(evt);
            }
        });
        dlgDatPhongCho.getContentPane().add(btnNhanPhongDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 170, 50));

        btnHuyPhieuDatTruoc.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyPhieuDatTruoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHuyPhieuDatTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        btnHuyPhieuDatTruoc.setText("Đóng");
        dlgDatPhongCho.getContentPane().add(btnHuyPhieuDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 167, 53));

        btnDatPhongTruoc.setBackground(new java.awt.Color(153, 255, 255));
        btnDatPhongTruoc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDatPhongTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        btnDatPhongTruoc.setText("Đặt phòng");
        btnDatPhongTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongTruocActionPerformed(evt);
            }
        });
        dlgDatPhongCho.getContentPane().add(btnDatPhongTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, -1, 50));

        btnLamMoiIndlg.setBackground(new java.awt.Color(153, 255, 153));
        btnLamMoiIndlg.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoiIndlg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoiIndlg.setText("Làm mới");
        btnLamMoiIndlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiIndlgActionPerformed(evt);
            }
        });
        dlgDatPhongCho.getContentPane().add(btnLamMoiIndlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 150, 50));

        lblNgayDatTruoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayDatTruoc.setText("Ngày đặt phòng:");
        dlgDatPhongCho.getContentPane().add(lblNgayDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, -1, 30));
        dlgDatPhongCho.getContentPane().add(dateNgayDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 193, 30));

        pnlDanhSachPhieuDatTruoc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PhIẾU ĐẶT PHÒNG\n\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlDanhSachPhieuDatTruoc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlDanhSachPhieuDatTruocComponentShown(evt);
            }
        });
        pnlDanhSachPhieuDatTruoc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachPhieuDatPhongTruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu đặt phòng", "Mã phòng", "Loại phòng", "Khách hàng", "Nhân viên", "Ngày đặt phòng", "Trạng thái phiếu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachPhieuDatPhongTruoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblDanhSachPhieuDatPhongTruocFocusLost(evt);
            }
        });
        tblDanhSachPhieuDatPhongTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhieuDatPhongTruocMouseClicked(evt);
            }
        });
        tblDanhSachPhieuDatPhongTruoc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblDanhSachPhieuDatPhongTruocComponentShown(evt);
            }
        });
        scrDanhSachPhieuDatPhongTruoc.setViewportView(tblDanhSachPhieuDatPhongTruoc);

        pnlDanhSachPhieuDatTruoc.add(scrDanhSachPhieuDatPhongTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 710, 200));

        dlgDatPhongCho.getContentPane().add(pnlDanhSachPhieuDatTruoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 320, 730, 240));

        pnlThongTinKhachHang1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlThongTinKhachHang1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPSoDienThoaiActionPerformed(evt);
            }
        });
        pnlThongTinKhachHang1.add(txtPSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 28, 180, -1));

        lblPTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPTenKhachHang.setText("Tên Khách Hàng:");
        pnlThongTinKhachHang1.add(lblPTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 79, -1, -1));

        lblPSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPSoDienThoai.setText("Số điện thoại:");
        pnlThongTinKhachHang1.add(lblPSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 28, -1, -1));

        btnPKiemTraSDT.setBackground(new java.awt.Color(204, 204, 204));
        btnPKiemTraSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPKiemTraSDT.setText("Kiểm tra");
        btnPKiemTraSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPKiemTraSDTActionPerformed(evt);
            }
        });
        pnlThongTinKhachHang1.add(btnPKiemTraSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 171, -1, 28));

        txtPMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinKhachHang1.add(txtPMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 125, 180, -1));

        lblPMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPMaKhachHang.setText("Mã khách hàng:");
        pnlThongTinKhachHang1.add(lblPMaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 130, -1, -1));

        txtPTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pnlThongTinKhachHang1.add(txtPTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 74, 180, -1));

        dlgDatPhongCho.getContentPane().add(pnlThongTinKhachHang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 350, 210));

        btnTimPhong.setBackground(new java.awt.Color(204, 204, 204));
        btnTimPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimPhong.setText("Tìm phòng");
        btnTimPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongActionPerformed(evt);
            }
        });
        dlgDatPhongCho.getContentPane().add(btnTimPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, 28));

        pnlTieuDe.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDeDatTruoc.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDeDatTruoc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDeDatTruoc.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDeDatTruoc.setText("ĐẶT PHÒNG TRƯỚC");

        javax.swing.GroupLayout pnlTieuDeLayout = new javax.swing.GroupLayout(pnlTieuDe);
        pnlTieuDe.setLayout(pnlTieuDeLayout);
        pnlTieuDeLayout.setHorizontalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap(442, Short.MAX_VALUE)
                .addComponent(lblTieuDeDatTruoc)
                .addGap(426, 426, 426))
        );
        pnlTieuDeLayout.setVerticalGroup(
            pnlTieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDeDatTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        dlgDatPhongCho.getContentPane().add(pnlTieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 50));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTieuDe3.setBackground(new java.awt.Color(102, 0, 0));

        lblTieuDe.setBackground(new java.awt.Color(102, 0, 0));
        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(242, 242, 242));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("ĐẶT PHÒNG ");

        lblTenNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblTenNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user (6).png"))); // NOI18N
        lblTenNhanVien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblTenNhanVienAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                lblTenNhanVienAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout pnlTieuDe3Layout = new javax.swing.GroupLayout(pnlTieuDe3);
        pnlTieuDe3.setLayout(pnlTieuDe3Layout);
        pnlTieuDe3Layout.setHorizontalGroup(
            pnlTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDe3Layout.createSequentialGroup()
                .addGap(709, 709, 709)
                .addComponent(lblTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
                .addComponent(lblTenNhanVien)
                .addGap(192, 192, 192))
        );
        pnlTieuDe3Layout.setVerticalGroup(
            pnlTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTieuDe3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlTieuDe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTenNhanVien)
                    .addComponent(lblTieuDe))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(pnlTieuDe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 100));

        pnlDanhSachPhong1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH ĐẶT PHÒNG \n\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlDanhSachPhong1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlDanhSachPhong1ComponentShown(evt);
            }
        });
        pnlDanhSachPhong1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachPhongCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Loại phòng", "Tên phòng", "Giá phòng", "Số người tối đa", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSachPhongCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhongChoMouseClicked(evt);
            }
        });
        tblDanhSachPhongCho.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblDanhSachPhongChoComponentShown(evt);
            }
        });
        scrDanhSachPhong.setViewportView(tblDanhSachPhongCho);

        pnlDanhSachPhong1.add(scrDanhSachPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 620, 380));

        getContentPane().add(pnlDanhSachPhong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 300, 640, 420));

        pnlDanhSachPhieuDatPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH PHIẾU ĐẶT PHÒNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnlDanhSachPhieuDatPhong.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlDanhSachPhieuDatPhongComponentShown(evt);
            }
        });
        pnlDanhSachPhieuDatPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDanhSachPhieuDatPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblDanhSachPhieuDatPhong.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhSachPhieuDatPhong.setRowHeight(25);
        tblDanhSachPhieuDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachPhieuDatPhongMouseClicked(evt);
            }
        });
        scrDanhSachPhong2.setViewportView(tblDanhSachPhieuDatPhong);

        pnlDanhSachPhieuDatPhong.add(scrDanhSachPhong2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, 390));

        getContentPane().add(pnlDanhSachPhieuDatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 850, 420));

        lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNhanVien.setText("Nhân viên:");
        getContentPane().add(lblMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        lblMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaPhong.setText("Mã phòng:");
        getContentPane().add(lblMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });
        getContentPane().add(txtMaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 190, 30));

        btnDatPhongCho.setBackground(new java.awt.Color(153, 255, 255));
        btnDatPhongCho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDatPhongCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/danhmuc.png"))); // NOI18N
        btnDatPhongCho.setText("Đặt phòng chờ");
        btnDatPhongCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongChoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDatPhongCho, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 220, 62));

        btnHuyPhongCho.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyPhongCho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHuyPhongCho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel (1).png"))); // NOI18N
        btnHuyPhongCho.setText("Huỷ phiếu đặt phòng");
        btnHuyPhongCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhongChoActionPerformed(evt);
            }
        });
        getContentPane().add(btnHuyPhongCho, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 220, 240, 60));

        btnLamMoi.setBackground(new java.awt.Color(153, 255, 153));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 220, 195, 57));

        pnlThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });

        lblTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTenKhachHang.setText("Tên Khách Hàng:");

        lblNgayLap3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayLap3.setText("Số điện thoại:");

        btnKiemTraSDT.setBackground(new java.awt.Color(204, 204, 204));
        btnKiemTraSDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnKiemTraSDT.setText("Kiểm tra");
        btnKiemTraSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraSDTActionPerformed(evt);
            }
        });

        txtMaKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblNgayLap1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayLap1.setText("Mã khách hàng:");

        txtTenKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        javax.swing.GroupLayout pnlThongTinKhachHangLayout = new javax.swing.GroupLayout(pnlThongTinKhachHang);
        pnlThongTinKhachHang.setLayout(pnlThongTinKhachHangLayout);
        pnlThongTinKhachHangLayout.setHorizontalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenKhachHang)
                    .addComponent(lblNgayLap3)
                    .addComponent(lblNgayLap1))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKiemTraSDT)))
                .addGap(13, 13, 13))
        );
        pnlThongTinKhachHangLayout.setVerticalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayLap3)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemTraSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhachHang)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayLap1)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlThongTinKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 480, 190));

        btnDatPhongNgay.setBackground(new java.awt.Color(153, 255, 255));
        btnDatPhongNgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDatPhongNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnDatPhongNgay.setText("Đặt phòng ngay");
        btnDatPhongNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongNgayActionPerformed(evt);
            }
        });
        getContentPane().add(btnDatPhongNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 140, 210, 60));

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 0, 50));
        getContentPane().add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 190, 30));

        pnTime.setBackground(new java.awt.Color(255, 255, 255));
        pnTime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTime.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("18 : 28 :45");
        pnTime.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDate.setText("11/04/2023");
        pnTime.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        getContentPane().add(pnTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        mnuTong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mnHeThong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/system.png"))); // NOI18N
        mnHeThong.setText("Hệ Thống");
        mnHeThong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mnHeThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnHeThongActionPerformed(evt);
            }
        });

        mniTrangChu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_HOME, 0));
        mniTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/24-hours.png"))); // NOI18N
        mniTrangChu.setText("Trang chủ");
        mniTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTrangChuActionPerformed(evt);
            }
        });
        mnHeThong.add(mniTrangChu);

        mniTroGiup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_QUOTE, 0));
        mniTroGiup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mniTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        mniTroGiup.setText("Trợ giúp");
        mniTroGiup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTroGiupActionPerformed(evt);
            }
        });
        mnHeThong.add(mniTroGiup);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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
        mniDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lich_lam.png"))); // NOI18N
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


    private void btnHuyPhongChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhongChoActionPerformed
        // TODO add your handling code here:
        int row = tblDanhSachPhieuDatPhong.getSelectedRow();
        String maPDP = tblDanhSachPhieuDatPhong.getValueAt(row, 0).toString();
        String maP = txtMaPhong.getText();
        String trangThaiPhieu = tblDanhSachPhieuDatPhong.getValueAt(row, 6).toString();
        DefaultTableModel dftblPDP = (DefaultTableModel) tblDanhSachPhieuDatPhong.getModel();
        //kiem tra trung ma
        try {
            if(trangThaiPhieu == "Đã lập hóa đơn"){
		pdp_dao.huyPhieuDatPhong(maPDP,maP);
		docDuLieuTuDataVaoTableDanhSachPhieuDatPhong();
                docDuLieuTuDataVaoTableDanhSachPhongCho();
		JOptionPane.showMessageDialog(this, "Huy thanh cong");
                }else{
                    JOptionPane.showMessageDialog(this, "Hóa đơn đã được lập nên không thể xóa");
                }
	} catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "Huy không thanh cong");
			e2.printStackTrace();
	}
    }//GEN-LAST:event_btnHuyPhongChoActionPerformed

    private void btnDatPhongChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongChoActionPerformed
        dlgDatPhongCho.setVisible(true);
        try {
            docDuLieuTuDataVaoTableDanhSachPhieuDatPhongTruoc();
        } catch (SQLException ex) {
            Logger.getLogger(GUIDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDatPhongChoActionPerformed
    public boolean kiemTraSDTKhach() {
        ArrayList<KhachHang> dskh = new ArrayList<>();
        KhachHang kh = null;
        String soDT = txtSoDienThoai.getText();
        if (soDT.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại Khách");
            txtSoDienThoai.selectAll();
            txtSoDienThoai.requestFocus();
            return false;
        }
        if (!soDT.matches("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng địng dạng");
            txtSoDienThoai.selectAll();
            txtSoDienThoai.requestFocus();
            return false;
        }
        kh = khachHang_dao.timKhachHangTheoSoDT(soDT);
        if (kh == null) {
            int xacNhan = JOptionPane.showConfirmDialog(this, "Khách hàng không có trong hệ thống, Bạn có muốn thêm khách hàng không", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (xacNhan == JOptionPane.YES_OPTION) {
                GUICapNhatKhachHang guiKhachHang = new GUICapNhatKhachHang();
                String soDienThoai = txtSoDienThoai.getText();
                guiKhachHang.setSoDienThoai(soDienThoai);
                guiKhachHang.setVisible(true);
            }
        } else {
            txtMaKhachHang.setText(kh.getMaKhachHang());
            txtTenKhachHang.setText(kh.getTenKhachHang());
        }
        return true;
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMaPhong.setText("");
        txtMaKhachHang.setText("");

        try {
            docDuLieuTuDataVaoTableDanhSachPhieuDatPhong();
        } catch (SQLException ex) {
            Logger.getLogger(GUICapNhatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            docDuLieuTuDataVaoTableDanhSachPhongCho();
        } catch (SQLException ex) {
            Logger.getLogger(GUIDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

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
        GUIDatPhong dpc = new GUIDatPhong();
        dpc.setVisible(true);
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
//        GUIThanhToan tt = new GUIThanhToan();
//        tt.setVisible(true);
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

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            docDuLieuTuDataVaoTableDanhSachPhongCho();
        } catch (SQLException ex) {
            Logger.getLogger(GUIDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            docDuLieuTuDataVaoTableDanhSachPhieuDatPhong();
        } catch (SQLException ex) {
            Logger.getLogger(GUIDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void pnlDanhSachPhong1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlDanhSachPhong1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlDanhSachPhong1ComponentShown

    private void tblDanhSachPhongChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhongChoMouseClicked
        int row = tblDanhSachPhongCho.getSelectedRow();
        String maPhong = tblDanhSachPhongCho.getValueAt(row, 0).toString();
        txtMaPhong.setText(maPhong);
    }//GEN-LAST:event_tblDanhSachPhongChoMouseClicked

    private void tblDanhSachPhongChoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblDanhSachPhongChoComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_tblDanhSachPhongChoComponentShown

    private void pnlDanhSachPhieuDatPhongComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlDanhSachPhieuDatPhongComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlDanhSachPhieuDatPhongComponentShown

    private void btnNhanPhongDatTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanPhongDatTruocActionPerformed
//        // TODO add your handling code here:
//        if (txtMaPhongIndlg.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
//            return;
//        }
//
//        String maP = txtMaPhongIndlg.getText();
//        Phong x = new Phong(maP);
//        DefaultTableModel dftblPC = (DefaultTableModel) tblDanhSachPhongDatTruoc.getModel();
//
//        try {
//            p_dao.chuyenTrangThaiCho(x);
//            dftblPC.addRow(new Object[]{x.getMaPhong(), x.getLoaiPhong().getMaLoaiPhong(), x.getTenPhong(), x.getGiaPhong(), x.getSoNguoiToiDa(), x.getTrangThaiPhong()});
//            //docDuLieuTuDataVaoTableDanhSachPhong();
//            JOptionPane.showMessageDialog(this, "Cap nhat thanh cong");
//        } catch (Exception e2) {
//            JOptionPane.showMessageDialog(this, "Cap nhat không thanh cong");
//            e2.printStackTrace();
//        }

    }//GEN-LAST:event_btnNhanPhongDatTruocActionPerformed

    private void tblDanhSachPhongDatTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhongDatTruocMouseClicked
        // TODO add your handling code here:
        int row = tblDanhSachPhongDatTruoc.getSelectedRow();
        String maPhong = tblDanhSachPhongDatTruoc.getValueAt(row, 0).toString();
        

    }//GEN-LAST:event_tblDanhSachPhongDatTruocMouseClicked

    private void tblDanhSachPhongDatTruocComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblDanhSachPhongDatTruocComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachPhongDatTruocComponentShown

    private void pnlDanhSachPhongComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlDanhSachPhongComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlDanhSachPhongComponentShown

    private void dlgDatPhongChoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_dlgDatPhongChoComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_dlgDatPhongChoComponentShown

    private void btnDatPhongTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongTruocActionPerformed
        DefaultTableModel dftblPDPT = (DefaultTableModel) tblDanhSachPhieuDatPhongTruoc.getModel();
        int row = tblDanhSachPhongDatTruoc.getSelectedRow();
        if(row>0){
            String maPhong = tblDanhSachPhongDatTruoc.getValueAt(row, 0).toString();
            Phong phong = null;
            phong = p_dao.timPhongTheoMaPhong(maPhong);
            
            String tenLoaiPhong = tblDanhSachPhongDatTruoc.getValueAt(row, 2).toString();
                    
            KhachHang maKH = new KhachHang(txtPMaKhachHang.getText());
            
            NhanVien maNV = new NhanVien(lblNhanVien.getText());
            
            Date ngayDat = dateNgayDatPhong.getDate();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String ngayDatPhong = df.format(ngayDat);
            
            String maPDP = pdp_dao.khoiTaoMaPhieuDatPhong();

            String trangThaiPhieu = pdp_dao.khoiTaoTrangThaiPhieuDatTruoc();
            
            PhieuDatPhong x = new PhieuDatPhong(maPDP, phong, maKH, maNV, ngayDatPhong, trangThaiPhieu);
            
            try {
                pdp_dao.themPhieuDatPhongTruoc(x);
                docDuLieuTuDataVaoDanhSachPhongDatTruoc();
                JOptionPane.showMessageDialog(this, "Đặt phòng thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "Đặt phòng không thành công!");
                e2.printStackTrace();
            }
        }
        
//        for (Phong x : ) {
//            dftbl.addRow(new Object[]{x.getMaPhong(), x.getLoaiPhong().getMaLoaiPhong(), x.getTenPhong(), x.getGiaPhong(), x.getSoNguoiToiDa(), x.getTrangThaiPhong()});
//        }

    }//GEN-LAST:event_btnDatPhongTruocActionPerformed

    private void btnLamMoiIndlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiIndlgActionPerformed
        
    }//GEN-LAST:event_btnLamMoiIndlgActionPerformed

    private void dlgDatPhongChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlgDatPhongChoMouseClicked
        // TODO add your handling code here:
        int row = tblDanhSachPhongDatTruoc.getSelectedRow();
        String maPhong = tblDanhSachPhongDatTruoc.getValueAt(row, 0).toString();

    }//GEN-LAST:event_dlgDatPhongChoMouseClicked

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btnKiemTraSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraSDTActionPerformed
        kiemTraSDTKhach();
    }//GEN-LAST:event_btnKiemTraSDTActionPerformed

    private void mnHeThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnHeThongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnHeThongActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhap dn = new DangNhap();
        dn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void btnDatPhongNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongNgayActionPerformed
        HoaDon hoaDon = null;
        KhachHang kh = null;
        //int row = tblDanhSachPhongCho.getSelectedRow();
        if (txtMaPhong.getText().equals("") || txtMaKhachHang.getText().equals("") || lblNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
            return;
        }
        
        String maPhong = txtMaPhong.getText();
        Phong phong = new Phong(maPhong);
        
        
        KhachHang maKH = new KhachHang(txtMaKhachHang.getText());
        NhanVien maNV = new NhanVien(lblNhanVien.getText());
        LocalDate ltNgayDatPhong = LocalDate.now();
        DateTimeFormatter fmtNgayDatPhong = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngayDatPhong = ltNgayDatPhong.format(fmtNgayDatPhong);
        String maPDP = pdp_dao.khoiTaoMaPhieuDatPhong();
        LocalDateTime ltGioNhanPhong = LocalDateTime.now();
        DateTimeFormatter fmtGioNhanPhong = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String gioNhanPhong = ltGioNhanPhong.format(fmtGioNhanPhong);
        String trangThaiPhieu = pdp_dao.khoiTaoTrangThaiPhieu();
        PhieuDatPhong x = new PhieuDatPhong(maPDP, phong, maKH, maNV, ngayDatPhong, gioNhanPhong, trangThaiPhieu);
        DefaultTableModel dftblPDP = (DefaultTableModel) tblDanhSachPhieuDatPhong.getModel();
        kh = khachHang_dao.timKhachHangTheoMaKH(maKH.getMaKhachHang());
        try {
            pdp_dao.themPhieuDatPhong(x);
            hoaDon = new HoaDon(maNV, kh.getTenKhachHang(), phong);
            hoaDon_dao.themHoaDon(hoaDon);
            dftblPDP.addRow(new Object[]{x.getMaPhieuDatPhong(), x.getPhong().getMaPhong(), x.getKhachHang().getMaKhachHang(), x.getNhanVien().getMaNhanVien(), x.getNgayDatPhong(), x.getGioNhanPhong(), x.getTrangThaiPhieu()});
            docDuLieuTuDataVaoTableDanhSachPhieuDatPhong();
            docDuLieuTuDataVaoTableDanhSachPhongCho();
            JOptionPane.showMessageDialog(this, "Đặt phòng thành công!");
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(this, "Đặt phòng không thành công!");
            e2.printStackTrace();
        }
    }//GEN-LAST:event_btnDatPhongNgayActionPerformed

    private void lblTenNhanVienAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblTenNhanVienAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTenNhanVienAncestorAdded

    private void lblTenNhanVienAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblTenNhanVienAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTenNhanVienAncestorMoved

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void tblDanhSachPhieuDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuDatPhongMouseClicked
       
    }//GEN-LAST:event_tblDanhSachPhieuDatPhongMouseClicked

    private void pnlDanhSachPhieuDatTruocComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlDanhSachPhieuDatTruocComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlDanhSachPhieuDatTruocComponentShown

    private void txtPSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPSoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPSoDienThoaiActionPerformed

    private void btnPKiemTraSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPKiemTraSDTActionPerformed
        ArrayList<KhachHang> dskh = new ArrayList<>();
        KhachHang kh = null;
        String soDT = txtPSoDienThoai.getText();
        if (soDT.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại Khách");
            txtPSoDienThoai.selectAll();
            txtSoDienThoai.requestFocus();
            return;
        }
        if (!soDT.matches("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng địng dạng");
            txtPSoDienThoai.selectAll();
            txtPSoDienThoai.requestFocus();
            return;
        }
        kh = khachHang_dao.timKhachHangTheoSoDT(soDT);
        if (kh == null) {
            int xacNhan = JOptionPane.showConfirmDialog(this, "Khách hàng không có trong hệ thống, Bạn có muốn thêm khách hàng không", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (xacNhan == JOptionPane.YES_OPTION) {
                GUICapNhatKhachHang guiKhachHang = new GUICapNhatKhachHang();
                String soDThoai = txtPSoDienThoai.getText();
                guiKhachHang.setSoDienThoai(soDThoai);
                guiKhachHang.setVisible(true);
            }
        } else {
            txtPMaKhachHang.setText(kh.getMaKhachHang());
            txtPTenKhachHang.setText(kh.getTenKhachHang());
        }
    }//GEN-LAST:event_btnPKiemTraSDTActionPerformed

    private void btnTimPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongActionPerformed
        int day = dateNgayDatPhong.getDate().getDate();
	int today = new Date().getDate();		
	if (day <= today) {
		JOptionPane.showMessageDialog(this, "Dat cac phong sau ngay hom nay 1 ngay");
		return;
	}	
        try {
            docDuLieuTuDataVaoDanhSachPhongDatTruoc();
//	loadDataToTablePhong(dateChooser.getDate());
        } catch (SQLException ex) {
            Logger.getLogger(GUIDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimPhongActionPerformed

    private void tblDanhSachPhieuDatPhongTruocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuDatPhongTruocFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachPhieuDatPhongTruocFocusLost

    private void tblDanhSachPhieuDatPhongTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuDatPhongTruocMouseClicked
        // TODO add your handling code here:
        int row = tblDanhSachPhieuDatPhong.getSelectedRow();
        String maPDP = tblDanhSachPhieuDatPhong.getValueAt(row, 0).toString();
        String maP = tblDanhSachPhieuDatPhong.getValueAt(row, 1).toString();
        String maKH = tblDanhSachPhieuDatPhong.getValueAt(row, 2).toString();
        String maNV = tblDanhSachPhieuDatPhong.getValueAt(row, 3).toString();
        String ngayDatPhong = tblDanhSachPhieuDatPhong.getValueAt(row, 4).toString();
        txtMaPhong.setText(maP);
        txtTenKhachHang.setText(maKH);
        lblNhanVien.setText(maNV);
        dateNgayDatPhong.setDateFormatString(ngayDatPhong);
    }//GEN-LAST:event_tblDanhSachPhieuDatPhongTruocMouseClicked

    private void tblDanhSachPhieuDatPhongTruocComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblDanhSachPhieuDatPhongTruocComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachPhieuDatPhongTruocComponentShown

    public void docDuLieuTuDataVaoDanhSachPhongDatTruoc() throws SQLException {
        DefaultTableModel dftblDatTruoc = (DefaultTableModel) tblDanhSachPhongDatTruoc.getModel();
        dftblDatTruoc.setRowCount(0);
        ArrayList<Phong> listpc = p_dao.getAllPhongTrong();
        dftblDatTruoc.setRowCount(0);
        for (Phong x : listpc) {
            dftblDatTruoc.addRow(new Object[]{x.getMaPhong(), x.getTenPhong(), x.getLoaiPhong().getTenLoaiPhong(), x.getGiaPhong(), x.getSoNguoiToiDa(), x.getTrangThaiPhong()});
        }
    }

    public void docDuLieuTuDataVaoTableDanhSachPhongCho() throws SQLException {
        DefaultTableModel dftblPC = (DefaultTableModel) tblDanhSachPhongCho.getModel();
        ArrayList<Phong> listpc = p_dao.getAllPhongTrong();
        dftblPC.setRowCount(0);
        for (Phong x : listpc) {
            dftblPC.addRow(new Object[]{x.getMaPhong(), x.getLoaiPhong().getMaLoaiPhong(), x.getTenPhong(), x.getGiaPhong(), x.getSoNguoiToiDa(), x.getTrangThaiPhong()});
        }
    }

    public void docDuLieuTuDataVaoTableDanhSachPhieuDatPhong() throws SQLException {
        DefaultTableModel dftblPDP = (DefaultTableModel) tblDanhSachPhieuDatPhong.getModel();
        ArrayList<PhieuDatPhong> listpdp = pdp_dao.layPhieuDatPhongChuaThanhToan();
        dftblPDP.setRowCount(0);
        for (PhieuDatPhong x : listpdp) {
            dftblPDP.addRow(new Object[]{
                x.getPhong().getMaPhong(),
                x.getPhong().getTenPhong(), 
                x.getPhong().getLoaiPhong().getTenLoaiPhong(), 
                x.getPhong().getGiaPhong(), 
                x.getGioNhanPhong(), 
                x.getNhanVien().getTenNhanVien(), 
                x.getKhachHang().getTenKhachHang()});
        }
    }

    public void docDuLieuTuDataVaoTableDanhSachPhieuDatPhongTruoc() throws SQLException {
        DefaultTableModel dftblPDPT = (DefaultTableModel) tblDanhSachPhieuDatPhongTruoc.getModel();
        ArrayList<PhieuDatPhong> listpdp = pdp_dao.layPhieuDatPhongDatTruoc();
        dftblPDPT.setRowCount(0);
        for (PhieuDatPhong x : listpdp) {
            dftblPDPT.addRow(new Object[]{
                x.getMaPhieuDatPhong(),
                x.getPhong().getMaPhong(), 
                x.getPhong().getLoaiPhong().getTenLoaiPhong(),  
                x.getKhachHang().getTenKhachHang(),
                x.getNhanVien().getTenNhanVien(), 
                x.getNgayDatPhong(),
                x.getTrangThaiPhieu()});
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUICapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICapNhatPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDatPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatPhongCho;
    private javax.swing.JButton btnDatPhongNgay;
    private javax.swing.JButton btnDatPhongTruoc;
    private javax.swing.JButton btnHuyPhieuDatTruoc;
    private javax.swing.JButton btnHuyPhongCho;
    private javax.swing.JButton btnKiemTraSDT;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiIndlg;
    private javax.swing.JButton btnNhanPhongDatTruoc;
    private javax.swing.JButton btnPKiemTraSDT;
    private javax.swing.JButton btnTimPhong;
    private com.toedter.calendar.JDateChooser dateNgayDatPhong;
    private javax.swing.JDialog dlgDatPhongCho;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblNgayDatTruoc;
    private javax.swing.JLabel lblNgayLap1;
    private javax.swing.JLabel lblNgayLap3;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPMaKhachHang;
    private javax.swing.JLabel lblPSoDienThoai;
    private javax.swing.JLabel lblPTenKhachHang;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTieuDeDatTruoc;
    private javax.swing.JLabel lblTime;
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
    private javax.swing.JPanel pnTime;
    private javax.swing.JPanel pnlDanhSachPhieuDatPhong;
    private javax.swing.JPanel pnlDanhSachPhieuDatTruoc;
    private javax.swing.JPanel pnlDanhSachPhong;
    private javax.swing.JPanel pnlDanhSachPhong1;
    private javax.swing.JPanel pnlThongTinKhachHang;
    private javax.swing.JPanel pnlThongTinKhachHang1;
    private javax.swing.JPanel pnlTieuDe;
    private javax.swing.JPanel pnlTieuDe3;
    private javax.swing.JScrollPane scrDanhSachPhieuDatPhongTruoc;
    private javax.swing.JScrollPane scrDanhSachPhong;
    private javax.swing.JScrollPane scrDanhSachPhong2;
    private javax.swing.JScrollPane scrDanhSachPhongDatTruoc;
    private javax.swing.JTable tblDanhSachPhieuDatPhong;
    private javax.swing.JTable tblDanhSachPhieuDatPhongTruoc;
    private javax.swing.JTable tblDanhSachPhongCho;
    private javax.swing.JTable tblDanhSachPhongDatTruoc;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtPMaKhachHang;
    private javax.swing.JTextField txtPSoDienThoai;
    private javax.swing.JTextField txtPTenKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
