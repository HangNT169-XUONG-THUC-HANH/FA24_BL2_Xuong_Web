package com.poly.xuong.B2_CRUD2Bang.sevice;

import com.poly.xuong.B2_CRUD2Bang.entity.NhanVien;
import com.poly.xuong.B2_CRUD2Bang.repository.NhanVienRepository;
import com.poly.xuong.B2_CRUD2Bang.response.NhanVienResponse;

import java.util.List;
import java.util.stream.Collectors;

public class NhanVienService {

    private NhanVienRepository repository = new NhanVienRepository();

    public List<NhanVienResponse> getAll() {
        List<NhanVien> listNhanVien = repository.getAll();
        return listNhanVien.stream().map(NhanVienResponse::new).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienService().getAll());
    }
}
