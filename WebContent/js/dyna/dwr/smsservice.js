function dwrCall_hello() {
	SMSService.hello("JayZ", callback);
}

function callback(data) {
	alert(data);
}