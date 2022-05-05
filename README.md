# seate-tcc
## 1 环境准备
* seate1.3.0  
* mysql5.7(sql初始化脚本：sql/tcc-samples.sql)  
* zookeeper-3.4.6
## 2 项目宏观业务
核心目的：seate tcc 模式探索应用。  
业务落地：实现两个用户互相转账业务。
## 3 子模块简介  
* tcc-samples-api(定义扣款和加款接口)  
* tcc-samples-provider(提供扣款和加款实现，并注册进zk中)  
* tcc-samples-business(从zk中远程调用扣款和加款实现，组成转账逻辑) 
## 4 启动步骤
**step1**  
本地安装seate,mysql,zk 并启动  
**step2**  
创建数据库，并执行sql脚本，完成表创建  
**step3**  
首先启动tcc-samples-provider，再启动tcc-samples-business  
**step4**   
测试提交：get 127.0.0.1:8080/tansfer  
测试回滚：get 127.0.0.1:8080/rollback