
package UI;

import connectdb.ConnectDB;
import dao.DangNhap_DAO;
import entity.PhanQuyen;
import entity.ThongTinDangNhap;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DangNhap extends javax.swing.JFrame {

    public DangNhap() {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtTaiKhoan = new javax.swing.JTextField();
        lblTaiKhoan = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        radMatKhau = new javax.swing.JRadioButton();
        btnDangNhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karaoke MMM");
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(300, 120, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangnhap.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("ĐĂNG NHẬP");

        txtTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTaiKhoan.setText("0765599103");
        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTaiKhoan.setText("Tài khoản:");

        lblMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblMatKhau.setText("Mật khẩu:");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMatKhau.setText("123456");
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        radMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        radMatKhau.setText("Hiển thị mật khẩu");
        radMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMatKhau)
                    .addComponent(lblTaiKhoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(txtMatKhau))
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radMatKhau)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(radMatKhau)
                .addGap(21, 21, 21))
        );

        btnDangNhap.setBackground(new java.awt.Color(102, 51, 0));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(242, 242, 242));
        btnDangNhap.setText("ĐĂNG NHẬP");
        btnDangNhap.setBorder(null);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Sự kiện nút hiển mật khẩu
    private void radMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMatKhauActionPerformed
        if (radMatKhau.isSelected()) {
            txtMatKhau.setEchoChar((char) 0); // Hiển thị mật khẩu
        } else {
            txtMatKhau.setEchoChar('\u2022'); // Ẩn mật khẩu
        }
    }//GEN-LAST:event_radMatKhauActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String soDienThoai = txtTaiKhoan.getText();
        String matKhau = txtMatKhau.getText();

        Connection connection = ConnectDB.getConnection();
        DangNhap_DAO login = new DangNhap_DAO(connection);

        // Kiểm tra chức vụ của người dùng
        String chucVu = login.layChucVu(soDienThoai, matKhau);
        String tenNhanVien = login.layTenNhanVien(soDienThoai, matKhau);
        String maNhanVien = login.layMaNhanVien(soDienThoai, matKhau);
        ThongTinDangNhap.setMaNhanVien(maNhanVien);
        if (chucVu != null) {
            PhanQuyen.setVaiTro(chucVu);
            if (chucVu.equals("Quản lý Karaoke")) {
                GUITrangChu tc = new GUITrangChu();
                tc.setVisible(true);
                this.setVisible(false);
            } else if (chucVu.equals("Nhân viên Thu Ngân")) {
                GUITrangChu tc = new GUITrangChu();
                tc.setVisible(true);
                this.setVisible(false);
            } else if (chucVu.equals("Nhân viên Phục vụ")) {
                GUITrangChu tc = new GUITrangChu();
                tc.setVisible(true);
                this.setVisible(false);
            } else if (chucVu.equals("Nhân viên Bảo vệ")) {
                GUITrangChu tc = new GUITrangChu();
                tc.setVisible(true);
                this.setVisible(false);
            } else if (chucVu.equals("Nhân viên Kĩ thuật")) {
                GUITrangChu tc = new GUITrangChu();
                tc.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Người dùng không có quyền truy cập!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Số điện thoại hoặc mật khẩu không chính xác!");
        }

//        // lấy tên nhân viên khi đăng nhập
//        if (tenNhanVien != null && !tenNhanVien.isEmpty()) {
//            GUITrangChu tc = new GUITrangChu();
//            tc.hienThiTenNhanVien(tenNhanVien);
//            tc.setVisible(true);
//            this.setVisible(false);
//        } else {
//            JOptionPane.showMessageDialog(this, "Không thể truy xuất tên nhân viên đang đăng nhập!");
//        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaiKhoanActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JRadioButton radMatKhau;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

}
