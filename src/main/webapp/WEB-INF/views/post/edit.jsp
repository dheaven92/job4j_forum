<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="../header.jsp" />
<body>
<jsp:include page="../navbar.jsp" />
<div class="container">
    <div class="row pt-3">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <c:if test="${empty post}">Создать тему</c:if>
                <c:if test="${not empty post}">Редактировать тему</c:if>
            </div>
            <div class="card-body">
                <form action="<c:url value='/post/save'/>" method='POST'>
                    <div class="form-group">
                        <label>Название:</label>
                        <input
                                type='text'
                                name='name'
                                class="form-control"
                                required
                                value="<c:if test="${not empty post}"><c:out value="${post.name}"/></c:if>"
                        >
                    </div>
                    <div class="form-group">
                        <label>Описание:</label>
                        <textarea
                                name="description"
                                class="form-control"
                                required
                        ><c:if test="${not empty post}"><c:out value="${post.description}"/></c:if></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
