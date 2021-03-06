<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<script>
    var result = '${result}';

    if(result == 'SUCCESS') {
        alert("처리가 완료되었습니다.");
    }

</script>
<body>
<%@include file="/include/header.jsp" %>

    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">HOME PAGE</h3>
                    </div>
                </div>
            </div>
        <div>

        <table class="table table-bordered">
            <tr>
                <th style="width: 10px">BNO</th>
                <th>TITLE</th>
                <th>WRITER</th>
                <th>REGDATE</th>
                <th style="width: 40px">VIEWCNT</th>
            </tr>


            <c:forEach items="${list}" var="boardVO">

                <tr>
                    <td>${boardVO.bno}</td>
                    <td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</td>
                    <td>${boardVO.writer}</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
                        value="${boardVO.regdate}"/></td>
                    <td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
            </c:forEach>

        </table>
    </section>
<%@include file="/include/footer.jsp" %>
</body>
</html>



