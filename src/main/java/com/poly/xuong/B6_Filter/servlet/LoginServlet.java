package com.poly.xuong.B6_Filter.servlet;

import com.poly.xuong.B6_Filter.entity.TaiKhoan;
import com.poly.xuong.B6_Filter.repository.TaiKhoanRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private TaiKhoanRepository repository = new TaiKhoanRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/buoi6/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tren o input
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        // B2: Kiem tra trong CSDL
        TaiKhoan tk = repository.login(uname, pass);
        if (tk == null) {
            // tk va mk sai => Quay tro lai trang dang nhap
            request.setAttribute("mess", "Tai khoan mk k dung");
            request.getRequestDispatcher("/view/buoi6/login.jsp").forward(request, response);
        } else {
            // truong hop thanh cong => quay ve trang /nhan-vien/hien-thi
            HttpSession session = request.getSession();
            session.setAttribute("taiKhoan", tk);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
