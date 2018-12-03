<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="furnitureList" title="设备列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       	url="/furniture/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="furniture_id">
            编号
        </th>
        <th field="furniture_name">
            家具名称
        </th>
        <th field="furniture_discription">
            家具描述
        </th>
        <th field="picture_path">
            图片
        </th>
        <th field="provider">
            提供商
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newFurniture()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editFurniture()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyFurniture()">删除</a>
</div>

<div id="furnitureEditWindow" class="easyui-window" title="编辑家具"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'furniture/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="furnitureAddWindow" class="easyui-window" title="添加家具"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/furniture/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function newFurniture() {
        $('#furnitureAddWindow').window("open")
    }

    function getFurnitureSelectionsIds(){
        var furnitureList = $("#furnitureList");
        var sels = furnitureList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].furniture_id);
        }
        ids = ids.join(",");
        return ids;
    }

    function editFurniture(){
        var ids = getFurnitureSelectionsIds();
        if(ids.length == 0){
                    $.messager.alert('提示','必须选择一个家具才能编辑!');
                    return ;
                }
                if(ids.indexOf(',') > 0){
                    $.messager.alert('提示','只能选择一个家具!');
                    return ;
                }

                $("#furnitureEditWindow").window({
                    onLoad :function(){
                        //回显数据
                        var data = $("#furnitureList").datagrid("getSelections")[0];
                        $("#furnitureEditForm").form("load", data);
                    }
                }).window("open");

    }
    function destroyFurniture(){
                var ids = getFurnitureSelectionsIds();
                console.log(ids)
        var param={"ids":ids}
        console.log(param)
                if(ids.length == 0){
                    $.messager.alert('提示','未选中家具!');
                    return ;
                }
                $.messager.confirm('确认','确定删除ID为 '+ids+' 的家具吗？',function(r){
                    if (r){
                        $.post("/furniture/delete_batch",param, function(data){
                            if(data.status == 200){
                                $.messager.alert('提示','删除家具成功!',undefined,function(){
                                    $("#furnitureList").datagrid("reload");
                                });
                            }
                        });
                    }
                });
    }
</script>
