package com.poly.xuong.B5_PhanTrangSearch.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseObject <T> {

    private Integer pageNo; // pageNo: so trang

    private Integer totalPage; // tong so trang

    private List<T>listObject; // so phan tu trong 1 trang

}
