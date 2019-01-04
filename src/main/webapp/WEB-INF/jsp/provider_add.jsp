<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="providerAddForm" class="providerForm" method="post">
        <table cellpadding="5" >
            <tr>
                <td>供应商编号:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="provider_id" data-options="required:true"/>
                </td>
            </tr>
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
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitproviderAddForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearproviderAddForm()">重置</a>
    </div>
</div>
<script>

    function submitproviderAddForm(){
//有效性验证
        if(!$('#providerAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
//ajax的post方式提交表单
//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/provider/insert",$("#providerAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增成功!');
                clearOutBoundAddForm();
                $("#providerAddWindow").window('close');
                $("#providerList").datagrid("reload");
            }else{
                $.messager.alert('提示',data.msg);
            }
        });
    }

    function clearproviderAddForm(){
        $('#providerAddForm').form('reset');
    }
</script>
