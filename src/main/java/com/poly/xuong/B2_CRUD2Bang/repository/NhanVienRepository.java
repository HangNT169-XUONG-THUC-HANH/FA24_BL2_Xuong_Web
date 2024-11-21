package com.poly.xuong.B2_CRUD2Bang.repository;

import com.poly.xuong.B2_CRUD2Bang.entity.NhanVien;
import com.poly.xuong.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class NhanVienRepository {
    private Session session;

    public NhanVienRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<NhanVien> getAll() {
        return session.createQuery("From NhanVien ").list();
    }

    public NhanVien getOne(Integer id) {
        return session.find(NhanVien.class, id);
    }

    public void add(NhanVien nhanVien) {
        try {
            session.getTransaction().begin();
            session.persist(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace(System.out);
        }
    }

    public void update(NhanVien nhanVien) {
        try {
            session.getTransaction().begin();
            session.merge(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace(System.out);
        }
    }

    public void delete(NhanVien nhanVien) {
        try {
            session.getTransaction().begin();
            session.delete(nhanVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace(System.out);
        }
    }
}
