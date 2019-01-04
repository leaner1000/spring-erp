<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="outstockAddForm" class="outstockForm" method="post">
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitoutstockAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearoutstockAddForm()">重置</a>
    </div>
</div>
<script>

    function submitoutstockAddForm(){
//有效性验证
        if(!$('#outstockAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/outstock/insert",$("#outstockAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#outstockAddWindow").window('close');
                $("#outstockList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearoutstockAddForm(){
        $('#outstockAddForm').form('reset');
    }
</script>
