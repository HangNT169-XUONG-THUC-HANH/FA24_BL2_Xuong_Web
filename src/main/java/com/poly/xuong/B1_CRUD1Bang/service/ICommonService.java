package com.poly.xuong.B1_CRUD1Bang.service;

import java.util.List;

// ICOMMON : INTERFACE CHUA CAC HAM CHUNG
public interface ICommonService<T> {
    // cac ham chung CRUD , chi khac nhau Thuc the truy van
    List<T> getAll();

    T getOne(Integer id);

    void add(T object);

    void update(T object);

    void delete(Integer id);

}
