<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">SVClub Iot </h1>

#### 前端代码地址
前端代码地址: [https://github.com/sv-zlf/SVClub-system-UI](https://github.com/sv-zlf/SVClub-system-UI)  


## 1.技术栈

本项目基于 [RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue?_from=gitee_search) 后台开发框架，感谢 [RuoYi-Vue](https://gitee.com/y_project/RuoYi-Vue?_from=gitee_search) 的开源。


| 技术栈 | 介绍 | 地址 |
|:-:|:-:|:-:|
| Vue | 渐进式 JavaScript 框架  |  https://cn.vuejs.org/  |
|  Vuex	|专为 Vue.js 应用程序开发的状态管理模式	|https://vuex.vuejs.org/zh/  |
|Vue Router|	Vue.js 官方的路由管理器|	https://router.vuejs.org/zh/
|Vue CLI	|基于 Vue.js 进行快速开发的完整系统	|https://cli.vuejs.org/zh/guide/
|Vant|	轻量、可靠的移动端 Vue 组件库	|https://vant-contrib.gitee.io/vant/#/zh-CN/
|Element-UI	|基于 Vue 2.0 的桌面端组件库|	https://element.eleme.io/#/zh-CN
|ES6|	JavaScript 语言的下一代标准|	https://es6.ruanyifeng.com/


 **后端技术栈** 
| 技术栈 | 介绍 | 地址 |
|:-:|:-:|:-:|
|Spring Boot	|快捷创建基于 Spring 的生产级应用程序|	https://spring.io/projects/spring-boot
|MyBatis-Plus|	MyBatis 增强工具	|https://mp.baomidou.com/
|MyBatis|	MyBatis 持久层框架	|https://mybatis.org/mybatis-3/zh/index.html
|JWT|	轻量级身份认证规范|	https://jwt.io/introduction
|RabbitMq|	基于AMQP协议的消息中间件 |	https://www.rabbitmq.com/
|Spring Security	|基于 Spring 的强大且高度可定制的身份验证和访问控制框架	|https://spring.io/projects/spring-security/


## 1.2 项目结构

**后端结构** 

```
com.ujs.iot     
├── config            // 工具类
│       └── GlobalResult                  // 返回数据定义配置
│       └── SwaggerConfig                 // Swagger-ui配置
├── controller         // 控制层
│       └── DeviceController              // 设备接口
│       └── LogController                 // 日志接口
│       └── ProductController             // 产品接口
├── entity            // 实体层
│       └── DeviceController             // 设备
        └── DeviceController             // 产品
        └── DeviceController            // 监听yunze-admin业务执行
├── mapper   // 数据持久层
├── mqttx      // mqtt-broker代理
├── service      // 服务层

```

**前端结构** 

```
├── build                      // 构建相关  
├── bin                        // 执行脚本
├── public                     // 公共文件
│   ├── favicon.ico            // favicon图标
│   └── index.html             // html模板
├── src                        // 源代码
│   ├── api                    // 所有请求
│   ├── assets                 // 主题 字体等静态资源
│   ├── components             // 全局公用组件
│   ├── directive              // 全局指令
│   ├── layout                 // 布局
│   ├── router                 // 路由
│   ├── store                  // 全局 store管理
│   ├── utils                  // 全局公用方法
│   ├── views                  // view
│   ├── App.vue                // 入口页面
│   ├── main.js                // 入口 加载组件 初始化等
│   ├── permission.js          // 权限管理
│   └── settings.js            // 系统配置
├── .editorconfig              // 编码格式
├── .env.development           // 开发环境配置
├── .env.production            // 生产环境配置
├── .env.staging               // 测试环境配置
├── .eslintignore              // 忽略语法检查
├── .eslintrc.js               // eslint 配置项
├── .gitignore                 // git 忽略项
├── babel.config.js            // babel.config.js
├── package.json               // package.json
└── vue.config.js              // vue.config.js
```

