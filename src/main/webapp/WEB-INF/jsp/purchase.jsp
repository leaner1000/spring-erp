<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="purchaseList" title="出库列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/purchase/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar8">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="purchase_id" data-options="width:150">
            订单编号
        </th>
        <th field="guest_id" data-options="width:150">
            顾客编号
        </th>
        <th field="furniture_id" data-options="width:150">
            家具编号
        </th>
        <th field="furniture_name" data-options="width:150">
            家具名称
        </th>
        <th field="purchase_date" data-options="width:150">
            下单日期
        </th>
        <th field="amount" data-options="width:150">
            订购数量
        </th>
        <th field="total_price" data-options="width:150" formatter="formatyingshou">
            应收款
        </th>
        <th field="receive_money" data-options="width:150">
            实付款
        </th>
        <th field="remarks" data-options="width:150">
            备注
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar8">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newpurchase()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editpurchase()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroypurchase()">删除</a>
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_purchase_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'purchase_id'">订单编号</div>
        </div>
    </div>
</div>

<div id="purchaseEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/purchase/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="purchaseAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/purchase/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function formatyingshou(val,row){
        var data=$("#purchaseList").datagrid('getRowIndex',row);
        var data1=$("#purchaseList").datagrid("getRows")[data]
        console.log(data1)
        if(parseInt(val)>parseInt(data1.receive_money)){
            return '<span style="color: red" >'+val+'</span>'
        }else if(val==data1.receive_money){
            return '<span style="color: lawngreen" >'+val+'</span>'
        }
    }
    function doSearch_purchase_id(value,name){
        if(value==null||value==''){
            $("#purchaseList").datagrid("reload");
        }else{
            $.get("/purchase/"+value,'',function(data){
                if(data!=''){
                    $("#purchaseList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#purchaseList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }
    function newpurchase() {
        $('#purchaseAddWindow').window("open")
    }

    function getpurchaseSelectionsIds(){
        var purchaseList = $("#purchaseList");
        var sels = purchaseList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].purchase_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editpurchase(){
        var ids = getOutboundSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#purchaseEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#purchaseList").datagrid("getSelections")[0];
                $("#purchaseEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroypurchase(){
        var ids = getpurchaseSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/purchase/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除成功!',undefined,function(){
                            $("#purchaseList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>