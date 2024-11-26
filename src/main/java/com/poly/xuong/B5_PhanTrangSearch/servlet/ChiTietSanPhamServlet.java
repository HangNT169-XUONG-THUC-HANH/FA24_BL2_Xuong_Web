package com.poly.xuong.B5_PhanTrangSearch.servlet;

import com.poly.xuong.B5_PhanTrangSearch.service.ChiTietSanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ChiTietSanPhamServlet", value = "/ctsp/hien-thi")
public class ChiTietSanPhamServlet extends HttpServlet {

    private ChiTietSanPhamService service = new ChiTietSanPhamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = 5;
        // 6: 36/5 = 7.2 => 8
        // Hien thi duoc so luong trang can thiet
        int totalPages = service.totalPage(pageSize);
        request.setAttribute("totalPages", totalPages);
        // Lay ra pageNo
        int pageNo = 1;
        // lan dau tien chay => k co pageNo
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            pageNo = Integer.valueOf(pageParam);
        }
        // Lay ra list cua pageNo hien tai dang chon
        request.setAttribute("lists", service.phanTrang(pageNo, pageSize));
        request.getRequestDispatcher("/view/buoi5/ctsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
