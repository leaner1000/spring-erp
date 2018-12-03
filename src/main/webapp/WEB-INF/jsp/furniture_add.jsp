<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="furnitureAddForm" class="furnitureForm" method="post">
        <table cellpadding="5" >
            <tr>
                <td>编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_id" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>家具名称:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_name" />
                </td>
            </tr>
            <tr>
                <td>家具描述</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_discription" style="width: 280px;"/>
                </td>
            </tr>
            <tr>
                <td>图片</td>
                <td>
                    <input class="easyui-textbox" type="text" name="picture_path"/>
                </td>
            </tr>
            <tr>
                <td>提供商</td>
                <td>
                    <input class="easyui-textbox" type="text" name="provider"/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="customParams"/>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitFurnitureAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearFurnitureAddForm()">重置</a>
    </div>
</div>
<script>
function submitFurnitureAddForm(){
//有效性验证
if(!$('#customAddForm').form('validate')){
$.messager.alert('提示','表单还未填写完成!');
return ;
}
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
$.post("/furniture/insert",$("#furnitureAddForm").serialize(), function(data){
if(data.status == 200){
$.messager.alert('提示','新增家具成功!');
clearFurnitureAddForm();
$("#furnitureAddWindow").window('close');
$("#furnitureList").datagrid("reload");
}else{
$.messager.alert('提示',data.msg);
}
});
}

function clearFurnitureAddForm(){
$('#customAddForm').form('reset');
}
</script>