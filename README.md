# 斗鱼弹幕中转客户端

* 窗体直接用的Swing；
* Netty框架实现基本功能；
* 由于斗鱼弹幕服务器只接收数字房间ID，所以对于个性ID的房间名，需通过官方api查询，相关内容在json目录下；
* util目录下的Formatter中完成decode功能，若协议更新，请修改相关代码。

***
[服务端请点击这里](https://github.com/tlinjia/DyTransitServer)
