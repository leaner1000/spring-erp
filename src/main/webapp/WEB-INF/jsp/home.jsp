
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>家具管理系统</title>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/js/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/js/themes/default/easyui.css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
<div class="divNorth" style="height:100px;" data-options="region:'north'" ></div>
<div class="divWest" style="width: 200px" data-options="region:'west'">
    <div class="easyui-accordion" style="padding:0px;">
        <div title="库存管理">
            <ul id="store" class="easyui-tree">
                <li data-options="attributes:{'url':'/furniture'}">库存管理</li>
                <li data-options="attributes:{'url':'/outbound'}">出货管理</li>
                <li>订单管理</li>
            </ul>
        </div>
        <div title="用户管理">
            <ul id="systems" class="easyui-tree">
                <li>用户管理</li>
                <li>角色管理</li>
            </ul>
        </div>
    </div>
</div>
<div id="content" region="center" title="" style="padding:5px;">
    <div id="tabs" class="easyui-tabs" >
        <div title="首页" style="padding:20px;"></div>
    </div>
</div>
</body>
<script>

    $(function() {
        $('#store').tree({
            onClick:function(node) {
                if ($('#store').tree('isLeaf'), node.target) {
                    var tab = $('#tabs')
                    var tab2 = tab.tabs("getTab", node.text);
                    if (tab2) {
                        tab.tabs("select", node.text);
                    } else {
                        tab.tabs('add', {
                            title: node.text,
                            href: node.attributes.url,
                            closable: true,
                            bodyCls: "content"
                        });
                    }
                }
            }
        });
    });
</script>
</html>
