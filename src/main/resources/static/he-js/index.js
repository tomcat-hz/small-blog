layui.use(['element','laypage', 'layer'], function(){
    var element = layui.element,
        laypage = layui.laypage,
        $ = layui.jquery,
        layer = layui.layer;
    var title='';


    $('#search').click(function () {
        title = $('#title').val();
        getCount(title);
        otherBlogPage(1, title);
    });


    $('#baidu').blur(function () {
        var keyword=$(this).val();
        if ($(this).val()!='') {
            $.ajax({
                type: 'get',
                url: '/baidu',
                data:{'keyword': keyword},
                success:function (msg) {
                    $('#content').text(msg)
                }
            })
        }
    })

    $('#translate').blur(function () {
        var keyword=$(this).val();
        if ($(this).val()!='') {
            $.ajax({
                type: 'get',
                url: '/translate',
                data:{'keyword': keyword},
                success:function (msg) {
                    $('#content1').text(msg)
                }
            })
        }
    })

    if ($('#msg').text() != null && $('#msg').text() != '') {
        var msg = $('#msg').text();
        layer.msg(msg, {icon: 2, time: 1000, shade: 0.5, anim: 1});
    }

    function otherBlogPage(page,title) {
        $.ajax({
            type: 'get',
            url: '/pageBlog',
            data:{'page':page, 'title': title},
            success: function (data) {
                $('#total').text(data.count)
                //console.log(data);
                data = data.data;
                var str = '';
                $.each(data,function (i, e) {
                    str+='<div>\n' +
                        '                                    <div class="layui-row">\n' +
                        '                                       <a href="/blog/blog/content/'+e.id+'" target="_blank"><div class="title layui-col-md-offset4">\n' +
                        '                                            '+e.title+'\n' +
                        '                                        </div></a>\n' +
                        '                                        <div class="layui-col-md8 margin-top">\n' +
                        '                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n' +
                        '                                            <span>\n' +
                        '                                            '+e.outline+'\n' +
                        '                                        </span>\n' +
                        '                                        </div>\n' +
                        '                                        <div class="layui-col-md4 margin-top padding-left padding-right">\n' +
                        '                                            <img src="'+e.avatar+'" class="index-img"/>\n' +
                        '                                        </div>\n' +
                        '                                    </div>\n' +
                        '                                    <hr class="layui-bg-black">\n' +
                        '                                </div>'
                })
                $('#blog-body').html(str);
            }
        })
    }

    getCount(title);

    function getCount(title) {
        $.ajax({
            type: 'get',
            url: '/blog/blog/count',
            data:{'title': title},
            success: function (count) {
                //layer.msg('666');
                //总页数低于页码总数
                laypage.render({
                    limit:4,
                    elem: 'page'
                    , count:count//数据总数
                    ,jump: function(obj, first){
                        //obj包含了当前分页的所有参数，比如：
                        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                        //首次不执行
                        otherBlogPage(obj.curr,title);
                        //页面跳转
                        if(!first){
                            //do something
                        }
                    }
                });
                //…
            },
            error:function () {
                layer.msg('服务器异常',{icon:3,time:1000,shade:0.5,anim:1})
            }
        })
    }

    if ($('#msg').text() != '' && $('#msg').text() != null) {
        layer.msg($('#msg').text(), {icon: 1, time: 1000, shade: 0.5, anim: 1});
    }


});
