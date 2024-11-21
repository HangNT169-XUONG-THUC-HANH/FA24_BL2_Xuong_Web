package com.poly.xuong.B1_CRUD1Bang.servlet;

import com.poly.xuong.B1_CRUD1Bang.service.KhachHangService;
import com.poly.xuong.B1_CRUD1Bang.service.impl.KhachHangServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = "/KhachHangServlet")
public class KhachHangServlet extends HttpServlet {
    // Khong goi tu repo
//    ArrayList: interface = new class
    private KhachHangService khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
