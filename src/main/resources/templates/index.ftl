<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图片上传</title>
</head>
<body>
<form id="form" enctype="multipart/form-data">
    <input type="file" id="upload" name="file">
    <button type="submit">提交</button>
</form>
<br/>
<img id="testImg" src=""  alt="图片" />

</body>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.1/jquery.form.min.js"></script>
<script>

    /* 文件改变时触发文件上传 */
    $('#upload').change(function(){
        // 设置ajax参数
        var options = {
            url : "/test-demo/uploadImage",
            type: "POST",
            success: function (data) {
                // 设置图片地址
                var imgUrl = "/test-demo/"+data;
                $("#testImg").attr("src", imgUrl);
            }
        }
        // 提交表单
        $('#form').ajaxSubmit(options);
        return false;
    })
</script>
</html>
