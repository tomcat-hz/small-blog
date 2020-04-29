layui.use(['element','form','layer','jquery'], function(){
    var element = layui.element;
    var form = layui.form;
    var layer = layui.layer;
    var $ = layui.jquery;

    var code=null;

    //表单验证
    form.verify({
      password: [
                /^^[A-Za-z0-9]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
    });

    //监听提交
    form.on('submit(formDemo)', function(data){
        //登陆
        if (!b) {
            //layer.msg(JSON.stringify(data.field));
            //登陆地方法
            login(data.field);
        }
        return false;
    });

    form.on('submit(formDemo1)', function (data) {
        if (code == null) {
            layer.msg('请先获得验证码,谢谢', {icon: 2, time: 1300, shade: 0.5, anim: 1});
        } else if (code == $('#code').val()) {
            var userJson = data.field;
            register(userJson);
        }
        //console.log(JSON.stringify(data.field) + code);
        //$('#code').val();
        //console.log($('#code').val())
        return false;
    });


    //判断是否填写成功验证码
    var b = true;

    //登陆时没填没填
    $('#login').click(function () {
        if (b) {
        layer.msg('请完成验证码验证!',{icon:2,time:1000,shade:0.5,anim:1})
        }
    })
    //发送邮件点击事件
    $('#send_email').click(function () {
        $(this).attr('disabled', 'disabled');
        countDown();
        var emailReg=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
        if (emailReg.test($('#email').val())) {
            sendEmail($('#email').val());
        }
    });

    jigsaw.init({
        el: document.getElementById('qrcode'),
        width: 310, // 可选, 默认310
        height: 155, // 可选, 默认155
        onSuccess: function () { layer.msg('验证成功',{icon:1,time:1000,shade:0.5,anim:1})
            //首先提交按钮是无法点击的只有当验证码通过才能点击
            $('#login').removeAttr('disabled');
            b = false;
        },
        onFail: function () { layer.msg('验证失败',{icon:2,time:1000,shade:0.5,anim:1})},
        onRefresh: function () {  }
    });

        //切换登陆注册面板
    $('#login-pane').click(function () {
       $(this).attr({'style':'font-weight:bold'})
        $('#register-pane').attr({'style':'font-weight:normal'})
        $('#login-form').show();
        $('#register-form').hide();
    });
    $('#register-pane').click(function () {
        $(this).attr({'style':'font-weight:bold'})
        $('#login-pane').attr({'style':'font-weight:normal'})
        $('#login-form').hide();
        $('#register-form').show();
    })



    function register(json) {
        $.ajax({
            type: 'post',
            data: json,
            url: '/register',
            success: function (data) {
                layer.msg(data.msg);
                if (data.msg == '注册成功') {
                    setTimeout(function () {
                        $('#login-pane').attr({'style': 'font-weight:bold'});
                        $('#register-pane').attr({'style': 'font-weight:normal'});
                        $('#login-form').show();
                        $('#register-form').hide();
                    },1000)

                }
            },
            error:function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5, anim: 1})
            }
        })
    }

    function login(json) {
        $.ajax({
            type: 'post',
            url: '/user/login',
            data: json,
            success:function (data) {
                if (data.data != null) {
                    $('#user').show();
                    layer.msg(data.msg,{icon:1,time:1000,shade:0.5, anim: 1})
                    setTimeout(function (args) { location.href="/" }, 1000);
                } else {
                    layer.msg(data.msg,{icon:2,time:1000,shade:0.5, anim: 1})
                }
            },
            error: function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5, anim: 1})
            }
        })
    }

    function sendEmail(email) {
        $.ajax({
            type: 'get',
            url: '/sendEmail',
            data: {'email': email},
            success:function (data) {
                code=data.msg
            },
            error: function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5, anim: 1})
            }
        })
    }

    var i = 60;
    function countDown() {
        i = i - 1;
        $("#send_email").html(i+"秒后重新发送");
        if (i == 0) {
            $("#send_email").removeAttr("disabled");
            $("#send_email").html("重新发送");
            i = 60;
            return;
        }
        setTimeout(function (args) { countDown() },1000);
    }

});

