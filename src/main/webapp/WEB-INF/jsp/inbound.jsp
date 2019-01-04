<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="inboundList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/inbound/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar4">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="inbound_id" data-options="width:150">
            入库编号
        </th>
        <th field="furniture_id" data-options="width:150">
            家具编号
        </th>
        <th field="amount" data-options="width:150">
            家具数量
        </th>
        <th field="warehouse_id" data-options="width:150">
            所在仓库编号
        </th>
        <th field="date" data-options="width:150">
            日期
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar4">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newinbound()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editinbound()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyinbound()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_inbound_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'inbound_id'">入库编号</div>
        </div>
    </div>
</div>

<div id="inboundEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/inbound/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="inboundAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/inbound/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_inbound_id(value,name){
        if(value==null||value==''){
            $("#inboundList").datagrid("reload");
        }else{
            $.get("/inbound/"+value,'',function(data){
                if(data!=''){
                    $("#inboundList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#inboundList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newinbound() {
        $('#inboundAddWindow').window("open")
    }

    function getinboundSelectionsIds(){
        var inboundList = $("#inboundList");
        var sels = inboundList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].inbound_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editinbound(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#inboundEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#inboundList").datagrid("getSelections")[0];
                $("#inboundEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyinbound(){
        var ids = getinboundSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/inbound/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除记录成功!',undefined,function(){
                            $("#inboundList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>