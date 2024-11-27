package com.poly.xuong.B6_Filter.filter;

import com.poly.xuong.B6_Filter.entity.TaiKhoan;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// DAY LA FILE MOI LAN CHAY PROJECT BAT CU DUONG LINK NAO THI SE CHAY FILE DAU TIEN
@WebFilter(filterName = "AuthFilter", value = {
        // DUONG DAN CAN PHAI CHECK LOGIN
        "/nhan-vien/*",
        "/ctsp/*",
})
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // KHOI TAO 1 LAN DUY NHAT => chay dau tien
    }

    public void destroy() {
        // don dep tai nguyen khi chay filter => 1 lan duy nhat => chay cuoi cung
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // chain.doFilter(request, response);
        // Check dang nhap hoac chua dang nhap
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        TaiKhoan tk = (TaiKhoan) session.getAttribute("taiKhoan");
        if (tk == null) {
            // chua dang nhap => quay ve trang /login
            res.sendRedirect("/login");
        } else {
            // dang nhap roi
            // author => phan quyen
            // role 1 => truy cap tat ca duong dan dan
            // role 2 => /nhan-vien/*
//            chain.doFilter(request, response);
            if (tk.getRole() == 1) {
                chain.doFilter(request, response);
            } else {
                String uri = req.getRequestURI();
                if (uri.startsWith("/nhan-vien/")) {
                    chain.doFilter(request, response);
                } else {
                    // tai khoan k duoc phep truy cap
                    res.sendRedirect("/view/buoi6/403page.jsp");
                }
            }
        }
    }
}
