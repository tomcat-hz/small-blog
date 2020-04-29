layui.use(['element','form','upload'], function(){
    var element = layui.element,
        form=layui.form;
    var upload = layui.upload;

    var avatarPath = null;

    //执行实例
    var uploadInst = upload.render({
        elem: '#test1', //绑定元素
        field:'file'
        ,size:0
        ,url: '/upload' //上传接口
        ,done: function(res){
            //上传完毕回调
            //console.log(res);
            layer.msg('图片上传成功');
            $('#test1').html('<i class="layui-icon">&#xe605;</i>上传成功')
            avatarPath = res.newFileName;
        }
        ,error: function(){
            //请求异常回调
        }
    });


    //监听提交
    form.on('submit(formDemo)', function (data) {
        data = data.field;
        if (data['original'] == 'on') {
            data['original'] = 1;
        } else {
            data['original'] = 0;
        }
        if (data['commentable'] == 'on') {
            data['commentable'] = 1;
        } else {
            data['commentable'] = 0;
        }
        if (data['appreciate'] == 'on') {
            data['appreciate'] = 1;
        } else {
            data['appreciate'] = 0;
        }
        data['avatar'] = avatarPath;
        //console.log(JSON.stringify(data));
        saveBlog(data);
        return false;
    });

    getAllType();

    function getAllType() {
        $.ajax({
            type: 'get',
            url: '/blog/blog-type/admin/getAllType',
            success: function (data) {
                console.log(data);
                var types = data.data;
                var str = '<option value=""></option>';
                $.each(types, function (i, e) {
                    str+='<option value="'+e.id+'">'+e.typeName+'</option>'
                });
                $('#blog-type').html(str);
                form.render('select');
            },
            error:function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5, anim: 1})
            }
        })
    };


    //保存博客
    function saveBlog(json) {
        $.ajax({
            type: 'post',
            url: '/blog/blog/admin/saveBlog',
            data: json,
            success: function (data) {
                layer.msg(data.msg);
            },
            error:function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5, anim: 1})

            }
        })
    }





});

