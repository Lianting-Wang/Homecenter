'use strict';
var server = require("./server");
var routers = require("./routers/routers");

server.start(routers);