# 项目名称
编程试题评测助手 COJ

# 目录

- [项目介绍](#项目介绍)
- [界面展示](#界面展示)
- [项目架构](#项目架构)
- [技术选型](#技术选型)
- [项目部署](#项目部署)

# 项目介绍


编程试题评测助手 COJ 是一款基于 Spring Boot + Spring Cloud Alibaba + Docker 架构的微服务项目，不同于传统拘泥于增删改查的管理系统，COJ 基于 Docker 虚拟化技术，使用多种设计模式自主开发出安全可靠、能够复用的代码沙箱服务，项目功能大致如下：<br>

* 在系统前台，仅管理员可以创建、管理题目；用户可自由搜索题目、阅读题目、编写并提交代码
* 在系统后台，能够根据管理员设定的题目测试用例在代码沙箱中对代码进行编译、运行、判断输出是否正确
* 代码沙箱可以作为独立服务提供给开发者使用

> 题目模块

* 创建题目（仅管理员）
* 删除题目（仅管理员）
* 修改题目（仅管理员）
* 搜索题目（全部用户）
* 在线做题（全部用户）
* 提交题目代码（全部用户）

> 用户模块

* 注册功能
* 登录功能

> 判题模块

* 提交判题（结果正确与否）
* 错误处理（内存溢出、安全性、是否超时）
* 自主实现 **代码沙箱**（安全沙箱）
* 开放接口（对外服务）

# 界面展示
> 题目搜索页面

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-01.png)

> 在线答题页面（支持代码编辑器、代码高亮）

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-02.png)

> 题目提交页面

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-03.png)

> 创建题目页面（包含Markdown富文本编辑器、动态增删测试用例）

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-04.png)

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-05.png)![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-05.png)

# 项目架构

> 项目架构图

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-21.png)


> 业务流程图 

![](https://cyan-images.oss-cn-shanghai.aliyuncs.com/images/docs-oj-06.png)


# 技术选型

> 前端

* Vue3
* Vue-CLI 脚手架
* Vuex 状态管理
* Arco Design 组件库
* 前端工程化：ESLint + Prettier + TypeScript
* 前端项目模板（通用布局、权限管理、状态管理、菜单生成）
* Markdown 富文本编辑器
* Monaco Editor 代码编辑器
* Open API 前端代码生成

> 后端

* Java Spring Cloud + Spring Cloud Alibaba 微服务
  * Nacos 注册中心
  * OpenFeign 客户端调用
  * Gateway 网关
  * 聚合接口文档 

* Java Spring Boot
* Java 进程控制
* Java 安全管理器
* Docker 代码沙箱实现 
* 虚拟机 + 远程开发
* MySQL 数据库

* MyBatis-Plus 及 MyBatis X 自动生成
* Redis 分布式 Session
* RabbitMQ 消息队列
* 多种设计模式：策略模式、工厂模式、代理模式、模板方法模式




# 项目部署


> Docker  Compose

[Docker  Compose](https://cyanzzy.github.io/2023/07/20/%E4%BC%81%E4%B8%9A%E5%BC%80%E5%8F%91%E8%BF%9B%E9%98%B6-5-DockerAdvance/#Docker-Compose-%E5%AE%B9%E5%99%A8%E7%BC%96%E6%8E%92
) 通常适用于把所有微服务部署在同一台服务器的场景，真实企业级项目中往往使用 K8S 等更专业的容器编排和自动化部署工具，更方便地在多个服务器上部署容器

## 本地部署

1. 梳理服务部署表格
2. Maven 子父模块打包
3. Dockerfile 编写
4. 编写环境依赖配置
5. 编写服务配置
6. 调整程序配置
7. 测试访问



本地执行  Docker Compose，启动环境依赖，包括 MySQL、Redis、RabbitMQ、Nacos 服务，<br>

执行 Docker Compose 启动业务服务。访问聚合文档，依次调用用户注册--登录--获取登录用户信息--创建题目接口，查看是否运行成功。


## 服务器部署

### 准备服务器
自行准备阿里云服务器。

### Docker Compose 安装

自行安装 Docker Compose <br>

Docker Compose V2 地址：https://docs.docker.com/compose/migrate/  <br>

Docker Compose Linux 安装：https://docs.docker.com/compose/install/linux/#install-using-the-repository  <br>

### 同步文件

将本地的微服务项目源码同步到服务器中。

### 获取 jar 包

服务器安装 maven，在服务器上打包。

### 服务启动

>启动环境依赖

以后台方式启动环境依赖：

```shell
docker compose -f docker-compose.env.yml up -d
```

> 启动业务服务

```shell
docker compose -f docker-compose.service.yml up
```

如果要单独重新启动某服务，比如网关服务：

```shell
docker compose -f docker-compose.service.yml up coj-backend-gateway
```

### 测试访问

访问线上网关接口文档，依次调用用户注册--登录--获取登录的用户消息--创建题目