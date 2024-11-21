package com.poly.xuong.B1_CRUD1Bang.repository;

import com.poly.xuong.B1_CRUD1Bang.entity.ChucVu1;
import com.poly.xuong.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ChucVuRepository {
    // CODE CRUD
    private Session session;

    public ChucVuRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }
    // TRONG HQL K CO SELECT *

    public List<ChucVu1> getAll() {
        return null;
    }

    public ChucVu1 getOne(Integer id) {
        return null;
    }

    public void add(ChucVu1 cv) {

    }

    public void sort() {

    }

    public void update(ChucVu1 cv) {

    }

    public void delete(ChucVu1 cv) {

    }
}
