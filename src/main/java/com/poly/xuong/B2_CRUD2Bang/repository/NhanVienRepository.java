package com.poly.xuong.B2_CRUD2Bang.repository;

import com.poly.xuong.B2_CRUD2Bang.entity.NhanVien;
import com.poly.xuong.util.HibernateUtil;
import jakarta.persistence.Query;
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

    // Tim kiem nang cao: 1 o input tim kiem theo nhieu truong, tim kiem bao gom ca combobox va radio..
    // 1 o input => chua ma, ten
    // 1 o combobo trang thai/radio...
    public List<NhanVien> search(String keywork, Integer trangThai) {
        // B1: Viet cau lenh HQl
        String hql = "SELECT nv FROM NhanVien nv WHERE 1=1 ";
        // Check xem lan luot tung dieu kien co khong
        // Neu co trang thai
        if (trangThai != null) {
            hql += " AND nv.trangThai =:tt";
        }
        if (keywork != null) {
            hql += " AND ( nv.ma LIKE :kw OR nv.ten LIKE :kw )";
        }
        // B2: Tao quey
        Query query = session.createQuery(hql);
        // B3: Set gia tri cho tham gia
        if (trangThai != null) {
            query.setParameter("tt", trangThai);
        }
        if (keywork != null) {
            query.setParameter("kw", "%" + keywork + "%");
        }
        return query.getResultList();
    }

    public static void main(String[] args) {
        new NhanVienRepository().search("n", 1).forEach(s -> System.out.println(s));
    }
}
