define([
	//TODO ADD
], function() {
    return function(title) {
    	this.grid = null;
    	this.win = null;
    	this.form = null;
    	
    	this.init = function(){
    		//init grid
    		this.grid = $('#user-table').datagrid({
    			url:'/DynaSMS/user/getUsers',
    			title:'Users',
    			width:600,
    			height:300,
    			singleSelect:true,
    			toolbar:[{
    				text:'New',
    				iconCls:'icon-add',
    				handler:this.newUser
    			},'-',{
    				text:'Edit',
    				iconCls:'icon-edit',
    				handler:this.editUser
    			},'-',{
    				text:'Delete',
    				iconCls:'icon-remove'
    			}]
    		});
    		$('#btn-save,#btn-cancel').linkbutton();
    		this.win = $('#user-window').window({
    			closed:true
    		});
    		this.form = this.win.find('form');
    	};
    	
    	this.newUser = function(){
    		this.win.window('open');
    		this.form.form('clear');
    		this.form.url = '/DynaSMS/user/save';
    	};
    	
    	this.editUser = function(){
    		var row = this.grid.datagrid('getSelected');
    		if (row){
    			this.win.window('open');
    			this.form.form('load', '/DynaSMS/user/getUser/'+row.id);
    			this.form.url = '/DynaSMS/user/update/'+row.id;
    		} else {
    			$.messager.show({
    				title:'Warning', 
    				msg:'Please select user first!'
    			});
    		}
    	};
    	
    	this.saveUser = function(){
    		this.form.form('submit', {
    			url:this.form.url,
    			success:function(data){
    				eval('data='+data);
    				if (data.success){
    					this.grid.datagrid('reload');
    					this.win.window('close');
    				} else {
    					$.messager.alert('Error',data.msg,'error');
    				}
    			}
    		});
    	};
    	
    	this.closeWindow = function(){
    		this.win.window('close');
    	}
    	
    	
    }
});









