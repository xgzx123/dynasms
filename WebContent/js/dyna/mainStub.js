define([
	"./admin/user",
	"./dwr/smsservice"
], function(user, smsservice) {
	return function() {
		this.user = new user();
		this.smsservice = new smsservice();
		this.init = function(){
			this.user.init();
			this.smsservice.init();
			
			this.initHeader();
			this.initTree();
		};
		
		this.initHeader = function(){
			$("#postMessage").click(function(){
				$.ajax({
	    			url:"userController!returnUsers.action",
	    			type:"POST",
	    			data:{name: "xxx", phone: "111"},
	    			dataType:"json",
	    			success:function(data){
	    				console.log(data);
	    			}
	    		});
			});
		};
		
		this.initTree = function(){
			//TODO
		};
		
		this.clickOnTreeNode = function(node){
			//$('#mainTree').tree('beginEdit',node.target);
			if($('#mainTabs').tabs("exists", node.text)){
				$('#mainTabs').tabs('select',node.text);
			}else{
				$('#mainTabs').tabs('add',{
					title: node.text,
					href: "views/" + node.text + ".html",
					//content: '<div style="padding:10px">Content'+node.text+'</div>',
					closable: true
				});
				
				require([
			     	"./controls/" + node.text
			     ], function(control) {
					var control = new control();
					control.init();
			     });
			}
		};
    }
});
