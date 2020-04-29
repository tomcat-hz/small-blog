layui.use(['element','laypage', 'layer','rate'], function(){
    var element = layui.element,
        laypage = layui.laypage,
        $ = layui.jquery,
        rate=layui.rate,
        layer = layui.layer;

    rate.render({
        elem: '#test4'
        ,value: 3.5
        ,half: true
        ,text: true
    })



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

    $('#showCataLog').on('click', function(){
        layer.open({
            title: false,
            type: 1,
            offset: 'rt',
            shade:0,



            scrollbar: false,
            skin: 'demo-class',
            fixed:true,
            content: $('#catalog') //这里content是一个普通的String
        });
        var that = this;
    });
});
