
package entity;


public class CT_DichVu {
    private HoaDon hoaDon;
    private DichVu dichVu;
    private int soLuong;

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
   
    public double getThanhTien() {
	return soLuong * dichVu.getGiaBan();
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public CT_DichVu(HoaDon hoaDon, DichVu dichVu, int soLuong) {
        this.hoaDon = hoaDon;
        this.dichVu = dichVu;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "CT_DichVu{" + "hoaDon=" + hoaDon + ", dichVu=" + dichVu + ", soLuong=" + soLuong + '}';
    }

}
