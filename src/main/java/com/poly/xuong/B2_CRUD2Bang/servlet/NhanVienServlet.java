package com.poly.xuong.B2_CRUD2Bang.servlet;

import com.poly.xuong.B2_CRUD2Bang.request.NhanVienRequest;
import com.poly.xuong.B2_CRUD2Bang.response.NhanVienResponse;
import com.poly.xuong.B2_CRUD2Bang.sevice.ChucVuService;
import com.poly.xuong.B2_CRUD2Bang.sevice.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/remove",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/add",
})
public class NhanVienServlet extends HttpServlet {

    private NhanVienService nhanVienService = new NhanVienService();

    private ChucVuService chucVuService = new ChucVuService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
//        if (uri.contains("hien-thi")) {
//            this.hienThiNhanVien(request, response);
//        }else if(uri.contains("remove")){
//            this.removeNhanVien(request,response);
//        }
        // lamda -> k can brean o moi case
        switch (uri) {
            case "/nhan-vien/hien-thi" -> {
                this.hienThiNhanVien(request, response);
            }
            case "/nhan-vien/remove" -> {
                this.removeNhanVien(request, response);
            }
            case "/nhan-vien/detail" -> {
                this.detailNhanVien(request, response);
            }
            default -> {
                // loi 404 
                this.page404(request, response);
            }
        }
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listChucVu", chucVuService.getAll());
        String id = request.getParameter("id");
        request.setAttribute("nv", nhanVienService.detailNhanVien(Integer.valueOf(id)));
        request.getRequestDispatcher("/view/buoi2/update-nhan-vien.jsp").forward(request, response);
    }

    private void page404(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        nhanVienService.removeNhanVien(Integer.valueOf(id));
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listChucVu", chucVuService.getAll());
        request.setAttribute("listNhanVien", nhanVienService.getAll());
        request.getRequestDispatcher("/view/buoi2/nhan-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/nhan-vien/add" -> {
                this.addNhanVien(request, response);
            }
            case "/nhan-vien/update" -> {
                this.updateNhanVien(request, response);
            }
            default -> {
                this.page404(request, response);
            }
        }
    }

    @SneakyThrows
    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        NhanVienResponse nvResponse = nhanVienService.detailNhanVien(Integer.valueOf(id));
        BeanUtils.populate(nvResponse, request.getParameterMap());
        nhanVienService.updateNhanVien(nvResponse);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    @SneakyThrows
    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) {
        NhanVienRequest nvRequest = new NhanVienRequest();
        BeanUtils.populate(nvRequest, request.getParameterMap());
        nhanVienService.addNhanVien(nvRequest);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
