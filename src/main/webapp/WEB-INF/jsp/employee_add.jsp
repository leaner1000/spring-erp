<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="employeeAddForm" class="employeeForm" method="post">
        <table cellpadding="5" >
            <tr>
                <td>员工编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="employee_id" data-options="required:true"/>
                </td>
            </tr>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitemployeeAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearemployeeAddForm()">重置</a>
    </div>
</div>
<script>

    function submitemployeeAddForm(){
//有效性验证
        if(!$('#employeeAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/employee/insert",$("#employeeAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#employeeAddWindow").window('close');
                $("#employeeList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearemployeeAddForm(){
        $('#employeeAddForm').form('reset');
    }
</script>
