package com.poly.xuong.B1_CRUD1Bang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "KhachHang")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Ma", length = 20)
    private String ma;

    @Nationalized
    @Column(name = "Ten", length = 30)
    private String ten;

    @Nationalized
    @Column(name = "TenDem", length = 30)
    private String tenDem;

    @Nationalized
    @Column(name = "Ho", length = 30)
    private String ho;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @Nationalized
    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Nationalized
    @Column(name = "ThanhPho", length = 50)
    private String thanhPho;

    @Nationalized
    @Column(name = "QuocGia", length = 50)
    private String quocGia;

    @Lob
    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

}