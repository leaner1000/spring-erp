
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="guestEditForm" class="guestEditForm" method="post">
        <input type="hidden" name="guest_id"/>
        <table cellpadding="5" >
            <tr>
                <td>客户编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="guest_id" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>客户名字:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="guest_name" />
                </td>
            </tr>
            <tr>
                <td>消费金额</td>
                <td>
                    <input class="easyui-textbox" type="text" name="consume_amount" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input class="easyui-textbox" type="text" name="address" style="width: 280px;"/>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitguestEditForm()">提交</a>
    </div>
</div>
<script>
    function submitguestEditForm(){
        if(!$('#guestEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#guestEditForm").serialize())
        $.post("guest/update",$("#guestEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#guestEditWindow").window('close');
                    $("#guestList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>