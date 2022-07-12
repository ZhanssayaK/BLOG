<%@ page import="kz.bitlab.javapro.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.javapro.model.Blog" %>
<%@ page import="kz.bitlab.javapro.model.Comment" %>
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
                        Blog blog = (Blog) request.getAttribute("blog");
                        if(blog!=null){
                    %>
                        <div class="row mt-3">
                            <div class="col-10 mx-auto px-4 pt-2" style="background-color: rgba(221,233,253,0.85); color: darkblue;">
                                <h3><%=blog.getTitle()%></h3>
                                <p>
                                    <%=blog.getContent()%>
                                </p>
                                <p class="mt-2">
                                    Posted by <strong><%=blog.getUser().getFullName()%></strong> at
                                    <strong><%=blog.getPostDate()%></strong>
                                </p>
                                <%
                                    if(currentUser!=null){
                                %>
                                    <form action="/addcomment" method="post">
                                        <input type="hidden" name="blog_id" value="<%=blog.getId()%>">
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <textarea class="form-control" name="comment"></textarea>
                                            </div>
                                        </div>
                                        <div class="row mt-2">
                                            <div class="col-12">
                                                <button class="btn btn-success btn-sm">ADD COMMENT</button>
                                            </div>
                                        </div>
                                    </form>
                                <%
                                    }
                                %>
                                <div class="row mt-3 mb-3">
                                    <div class="col-12">
                                        <div class="list-group">
                                            <%
                                                ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                                                if(comments!=null){
                                                    for(Comment comment : comments){
                                            %>
                                                <a href="JavaScript:void(0)" class="list-group-item list-group-item-action">
                                                    <div class="d-flex w-100 justify-content-between">
                                                        <h5 class="mb-1">
                                                            <%=comment.getUser().getFullName()%>
                                                        </h5>
                                                        <small><%=comment.getPostDate()%></small>
                                                    </div>
                                                    <p class="mb-1">
                                                        <%=comment.getComment()%>
                                                    </p>
                                                </a>
                                            <%
                                                    }
                                                }
                                            %>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
