/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "NhanVien")
        
@Getter
@Setter
@NoArgsConstructor
@ToString
public class NhanVien {

    @Id
    @Column(name = "MaNhanVien", columnDefinition = "nvarchar(20)", nullable = false)
    private String maNhanVien;
	
    @ManyToOne
    @JoinColumn(name = "MaCV",columnDefinition = "nvarchar(20)")
    private ChucVu chucVu;
    @Column(name = "TenNV", columnDefinition = "nvarchar(30)")
    private String tenNhanVien;
    @Column(name = "GioiTinh", columnDefinition = "nvarchar(5)")
    private String gioiTinh;
	
    @Column(name = "NgaySinh", columnDefinition = "date")
    private String ngaySinh;
	
    @Column(name = "SoDT", columnDefinition = "nvarchar(11)")
    private String soDienThoai;
	
    @Column(name = "DiaChi", columnDefinition = "nvarchar(40)")
    private String diaChi;
	
    @Column(name = "MatKhau", columnDefinition = "nvarchar(40)", nullable = false)
    private String matKhau;

    public NhanVien(String maNhanVien, ChucVu chucVu, String tenNhanVien, String gioiTinh, String ngaySinh, String soDienThoai, String diaChi, String matKhau) {
        this.maNhanVien = maNhanVien;
        this.chucVu = chucVu;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
    }

    public NhanVien(String maNhanVien, String tenNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

        
    public NhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
        
        

  
    
    
}
