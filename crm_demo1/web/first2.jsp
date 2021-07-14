<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2021/7/14
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.8.3.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:"oneServlet",
                    type:"get",
                    dataType:"text",
                    aysnc: false,
                    success:function (data){
                        $("#msg").html(data)
                    }
                })
            })
        })
    </script>
</head>
<body>
<button id="btn" >按一下</button>
<div id="msg" style="color: aqua">哈哈哈哈哈</div>

</body>
</html>
