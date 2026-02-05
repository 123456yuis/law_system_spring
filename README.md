# 律师事务所管理系统 (Law System)

## 项目概述

律师事务所管理系统是一个基于Spring Boot 3.3.2和Java 17开发的企业级法律业务管理系统。该系统提供了完整的律师事务所业务管理功能，包括案件管理、客户管理、律师管理、员工管理、论坛交流等模块。

### 技术栈

- **后端框架**: Spring Boot 3.3.2
- **Java版本**: Java 17
- **数据库**: MySQL
- **ORM框架**: MyBatis-Plus
- **认证授权**: JWT Token
- **API文档**: SpringDoc OpenAPI + Knife4j
- **构建工具**: Maven
- **开发工具**: Spring Boot DevTools (热部署)

## 项目结构

```
src/main/java/com/ylsf/grk/law_system/
├── LawSystemApplication.java          # 应用启动类
├── annotation/                        # 自定义注解
│   ├── CaseSearchFilter.java         # 案件搜索过滤注解
│   └── Log.java                      # 日志记录注解
├── aspect/                           # AOP切面
│   ├── CaseSearchFilterAspect.java   # 案件搜索过滤切面
│   └── LogAspect.java                # 日志记录切面
├── config/                           # 配置类
│   ├── MybatisPlusConfig.java        # MyBatis-Plus配置
│   └── WebMvcConfiguration.java      # Web MVC配置
├── controller/                       # 控制器层
│   ├── AnnouncementController.java   # 公告管理
│   ├── CaseController.java           # 案件管理
│   ├── ClientController.java         # 客户管理
│   ├── EmployeeController.java       # 员工管理
│   ├── ForumController.java          # 论坛管理
│   └── LawyerController.java         # 律师管理
├── entity/                           # 实体类
│   ├── Announcement.java             # 公告实体
│   ├── Appointment.java              # 预约实体
│   ├── Bill.java                     # 账单实体
│   ├── Case.java                     # 案件实体
│   ├── Client.java                   # 客户实体
│   ├── Comment.java                  # 评论实体
│   ├── Employee.java                 # 员工实体
│   ├── ForumCategories.java          # 论坛分类实体
│   ├── ForumPosts.java               # 论坛帖子实体
│   ├── Lawyer.java                   # 律师实体
│   ├── Recruit.java                  # 招聘实体
│   └── Wage.java                     # 工资实体
├── service/                          # 服务层接口
│   ├── AnnouncementService.java
│   ├── CaseService.java
│   ├── ClientService.java
│   ├── EmployeeService.java
│   ├── ForumCategoriesService.java
│   ├── ForumPostsService.java
│   └── LawyerService.java
├── service/impl/                     # 服务层实现
│   ├── AnnouncementServiceImpl.java
│   ├── CaseServiceImpl.java
│   ├── ClientServiceImpl.java
│   ├── EmployeeServiceImpl.java
│   ├── ForumCategoriesServiceImpl.java
│   ├── ForumPostsServiceImpl.java
│   └── LawyerServiceImpl.java
├── mapper/                           # 数据访问层
│   ├── AnnouncementMapper.java
│   ├── CaseMapper.java
│   ├── ClientMapper.java
│   ├── EmployeeMapper.java
│   ├── ForumCategoriesMapper.java
│   ├── ForumPostsMapper.java
│   └── LawyerMapper.java
├── dto/                              # 数据传输对象
│   ├── CaseDTO.java                  # 案件DTO
│   ├── CasePageQueryDto.java         # 案件分页查询DTO
│   ├── CaseSearchDto.java            # 案件搜索DTO
│   ├── ClientPageQueryDto.java       # 客户分页查询DTO
│   ├── EmployeeLoginDto.java         # 员工登录DTO
│   ├── EmployeeRegisterDto.java      # 员工注册DTO
│   ├── ForumPostEditDto.java         # 论坛帖子编辑DTO
│   └── PageQueryDto.java             # 通用分页查询DTO
├── vo/                               # 视图对象
│   ├── CaseStatisticVO.java          # 案件统计VO
│   ├── EmployeeLoginVo.java          # 员工登录VO
│   └── ForumPostsVO.java             # 论坛帖子VO
├── result/                           # 统一返回结果
│   ├── PageResult.java               # 分页结果
│   └── Result.java                   # 通用结果
├── exception/                        # 异常处理
│   ├── BaseException.java            # 基础异常
│   ├── CommonException.java          # 通用异常
│   ├── EmployeeException.java        # 员工相关异常
│   └── UnauthorizedException.java    # 未授权异常
├── handler/                          # 异常处理器
│   └── GlobalExceptionHandler.java   # 全局异常处理
├── interceptor/                      # 拦截器
│   └── JWTEmployeeInterceptor.java   # JWT员工拦截器
├── context/                          # 上下文
│   └── BaseContext.java              # 基础上下文
├── property/                         # 配置属性
│   └── JwtProperties.java            # JWT配置属性
└── utils/                            # 工具类
    └── JwtUtil.java                  # JWT工具类
```

## 核心功能模块

### 1. 员工管理模块
- 员工登录/注册
- 员工信息管理
- 权限控制
- JWT认证

### 2. 案件管理模块
- 案件增删改查
- 案件分类管理（刑事、民事、行政等）
- 案件状态跟踪
- 案件搜索过滤
- 案件统计

### 3. 客户管理模块
- 客户信息管理
- 客户案件关联
- 客户预约管理

### 4. 律师管理模块
- 律师信息管理
- 律师业务领域
- 律师费用管理
- 律师状态管理

### 5. 论坛交流模块
- 论坛帖子管理
- 评论功能
- 分类管理
- 点赞浏览统计

### 6. 公告管理模块
- 公告发布
- 公告查看
- 点赞浏览统计

### 7. 财务模块
- 账单管理
- 工资管理
- 费用统计

## 数据库配置

### 数据库连接
```yaml
spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/law_system
      username: root
      password: 123456
```

### MyBatis-Plus配置
```yaml
mybatis-plus:
  type-aliases-package: com.ylsf.grk.law_system.pojo.entity
  mapper-locations: classpath:mapper/*.xml
  global-config:
    id-type: 0  # 数据库ID自增
    field-strategy: 2  # 非空判断
    db-column-underline: true  # 驼峰下划线转换
```

## API接口文档

项目集成了SpringDoc OpenAPI和Knife4j，提供完整的API文档：

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API文档**: http://localhost:8080/v3/api-docs
- **Knife4j增强**: http://localhost:8080/doc.html

### 主要API端点

#### 员工相关接口
- `POST /employee/login` - 员工登录
- `POST /employee/register` - 员工注册
- `GET /employee/info` - 获取员工信息

#### 案件相关接口
- `GET /case/page` - 分页查询案件
- `POST /case` - 新增案件
- `PUT /case` - 修改案件
- `DELETE /case/{id}` - 删除案件
- `GET /case/search` - 搜索案件

#### 律师相关接口
- `GET /lawyer/page` - 分页查询律师
- `POST /lawyer` - 新增律师
- `PUT /lawyer` - 修改律师
- `DELETE /lawyer/{id}` - 删除律师

## 安全认证

### JWT配置
```yaml
law:
  jwt:
    employee-secret-key: cereshuzhitingnizhenbangcereshuzhitingnizhenbang
    employee-ttl: 7200000  # 2小时
    employee-token-name: token
```

### 密码验证规则
- 用户名：5-10位字母数字组合
- 密码：6-15位非空字符（支持特殊字符）

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 5.7+

### 安装步骤

1. **克隆项目**
```bash
git clone <repository-url>
cd law_system
```

2. **数据库配置**
```sql
CREATE DATABASE law_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **修改配置文件**
编辑 `src/main/resources/application.yml`，更新数据库连接信息。

4. **构建项目**
```bash
mvn clean install
```

5. **运行项目**
```bash
mvn spring-boot:run
```

6. **访问应用**
- 应用地址：http://localhost:8080
- API文档：http://localhost:8080/swagger-ui.html

## 开发特性

### 热部署支持
项目集成了Spring Boot DevTools，支持代码热更新。

### 统一异常处理
全局异常处理器统一处理业务异常，返回标准格式的错误信息。

### 分页查询
使用MyBatis-Plus和PageHelper实现统一的分页查询功能。

### 日志记录
通过AOP实现方法级别的日志记录，便于调试和监控。

## 实体关系说明

### 核心实体关系
- **案件(Case)** 与 **客户(Client)**：多对一关系
- **案件(Case)** 与 **律师(Lawyer)**：多对一关系  
- **员工(Employee)** 与 **律师(Lawyer)**：管理关系
- **论坛帖子(ForumPosts)** 与 **论坛分类(ForumCategories)**：多对一关系
- **账单(Bill)** 与 **客户(Client)**：多对一关系
- **工资(Wage)** 与 **员工(Employee)**：多对一关系

## 注意事项

1. 项目使用MySQL数据库，请确保数据库服务正常运行
2. 默认端口为8080，可在配置文件中修改
3. JWT令牌有效期为2小时，过期后需要重新登录
4. 密码采用正则表达式验证，确保安全性
5. 项目使用MyBatis-Plus简化数据库操作

## 许可证

本项目采用开源许可证，具体信息请查看LICENSE文件。

## 联系方式

如有问题或建议，请联系项目维护者。

---

*最后更新：2025年2月3日*