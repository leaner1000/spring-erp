
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="repairEditForm" class="repairEditForm" method="post">
        <input type="hidden" name="repair_id"/>
        <table cellpadding="5" >
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitrepairEditForm()">提交</a>
    </div>
</div>
<script>
    function submitrepairEditForm(){
        if(!$('#repairEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#repairEditForm").serialize())
        $.post("repair/update",$("#repairEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#repairEditWindow").window('close');
                    $("#repairList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>