/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhanQuyen implements Serializable{
	
	/*
	 * Huỳnh Công Vương _ 21004195
     */
	
	private static String vaiTro;
        public static void setVaiTro(String role) {
            vaiTro = role;
        }
        public static String getVaiTro() {
            return vaiTro;
        }
        public static boolean coQuyenCapNhatNhanVien() {
	    return vaiTro.equals("Quản lý Karaoke");
	}	
}
