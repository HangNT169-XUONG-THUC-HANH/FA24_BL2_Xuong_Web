package com.poly.xuong.B2_CRUD2Bang.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVienRequest {

    // liet ke lai form (yeu cau tu phia nguoi dung vao day)
    private Integer id;

    private String ma;

    private String ho;

    private String ten;

    private String tenDem;

    private String gioiTinh;

    private String sdt;

    private String diaChi;

    private Integer chucVuId;
}
