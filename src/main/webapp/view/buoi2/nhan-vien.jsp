<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Spring security
WebFilter--%>
<p>Xin chao ${sessionScope.taiKhoan.username}</p>
<form action="/nhan-vien/add" method="post">
    Ma: <input type="text" name="ma"/>
    <br/>
    Ho: <input type="text" name="ho"/>
    <br/>
    Ten dem: <input type="text" name="tenDem"/>
    <br/>
    Ten: <input type="text" name="ten"/>
    <br/>
    SDT: <input type="text" name="sdt"/>
    <br/>
    Dia chi: <input type="text" name="diaChi"/>
    <br/>
    Gioi tinh: <input type="radio" name="gioiTinh" value="Nam" checked/> Nam
    <input type="radio" name="gioiTinh" value="Nữ"/>Nu
    <br/>
    Ten chuc vu:
    <select name="chucVuId">
        <c:forEach items="${listChucVu}" var="cv">
            <option value="${cv.id}">${cv.ten}</option>
        </c:forEach>
    </select>
    <br/>
    <button type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ và tên</th>
        <th>Địa chỉ</th>
        <th>Tên chức vụ</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="nv" varStatus="i">
        <tr>
            <td>${i.index}</td>
                <%-- getHoVaTen => getter
                hoVaTen: nhu 1 ten bien --%>
            <td>${nv.hoVaTen} </td>
            <td>${nv.getDiaChi()}</td>
            <td>${nv.tenChucVu}</td>
            <td>
                <a href="/nhan-vien/remove?id=${nv.id}">Delete</a>
                <a href="/nhan-vien/detail?id=${nv.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
