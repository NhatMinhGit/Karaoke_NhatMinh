package dao.impl;
import dao.NhanVien_DAO;
import dao.Impl.NhanVienImpl;
import dao.Impl.ChucVuImpl;
import dao.ChucVu_DAO;


import entity.NhanVien;
import entity.ChucVu;

import java.rmi.RemoteException;
import org.hibernate.classic.Lifecycle;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import org.junit.Test;


@TestInstance(Lifecycle.PER_CLASS)
public class mainTestChucVu {
	
	private ChucVu_DAO chucVuDao;
	private NhanVien_DAO nhanVienDao;
	private NhanVien x;
	private ChucVu cv;
	
	@BeforeAll
	void setUp() throws Exception {
		nhanVienDao = new NhanVienImpl();
		chucVuDao = new ChucVuImpl();
	}
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		nhanVienDao = new NhanVienImpl();
		chucVuDao = new ChucVuImpl();
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		nhanVienDao = null;
		chucVuDao = null;
	}
	
	@Test
	void testThemChucVu() throws RemoteException {
		ChucVu cv = new ChucVu();
		cv.setMaChucVu("QLNV");
		cv.setTenChucVu("Quản lý Nhan Vien");

		// Kiểm tra xem ChucVu với MaChucVu tương ứng đã tồn tại chưa
		ChucVu existingChucVu = chucVuDao.timChucVuTheoMa("QLNV");
		if (existingChucVu == null) {
			// Nếu chưa tồn tại, thực hiện thao tác thêm
			chucVuDao.themChucVu(cv);
		} else {
			// Nếu đã tồn tại, sử dụng ChucVu hiện có
			cv = existingChucVu;
		}

		// Kiểm tra xem ChucVu đã được thêm thành công chưa
		ChucVu addedChucVu = chucVuDao.timChucVuTheoMa("QLNV");
		assertNotNull(addedChucVu);
		assertEquals("Quản lý Nhan Vien", addedChucVu.getTenChucVu());
	}
	
	@Test
	void capNhatChucVu() throws RemoteException {
	    ChucVu cv = new ChucVu();
	    cv.setMaChucVu("QLPhong");

	    // Kiểm tra xem ChucVu với MaChucVu tương ứng đã tồn tại chưa
	    ChucVu existingChucVu = chucVuDao.timChucVuTheoMa("QLPhong");
	    if (existingChucVu == null) {
	        // Nếu chưa tồn tại, thực hiện thao tác thêm
	    	cv.setTenChucVu("");
	        chucVuDao.themChucVu(cv);
	    } else {
	        // Nếu đã tồm tại, thực hiện thao tác cập nhật
	        existingChucVu.setTenChucVu("Quản lý Nhan Vien Nu");
	        chucVuDao.capNhatChucVu(existingChucVu); // Thêm dòng này
	    }   
	    // Kiểm tra xem ChucVu đã được cập nhật thành công chưa
	    ChucVu updatedChucVu = chucVuDao.timChucVuTheoMa("QLGirl"); // Sửa dòng này
	    assertNotNull(updatedChucVu);
	    assertEquals("Quản lý Nhan Vien Nu", updatedChucVu.getTenChucVu());
	}
	@Test
	void timChucVuTheoMa() throws RemoteException {
        ChucVu cv = chucVuDao.timChucVuTheoMa("QLNV");
        assertNotNull(cv);
        assertEquals("Quản lý Nhan Vien", cv.getTenChucVu());
        System.out.println("Thành công" + cv.getTenChucVu()+ cv.getMaChucVu());
    }
}
