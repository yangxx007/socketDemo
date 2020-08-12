const request = require('request')

request('http://127.0.0.1:8888', function (err, response, body) {

  /*
    response 响应信息的集合
  */

  if (!err && response.statusCode == 200) { 
    console.log(body)
    console.log(JSON.stringify(body))
  }
})
