<%@ page import="kz.bitlab.javapro.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>BLOG SAMPLE</title>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container">
            <div class="row mt-3">
                <div class="col-6 mx-auto">
                    <%
                        String userError = request.getParameter("usererror");
                        if(userError!=null){
                    %>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Incorrect Email!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    <%
                        }
                    %>
                    <%
                        String passwordError = request.getParameter("passworderror");
                        if(passwordError!=null){
                    %>
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            Incorrect Password!
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    <%
                        }
                    %>
                    <form action="/login" method="post">
                        <div class="row">
                            <div class="col-12">
                                <label>EMAIL : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="email" class="form-control" placeholder="Email : " required name = "email">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>PASSWORD : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="password" class="form-control" placeholder="Password : " required name = "password">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <button class="btn btn-success">SIGN IN</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
