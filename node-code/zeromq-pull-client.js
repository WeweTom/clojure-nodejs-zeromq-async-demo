var zmq = require('zmq')
  , sock = zmq.socket('pull');

sock.connect('tcp://0.0.0.0:4242');

console.log('connected :4242');

sock.on('message', function(msg){
  console.log(msg.toString());
});
