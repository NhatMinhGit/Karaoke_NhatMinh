
package entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.*;
@Entity
@Table(name = "Phong")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ //JPQL
        @NamedQuery(name = "Phong.findAll", query = "select p from Phong p"),
})
@Getter
@Setter
@ToString
public class Phong {
    @Id
    @Column(name = "MaPhong",columnDefinition = "nvarchar(20)",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maPhong;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoaiPhong",columnDefinition = "nvarchar(10)")
    private LoaiPhong loaiPhong;
    @Column(name = "TenPhong",columnDefinition = "nvarchar(10)")
    private String tenPhong;
    @Column(name = "GiaPhong",columnDefinition = "float")
    private float giaPhong;
    @Column(name = "SoNguoiToiDa",columnDefinition = "int")
    private int soNguoiToiDa;
    @Column(name = "TrangThaiPhong",columnDefinition = "nvarchar(10)")
    private String trangThaiPhong;

    public Phong() {
    }

    public Phong(String maPhong) {
        this.maPhong = maPhong;
    }
    
    public Phong(String maPhong, String tenPhong, float giaPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.giaPhong = giaPhong;
    }

    public Phong(String maPhong, LoaiPhong loaiPhong, String tenPhong, float giaPhong) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.tenPhong = tenPhong;
        this.giaPhong = giaPhong;
    }
    
    
    
    public Phong(String maPhong, LoaiPhong loaiPhong, String tenPhong, float giaPhong, int soNguoiToiDa, String trangThaiPhong) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.tenPhong = tenPhong;
        this.giaPhong = giaPhong;
        this.soNguoiToiDa = soNguoiToiDa;
        this.trangThaiPhong = trangThaiPhong;
    }
    
}   
