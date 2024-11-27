package com.poly.xuong.B1_CRUD1Bang.service;

import java.util.List;

// ICOMMON : INTERFACE CHUA CAC HAM CHUNG
//T,K: T: Object
// K: kieu du lieu cua khoa chinh
public interface ICommonService<T,K> {
    // cac ham chung CRUD , chi khac nhau Thuc the truy van
    List<T> getAll();

    T getOne(K id);

    void add(T object);

    void update(T object);

    void delete(K id);

}
