(ns clj-zeromq-async.core)
;; com.keminglabs.zmq-async.core 使用 core.async 做了一层 200 line 的 zeromq
;; channel 包装 —— thread safe !
(require '[com.keminglabs.zmq-async.core :refer [register-socket!]]
         '[clojure.core.async :refer [>! <! go chan sliding-buffer close!]])

(defn start-clj-pull-client
  []
  (let [;; zeromq-push-server.js 会监听这个 tcp 端口
        addr "tcp://0.0.0.0:4242" 
        ;; 将 s-in s-out c-in c-out 绑定到 4 个 chan 上 : repeatedly 4 用于产生
        ;; 4 个 chan
        [s-in s-out c-in c-out] (repeatedly 4 #(chan (sliding-buffer 64)))]
    
    ;; pull client : 从 Node.js 创建的 push 服务器 pull 信息
    (register-socket! {:out c-out :socket-type :pull
                       :configurator (fn [socket] (.connect socket addr))})
    (go (loop [] ;; 循环获取 来自
          (println (String. (<! c-out)))
          (recur)))))
