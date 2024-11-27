package com.poly.xuong.util;

import com.poly.xuong.B1_CRUD1Bang.entity.KhachHang;
import com.poly.xuong.B2_CRUD2Bang.entity.ChucVu;
import com.poly.xuong.B2_CRUD2Bang.entity.NhanVien;
import com.poly.xuong.B5_PhanTrangSearch.entity.ChiTietSP;
import com.poly.xuong.B5_PhanTrangSearch.entity.DongSP;
import com.poly.xuong.B5_PhanTrangSearch.entity.MauSac;
import com.poly.xuong.B5_PhanTrangSearch.entity.Nsx;
import com.poly.xuong.B5_PhanTrangSearch.entity.SanPham;
import com.poly.xuong.B6_Filter.entity.TaiKhoan;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2016Dialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=XUONG_LEVEL1_WEB;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "Password.1");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        Class<?>[] annotatedClasses = {
                KhachHang.class,
                ChucVu.class,
                NhanVien.class,
                ChiTietSP.class,
                SanPham.class,
                MauSac.class,
                DongSP.class,
                Nsx.class,
                TaiKhoan.class
        };

        // Thêm tất cả các lớp trong mảng vào Configuration
        for (Class<?> annotatedClass : annotatedClasses) {
            conf.addAnnotatedClass(annotatedClass);
        }
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
