package com.poly.xuong.B6_Filter.repository;

import com.poly.xuong.B6_Filter.entity.TaiKhoan;
import com.poly.xuong.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

public class TaiKhoanRepository {

    private Session s;

    public TaiKhoanRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public TaiKhoan login(String username, String password) {
        TaiKhoan tk = null;
        try {
            // B1: Tao query
            String hql = "SELECT tk FROM TaiKhoan tk WHERE tk.username = ?1 AND tk.password = ?2";
            // B2: Tao query
            Query query = s.createQuery(hql);
            //B3: Set gia tri cho ?
            query.setParameter(1, username);
            query.setParameter(2, password);
            tk = (TaiKhoan) query.getSingleResult(); // getSingleResult => tra ve 1 doi tuong, getResultList => tra ve ds
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tk;
    }

    public static void main(String[] args) {
        System.out.println(new TaiKhoanRepository().login("hangnt169", "123456"));
    }
}
