package com.poly.xuong.B5_PhanTrangSearch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietSP")
@ToString
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP")
    private SanPham idSP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx")
    private Nsx idNsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;

//    @Column(name = "IdMauSac")
//    private Integer idMauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP")
    private DongSP idDongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Nationalized
    @Column(name = "MoTa", length = 50)
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap", precision = 20)
    private Float giaNhap;

    @Column(name = "GiaBan", precision = 20)
    private Float giaBan;

}