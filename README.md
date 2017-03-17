# 斗鱼弹幕中转客户端

* 窗体直接用的Swing；
* Netty框架实现基本功能；
* 由于斗鱼弹幕服务器只接收数字房间ID，所以对于个性ID的房间名，需通过官方api查询，相关内容在json目录下；
* util目录下的Formatter中完成decode功能，若协议更新，请修改相关代码。
***
# 演示
##  连接服务器
![connect](https://github.com/tlinjia/Pictures/blob/master/TransitClient/%E8%BF%9E%E6%8E%A5%E6%9C%8D%E5%8A%A1%E5%99%A8.jpg)
## 请求房间号
![room](https://github.com/tlinjia/Pictures/blob/master/TransitClient/%E6%88%BF%E9%97%B4%E5%8F%B7.jpg)
## 显示弹幕
![danmu](https://github.com/tlinjia/Pictures/blob/master/TransitClient/%E5%AE%9E%E6%97%B6%E5%BC%B9%E5%B9%95.jpg)
***
[服务端请点击这里](https://github.com/tlinjia/DyTransitServer)
