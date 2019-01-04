<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="repairAddForm" class="repairForm" method="post">
        <table cellpadding="5" >
            <tr>
                <td>维修编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="repair_id" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>家具编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_id" />
                </td>
            </tr>
            <tr>
                <td>损坏情况</td>
                <td>
                    <input class="easyui-textbox" type="text" name="damage_condition" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>送修日期</td>
                <td>
                    <input class="easyui-datebox" type="text" name="send_date" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>维修人员编号</td>
                <td>
                    <input class="easyui-textbox" type="text" name="employee_id">
                </td>
            </tr>
            <tr>
                <td>顾客编号</td>
                <td>
                    <input class="easyui-textbox" type="text" name="guest_id">
                </td>
            </tr>
            <tr>
                <td>维修状态</td>
                <td>
                    <input class="easyui-textbox" type="text" name="repair_state">
                </td>
            </tr>
            <tr>
                <td>维修金额</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amount">
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitrepairAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearrepairAddForm()">重置</a>
    </div>
</div>
<script>

    function submitrepairAddForm(){
//有效性验证
        if(!$('#repairAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/repair/insert",$("#repairAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#repairAddWindow").window('close');
                $("#repairList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearrepairAddForm(){
        $('#repairAddForm').form('reset');
    }
</script>
