package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HoaDon {

    private String maHD;
    private Date ngayLapHD;
    private NhanVien nhanVien;
    private String tenKhachHang;
    private Phong phong;
    private Date gioNhanPhong;
    private Date gioTraPhong;
    private KhuyenMai khuyenMai;
    private double tongTien;
    private float chietKhau;
    private double tienKhachTra;
    private int thangLapHD;
    private int namLapHD;

    public int getThangLapHD() {
        return thangLapHD;
    }

    public void setThangLapHD(int thangLapHD) {
        this.thangLapHD = thangLapHD;
    }

    public int getNamLapHD() {
        return namLapHD;
    }

    public void setNamLapHD(int namLapHD) {
        this.namLapHD = namLapHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public Date getGioNhanPhong() {
        return gioNhanPhong;
    }

    public Date getGioTraPhong() {
        return gioTraPhong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public float getChietKhau() {
        return chietKhau;
    }

    public double getTienKhachTra() {
        return tienKhachTra;
    }

    public void setChietKhau(float chietKhau) {
        this.chietKhau = chietKhau;
    }

    public void setTienKhachTra(double tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
        //tháng
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(ngayLapHD);
        this.thangLapHD = calendar1.get(Calendar.MONTH) + 1;
        //năm
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(ngayLapHD);
        this.namLapHD = calendar2.get(Calendar.YEAR);
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public void setGioNhanPhong(Date gioNhanPhong) {
        this.gioNhanPhong = gioNhanPhong;
    }

    public void setGioTraPhong(Date gioTraPhong) {
        this.gioTraPhong = gioTraPhong;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public HoaDon() {
    }

    public HoaDon(String maHD, Date ngayLapHD) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    public HoaDon(String maHD, NhanVien nhanVien, String tenKhachHang, Phong phong, Date gioNhanPhong) {
        this.maHD = maHD;
        this.nhanVien = nhanVien;
        this.tenKhachHang = tenKhachHang;
        this.phong = phong;
        this.gioNhanPhong = gioNhanPhong;
    }

    public HoaDon(String maHD, Date ngayLapHD, NhanVien nhanVien, String tenKhachHang, Phong phong, Date gioNhanPhong) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.nhanVien = nhanVien;
        this.tenKhachHang = tenKhachHang;
        this.phong = phong;
        this.gioNhanPhong = gioNhanPhong;
    }

    public HoaDon(String maHD, Date ngayLapHD, NhanVien nhanVien, String tenKhachHang, Phong phong, Date gioNhanPhong, Date gioTraPhong, double tongTien, KhuyenMai khuyenMai) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.nhanVien = nhanVien;
        this.tenKhachHang = tenKhachHang;
        this.phong = phong;
        this.gioNhanPhong = gioNhanPhong;
        this.gioTraPhong = gioTraPhong;
        this.tongTien = tongTien;
        this.khuyenMai = khuyenMai;
    }

    public HoaDon(NhanVien nhanVien, String tenKhachHang, Phong phong) {
        this.nhanVien = nhanVien;
        this.tenKhachHang = tenKhachHang;
        this.phong = phong;
    }

    public HoaDon(String maHD, KhuyenMai khuyenMai, double tongTien, float chietKhau, double tienKhachTra) {
        this.maHD = maHD;
        this.khuyenMai = khuyenMai;
        this.tongTien = tongTien;
        this.chietKhau = chietKhau;
        this.tienKhachTra = tienKhachTra;
    }

    public HoaDon(String maHD, Date ngayLapHD, NhanVien nhanVien, String tenKhachHang, Phong phong, Date gioNhanPhong, Date gioTraPhong, double tongTien, float chietKhau, double tienKhachTra) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.nhanVien = nhanVien;
        this.tenKhachHang = tenKhachHang;
        this.phong = phong;
        this.gioNhanPhong = gioNhanPhong;
        this.gioTraPhong = gioTraPhong;
        this.tongTien = tongTien;
        this.chietKhau = chietKhau;
        this.tienKhachTra = tienKhachTra;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", nhanVien=" + nhanVien + ", tenKhachHang=" + tenKhachHang + ", phong=" + phong + ", gioNhanPhong=" + gioNhanPhong + ", gioTraPhong=" + gioTraPhong + ", tongTien=" + tongTien + ", khuyenMai=" + khuyenMai + '}';
    }

}

