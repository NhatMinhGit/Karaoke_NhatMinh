/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.*;

/**
 *
 * @author Duong Ngo Manh
 */
@Entity
@Table(name = "LoaiPhong")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ //JPQL
        @NamedQuery(name = "LoaiPhong.layDanhSachLoaiPhong", query = "select lp from LoaiPhong lp"),
        @NamedQuery(name = "LoaiPhong.capNhatLoaiPhong", query = "INSERT INTO LoaiPhong(lp.maLoaiPhong, lp.tenLoaiPhong) VALUES (:maLoaiPhong, :tenLoaiPhong)"),
        @NamedQuery(name = "LoaiPhong.capNhatLoaiPhong", query = "UPDATE LoaiPhong lp SET lp.tenLoaiPhong = :newTenLoaiPhong WHERE lp.maLoaiPhong = :maLoaiPhong")    
})

@Getter
@Setter
@ToString
public class LoaiPhong {
    @Id
    @Column(name = "MaLoaiPhong",columnDefinition = "nvarchar(20)",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maLoaiPhong;
    @Column(name = "TenLoaiPhong",columnDefinition = "nvarchar(20)")
    private String tenLoaiPhong;
    
    public LoaiPhong() {
    }

    public LoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public LoaiPhong(String maLoaiPhong, String tenLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.maLoaiPhong);
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
        final LoaiPhong other = (LoaiPhong) obj;
        return Objects.equals(this.maLoaiPhong, other.maLoaiPhong);
    }
    
}
