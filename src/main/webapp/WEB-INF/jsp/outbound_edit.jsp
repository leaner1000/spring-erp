
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="outboundEditForm" class="outboundEditForm" method="post">
        <input type="hidden" name="outbound_id"/>
        <table cellpadding="5" >
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
                <td>仓库id</td>
                <td>
                    <input class="easyui-textbox" type="text" name="warehouse_id" style="width: 280px;"/>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOutBoundEditForm()">提交</a>
    </div>
</div>
<script>
    function submitOutBoundEditForm(){
        if(!$('#outboundEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        console.log($("#outboundEditForm").serialize())
        $.post("outbound/update",$("#outboundEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改客户成功!','info',function(){
                    $("#outboundEditWindow").window('close');
                    $("#outboundList").datagrid("reload");
                });
            }else{
                $.messager.alert('提示', data.msg);
            }
        }, "json");
    }
</script>