Spring Boot应用中整合RabbitMQ，并实现一个简单的发送、接收消息的例子

##############################
linux中安装RabbitMQ，参考https://github.com/judasn/Linux-Tutorial

1、先安装Erlang(centos7，下同)
	RabbitMQ 官网提供 Erlang 安装包，下载地址：http://www.rabbitmq.com/releases/erlang/

2、安装RabbitMQ
	通过官方下载页面https://www.rabbitmq.com/download.html下载linux版本
	安装rpm -i rabbitmq-server-3.6.6-1.el7.noarch.rpm
	启动服务：
		先看下自己的主机名：hostname，我的主机名是：bogon
		先修改一下 host 文件：vim /etc/hosts，添加一行：127.0.0.1 bogon（必须这样做）
		启动：systemctl start rabbitmq-server
	配置：
		查找默认配置位置：find / -name "rabbitmq.config.example"，我这边搜索结果是：/usr/share/doc/rabbitmq-server-3.6.1/rabbitmq.config.example
		复制默认配置：cp /usr/share/doc/rabbitmq-server-3.6.1/rabbitmq.config.example /etc/rabbitmq/
		修改配置文件名：cd /etc/rabbitmq ; mv rabbitmq.config.example rabbitmq.config
		编辑配置文件，开启用户远程访问：vim rabbitmq.config
		在 64 行，默认有这样一句话：%% {loopback_users, []},，注意，该语句最后有一个逗号，等下是要去掉的
		我们需要改为：{loopback_users, []}
	开启 Web 界面管理：rabbitmq-plugins enable rabbitmq_management
	重启 RabbitMQ 服务：service rabbitmq-server restart
	浏览器访问：http://192.168.179.132:15672 默认管理员账号：guest 默认管理员密码：guest