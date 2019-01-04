
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="outstockEditForm" class="outstockEditForm" method="post">
        <input type="hidden" name="outstock_id"/>
        <table cellpadding="5" >
            <tr>
                <td>缺货编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="id" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>家具编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_id" />
                </td>
            </tr>
            <tr>
                <td>家具数量</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amount" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>时间</td>
                <td>
                    <input type="text" name="date" class="easyui-datebox">
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitoutstockEditForm()">提交</a>
    </div>
</div>
<script>
    function submitoutstockEditForm(){
        if(!$('#outstockEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#outstockEditForm").serialize())
        $.post("outstock/update",$("#outstockEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改成功!','info',function(){
                    $("#outstockEditWindow").window('close');
                    $("#outstockList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>