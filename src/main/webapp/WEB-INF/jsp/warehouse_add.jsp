
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="warehouseAddForm" class="warehouseForm" method="post">
        <table cellpadding="5" >
            <tr>
                <td>仓库编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="warehouse_id" data-options="required:true"/>
                </td>
            </tr>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitwarehouseAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearwarehouseAddForm()">重置</a>
    </div>
</div>
<script>

    function submitwarehouseAddForm(){
//有效性验证
        if(!$('#warehouseAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/warehouse/insert",$("#warehouseAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#warehouseAddWindow").window('close');
                $("#warehouseList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearwarehouseAddForm(){
        $('#warehouseAddForm').form('reset');
    }
</script>
