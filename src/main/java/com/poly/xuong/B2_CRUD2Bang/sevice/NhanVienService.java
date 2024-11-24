package com.poly.xuong.B2_CRUD2Bang.sevice;

import com.poly.xuong.B2_CRUD2Bang.entity.ChucVu;
import com.poly.xuong.B2_CRUD2Bang.entity.NhanVien;
import com.poly.xuong.B2_CRUD2Bang.repository.ChucVuRepository;
import com.poly.xuong.B2_CRUD2Bang.repository.NhanVienRepository;
import com.poly.xuong.B2_CRUD2Bang.request.NhanVienRequest;
import com.poly.xuong.B2_CRUD2Bang.response.NhanVienResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class NhanVienService {

    private NhanVienRepository repository = new NhanVienRepository();

    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    public List<NhanVienResponse> getAll() {
        List<NhanVien> listNhanVien = repository.getAll();
        return listNhanVien.stream().map(NhanVienResponse::new).collect(Collectors.toList());
    }

    public void removeNhanVien(Integer id) {
        NhanVien nv = repository.getOne(id);
        repository.delete(nv);
    }

    public void addNhanVien(NhanVienRequest request) {
        // can: NhanVien
        // co: NhanVienRequest
        // => convert tu request -> nhanvien
        repository.add(convertNhanVienFromRequest(request));
    }

    @SneakyThrows
    private NhanVien convertNhanVienFromRequest(NhanVienRequest request) {
        NhanVien nv = new NhanVien();
        // code: ten trong request trung vs ten trong entity
        BeanUtils.copyProperties(nv, request);
//        nv.setMa(request.getMa());
        if (request.getChucVuId() != null) {
            ChucVu cv = new ChucVuRepository().getOne(request.getChucVuId());
            nv.setCv(cv);
        }
        return nv;
    }

    public NhanVienResponse detailNhanVien(Integer id) {
        NhanVien nv = repository.getOne(id);
        return new NhanVienResponse(nv);
    }

    @SneakyThrows
    public void updateNhanVien(NhanVienResponse nv) {
        NhanVienRequest request = new NhanVienRequest();
        BeanUtils.copyProperties(request, nv);
        repository.update(convertNhanVienFromRequest(request));
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienService().getAll());
    }
}
