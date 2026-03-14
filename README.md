# YOLO+LangChain多模态AI法律平台

## 项目概述

YOLO+LangChain多模态AI法律平台是一个结合计算机视觉和大语言模型的智能法律系统，基于Spring Boot 3.3.2和Java 17开发。该系统不仅提供完整的律师事务所业务管理功能，还集成了先进的AI技术，支持多模态交互、法律文档智能分析和自动法律建议生成。

### 技术栈

- **后端框架**: Spring Boot 3.3.2
- **Java版本**: Java 17
- **数据库**: MySQL + MongoDB
- **ORM框架**: MyBatis-Plus
- **认证授权**: JWT Token
- **AI技术**: LangChain4j + OpenAI + DashScope
- **多模态处理**: YOLO (目标检测)
- **文档解析**: Apache PDFBox
- **API文档**: SpringDoc OpenAPI + Knife4j
- **构建工具**: Maven
- **开发工具**: Spring Boot DevTools (热部署)
## 项目展示
---
![image](image/Pasted%20image%2020260314174532.png)
![image](image/Pasted%20image%2020260314174714.png)
![image](image/Pasted%20image%2020260314174737.png)


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
├── assistant/                        # AI助手
│   ├── LegalAssistant.java           # 法律AI助手
│   └── SeparateChatAssistant.java    # 独立聊天助手
├── config/                           # 配置类
│   ├── LegalAgentConfig.java         # 法律AI代理配置
│   ├── MybatisPlusConfig.java        # MyBatis-Plus配置
│   ├── SeparateChatAssistantConfig.java # 独立聊天助手配置
│   └── WebMvcConfiguration.java      # Web MVC配置
├── controller/                       # 控制器层
│   ├── AnnouncementController.java   # 公告管理
│   ├── AppointmentController.java    # 预约管理
│   ├── CaseController.java           # 案件管理
│   ├── ClientController.java         # 客户管理
│   ├── EmployeeController.java       # 员工管理
│   ├── ForumController.java          # 论坛管理
│   ├── LawyerController.java         # 律师管理
│   ├── LegalController.java          # 法律AI助手接口
│   ├── RecruitController.java        # 招聘管理
│   └── StatisticsController.java     # 统计分析
├── constant/                         # 常量
│   └── CaseConstant.java             # 案件常量
├── context/                          # 上下文
│   └── BaseContext.java              # 基础上下文
├── exception/                        # 异常处理
│   ├── BaseException.java            # 基础异常
│   ├── CommonException.java          # 通用异常
│   ├── EmployeeException.java        # 员工相关异常
│   └── UnauthorizedException.java    # 未授权异常
├── handler/                          # 异常处理器
│   └── GlobalExceptionHandler.java   # 全局异常处理
├── interceptor/                      # 拦截器
│   └── JWTEmployeeInterceptor.java   # JWT员工拦截器
├── mapper/                           # 数据访问层
│   ├── AnnouncementMapper.java
│   ├── AppointmentMapper.java
│   ├── BillMapper.java
│   ├── CaseMapper.java
│   ├── ClientMapper.java
│   ├── EmployeeMapper.java
│   ├── ForumCategoriesMapper.java
│   ├── ForumCommentsMapper.java
│   ├── ForumPostsMapper.java
│   ├── LawyerMapper.java
│   ├── RecruitMapper.java
│   └── WageMapper.java
├── pojo/                             # 数据模型
│   ├── dto/                          # 数据传输对象
│   │   ├── AppointmentDto.java
│   │   ├── AppointmentPageQueryDto.java
│   │   ├── CaseDTO.java
│   │   ├── CasePageQueryDto.java
│   │   ├── CaseSearchDto.java
│   │   ├── ChatDto.java              # 聊天DTO
│   │   ├── ClientPageQueryDto.java
│   │   ├── ClientUpdateDto.java
│   │   ├── EmployeeLoginDto.java
│   │   ├── EmployeeRegisterDto.java
│   │   ├── ForumCommentDto.java
│   │   ├── ForumPostEditDto.java
│   │   ├── ForumPostsDto.java
│   │   └── PageQueryDto.java
│   ├── entity/                       # 实体类
│   │   ├── Announcement.java
│   │   ├── Appointment.java
│   │   ├── Bill.java
│   │   ├── Case.java
│   │   ├── ChatMessages.java         # 聊天消息实体
│   │   ├── Client.java
│   │   ├── Employee.java
│   │   ├── ForumCategories.java
│   │   ├── ForumComments.java
│   │   ├── ForumPosts.java
│   │   ├── Lawyer.java
│   │   ├── Recruit.java
│   │   └── Wage.java
│   └── vo/                           # 视图对象
│       ├── CaseCategoryStatisticsVO.java
│       ├── CaseStatisticVO.java
│       ├── EmployeeLoginVo.java
│       ├── ForumPostsVO.java
│       └── LawyerCaseCountVO.java
├── property/                         # 配置属性
│   └── JwtProperties.java            # JWT配置属性
├── result/                           # 统一返回结果
│   ├── PageResult.java               # 分页结果
│   └── Result.java                   # 通用结果
├── service/                          # 服务层
│   ├── impl/                         # 服务实现
│   │   ├── AnnouncementServiceImpl.java
│   │   ├── AppointmentServiceImpl.java
│   │   ├── BillServiceImpl.java
│   │   ├── CaseServiceImpl.java
│   │   ├── ClientServiceImpl.java
│   │   ├── EmployeeServiceImpl.java
│   │   ├── ForumCategoriesServiceImpl.java
│   │   ├── ForumCommentsServiceImpl.java
│   │   ├── ForumPostsServiceImpl.java
│   │   ├── LawyerServiceImpl.java
│   │   ├── RecruitServiceImpl.java
│   │   └── WageServiceImpl.java
│   ├── AnnouncementService.java
│   ├── AppointmentService.java
│   ├── BillService.java
│   ├── CaseService.java
│   ├── ClientService.java
│   ├── EmployeeService.java
│   ├── ForumCategoriesService.java
│   ├── ForumCommentsService.java
│   ├── ForumPostsService.java
│   ├── LawyerService.java
│   ├── RecruitService.java
│   └── WageService.java
├── store/                            # 存储
│   └── MongoChatMemoryStore.java     # MongoDB聊天记录存储
├── utils/                            # 工具类
│   ├── CalculatorTools.java          # 计算工具
│   └── JwtUtil.java                  # JWT工具类
└── resources/                        # 资源文件
    ├── legal/                        # 法律文档
    │   └── Constitution.pdf          # 宪法文件
    ├── application-dev.yml           # 开发环境配置
    ├── application.yml               # 主配置文件
    └── legal-prompt-template.txt     # 法律提示模板
```

## 核心功能模块

### 1. 智能法律助手模块
- **AI法律咨询**: 基于LangChain4j的法律智能问答
- **多模态交互**: 集成YOLO实现图像识别和分析
- **法律文档检索**: 基于RAG技术的法律文档智能查询
- **实时流式回复**: 提供流畅的AI对话体验
- **上下文记忆**: 基于MongoDB的聊天记录存储

### 2. 员工管理模块
- 员工登录/注册
- 员工信息管理
- 权限控制
- JWT认证

### 3. 案件管理模块
- 案件增删改查
- 案件分类管理（刑事、民事、行政等）
- 案件状态跟踪
- 案件搜索过滤
- 案件统计分析

### 4. 客户管理模块
- 客户信息管理
- 客户案件关联
- 客户预约管理

### 5. 律师管理模块
- 律师信息管理
- 律师业务领域
- 律师费用管理
- 律师状态管理

### 6. 论坛交流模块
- 论坛帖子管理
- 评论功能
- 分类管理
- 点赞浏览统计

### 7. 公告管理模块
- 公告发布
- 公告查看
- 点赞浏览统计

### 8. 财务模块
- 账单管理
- 工资管理
- 费用统计

### 9. 统计分析模块
- 案件分类统计
- 律师案件数量统计
- 业务数据可视化

## 数据库配置

### MySQL数据库连接
```yaml
spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/law_system
      username: root
      password: 123456
```

### MongoDB配置
```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/law_system
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

### AI配置
```yaml
langchain4j:
  open-ai:
    chat-model:
      api-key: your-openai-api-key
  dashscope:
    chat-model:
      api-key: your-dashscope-api-key
      model-name: qwen-plus
```

## API接口文档

项目集成了SpringDoc OpenAPI和Knife4j，提供完整的API文档：

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API文档**: http://localhost:8080/v3/api-docs
- **Knife4j增强**: http://localhost:8080/doc.html

### 主要API端点

#### AI法律助手接口
- `POST /legal/chat` - AI法律聊天
- `POST /legal/multimodal` - 多模态法律分析（支持图像）

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

#### 统计相关接口
- `GET /statistics/case-category` - 案件分类统计
- `GET /statistics/lawyer-case-count` - 律师案件数量统计

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

### AI安全配置
- API密钥加密存储
- 聊天内容脱敏处理
- 访问权限控制

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 5.7+
- MongoDB 4.0+
- OpenAI API密钥或阿里云DashScope API密钥

### 安装步骤

1. **克隆项目**
```bash
git clone <repository-url>
cd law_system
```

2. **数据库配置**
```sql
-- 创建MySQL数据库
CREATE DATABASE law_system CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 导入数据库表结构
mysql -u root -p law_system < src/main/resources/law_system.sql
```

3. **修改配置文件**
- 编辑 `src/main/resources/application.yml`，更新数据库连接信息
- 配置OpenAI或DashScope API密钥

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
- AI法律助手：通过 `/legal/chat` 接口访问

### 法律文档配置
- 将法律文档放入 `src/main/resources/legal/` 目录
- 系统会自动解析PDF文档并构建向量索引

## 开发特性

### 热部署支持
项目集成了Spring Boot DevTools，支持代码热更新。

### 统一异常处理
全局异常处理器统一处理业务异常，返回标准格式的错误信息。

### 分页查询
使用MyBatis-Plus和PageHelper实现统一的分页查询功能。

### 日志记录
通过AOP实现方法级别的日志记录，便于调试和监控。

### AI集成特性
- **RAG技术**: 检索增强生成，提高法律回答准确性
- **多模态支持**: 集成YOLO实现图像识别和分析
- **流式响应**: 提供实时的AI对话体验
- **向量存储**: 高效的法律文档检索
- **上下文管理**: 基于MongoDB的聊天记忆

### 法律文档处理
- **PDF解析**: 支持法律文档自动解析
- **智能索引**: 自动构建法律文档向量索引
- **语义搜索**: 基于嵌入向量的语义搜索

### 性能优化
- **缓存机制**: 提高频繁访问数据的响应速度
- **异步处理**: 非阻塞式API设计
- **连接池优化**: 数据库连接池配置优化

## 实体关系说明

### 核心实体关系
- **案件(Case)** 与 **客户(Client)**：多对一关系
- **案件(Case)** 与 **律师(Lawyer)**：多对一关系  
- **员工(Employee)** 与 **律师(Lawyer)**：管理关系
- **论坛帖子(ForumPosts)** 与 **论坛分类(ForumCategories)**：多对一关系
- **账单(Bill)** 与 **客户(Client)**：多对一关系
- **工资(Wage)** 与 **员工(Employee)**：多对一关系
- **聊天消息(ChatMessages)** 与 **用户**：多对一关系

### AI数据流向
1. 用户输入 → 多模态处理（YOLO）→ 文本转换
2. 文本输入 → LangChain4j → 法律文档检索（RAG）
3. 检索结果 + 上下文 → 大语言模型 → 法律建议
4. 回复结果 → 流式返回给用户
5. 聊天记录 → MongoDB存储

## 注意事项

1. **数据库要求**：项目同时使用MySQL和MongoDB，请确保两者服务正常运行
2. **端口配置**：默认端口为8080，可在配置文件中修改
3. **JWT令牌**：有效期为2小时，过期后需要重新登录
4. **密码安全**：采用正则表达式验证，确保安全性
5. **API密钥**：请妥善保管OpenAI或DashScope API密钥
6. **法律文档**：首次启动时会自动解析法律文档，可能需要较长时间
7. **性能优化**：对于大量法律文档，建议增加服务器内存
8. **模型选择**：根据实际需求选择合适的AI模型（OpenAI或DashScope）
9. **权限控制**：AI法律助手接口需要员工登录认证
10. **数据备份**：定期备份MySQL和MongoDB数据

## 多模态功能说明

### YOLO集成
- **图像识别**：支持识别法律文档、证件等图像内容
- **物体检测**：可检测图像中的关键信息和物体
- **OCR功能**：将图像中的文字转换为可编辑文本

### 多模态交互流程
1. 用户上传图像（如合同、证件等）
2. YOLO模型识别图像内容
3. 生成文本提取文本信息处理图像分析
4. 处理
-  多模态处理后的结果 处理后的结果 处理
4. 结合AI模型分析处理后的结果
4. AI模型分析结果
4. 系统分析结果并生成法律建议
5. 系统返回智能法律建议

### 应用场景
- **合同审查**：上传合同图像快速分析合同条款
- **证据分析**：分析案件相关证据图片
- **身份验证**：识别身份证件和法律文件
- **现场取证**：分析现场照片和视频证据

## 许可证

本项目采用开源许可证，具体信息请查看LICENSE文件。

## 联系方式

如有问题或建议，请联系项目维护者。

---

*最后更新：2026-02-13*

## 联系方式

如有问题或建议，请联系项目维护者。

---

*最后更新：2025年2月3日*