'use strict';
const server = require("./server");
const socket = require("./socket");
const routers = require("./routers/routers");

server.start(routers);
socket.start();