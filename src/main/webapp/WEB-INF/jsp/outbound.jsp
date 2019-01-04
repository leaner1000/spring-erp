<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="outboundList" title="出库列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/outbound/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar5">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="outbound_id" data-options="width:150">
            出库编号
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
<div id="toolbar5">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newoutbound()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editoutbound()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyoutbound()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_outbound_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'outbound_id'">出库编号</div>
        </div>
    </div>
</div>

<div id="outboundEditWindow" class="easyui-window" title="编辑出库信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/outbound/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="outboundAddWindow" class="easyui-window" title="添加家具出库"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/outbound/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_outbound_id(value,name){
        if(value==null||value==''){
            $("#outboundList").datagrid("reload");
        }else{
            $.get("/outbound/"+value,'',function(data){
                if(data!=''){
                    $("#outboundList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#outboundList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newoutbound() {
        $('#outboundAddWindow').window("open")
    }

    function getOutboundSelectionsIds(){
        var outboundList = $("#outboundList");
        var sels = outboundList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].outbound_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editoutbound(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一个家具出库信息才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一个家具出库信息!');
            return ;
        }

        $("#outboundEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#outboundList").datagrid("getSelections")[0];
                $("#outboundEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyoutbound(){
        var ids = getOutboundSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/outbound/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除成功!',undefined,function(){
                            $("#outboundList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>