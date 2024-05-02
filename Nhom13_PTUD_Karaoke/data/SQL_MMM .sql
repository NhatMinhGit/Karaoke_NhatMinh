Create database QlKara
Use QlKara

Create table LoaiDichVu(
MaLoaiDichVu nvarchar(10) primary key,
TenLoaiDichVu nvarchar(10) NOT NULL
)
INSERT INTO LoaiDichVu(MaLoaiDichVu,TenLoaiDichVu)
VALUES 
	('TU',N'Thức uống'),
	('TA',N'Thức ăn'),
	('TT',N'Trang trí')

Create table DichVu(
MaDichVu nvarchar(20) primary key,
TenDichVu nvarchar(10) NOT NULL,
SoLuongDichVu int,
GiaBan float ,
DonViTinh nvarchar(10) NOT NULL,
trangThaiDichVu bit ,
MaLDV nvarchar(10), 
foreign key (MaLDV) references LoaiDichVu(MaLoaiDichVu)
)
INSERT INTO DichVu(MaDichVu,TenDichVu,SoLuongDichVu,GiaBan,DonViTinh,trangThaiDichVu,MaLDV)
VALUES 
	('DV001','Coca cola',200,20000,N'lon','true','TU'),
	('DV002','Lavie',100,10000,N'chai','true','TU'),
	('DV003','Heniken',300,30000,N'lon','true','TU'),
	('DV004','333',300,30000,N'lon','true','TU'),
	('DV005','Tiger',300,30000,N'lon','true','TU'),
	('DV006','Sting',200,20000,N'lon','true','TU'),
	('DV007','Nuoc ngot',50,250000,'thung','true','TU'),
	('DV008','Dau phong',500,15000,'bich','true','TA'),
	('DV009','Mi xao',500,30000,'phan','true','TA'),
	('DV0010','Trai cay',500,50000,'phan','true','TA'),
	('DV0011','Com chien',500,30000,'phan','true','TA'),
	('DV0012','Muc nuong',500,70000,'phan','true','TA'),
	('DV0013','Cau hon',50,1000000,'show','true','TT'),
	('DV0014','Sinh nhat',50,500000,'show','true','TT');


CREATE TABLE KhuyenMai (
    MaKhuyenMai NVARCHAR(20) PRIMARY KEY,
    MaGiamGia NVARCHAR(20) NOT NULL,
    ChietKhau FLOAT,
    SoLuong INT,
    ngayBatDauKM DATE NOT NULL,
    ngayKetThucKM DATE NOT NULL,
    MoTa NVARCHAR(20)
);

-- Insert data into the KhuyenMai table
INSERT INTO KhuyenMai (MaKhuyenMai, MaGiamGia, ChietKhau, SoLuong, ngayBatDauKM, ngayKetThucKM, MoTa)
VALUES
    ('KM000', 'KM', 0, 100, '2023-11-01', '2023-12-30', N'Giảm 0%'),
    ('KM001', 'TrungThu', 5, 100, '2023-11-01', '2023-12-30', N'Giảm 5%'),
    ('KM002', 'Noel', 5, 50, '2023-12-01', '2023-12-30', N'Giảm 5%'),
    ('KM003', '20/10', 10, 200, '2023-10-25', '2023-10-25', N'Giảm 10%'), -- Corrected date
    ('KM004', '20/11', 5, 75, '2023-11-10', '2023-11-20', N'Giảm 5%'),
    ('KM005', '1/1', 2, 80, '2023-01-01', '2023-01-05', N'Giảm 2%'),
    ('KM006', '2/9', 10, 60, '2023-09-01', '2023-09-05', N'Giảm 10%');

CREATE TABLE KhachHang (
    MaKhachHang nvarchar(20) PRIMARY KEY NOT NULL,
    TenKhachHang nvarchar(20) NOT NULL,
    GioiTinh nvarchar(5),
    NgaySinh date,
    SoDT nvarchar(12) NULL,
    SoCCCD nvarchar(13) NULL,
	DiaChi nvarchar(50) NULL
)

INSERT INTO KhachHang (MaKhachHang, TenKhachHang, GioiTinh, NgaySinh, SoDT, SoCCCD, DiaChi)
VALUES
    ('KHA001', 'Nguyen Van Chi', 'Nam', '1990-05-15', '09712345678', '012345678901', N'Quận 1, TP Hồ Chí Minh'),
    ('KHA002', 'Nguyen Tran Minh', N'Nam', '2003-12-10', '0765599103', '071234567890', N'Quận 2, TP Hồ Chí Minh'),
    ('KHA003', 'Bui Tat Nhut Minh', 'Nam', '2003-08-20', '0938533438', '0512345678901', N'Quận 3, TP Hồ Chí Minh'),
    ('KHA004', 'Duong Ngo Manh', N'Nam', '2003-03-05', '0941424359', '0612345678902', N'Quận 4, TP Hồ Chí Minh'),
    ('KHA005', 'Nguyen Thi Nhu', N'Nữ', '1992-11-28', '09312345678', '0712345678903', N'Quận 5, TP Hồ Chí Minh'),
    ('KHA006', 'Tran Van Long', 'Nam', '1988-07-02', '07923456789', '0512345678904', N'Quận 6, TP Hồ Chí Minh'),
    ('KHA007', 'Le Thi Huyen', N'Nữ', '1997-04-17', '09734567890', '0612345678905', N'Quận 7, TP Hồ Chí Minh'),
    ('KHA008', 'Pham Van Huynh', 'Nam', '2001-09-22', '09845678901', '0712345678906', N'Quận 8, TP Hồ Chí Minh'),
    ('KHA009', 'Nguyen Van Troi', 'Nam', '1998-02-14', '09356789012', '0512345678907', N'Quận 9, TP Hồ Chí Minh'),
    ('KHA010', 'Tran Thi Thu', N'Nữ', '1991-10-31', '09767890123', '0712345678908', N'Quận 10, TP Hồ Chí Minh'),
    ('KHA011', 'Le Van Long', 'Nam', '2002-07-25', '07978901234', '0612345678909', N'Quận 11, TP Hồ Chí Minh'),
    ('KHA012', 'Pham Thi My', N'Nữ', '1989-03-18', '09889012345', '0712345678910', N'Quận 12, TP Hồ Chí Minh'),
    ('KHA013', 'Nguyen Thi Quynh', N'Nữ', '1994-06-09', '09790123456', '0712345678911', N'Quận Bình Tân, TP Hồ Chí Minh'),
    ('KHA014', 'Tran Van Phong', 'Nam', '2003-01-11', '09701234567', '0712345678912', N'Quận Bình Thạnh, TP Hồ Chí Minh'),
    ('KHA015', 'Le Thi Linh', N'Nữ', '1987-08-08', '07912345678', '0712345678913', N'Quận Tân Phú, TP Hồ Chí Minh'),
    ('KHA016', 'Pham Van Phong', 'Nam', '1993-12-03', '09323456789', '0712345678914', N'Quận Tân Bình, TP Hồ Chí Minh'),
    ('KHA017', 'Nguyen Van Linh', 'Nam', '1996-04-06', '09334567890', '0712345678915', N'Quận Phú Nhuận, TP Hồ Chí Minh'),
    ('KHA018', 'Tran Thi Sau', N'Nữ', '1999-09-29', '07945678901', '0712345678916', N'Quận Gò Vấp, TP Hồ Chí Minh'),
    ('KHA019', 'Le Van Tien', 'Nam', '2004-02-20', '09756789012', '0712345678917', N'Quận Củ Chi, TP Hồ Chí Minh'),
    ('KHA020', 'Dao Thi Truc Linh', N'Nữ', '2003-06-11', '0372135696', '072203004088', N'Ninh Kiều, Cần Thơ');
select * FROM KhachHang

CREATE TABLE ChucVu (
    MaChucVu nvarchar(20) PRIMARY KEY,
    TenChucVu nvarchar(50) NOT NULL
)

INSERT INTO ChucVu (MaChucVu, TenChucVu)
VALUES
    ('QL', N'Quản lý Karaoke'),
    ('NVTN', N'Nhân viên Thu Ngân')

SELECT * FROM ChucVu


Create table LoaiPhong(
MaLoaiPhong nvarchar(20) primary key,
TenLoaiPhong nvarchar(20),
)

INSERT INTO LoaiPhong(MaLoaiPhong, TenLoaiPhong)
VALUES
('LP001', 'VIP'),
('LP002', 'Thuong')
SELECT * FROM LoaiPhong

Create table NhanVien(
MaNhanVien nvarchar(20) primary key ,
MaCV nvarchar(20),
TenNV nvarchar(30) ,
GioiTinh nvarchar(5) ,
NgaySinh date,
SoDT nvarchar(11) , 
DiaChi nvarchar(40) ,
MatKhau nvarchar(40) ,
foreign key (MaCV) references ChucVu(MaChucVu)
)

INSERT INTO NhanVien(MaNhanVien, MaCV, TenNV, GioiTinh, NgaySinh, SoDT, DiaChi, MatKhau)
VALUES
('NV001','QL', N'Duong Ngo Manh', N'Nam', '1980-07-14', '0941424359', '12 Nguyen Van Bao', '123456'),
('NV002','QL',N'Bui Tat Nhut Minh', N'Nam', '2003-01-08', '0938533438', 'Tây Ninh', '123456'),
('NV003','QL',N'Nguyen Tran Nhat Minh', N'Nam', '1993-09-05', '0765599103', '125 Le Duc Tho', '123456'),
('NV004','NVTN',N'Duong Van Hung', N'Nam', '1996-02-12', '0823356789', '225 Ton That Thuyet', 'bferf4'),
('NV005','NVTN',N'Nhat Van Tien', N'Nữ', '1998-03-13', '0823756789', '221 Le Thai To', 'aefsd2'),
('NV006','NVTN',N'Bui Van Dung', N'Nam', '1991-08-19', '0923456749', '436 Tran Duy Hung', '43fsgegf'),
('NV007','NVTN',N'Hua Van Khang', N'Nữ', '1992-06-20', '0723676789', '64 Nguyen Oanh', 'agser6'),
('NV008','NVTN', N'That Van Ngoc', N'Nam', '1996-08-21', '0823456789', '69 Hoang Sa', 'adfg72'),
('NV009','NVTN',N'Lo Van Hoang', N'Nữ', '1997-04-22', '0923456789', '93 Phan Van Tri', 'dzfhfg7'),
('NV010','NVTN',N'Le Van Phuc', N'Nam', '1995-03-27', '0723456789', '551 Nguyen Thai Son', 'dgehsdh90'),
('NV011','NVTN', N'Vi Van Tam', N'Nữ', '1993-01-24', '0523456789', '416 Nguyen Huy Thong', '0fgb63v'),
('NV012','NVTN', N'Pham Van Huy', N'Nam', '1988-09-26', '0323456789', '31/20/8 Tran Ba Giao', 'dfg65sdfh'),
('NV013','NVTN', N'Kieu Van Yen', N'Nữ', '1984-11-21', '0723456789', '81/20 Tan Son Nhat', 'zdf5xdfb'),
('NV014','QL', N'Hoang Gia Nguyen', N'Nam', '1987-12-18', '0923456789', '53/18 Duong Quang Ham', 'zgdf32zdgf'),
('NV015','NVTN', N'Chu Van An', N'Nam', '1991-08-15', '0323456789', '347 Quang Trung', 'zdgf7zse'),
('NV016','NVTN', N'Ton Van Ngo', N'Nữ', '1992-03-12', '0723456789', '821 Xo Viet', 'zdgf6zd'),
('NV017','QL', N'Vu Van Thuan', N'Nam', '1993-06-11', '0923456789', '741 Nguyen Trai', 'hui76sgr'),
('NV018','NVTN', N'Thong Van Ba',  N'Nữ', '1995-07-17', '0823456789', '183 Tran Quoc Toan', 'zdfg5gytu');

SELECT *FROM NhanVien

Create table Phong(
MaPhong nvarchar(20) primary key,
MaLP nvarchar(20),
TenPhong nvarchar(10),
GiaPhong float,
SoNguoiToiDa int,
TrangThaiPhong nvarchar(10),
foreign key (MaLP) references LoaiPhong(MaLoaiPhong)
)

INSERT INTO Phong(MaPhong, MaLP, TenPhong, GiaPhong, SoNguoiToiDa,TrangThaiPhong)
VALUES
('P001', 'LP001', 'Phong 001', 40000, 10,N'Trống'),
('P002', 'LP002', 'Phong 002', 25000, 5,N'Trống'),
('P003', 'LP001', 'Phong 003', 40000, 10,N'Trống'),
('P004', 'LP002', 'Phong 004', 25000, 5,N'Trống'),
('P005', 'LP001', 'Phong 005', 40000, 10,N'Trống'),
('P006', 'LP002', 'Phong 006', 25000, 5,N'Trống'),
('P007', 'LP001', 'Phong 007', 40000, 10,N'Trống'),
('P008', 'LP001', 'Phong 008', 40000, 10,N'Trống'),
('P009', 'LP001', 'Phong 009', 40000, 10,N'Trống'),
('P010', 'LP002', 'Phong 010', 25000, 5,N'Trống'),
('P011', 'LP002', 'Phong 011', 25000, 5,N'Trống'),
('P012', 'LP002', 'Phong 012', 25000, 5,N'Trống');

Create table PhieuDatPhong(
ID INT IDENTITY(1,1) PRIMARY KEY,
MaPhieuDatPhong NVARCHAR(20) UNIQUE NOT NULL,
MaP nvarchar(20),
MaKH nvarchar(20),
MaNV nvarchar(20),
NgayDatPhong date,
GioNhanPhong datetime,
TrangThaiPhieu nvarchar(20),
foreign key (MaP) references Phong(MaPhong),
foreign key (MaKH) references KhachHang(MaKhachHang),
foreign key (MaNV) references NhanVien(MaNhanVien)
)

SELECT * FROM PhieuDatPhong

Create table HoaDon(
MaHoaDon nvarchar(20) primary key,
NgayLapHD date,
MaNV nvarchar(20),
TenKhachHang nvarchar(20),
MaP nvarchar(20),
GioNhanPhong datetime,
GioTraPhong datetime null,
MaKM nvarchar(20) null,
TongTien float null,
ChietKhau float null,
TienKhachTra float null,
foreign key (MaNV) references NhanVien(MaNhanVien),
foreign key (MaP) references Phong(MaPhong),
foreign key (MaKM) references KhuyenMai(MaKhuyenMai)
)
INSERT INTO HoaDon (MaHoaDon, NgayLapHD, MaNV, TenKhachHang, MaP, GioNhanPhong, GioTraPhong, MaKM, TongTien)
VALUES 
('130113004724', '2023-01-13', 'NV004', 'Nguyen Tran Minh', 'P001', '2023-01-13 23:47:24.050', '2023-01-13 23:48:06.343', 'KM002', 1054500),
('130113002311', '2023-01-13', 'NV013', 'Le Van Long', 'P002', '2023-01-13 23:23:11.000', '2023-01-13 23:45:00.000', 'KM002', 1054500),
('130313011515', '2023-03-13', 'NV014', 'Tran Van Phong', 'P010', '2023-03-13 11:15:15.000', '2023-03-13 12:45:00.000', 'KM002', 1054500),

('130513018318', '2023-05-13', 'NV016', 'Nguyen Van Linh', 'P011', '2023-05-13 18:33:18.000', '2023-05-13 20:00:00.000', 'KM002', 1054500),
('130613009524', '2023-06-13', 'NV003', 'Bui Tat Nhut Minh', 'P012', '2023-06-13 09:52:04.000', '2023-06-13 10:45:00.000', 'KM002', 2054500), 
('130723240001', '2023-07-13', 'NV001', 'Nguyen Van Chi', 'P001', '2023-07-13 00:00:01.000', '2023-07-13 01:00:00.000', 'KM002', 1054500),
('130823242345', '2023-08-13', 'NV005', 'Nguyen Thi Nhu', 'P002', '2023-08-13 23:45:00.000', '2023-08-14 00:45:00.000', 'KM002', 3054500),
('130923244512', '2023-09-13', 'NV007', 'Le Thi Huyen', 'P003', '2023-09-13 04:45:12.000', '2023-09-13 06:00:00.000', 'KM002', 1554500),
('131023248765', '2023-10-13', 'NV010', 'Tran Thi Thu', 'P004', '2023-10-13 08:47:00.000', '2023-10-13 10:15:00.000', 'KM002', 1054500),
('131023251212', '2023-10-13', 'NV012', 'Pham Thi My', 'P005', '2023-10-13 15:12:12.000', '2023-10-13 16:30:00.000', 'KM002', 2054500),

('131123253434', '2023-11-13', 'NV015', 'Le Thi Linh', 'P006', '2023-11-13 23:53:34.000', '2023-11-14 00:45:00.000', 'KM002', 1854500),
('130623256789', '2023-06-13', 'NV018', 'Dao Thi Truc Linh', 'P007', '2023-06-13 16:12:34.000', '2023-06-13 17:30:00.000', 'KM002', 1354500),
('131123260123', '2023-11-13', 'NV002', 'Nguyen Tran Minh', 'P008', '2023-11-13 12:01:23.000', '2023-11-13 14:00:00.000', 'KM002', 1054500),
('131223264321', '2023-12-13', 'NV006', 'Tran Van Long', 'P009', '2023-12-13 20:43:21.000', '2023-12-13 22:00:00.000', 'KM002', 1054500),
('130223267777', '2023-02-13', 'NV011', 'Le Van Long', 'P010', '2023-02-13 15:27:00.000', '2023-02-13 16:45:00.000', 'KM002', 2254500),

('131223270909', '2023-12-13', 'NV013', 'Pham Thi My', 'P011', '2023-12-13 09:09:09.000', '2023-12-13 10:30:00.000', 'KM002', 1354500),
('131223272727', '2023-12-13', 'NV017', 'Le Van Tien', 'P012', '2023-12-13 22:27:27.000', '2023-12-14 00:00:00.000', 'KM002', 1254500),
('131223275656', '2023-12-13', 'NV004', 'Nguyen Van Troi', 'P001', '2023-12-13 21:56:56.000', '2023-12-13 23:15:00.000', 'KM002', 1454500),
('131223279898', '2023-12-13', 'NV008', 'Pham Van Huynh', 'P002', '2023-12-13 14:56:56.000', '2023-12-13 16:00:00.000', 'KM002', 2354500),
('130323281818', '2023-03-13', 'NV013', 'Nguyen Van Linh', 'P003', '2023-03-13 17:18:18.000', '2023-03-13 18:30:00.000', 'KM002', 654500);
select * from HoaDon

CREATE TABLE CT_DichVu (
    RowID INT IDENTITY(1,1) PRIMARY KEY,
    MaHD NVARCHAR(20),
    MaDV NVARCHAR(20) NULL,
    SoLuong INT NULL,
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaDV) REFERENCES DichVu(MaDichVu)
);

CREATE TABLE CT_HoaDon (
    RowID INT IDENTITY(1,1) PRIMARY KEY,
    MaHD NVARCHAR(20),
	MaP NVARCHAR(20),
    ThoiLuong INT NULL,
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHoaDon),
    FOREIGN KEY (MaP) REFERENCES Phong(MaPhong),
)

select * from PhieuDatPhong
select * from HoaDon