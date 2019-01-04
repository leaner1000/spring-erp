<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
    <form id="furnitureAddForm" class="furnitureForm" method="post" enctype="multipart/form-data">
        <table cellpadding="5" >
            <tr>
                <td>编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_id" id="furniture_id" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>家具名称:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_name" id="furniture_name"/>
                </td>
            </tr>
            <tr>
                <td>家具描述</td>
                <td>
                    <input class="easyui-textbox" type="text" name="furniture_discription" id="furniture_discription" />
                </td>
            </tr>
            <tr>
                <td>图片</td>
                <td>
                    <input value="上传图片" class="easyui-linkbutton picFileUpload" type="file" name="picture_path" accept="image/jpeg,image/png,image/gif" id="picture_path"/>
                </td>
            </tr>
            <tr>
                <td>所在仓库</td>
                <td>
                    <input class="easyui-textbox" type="text" name="warehouse_id" id="warehouse_id"/>
                </td>
            </tr>
            <tr>
                <td>剩余数量</td>
                <td>
                    <input class="easyui-textbox" type="text" name="amount" id="amount"/>
                </td>
            </tr>
            <tr>
                <td>提供商</td>
                <td>
                    <input class="easyui-textbox" type="text" name="provider" id="provider"/>
                </td>
            </tr>
        </table>
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
    //使用FormData上传图片及表单
    var form=$("#furnitureAddForm").serialize()
    var formdata=new FormData()
    formdata.append("furniture_id",$("#furniture_id").val())
    formdata.append("furniture_name",$("#furniture_name").val())
    formdata.append("furniture_discription",$("#furniture_discription").val())
    formdata.append("warehouse_id",$("#warehouse_id").val())
    formdata.append("amount",$("#amount").val())
    formdata.append("provider",$("#provider").val())
    formdata.append('picture_path',$('#picture_path')[0].files[0])
    $.ajax({
        type:"POST",
        url:"furniture/insert",
        data:formdata,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
        success:function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearFurnitureAddForm();
                $("#furnitureAddWindow").window('close');
                $("#furnitureList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        }
    })

}

function clearFurnitureAddForm(){
$('#customAddForm').form('reset');
}
</script>