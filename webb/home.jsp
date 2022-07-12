<%@ page import="kz.bitlab.javapro.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.javapro.model.Blog" %>
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
                    <%
                        ArrayList<Blog> blogs = (ArrayList<Blog>) request.getAttribute("blogs");
                        if(blogs!=null){
                            for(Blog b : blogs){
                    %>
                        <div class="row mt-3">
                            <div class="col-10 mx-auto px-4 pt-2" style="background-color: rgba(221,233,253,0.85); color: darkblue;">
                                <h4>
                                    <a href="/readblog?id=<%=b.getId()%>" class="text-decoration-none text-black">
                                        <%=b.getTitle()%>
                                    </a>
                                </h4>
                                <p class="mt-2">
                                    Posted by <strong><%=b.getUser().getFullName()%></strong> at
                                    <strong><%=b.getPostDate()%></strong>
                                </p>
                            </div>
                        </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
