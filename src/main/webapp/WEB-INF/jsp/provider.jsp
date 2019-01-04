<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="providerList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/provider/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar7">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="provider_id" data-options="width:150">
            供应商编号
        </th>
        <th field="provider_name" data-options="width:150">
            供应商名称
        </th>
        <th field="address" data-options="width:150">
            地址
        </th>
        <th field="phone" data-options="width:150">
            电话
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar7">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newprovider()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editprovider()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyprovider()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_provider_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'provider_id'">供应商编号</div>
        </div>
    </div>
</div>

<div id="providerEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/provider/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="providerAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/provider/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_provider_id(value,name){
        if(value==null||value==''){
            $("#providerList").datagrid("reload");
        }else{
            $.get("/provider/"+value,'',function(data){
                if(data!=''){
                    $("#providerList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#providerList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newprovider() {
        $('#providerAddWindow').window("open")
    }

    function getproviderSelectionsIds(){
        var providerList = $("#providerList");
        var sels = providerList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].provider_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editprovider(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#providerEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#providerList").datagrid("getSelections")[0];
                $("#providerEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyprovider(){
        var ids = getproviderSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/provider/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除记录成功!',undefined,function(){
                            $("#providerList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>
