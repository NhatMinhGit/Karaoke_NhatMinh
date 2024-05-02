
package entity;

public class CT_HoaDon {
    private HoaDon hoaDon;
    private Phong phong;
    private int thoiLuong;

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public Phong getPhong() {
        return phong;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public CT_HoaDon(HoaDon hoaDon, Phong phong, int thoiLuong) {
        this.hoaDon = hoaDon;
        this.phong = phong;
        this.thoiLuong = thoiLuong;
    }
    
    public double thanhTien(){
	return (getThoiLuong()/60.0)*phong.getGiaPhong();
    }
    
    @Override
    public String toString() {
        return "CT_HoaDon{" + "hoaDon=" + hoaDon + ", phong=" + phong + ", thoiLuong=" + thoiLuong + '}';
    }
 
}
