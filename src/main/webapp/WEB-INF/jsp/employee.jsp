<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="easyui-datagrid" id="employeeList" title="列表"
       singleSelect="false" collapsible="true" pagination="true" rownumbers="true"
       url="/employee/page" method="post" pageSize="10" fitColumns="true" toolbar="#toolbar1">
    <thead>
    <tr>
        <th checkbox="true" field="ck"></th>
        <th field="employee_id" data-options="width:150">
            员工编号
        </th>
        <th field="name" data-options="width:150">
            员工姓名
        </th>
        <th field="sex" data-options="width:150">
            性别
        </th>
        <th field="birthday" data-options="width:150">
            生日
        </th>
        <th field="hiredate" data-options="width:150">
            雇佣日期
        </th>
        <th field="jobtitle" data-options="width:150">
            职务
        </th>
        <th field="address" data-options="width:150">
            住址
        </th>
        <th field="phone" data-options="width:150">
            电话号码
        </th>
        <th field="id_number" data-options="width:150">
            身份证
        </th>
    </tr>
    </thead>
</table>
<div id="toolbar1">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newemployee()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editemployee()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyemployee()">删除</a>

    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"
               data-options="searcher:doSearch_employee_id,prompt:'请输入...',menu:'#menu_custom'"
               style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px">
            <div data-options="name:'employee_id'">员工编号</div>
        </div>
    </div>
</div>

<div id="employeeEditWindow" class="easyui-window" title="编辑信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/employee/edit'"
     style="width:65%;height:80%;padding:10px;">
</div>

<div id="employeeAddWindow" class="easyui-window" title="添加信息"
     data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'/employee/add'"
     style="width:65%;height:80%;padding:10px;">
</div>

<script>
    function doSearch_employee_id(value,name){
        if(value==null||value==''){
            $("#employeeList").datagrid("reload");
        }else{
            $.get("/employee/"+value,'',function(data){
                console.log(data)
                if(data!=''){
                    $("#employeeList").datagrid("loadData",{"total":1,"rows":[data]})
                }else{
                    $("#employeeList").datagrid("loadData",{"total":0,"rows":[]})
                }
            })
        }
    }

    function newemployee() {
        $('#employeeAddWindow').window("open")
    }

    function getemployeeSelectionsIds(){
        var employeeList = $("#employeeList");
        var sels = employeeList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].employee_id);
        }
        ids = ids.join(",");
        console.log(ids);
        return ids;
    }

    function editemployee(){
        var ids = getemployeeSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','必须选择一条记录才能编辑!');
            return ;
        }
        if(ids.indexOf(',') > 0){
            $.messager.alert('提示','只能选择一条记录!');
            return ;
        }

        $("#employeeEditWindow").window({
            onLoad :function(){
                //回显数据
                var data = $("#employeeList").datagrid("getSelections")[0];
                $("#employeeEditForm").form("load", data);
            }
        }).window("open");

    }
    function destroyemployee(){
        var ids = getemployeeSelectionsIds();
        console.log(ids)
        var param={"ids":ids}
        console.log(param)
        if(ids.length == 0){
            $.messager.alert('提示','未选中记录!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
            if (r){
                $.post("/employee/delete_batch",param, function(data){
                    if(data.status == 200){
                        $.messager.alert('提示','删除记录成功!',undefined,function(){
                            $("#employeeList").datagrid("reload");
                        });
                    }else{
                        $.messager.alert('提示',data.msg);
                    }
                });
            }
        });
    }
</script>