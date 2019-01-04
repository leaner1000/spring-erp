
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="providerEditForm" class="providerEditForm" method="post">
        <input type="hidden" name="provider_id"/>
        <table cellpadding="5" >
            <tr>
                <td>供应商名称:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="provider_name" />
                </td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input class="easyui-textbox" type="text" name="address" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td>
                    <input class="easyui-textbox" type="text" name="phone" style="width: 280px;"/>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitproviderEditForm()">提交</a>
    </div>
</div>
<script>
    function submitproviderEditForm(){
        if(!$('#providerEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#providerEditForm").serialize())
        $.post("provider/update",$("#providerEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#providerEditWindow").window('close');
                    $("#providerList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>