layui.use(['element', 'layer','table','form','laydate'], function(){
    var element = layui.element,
        form = layui.form,
        table = layui.table,
        $ = layui.jquery,
        layer = layui.layer;


    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        saveBlogType(data.field.typeName);
        return false;
    });

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 555
        ,url: '/blog/blog-type/admin/typePage' //数据接口
        ,title: '博客类型表'
        ,page: true //开启分页
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,totalRow: true //开启合计行
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left', totalRowText: '合计：'}
            ,{field: 'typeName', title: '博客类型', width:130, edit: 'text'}
            ,{field: 'createTime', title: '发布时间', width:180, sort: true}
            ,{field: 'updateTime', title: '修改时间', width: 180, sort: true}
            ,{field: 'num', title: '数量', width: 80, sort: true, totalRow: true}
            ,{fixed: 'right', width: 70, align:'center', toolbar: '#barDemo'}
        ]], done: function(res, curr, count){
            $('#total').text(count);
        }
    });

    //监听单元格编辑
    table.on('edit(test)', function(obj){
        var value = obj.value //得到修改后的值
            ,data = obj.data //得到所在行所有键值
            ,field1 = obj.field; //得到字段
        //layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+value);
        var updateJson={'id':data.id, 'typeName': value}
        updateType(updateJson);
    });

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
                    //deleteType(data.id);
                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                deleteType(data.id);
                //向服务端发送删除指令
            });
        }
    });


    function deleteType(id) {
        $.ajax({
            type: 'delete',
            url: '/blog/blog-type/admin/delete/' + id,
            success: function (msg) {
                layer.msg(msg,{icon:1,time:1000,shade:0.5, anim: 1});
            },
            error:function () {
                layer.msg('服务器异常');
            }
        })
    }

    function updateType(json) {
        $.ajax({
            type: 'put',
            url: '/blog/blog-type/admin/update',
            data: json,
            success: function (msg) {
                layer.msg(msg,{icon:1,time:1000,shade:0.5, anim: 1});
            },
            error:function () {
                layer.msg('服务器异常');
            }
        })
    }

    function saveBlogType(typeName) {
        $.ajax({
            type: 'post',
            url: '/blog/blog-type/admin/save/'+typeName,
            success: function (msg) {
                layer.msg(msg,{icon:1,time:1000,shade:0.5, anim: 1});
            },
            error:function () {
                layer.msg('服务器异常');
            }
        })
    }

});
