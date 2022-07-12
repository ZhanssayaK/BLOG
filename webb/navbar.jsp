<%
  User currentUser = (User) request.getAttribute("currentUser");
%>
<div class="container">
  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgba(35,67,105,0.85)">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">ELECTRONIC-SHOP</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <%
            if(currentUser!=null){
          %>
            <li class="nav-item">
              <a class="nav-link" href="/profile"><%=currentUser.getFullName()%></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/addblog">Add Blog</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/logout">Logout</a>
            </li>
          <%
            }else{
          %>
            <li class="nav-item">
              <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/register">Sign Up</a>
            </li>
          <%
            }
          %>
        </ul>
      </div>
    </div>
  </nav>
</div>