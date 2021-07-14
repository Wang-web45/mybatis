<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2021/7/13
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>mytitle</title>
    <script src="jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
           $("#btn").click(function (){
               $.ajax({
                   url :"oneServlet",
                   type:"get",
                   dataType:"text",
                   aysnc:false,
                   success:function (data) {
                       $("#msg").html(data)

                   }

                   }
               )

               alert("asda")
           })
        })
    </script>
</head>
<body>
<button id="btn">点击</button><br>
<div id="msg" style="color: lightskyblue">
    asdasdasd
<br>
    <br>
    <div style="color: lightskyblue">
        sadasdasd
    </div>
</div>

</body>
</html>
