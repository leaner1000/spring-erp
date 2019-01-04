<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="warehouseList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/warehouse/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar11">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="warehouse_id" data-options="width:150">
            仓库编号
        </th>
        <th field="employee_id" data-options="width:150">
            管理员工编号
        </th>
        <th field="employee_phone" data-options="width:150">
            管理者电话
        </th>
        <th field="address" data-options="width:150">
            地址
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar11">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newwarehouse()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editwarehouse()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroywarehouse()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_warehouse_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'warehouse_id'">仓库编号</div>
        </div>
    </div>
</div>

<div id="warehouseEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/warehouse/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="warehouseAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/warehouse/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_warehouse_id(value,name){
        if(value==null||value==''){
            $("#warehouseList").datagrid("reload");
        }else{
            $.get("/warehouse/"+value,'',function(data){
                if(data!=''){
                    $("#warehouseList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#warehouseList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newwarehouse() {
        $('#warehouseAddWindow').window("open")
    }

    function getwarehouseSelectionsIds(){
        var warehouseList = $("#warehouseList");
        var sels = warehouseList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].warehouse_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editwarehouse(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#warehouseEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#warehouseList").datagrid("getSelections")[0];
                $("#warehouseEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroywarehouse(){
        var ids = getwarehouseSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/warehouse/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除记录成功!',undefined,function(){
                            $("#warehouseList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>