package com.poly.xuong.B5_PhanTrangSearch.repository;

import com.poly.xuong.B5_PhanTrangSearch.entity.ChiTietSP;
import com.poly.xuong.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ChiTietSanPhamRepository {

    private Session s;

    public ChiTietSanPhamRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    // HQL => createQuery
    // pageNo : so trang
    public List<ChiTietSP> phanTrangSQL(int pageNo, int pageSize) {
        // B1: Tao cau sql
        String sql = "SELECT * FROM ChiTietSP\n" +
                "ORDER BY id \n" +
                "OFFSET ?1 ROW  \n" +
                "FETCH NEXT ?2 ROWS ONLY";
        // B2: Tao query: SQL => createNativeQuery
        Query query = s.createNativeQuery(sql, ChiTietSP.class);
        // B3: Set value cho dau ?
        query.setParameter(1, (pageNo - 1) * pageSize);
        query.setParameter(2, pageSize);
        return query.getResultList();
    }

    public List<ChiTietSP> phanTrangHQl(int pageNo, int pageSize) {
        String hql = "SELECT ctsp FROM ChiTietSP ctsp ORDER BY ctsp.id";
        Query query = s.createQuery("FROM ChiTietSP");
        // set value
        query.setFirstResult((pageNo - 1) * pageSize); // Tuong ung offset
        query.setMaxResults(pageSize); // Tuong ung fetch next - pagesize
        return query.getResultList();
    }

    // Tra ve tong so luong phan tu trong 1 trang
    public List<ChiTietSP> getAll() {
        return s.createQuery("FROM ChiTietSP ").list();
    }

    public static void main(String[] args) {
//        System.out.println(new ChiTietSanPhamRepository().phanTrangSQL(0,5));
        new ChiTietSanPhamRepository().phanTrangHQl(2, 5).forEach(s -> System.out.println(s));
    }
}
