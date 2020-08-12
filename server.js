var http = require('http');
var str = 'Hello World \x00\x00\x00\xe6\x71\x01\x00\x90\x87\x00'
var str2 = str + str + str + str
http.createServer(function (request, response) {

    // 发送 HTTP 头部 
    // HTTP 状态值: 200 : OK
    // 内容类型: text/plain
    response.writeHead(200, {'Content-Type': 'text/plain;charset=x-user-defined'});

    // 发送响应数据 "Hello World"
    response.end(str2);
}).listen(8888);
console.log(str2)
console.log(str2.length)
// 终端打印如下信息
console.log('Server running at http://127.0.0.1:8888/');
