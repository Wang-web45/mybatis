<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2021/7/14
  Time: 9:50
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
    <title>Title</title>
    <script src="jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                alert("ss")
                $.ajax({
                    url:"oneServlet",
                    type:"get",
                    dataType:"text",
                    async:false,
                    success:function (data){
                        $("#msg").html(data)
                    }
                })
                /*$.ajax({
                    url:"oneServlet",
                    type:"get",
                    dataType:"text",
                    async:false,
                    success:function (data){
                        $("msg").html(data)
                    }
                })*/
            })
        })
    </script>
</head>
<body>
<button id="btn">点击按钮</button>
<div id="msg" style="color: red">
    我是菜鸟
</div>

</body>
</html>
