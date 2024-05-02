/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ChucVu")

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ChucVu implements Serializable {
	
	
	@Id
	@Column(name = "MaChucVu", columnDefinition = "nvarchar(20)", nullable = false)
	private String maChucVu;
	@Column(name = "TenChucVu", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenChucVu;

        public ChucVu(String maChucVu) {
            this.maChucVu = maChucVu;
        }
	
	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	
	
}
