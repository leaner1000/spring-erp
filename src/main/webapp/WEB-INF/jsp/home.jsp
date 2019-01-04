
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
<div class="divNorth" style="height:100px;" data-options="region:'north'" >
	<center><img src="img/logo.png" style="height:90px;margin: auto;" />
        <a href="/logout" style="float:right">退出登陆</a>
    </center>
</div>
<div class="divWest" style="width: 200px" data-options="region:'west'">
    <div class="easyui-accordion" style="padding:0px;">
        <div title="库存管理">
            <ul id="store" class="easyui-tree">
                <li data-options="attributes:{'url':'/furniture'}">库存管理</li>
                <li data-options="attributes:{'url':'/outbound'}">出货管理</li>
                <li data-options="attributes:{'url':'/outstock'}">缺货管理</li>
                <li data-options="attributes:{'url':'/inbound'}">入库管理</li>
            </ul>
        </div>
        <div title="销售管理">
            <ul id="sale" class="easyui-tree">
                <li data-options="attributes:{'url':'/purchase'}">订单管理</li>
                <li data-options="attributes:{'url':'/repair'}">维修管理</li>
            </ul>
        </div>
        <div title="信息管理">
            <ul id="data" class="easyui-tree">
                <li data-options="attributes:{'url':'/provider'}">供应商管理</li>
                <li data-options="attributes:{'url':'/employee'}">员工管理</li>
                <li data-options="attributes:{'url':'/guest'}">顾客管理</li>
                <li data-options="attributes:{'url':'/warehouse'}">仓库管理</li>
            </ul>
        </div>
        <div title="用户管理">
            <ul id="systems" class="easyui-tree">
                <li data-options="attributes:{'url':'/user'}">用户管理</li>
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
        $('#sale').tree({
            onClick:function(node) {
                if ($('#sale').tree('isLeaf'), node.target) {
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
        $('#data').tree({
            onClick:function(node) {
                if ($('#data').tree('isLeaf'), node.target) {
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
        $('#systems').tree({
            onClick:function(node) {
                $.get('/user',function (a) {
                    if(a.status==400){
                        $.messager.alert(a.msg)
                    }else{
                        if ($('#systems').tree('isLeaf'), node.target) {
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
                })
            }
        });
    });
</script>
</html>
