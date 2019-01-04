
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="purchaseEditForm" class="purchaseEditForm" method="post">
        <input type="hidden" name="purchase_id"/>
        <table cellpadding="5" >
            <tr>
                <td>顾客编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="guest_id" />
                </td>
            </tr>
            <tr>
                <td>家具编号</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_id" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>家具名称</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_name" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>下单日期</td>
                <td>
                    <input type="text" name="purchase_date" class="easyui-datebox">
                </td>
            </tr>
            <tr>
                <td>订购数量</td>
                <td>
                    <input type="text" name="amount" class="easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>应收款</td>
                <td>
                    <input type="text" name="total_price" class="easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>实付款</td>
                <td>
                    <input type="text" name="receive_money" class="easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>备注</td>
                <td>
                    <input type="text" name="remarks" class="easyui-textbox">
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitpurchaseEditForm()">提交</a>
    </div>
</div>
<script>
    function submitpurchaseEditForm(){
        if(!$('#purchaseEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#purchaseEditForm").serialize())
        $.post("purchase/update",$("#purchaseEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#purchaseEditWindow").window('close');
                    $("#purchaseList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>