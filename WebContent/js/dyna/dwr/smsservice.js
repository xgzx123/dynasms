define([
	"./servicebase"
], function(servicebase) {
	var smsservice = function() {
		this.init = function(){
			//TODO
		};
		
		this.dwrCall_hello = function () {
			SMSService.hello("JayZ", $.proxy( this.callback, this ));
		};
		
		this.callback = function (data) {
			alert(data);
		};
    }
	
	//inheritance
	smsservice.prototype = new servicebase();
	smsservice.prototype.constructor = smsservice;
	
	return smsservice;
});

