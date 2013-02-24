// Christopher Michaelis - chris@chrismichaelis.com

var sayHelloAlert = function() {
	alert('Hello!');
};

var sayHelloDialog = function() {
	$('#dialogContent').html('Isn\'t this <b>cooler</b>?<br /><br />By setting modal to true, you can require the user to dismiss this before interacting with more of the page.');
	$('#dialogHolder').dialog({
		autoOpen: true,
		title: 'Hello!',
		modal: true,
		buttons: {
			"Go Away": function() {
				$(this).dialog("close");
			}
		}
	});
};

var basicAnimationDemo = function() {
	$('#doBasicAnimationDemo').animate({ 'color': '#ff0000' }, 4000, function() {
		$('#doBasicAnimationDemo').animate({ 'color': '#00ff00' }, 4000);
	});
};

var betterAnimationDemo = function() {
	if ($('#googleLogo').is(':visible')) {
		$('#googleLogo').hide('explode', {}, 2000);
	}
	else {
		$('#googleLogo').show('slide', {}, 1000);
	}
}

var advanceProgressBar = function() {
	if ($('#minuteProgress').progressbar('option', 'value') == 99) $('#minuteProgress').progressbar({ 'value': 1});
	$('#minuteProgress').progressbar({
		'value': $('#minuteProgress').progressbar('option', 'value') + 1
	});
}

$(document).ready(function() {
	$('#doSayHelloAlert').click(sayHelloAlert);
	$('#doSayHelloDialog').click(sayHelloDialog);
	$('#doBasicAnimationDemo').click(basicAnimationDemo);
	$('#doBetterAnimationDemo').click(betterAnimationDemo);

	$('#minuteProgress').progressbar();
	setInterval(advanceProgressBar, 100);

	$('#accordionDemo').accordion();
	
	$('#tabDemo').tabs();
	
	$('#dateDemo').datepicker({ 'maxDate': '+4m'});
	
	$('#treeDemo').simpleTree({
		autoclose: true,
		afterClick: function(node) {
			alert($('span:first',node).parent().attr('id') + " was clicked.");
		},
		animate: true,
		drag: false
	});

	$('#simpleTip1').simpletip({
		content: 'A basic tooltip.',
		fixed: false
	});

	$('#simpleTip2').simpletip({
		content: $('#simpleTip2Content').html(),
		fixed: true,
		position: ['100', '0']
	});

	$('#simpleTip3').simpletip({
		content: 'Some content to animate',
		hideEffect: 'slide',
		showEffect: 'custom',
		showCustom: function() {
			$(this).css({
				display: 'block',
				fontSize: '0.3em',
				color: '#0000ff',
				backgroundColor: '#ffffff'
			});
			$(this).animate({
				color: '#ff0000',
				fontSize: '1em'
			}, 400);
		}
	});

	$('#uploadifyDemo').uploadify({
		'auto': true,
		'folder': 'tmp',
		'cancelImg': 'uploadify/cancel.png',
		'script': 'uploadify/uploadify.php',
		'uploader': 'uploadify/uploadify.swf',
		onComplete: function(evt, id, file, resp, data) {
			alert('The file "' + file['name'] + '" with size "' + file['size'] + '" was uploaded. (It will be deleted in a few minutes automatically.)' + "\n\nThe upload script returned: " + resp);
		}
	});
});
