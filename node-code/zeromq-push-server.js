var zmq = require('zmq')
  , sock = zmq.socket('push');

sock.bind('tcp://0.0.0.0:4242',function(){
  // 间隔 1s 向 pull client 发送一次消息
  setInterval(function(){
    sock.send('pong');
  },1000);
});
