const WebSocket = require('ws');
const WebSocketServer = WebSocket.Server;
const server = require("./server");
const PORT = 3001;

function start() {
	const wss = new WebSocketServer({
		clientTracking: true,
		port: PORT
	});
	wss.on('connection', function (ws) {
		ws.send('Wellcome');
		ws.on('message', function (message) {
			const request = JSON.parse(message);
			if (request['auth']==process.env.API_AUTH
				&& new Date() - new Date(request['time']) <= 25) {
				wss.broadcast(request['code']);
			}
		});
	});
	wss.broadcast = function (data) {
		wss.clients.forEach(function (client) {
			client.send(data);
		});
	};
	console.log('WebSocket is running at http://127.0.0.1:'+PORT+'/');
}

function callback(request) {
	const callbackws = new WebSocket('ws://127.0.0.1:'+PORT);
	callbackws.on('message', (message) => {
		if (message=='Wellcome') {
			callbackws.send(JSON.stringify(request));
		}
		callbackws.close();
	});
}

exports.start = start;
exports.callback = callback;