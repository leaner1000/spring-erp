<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="outstockList" title="缺货列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/outstock/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar6">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="id" data-options="width:150">
            编号
        </th>
        <th field="furniture_id" data-options="width:150">
            家具编号
        </th>
        <th field="amount" data-options="width:150">
            家具数量
        </th>
        <th field="date" data-options="width:150">
            日期
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar6">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newoutstock()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editoutstock()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyoutstock()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_outstock_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'outstock_id'">缺货编号</div>
        </div>
    </div>
</div>

<div id="outstockEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/outstock/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="outstockAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/outstock/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_outstock_id(value,name){
        if(value==null||value==''){
            $("#outstockList").datagrid("reload");
        }else{
            $.get("/outstock/"+value,'',function(data){
                if(data!=''){
                    $("#outstockList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#outstockList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newoutstock() {
        $('#outstockAddWindow').window("open")
    }

    function getoutstockSelectionsIds(){
        var outstockList = $("#outstockList");
        var sels = outstockList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].outstock_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editoutstock(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条信息才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条信息!');
            return ;
        }

        $("#outstockEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#outstockList").datagrid("getSelections")[0];
                $("#outstockEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyoutstock(){
        var ids = getoutstockSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/outstock/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除成功!',undefined,function(){
                            $("#outstockList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>