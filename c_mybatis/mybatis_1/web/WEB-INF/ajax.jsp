<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2021/7/16
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        $(function (){
            $("#btn").click(function (){
                $.ajax({
                    url:oneService,
                    type:get,     /*请求方式*/
                    data:"json",  /*请求参数*/
                    dataType:"json", /*q请求参数类型*/
                    sync:false,   /*同步或者异步*/
                    success:function (data){
                        }

                })
            })
        })
    </script>
</head>
<body>

</body>
</html>
