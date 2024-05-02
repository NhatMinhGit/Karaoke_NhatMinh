
package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String gioiTinh;
    private Date ngaySinh;
    private String soDT;
    private String soCCCD;
    private String diaChi;
    private int soHoaDon;
    private float tongChiTieu;

    public KhachHang(String maKhachHang, String tenKhachHang, int soHoaDon, float tongChiTieu) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soHoaDon = soHoaDon;
        this.tongChiTieu = tongChiTieu;
    }
    
    public int getSoHoaDon() {
        return soHoaDon;
    }

    public float getTongChiTieu() {
        return tongChiTieu;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public void setTongChiTieu(float tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }
    
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public Date getNgaySinh() {
        return new java.sql.Date(this.ngaySinh.getTime());
    }

    public String getSoDT() {
        return soDT;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maKhachHang);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return true;
    }

    public KhachHang() {
    }

    public KhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public KhachHang(String maKhachHang, String tenKhachHang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String gioiTinh,Date ngaySinh, String soDT, String soCCCD, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.soCCCD = soCCCD;
        this.diaChi = diaChi;
    }


    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", soDT=" + soDT + ", soCCCD=" + soCCCD + ", diaChi=" + '}';
    }
    
    
}
