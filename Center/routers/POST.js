const fs = require("fs");
const util = require('util');
const socket = require("../socket");
const as = require("../answears");

function basic(post) {
	const data = JSON.parse(post);
	if (data['auth']==process.env.API_AUTH) {
		const request = {
			"time": new Date(),
			"code": data['code'],
			"request": data['request'],
			"auth": process.env.API_AUTH
		};
		const strRequest = JSON.stringify(request) + '\r\n';
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
		socket.callback(request);
		return as.answears[request['code']];
	}
	return as.answears['000'];
}

exports.basic = basic;