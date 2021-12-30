var fs = require("fs");
var util = require('util');
var socket = require("../socket");

function basic(post) {
	const data = JSON.parse(post);
	if (data['auth']==process.env.API_AUTH) {
		const requests = {
			"time": new Date(),
			"code": data['code'],
			"request": data['request']
		};
		const strRequest = JSON.stringify(requests) + '\r\n';
		const mode = {
			"encoding": "utf8",
			"mode": "0666",
			"flag": 'a'
		}
		try {
			fs.writeFileSync('requests.txt', strRequest, mode);
		} catch (error) {
			console.error(err);
		}
		return socket.callback(requests);
	}
	return '密钥错误';
}

exports.basic = basic;