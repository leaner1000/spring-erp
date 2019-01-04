<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="guestAddForm" class="guestForm" method="post">
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitguestAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearguestAddForm()">重置</a>
    </div>
</div>
<script>

    function submitguestAddForm(){
//有效性验证
        if(!$('#guestAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/guest/insert",$("#guestAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#guestAddWindow").window('close');
                $("#guestList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearguestAddForm(){
        $('#guestAddForm').form('reset');
    }
</script>
