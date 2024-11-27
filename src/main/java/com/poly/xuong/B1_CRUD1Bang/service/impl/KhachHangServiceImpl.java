package com.poly.xuong.B1_CRUD1Bang.service.impl;

import com.poly.xuong.B1_CRUD1Bang.entity.KhachHang;
import com.poly.xuong.B1_CRUD1Bang.service.ICommonService;
import com.poly.xuong.B1_CRUD1Bang.service.KhachHangService;

import java.util.List;

public class KhachHangServiceImpl implements ICommonService<KhachHang, String>, KhachHangService {
    @Override
    public List<KhachHang> getAll() {
        return null;
    }

    @Override
    public KhachHang getOne(String id) {
        return null;
    }

    @Override
    public void add(KhachHang object) {

    }

    @Override
    public void update(KhachHang object) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<KhachHang> search() {
        return null;
    }

//    private KhachHangRepository khachHangRepository = new KhachHangRepository();
//
//    @Override
//    public List<KhachHang> getAll() {
//        return khachHangRepository.getAll();
//    }
//
//    @Override
//    public KhachHang getOne(String id) {
//        return null;
//    }
//
//    @Override
//    public void add(KhachHang object) {
//        // validate ?
//        khachHangRepository.add(object);
//    }
//
//    @Override
//    public void update(KhachHang object) {
//
//    }
//
//    @Override
//    public void delete(Integer id) {
//        khachHangRepository.remove(khachHangRepository.getOne(id));
//    }
//
//    @Override
//    public List<KhachHang> search() {
//        return null;
//    }
}
