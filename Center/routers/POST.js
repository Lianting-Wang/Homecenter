var querystring = require('querystring');
var util = require('util');

function basic(post) {
	const data = JSON.parse(post);
	if (data['auth']=='111') {
		return '密钥正确';
	}
	return '密钥错误';
}

exports.basic = basic;