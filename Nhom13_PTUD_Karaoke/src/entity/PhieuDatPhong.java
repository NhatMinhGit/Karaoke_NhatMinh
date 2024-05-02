/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.*;

/**
 *
 * @author ad
 */

@Entity
@Table(name = "PhieuDatPhong")
@Inheritance(strategy = InheritanceType.JOINED)

@Getter
@Setter
@ToString
public class PhieuDatPhong {
    @Id
    @Column(name = "MaPhieuDatPhong")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maPhieuDatPhong;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong", columnDefinition = "nvarchar(20)", nullable = false)
    private Phong phong;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhachHang", columnDefinition = "nvarchar(20)", nullable = false)
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhanVien", columnDefinition = "nvarchar(20)", nullable = false)
    private NhanVien nhanVien;
    @Column(name = "TenNV", columnDefinition = "nvarchar(30)")
    private String ngayDatPhong;
    @Column(name = "TenNV", columnDefinition = "nvarchar(30)")
    private String gioNhanPhong;
    @Column(name = "TenNV", columnDefinition = "nvarchar(30)")
    private String trangThaiPhieu;
    public PhieuDatPhong() {
    }

    public PhieuDatPhong(String maPhieuDatPhong) {
        this.maPhieuDatPhong = maPhieuDatPhong;
    }

    public PhieuDatPhong(String maPhieuDatPhong, Phong phong, KhachHang khachHang, NhanVien nhanVien, String gioNhanPhong) {
        this.maPhieuDatPhong = maPhieuDatPhong;
        this.phong = phong;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.gioNhanPhong = gioNhanPhong;
    }

    public PhieuDatPhong(String maPhieuDatPhong, Phong phong, KhachHang khachHang, NhanVien nhanVien, String ngayDatPhong, String gioNhanPhong, String trangThaiPhieu) {
        this.maPhieuDatPhong = maPhieuDatPhong;
        this.phong = phong;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayDatPhong = ngayDatPhong;
        this.gioNhanPhong = gioNhanPhong;
        this.trangThaiPhieu = trangThaiPhieu;
    }    


    public PhieuDatPhong(String maPhieuDatPhong, Phong phong, KhachHang khachHang, NhanVien nhanVien, String ngayDatPhong, String trangThaiPhieu) {
        this.maPhieuDatPhong = maPhieuDatPhong;
        this.phong = phong;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayDatPhong = ngayDatPhong;
        this.trangThaiPhieu = trangThaiPhieu;
    }

    
    
    
    
}
