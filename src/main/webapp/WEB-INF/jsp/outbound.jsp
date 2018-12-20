<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="outboundList" title="设备列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/outbound/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="outbound_id">
            流水线编号
        </th>
        <th field="furniture_id">
            家具编号
        </th>
        <th field="amount">
            家具数量
        </th>
        <th field="warehouse_id">
            所在仓库编号
        </th>
        <th field="date">
            日期
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newoutbound()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editoutbound()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyoutbound()">删除</a>
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
            $.messager.alert('提示','未选中出库信息!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的家具出库信息吗？',function(r){
            if (r){
                $.post("/outbound/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除家具出库信息成功!',undefined,function(){
                            $("#outboundList").datagrid("reload");
                        });
                    }
                });
            }
        });
    }
</script>