package com.poly.xuong.B2_CRUD2Bang.repository;

import com.poly.xuong.B2_CRUD2Bang.entity.ChucVu;
import com.poly.xuong.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ChucVuRepository {
    private Session session;
    // dto: data tranfer object: chuyen doi du lieu Object
    // entity (Object)
    // CHUYEN DOI DATA: TAO CLASS CO CAC DU LIEU PHU HOP THEO MONG MUON
    // DUA VAO OBJECT TRONG ENTITY
    // request & response
    // request: yeu cau nguoi dung
    // response: du lieu tra ra
    // Load : Ma nhan vien,ho, ten, tendem, dia chi,ten chuc vu
    public ChucVuRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<ChucVu> getAll() {
        return session.createQuery("From ChucVu ").list();
    }

    public ChucVu getOne(Integer id) {
        return session.find(ChucVu.class, id);
    }

    public void add(ChucVu chucVu) {
        try {
            session.getTransaction().begin();
            session.persist(chucVu);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace(System.out);
        }
    }

    public void update(ChucVu chucVu) {
        try {
            session.getTransaction().begin();
            session.merge(chucVu);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace(System.out);
        }
    }

    public void delete(ChucVu chucVu) {
        try {
            session.getTransaction().begin();
            session.delete(chucVu);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace(System.out);
        }
    }

}
