layui.use(['element','laypage', 'layer','table','jquery','form'], function(){
    var element = layui.element,
        laypage = layui.laypage,
        layer = layui.layer,
        $=layui.jquery,
        form=layui.form,
        table=layui.table;

    //表单验证
    form.verify({
        username: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
            if (value.length > 12||value.length<2) {
                return '用户名不能小于2位大于12位'
            }
        },
        avatar: function (value, item) {
            if (value.length>50) {
                return '头像路径应该少于50位'
            }
        },
        age: function (value, item) {
            if (value < 0 || value > 200) {
                return '年龄应该在0~200岁之间';
            }
        },
        address: function (value, item) {
            if (value.length>50) {
                return '住址少于50位'
            }
        },
        job: function (value, item) {
            if (value.length>20) {
                return '职业少于20位'
            }
        }
    });

    //监听提交
        form.on('submit(formDemo)', function(data){
            //layer.msg(JSON.stringify(data.field));
            var userJson = data.field;
            updateUser(userJson);
            return false;
        });


    //触发事件
    var active = {
        notice: function(){
            //示范一个公告层
            layer.open({
                type: 1
                ,title: false //不显示标题栏
                ,closeBtn: 1
                ,area: '400px'
                ,shade: 0.8
                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: $('#userForm')
                ,success: function(layero){
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        href: 'http://www.layui.com/'
                        ,target: '_blank'
                    });
                }
            });
        }
    }

    $('#layerDemo .layui-btn').on('click', function(){
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });

    function updateUser(json) {
        $.ajax({
            type: 'put',
            data: json,
            url: '/blog/user/updateUser',
            success:function (data) {
                layer.msg(data.msg + '重新登陆可以查看结果');
            },
            error:function () {
                layer.msg('服务器异常');
            }
        })

    }

});
