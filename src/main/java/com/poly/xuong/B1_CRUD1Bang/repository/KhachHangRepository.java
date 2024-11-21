package com.poly.xuong.B1_CRUD1Bang.repository;

import com.poly.xuong.B1_CRUD1Bang.entity.KhachHang;
import com.poly.xuong.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class KhachHangRepository {

    private Session session;

    public KhachHangRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }
    // TRONG HQL K CO SELECT *

    public List<KhachHang> getAll() {
        return session.createQuery("SELECT kh FROM KhachHang kh").list();
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().getAll());
    }

    public KhachHang getOne(Integer id) {
        return session.find(KhachHang.class, id);
    }

    public List<KhachHang> search() {
        return null;
    }

    public void add(KhachHang kh) {
        try {
            session.getTransaction().begin();
            // thuc hien add
            session.persist(kh);
            // commit day di
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    // saveOrUpdate
    public void update(KhachHang kh) {
        try {
            session.getTransaction().begin();
            // thuc hien update
            session.merge(kh);
            // commit day di
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void remove(KhachHang kh) {
        try {
            session.getTransaction().begin();
            // thuc hien remove
            session.remove(kh);
            // commit day di
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
