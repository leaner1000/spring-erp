
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="employeeEditForm" class="employeeEditForm" method="post">
        <input type="hidden" name="employee_id"/>
        <table cellpadding="5" >
            <tr>
                <td>员工姓名:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="name" />
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input class="easyui-textbox" type="text" name="sex" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td>
                    <input class="easyui-datebox" type="text" name="birthday" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>雇佣日期</td>
                <td>
                    <input type="text" name="hiredate" class="easyui-datebox">
                </td>
            </tr>
            <tr>
                <td>职务</td>
                <td>
                    <input type="text" name="jobtitle" class="easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>住址</td>
                <td>
                    <input type="text" name="address" class="easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td>
                    <input type="text" name="phone" class="easyui-textbox">
                </td>
            </tr>
            <tr>
                <td>身份证</td>
                <td>
                    <input type="text" name="id_number" class="easyui-textbox">
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitemployeeEditForm()">提交</a>
    </div>
</div>
<script>
    function submitemployeeEditForm(){
        if(!$('#employeeEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#employeeEditForm").serialize())
        $.post("employee/update",$("#employeeEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#employeeEditWindow").window('close');
                    $("#employeeList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>