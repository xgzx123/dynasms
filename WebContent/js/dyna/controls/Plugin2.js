define([
	//TODO
], function() {
	return function() {
		this.init = function(){
			main.viewsControl.plugin2 = this;
			$("#plugin2Button").click(function(){
				$("#plugin2Calendar").calendar('moveTo', new Date(2012, 6, 1));
				
			});
		};
		
		this.helloWorld = function(){
			alert("hello plugin2");
		};
    }
});