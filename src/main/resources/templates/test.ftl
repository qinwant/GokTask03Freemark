<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>简历信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/layui/css/layui.css"  media="all">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>

</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>简历个人信息</legend>
</fieldset>

<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="RsName" lay-verify="RsName" autocomplete="off" placeholder="请输入姓名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生日</label>
        <div class="layui-input-inline">
            <input type="text" name="RsBirthday" id="RsBirthday" lay-verify="date" placeholder="年月日" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">籍贯</label>
        <div class="layui-input-inline">
            <input type="text" name="RsNative" lay-verify="RsNative" autocomplete="off" placeholder="请输入籍贯" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学历</label>
        <div class="layui-input-inline">
            <select name="RsEducation" lay-filter="RsEducation">
                <option value=""></option>
                <option value="小学">小学</option>
                <option value="初中">初中</option>
                <option value="高中">高中</option>
                <option value="大专">大专</option>
                <option value="本科">本科</option>
                <option value="硕士">硕士</option>
                <option value="博士">博士</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-inline">
                <input type="tel" name="RsTelephone" lay-verify="required|phone" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="RsMail" lay-verify="email" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
            <input type="text" name="RsAddress" lay-verify="RsAddress" autocomplete="off" placeholder="请输入地址" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">头像信息</label>
        <div class="layui-input-inline">
            <input type="text" name="RsPicUrl" lay-verify="RsPicUrl" autocomplete="off" placeholder="http/https开头" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">应聘职位</label>
        <div class="layui-input-inline">
            <select name="RsPosition" lay-verify="required" lay-search="">
                <option value="">直接选择或搜索选择</option>
                <option value="java实习生">java实习生</option>
                <option value="java初级工程师">java初级工程师</option>
                <option value="java高级工程师">java高级工程师</option>
                <option value="c++游戏开发">c++游戏开发</option>
                <option value="python分析师">python分析师</option>
                <option value="图像算法工程师">图像算法工程师</option>
                <option value="网络工程师">网络工程师</option>
                <option value="大数据工程师">大数据工程师</option>
                <option value="安卓开发">安卓开发</option>
                <option value="小程序开发">小程序开发</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">个人技能</label>
        <div class="layui-input-block">
            <input type="checkbox" name="RsSkills" value="英语四级" title="英语四级">
            <input type="checkbox" name="RsSkills" value="英语六级" title="英语六级" checked="">
            <input type="checkbox" name="RsSkills" value="计算机二级" title="计算机二级">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">自我评价</label>
        <div class="layui-input-block">
            <textarea name="rsSelfEvaluation" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>



<script src="https://www.layuicdn.com/layui-v2.5.7/layui.js" charset="utf-8"></script>
<#--<script src="../static/layui/layui.js" charset="utf-8"></script>-->
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#RsBirthday'
        });
        laydate.render({
            elem: '#date1'
        });


        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });


        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            $.ajax({
                type: 'post',
                url: 'createResume',
                data: data.field,
                dataType:"text",
                success: function(returnData){
                    if(returnData.code==1){

                    }
                }
            })

            return false;
        });

        //表单取值
        layui.$('#LAY-component-form-getval').on('click', function(){
            var data = form.val('example');
            alert(JSON.stringify(data));
        });

    });
</script>

</body>
</html>
