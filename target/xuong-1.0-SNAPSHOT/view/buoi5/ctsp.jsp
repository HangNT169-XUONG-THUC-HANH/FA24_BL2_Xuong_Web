<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 26/11/24
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--    Table--%>
    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Ten mau sac</th>
                <th>Ten dong san pham</th>
                <th>Ten nsx</th>
                <th>Nam bao hanh</th>
                <th>Mo ta</th>
                <th>So luong ton</th>
                <th>Gia nhap</th>
                <th>Gia ban</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lists}" var="ctsp" varStatus="i">
                <tr>
                    <td>${i.index}</td>
                    <td>${ctsp.id}</td>
                    <td>${ctsp.tenMauSac}</td>
                    <td>${ctsp.tenDongSanPham}</td>
                    <td>${ctsp.tenNSX}</td>
                    <td>${ctsp.namBaoHanh}</td>
                    <td>${ctsp.moTa}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaBan}</td>
                    <td>${ctsp.giaNhap}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <%--    Phan trang--%>
    <c:forEach var="i" begin="1" end="${totalPages}">
        <a href="/ctsp/hien-thi?page=${i}">${i}</a>
    </c:forEach>
</div>
</body>
</html>
