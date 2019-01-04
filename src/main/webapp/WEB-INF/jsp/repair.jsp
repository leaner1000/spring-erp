<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="repairList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/repair/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar9">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="repair_id" data-options="width:150">
            维修编号
        </th>
        <th field="furniture_id" data-options="width:150">
            家具编号
        </th>
        <th field="damage_condition" data-options="width:150">
            损坏情况
        </th>
        <th field="send_date" data-options="width:150">
            送修日期
        </th>
        <th field="employee_id" data-options="width:150">
            维修人员编号
        </th>
        <th field="guest_id" data-options="width:150">
            客户编号
        </th>
        <th field="repair_state" data-options="width:150">
            维修状态
        </th>
        <th field="amount" data-options="width:150">
            维修费用
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar9">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newrepair()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editrepair()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyrepair()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_repair_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'repair_id'">维修编号</div>
        </div>
    </div>
</div>

<div id="repairEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/repair/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="repairAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/repair/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_repair_id(value,name){
        if(value==null||value==''){
            $("#repairList").datagrid("reload");
        }else{
            $.get("/repair/"+value,'',function(data){
                if(data!=''){
                    $("#repairList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#repairList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newrepair() {
        $('#repairAddWindow').window("open")
    }

    function getrepairSelectionsIds(){
        var repairList = $("#repairList");
        var sels = repairList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].repair_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editrepair(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#repairEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#repairList").datagrid("getSelections")[0];
                $("#repairEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyrepair(){
        var ids = getrepairSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/repair/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除记录成功!',undefined,function(){
                            $("#repairList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>