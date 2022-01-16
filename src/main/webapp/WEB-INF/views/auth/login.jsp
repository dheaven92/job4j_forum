<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="../header.jsp" />
<body>
<div class="container">
   <div class="row pt-5">
      <div class="card" style="width: 100%">
         <div class="card-header">
            Войти
         </div>
         <div class="card-body">
            <c:if test="${not empty errorMessage}">
               <div class="row pt-3">
                  <div class="alert alert-danger">
                        ${errorMessage}
                  </div>
               </div>
            </c:if>
            <form action="<c:url value='/login'/>" method='POST'>
               <div class="form-group">
                  <label>Логин:</label>
                  <input type='text' name='username' class="form-control" required>
               </div>
               <div class="form-group">
                  <label>Пароль:</label>
                  <input type='password' name='password' class="form-control" required>
               </div>
               <button type="submit" class="btn btn-primary">Войти</button>
            </form>
         </div>
         <div class="card-footer">
            <a href="<c:url value='/register'/>">Регистрация</a>
         </div>
      </div>
   </div>
</div>
</body>
</html>
