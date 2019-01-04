
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="warehouseEditForm" class="warehouseEditForm" method="post">
        <input type="hidden" name="warehouse_id"/>
        <table cellpadding="5" >
            <tr>
                <td>管理员工编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="employee_id" />
                </td>
            </tr>
            <tr>
                <td>管理者电话</td>
                <td>
                    <input class="easyui-textbox" type="text" name="employee_phone" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>仓库地址</td>
                <td>
                    <input class="easyui-textbox" type="text" name="address" style="width: 280px;"/>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitwarehouseEditForm()">提交</a>
    </div>
</div>
<script>
    function submitwarehouseEditForm(){
        if(!$('#warehouseEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#warehouseEditForm").serialize())
        $.post("warehouse/update",$("#warehouseEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#warehouseEditWindow").window('close');
                    $("#warehouseList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>