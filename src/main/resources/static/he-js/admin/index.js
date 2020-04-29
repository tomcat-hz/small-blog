layui.use(['element', 'layer','table','form'], function(){
    var element = layui.element,
        form = layui.form,
        table = layui.table,
        $ = layui.jquery,
        layer = layui.layer;

    //初始化博客列表
    getBlogByParams();

    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        getBlogByParams(data.field);
        return false;
    });

    function getBlogByParams(json) {
    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 555
        ,where:json
        ,url: '/blog/blog/admin/blogPage' //数据接口
        ,title: '博客列表'
        ,page: true //开启分页
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
            ,{field: 'title', title: '标题', width: 110}
            ,{field: 'original', title: '原创', width:80,templet:'<div>{{#if(d.original==1){}}是{{#}else{}}否{{#}}}</div>'}
            ,{field: 'commentable', title: '评论', width: 80,totalRow: true,templet:'<div>{{#if(d.original==1){}}是{{#}else{}}否{{#}}}</div>'}
            ,{field: 'createTime', title: '发布时间', width:170, sort: true}
            ,{field: 'updateTime', title: '修改时间', width: 170, sort: true, totalRow: true}
            ,{field: 'appreciate', title: '赞赏', width:80,templet:'<div>{{#if(d.original==1){}}是{{#}else{}}否{{#}}}</div>'}
            ,{field: 'outline', title: '大纲', width: 100}
            ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
        ]]
    });
};

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除'+data.title+'吗?', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                deleteBlog(data.id);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){
            layer.msg('编辑操作');
        }
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

    //删除博客的方法
    function deleteBlog(id) {
        $.ajax({
            type: 'delete',
            url: '/blog/blog/deleteBlog/' + id,
            success:function (msg) {
                layer.msg(msg);
                setTimeout(function () {
                    layer.closeAll();
                }, 1000);
            },
            error:function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5, anim: 1})
            }
        })

    }



});
