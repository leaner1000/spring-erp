<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="furnitureList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       	url="/furniture/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar2">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="furniture_id" data-options="width:150">
            编号
        </th>
        <th field="furniture_name" data-options="width:150">
            家具名称
        </th>
        <th field="furniture_discription" data-options="width:150">
            家具描述
        </th>
        <th field="picture_path" formatter="formatpic" data-options="width:150">
            图片
        </th>
        <th field="warehouse_id"  data-options="width:150">
            所在仓库
        </th>
        <th field="amount" formatter="formatamount" data-options="width:150">
            剩余数量
        </th>
        <th field="provider" data-options="width:150">
            提供商
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar2">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newFurniture()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editFurniture()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyFurniture()">删除</a>

    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_furniture_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'furniture_id'">家具编号</div>
        </div>
    </div>
</div>

<div id="furnitureEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'furniture/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="furnitureAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/furniture/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_furniture_id(value,name){
        if(value==null||value==''){
            $("#furnitureList").datagrid("reload");
        }else{
            $.get("/furniture/"+value,'',function(data){
                if(data!=''){
                    $("#furnitureList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#furnitureList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function formatamount(val,row) {
        if(val<10){
            return '<span style="color: red" >'+val+'</span>'
        }else{
            return val
        }
    }

    function formatpic(val,row) {
        return '<a href="'+val+'">图片</a>'
    }

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
        console.log(ids)
        return ids;
    }

    function editFurniture(){
        var ids = getFurnitureSelectionsIds();
        if(ids.length == 0){
                    $.messager.alert('提示','必须选择一条记录才能编辑!');
                    return ;
                }
                if(ids.indexOf(',') > 0){
                    $.messager.alert('提示','只能选择一条记录!');
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
                    $.messager.alert('提示','未选中记录!');
                    return ;
                }
                $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
                    if (r){
                        $.post("/furniture/delete_batch",param, function(data){
                            if(data.status == 200){
                                $.messager.alert('提示','删除记录成功!',undefined,function(){
                                    $("#furnitureList").datagrid("reload");
                                });
                            }else{
                                $.messager.alert('提示',data.msg);
                            }
                        });
                    }
                });
    }
</script>
