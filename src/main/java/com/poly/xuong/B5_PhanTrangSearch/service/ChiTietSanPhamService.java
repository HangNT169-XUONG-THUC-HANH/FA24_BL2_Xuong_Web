package com.poly.xuong.B5_PhanTrangSearch.service;

import com.poly.xuong.B5_PhanTrangSearch.entity.ChiTietSP;
import com.poly.xuong.B5_PhanTrangSearch.repository.ChiTietSanPhamRepository;
import com.poly.xuong.B5_PhanTrangSearch.response.ChiTietSanPhamResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ChiTietSanPhamService {

    private ChiTietSanPhamRepository repository = new ChiTietSanPhamRepository();

    public List<ChiTietSanPhamResponse> phanTrang(int pageNo, int pageSize) {
        List<ChiTietSP> lists = repository.phanTrangHQl(pageNo, pageSize);
        return lists.stream().map(ChiTietSanPhamResponse::new).collect(Collectors.toList());
    }

    // tra ve tong so page
    public Integer totalPage(Integer itemPerPage) {
        Integer totalItems = repository.getAll().size();
        return (int) Math.ceil((double) totalItems / itemPerPage);
    }
}
