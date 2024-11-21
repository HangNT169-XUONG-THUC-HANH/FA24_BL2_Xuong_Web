package com.poly.xuong.B2_CRUD2Bang.response;

import com.poly.xuong.B2_CRUD2Bang.entity.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NhanVienResponse {
    // LIET KE TAT CA CAC TRUONG CAN THIET
    private Integer nhanVienID;

    private String ho;

    private String ten;

    private String tenDem;

    private String diaChi;

    private Integer chucVuID;

    private String tenChucVu;

    // convert nhanh tu NhanVien -> NhanVienResponse
    public NhanVienResponse(NhanVien nv) {
        this.nhanVienID = nv.getId();
        this.ho = nv.getHo();
        this.ten = nv.getTen();
        this.tenDem = nv.getTenDem();
        this.diaChi = nv.getDiaChi();
        // Phai check la Khoa ngoai co gia hay hoac khong
        if (nv.getCv() != null) {
            // fetch de dam bao du lieu cua cv duoc lay ra
            Hibernate.initialize(nv.getCv());
            this.chucVuID = nv.getCv().getId();
            this.tenChucVu = nv.getCv().getTen();
        }
    }

    public String getHoVaTen() {
        return this.ho + " " + this.tenDem + " " + this.ten;
    }
}
