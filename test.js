var request = require('sync-request');
var res = request('GET', 'http://127.0.0.1:8888');
console.log(res.body.toString())
console.log(res.headers)
console.log(res.body.toString().length);
console.log("test");
