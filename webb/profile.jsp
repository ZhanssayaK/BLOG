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
                <div class="col-12">
                    <h1 class="text-center">
                        HELLO
                        <%
                            if(currentUser!=null){
                                out.print(currentUser.getFullName());
                            }
                        %>
                    </h1>
                </div>
            </div>
        </div>
    </body>
</html>
