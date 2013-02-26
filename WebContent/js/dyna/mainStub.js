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
		}
    }
});
