request = require("request");
var url = 'http://www.xiaomi.com';

request({ url: url, followRedirect: false }, function (err, res, body) {
  console.log(res.headers.location);
});
