<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="outboundAddForm" class="outboundForm" method="post">
        <table cellpadding="5" >
            <tr>
                <td>出库编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="outbound_id" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>家具编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_id" />
                </td>
            </tr>
            <tr>
                <td>仓库id</td>
                <td>
                    <input class="easyui-textbox" type="text" name="warehouse_id" style="width: 280px;"/>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOutboundAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearOutboundAddForm()">重置</a>
    </div>
</div>
<script>

    function submitOutboundAddForm(){
//有效性验证
        if(!$('#outboundAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/outbound/insert",$("#outboundAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#outboundAddWindow").window('close');
                $("#outboundList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearOutboundAddForm(){
        $('#outboundAddForm').form('reset');
    }
</script>
