<%@ page import="kz.bitlab.javapro.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>BLOG SAMPLE</title>
        <%@include file="head.jsp"%>
        <script src="/js/tinymce/tinymce.min.js"></script>
        <script>tinymce.init({selector:'textarea'});</script>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container">
            <div class="row mt-3">
                <div class="col-10 mx-auto">
                    <form action="/addblog" method="post">
                        <div class="row">
                            <div class="col-12">
                                <label>TITLE : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <input type="text" class="form-control" name="title">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <label>CONTENT : </label>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <textarea name="content"></textarea>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-12">
                                <button class="btn btn-success">ADD BLOG</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
