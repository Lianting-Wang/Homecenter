var http = require('http');

function start(routers) {
	var server = http.createServer(function (request, response) {
		console.log(request.method + ': ' + request.url);
		var responding;
		switch(request.method) {
			case 'GET':
				response.writeHead(200, {'Content-Type': 'text/html'});
				response.end(routers.test.test(request.url));
				break;
			case 'POST': 
				var post = '';
				request.on('data', function(chunk){post += chunk});
				request.on('end', ()=> {
					response.writeHead(200, {'Content-Type': 'text/html'});
					response.end(routers.POST.basic(post));
				});
				break;
		}
	});

	server.listen(3000);
	console.log('Server is running at http://127.0.0.1:3000/');
}

exports.start = start;