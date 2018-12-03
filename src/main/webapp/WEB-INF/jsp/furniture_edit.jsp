
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="furnitureEditForm" class="furnitureForm" method="post">
        <input type="hidden" name="furniture_id"/>
        <table cellpadding="5" >
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
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitFurnitureEditForm()">提交</a>
    </div>
</div>
<script>
    function submitFurnitureEditForm(){
                if(!$('#furnitureEditForm').form('validate')){
                    $.messager.alert('提示','表单还未填写完成!');
                    return ;
                }
                console.log($("#furnitureEditForm").serialize())
                $.post("furniture/update",$("#furnitureEditForm").serialize(), function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','修改客户成功!','info',function(){
                            $("#furnitureEditWindow").window('close');
                            $("#furnitureList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示', data.msg);
                    }
                }, "json");
    }
</script>