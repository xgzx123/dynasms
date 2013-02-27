define([
	//TODO ADD
], function() {
    return function(title) {
    	this.grid = null;
    	this.win = null;
    	this.form = null;
    	
    	this.init = function(){
    		//init grid
    		$.getJSON("userController!returnUsers.action",$.proxy(function(data){
				this.grid = $('#user-table').datagrid({
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
	    		}).datagrid('loadData',data.users);
				
				$('#btn-save,#btn-cancel').linkbutton();
	    		this.win = $('#user-window').window({
	    			closed:true
	    		});
	    		this.form = this.win.find('form');
			}, this));
    	};
    	
    	this.newUser = $.proxy(function(){
    		this.win.window('open');
    		this.form.form('clear');
    		this.form.url = 'userController!newUser.action';
    	}, this);
    	
    	this.editUser = $.proxy(function(){
    		var row = this.grid.datagrid('getSelected');
    		if (row){
    			this.win.window('open');
    			$.getJSON("userController!returnUser.action?id="+row.id, $.proxy(function(data){
    				this.form.form('load', data.user);
    				this.form.url = 'userController!updateUser.action?id='+row.id;
    			}, this));
    		} else {
    			$.messager.show({
    				title:'Warning', 
    				msg:'Please select user first!'
    			});
    		}
    	}, this);
    	
    	this.saveUser = $.proxy(function(){
    		this.form.form('submit', {
    			url:this.form.url,
    			success:$.proxy(function(data){
    				eval('data='+data);
    				if (data.message && data.message == "success"){
    					$.getJSON("userController!returnUsers.action",$.proxy(function(data){
    						this.grid.datagrid('loadData', data.users);
    						this.win.window('close');
    					}, this));
    					
    				} else {
    					$.messager.alert('Error',data.msg,'error');
    				}
    			}, this)
    		});
    	}, this);
    	
    	this.closeWindow = $.proxy(function(){
    		this.win.window('close');
    	}, this);
    	
    	
    }
});









