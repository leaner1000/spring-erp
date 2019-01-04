<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="guestList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/guest/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar3">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="guest_id" data-options="width:150">
            顾客编号
        </th>
        <th field="guest_name" data-options="width:150">
            顾客名字
        </th>
        <th field="consume_amount" data-options="width:150">
           消费金额
        </th>
        <th field="phone_num" data-options="width:150">
            电话号码
        </th>
        <th field="address" data-options="width:150">
            地址
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar3">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newguest()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editguest()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyguest()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_guest_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'guest_id'">顾客编号</div>
        </div>
    </div>
</div>

<div id="guestEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/guest/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="guestAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/guest/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_guest_id(value,name){
        if(value==null||value==''){
            $("#guestList").datagrid("reload");
        }else{
            $.get("/guest/"+value,'',function(data){
                if(data!=''){
                    $("#guestList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#guestList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newguest() {
        $('#guestAddWindow').window("open")
    }

    function getguestSelectionsIds(){
        var guestList = $("#guestList");
        var sels = guestList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].guest_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editguest(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#guestEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#guestList").datagrid("getSelections")[0];
                $("#guestEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyguest(){
        var ids = getguestSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/guest/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除记录成功!',undefined,function(){
                            $("#guestList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>