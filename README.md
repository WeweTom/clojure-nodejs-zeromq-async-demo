# clojure Node.js messaging through zeromq-async 

Clojure receive message from Node.js through Zeromq —— RPC is possible !

## NOTE

1. make sure you have Node.js and npm installed
2. this is a lein project, be sure you have lein installed

## Usage

1. git clone https://github.com/WeweTom/clojure-nodejs-zeromq-async-demo.git
2. cd node-code
3. npm install                # Node.js deps
4. node zeromq-push-server.js # 1. now you have setup a ZeroMQ push server
5. node zeromq-pull-client.js # 2. now you have setup a ZeroMQ pull client , you
   will get messages in terminal
6. cd ../                     # now in the lein project root
7. lein repl                  # after some deps installed , the repl launched
8. (start-clj-pull-client)    # 3. in lein repl excute the function, now setup a
   ZeroMQ pull client in Clojure !!

![code](https://lh6.googleusercontent.com/-mVwhRUcYzZo/U-NZ68zJNTI/AAAAAAAAC9k/_zzHWJBFEQA/w1422-h1424-no/clj_zmq_node.png)

![demo](https://lh6.googleusercontent.com/-V_Fjwl66P-g/U-NZ67H9YNI/AAAAAAAAC9w/j6EgFfAF9Yo/w1412-h1424-no/clj_zmq_term.png)

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
