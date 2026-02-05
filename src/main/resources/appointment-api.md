93336
根据预约功能接口写接口文档，方便前端对接​​
TRAE AI
我来为您创建详细的预约功能接口文档。基于已实现的预约接口，我将创建一个完整的API文档文件。


appointment-api.md
Apply
# 客户预约功能接口文档

## 概述

本文档描述了律所管理系统中客户预约功能的完整API接口，包括预约创建、查询、删除等操作。

## 基础信息

- **基础URL**: `http://localhost:8080/client`
- **认证方式**: 无需认证（可根据实际需求添加JWT认证）
- **数据格式**: JSON
- **字符编码**: UTF-8

## 接口列表

### 1. 创建客户预约

**接口说明**: 客户创建新的律师预约

**请求方式**: `POST`

**接口路径**: `/createAppointment`

**请求头**:
```
Content-Type: application/json
```

**请求参数**:

| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| clientId | Long | 是 | 客户ID | 1 |
| lawerId | Long | 是 | 律师ID | 1 |
| caseId | Long | 否 | 关联案件ID（可为null） | 7 |
| createTime | String | 否 | 预约时间（格式：yyyy-MM-ddTHH:mm:ss） | 2025-02-10T09:30:00 |

**请求示例**:
```json
{
  "clientId": 1,
  "lawerId": 1,
  "caseId": 7,
  "createTime": "2025-02-10T09:30:00"
}
```

**响应参数**:

| 参数名 | 类型 | 说明 |
|--------|------|------|
| code | Integer | 响应码（200成功，500失败） |
| msg | String | 响应消息 |
| data | Boolean | 操作结果 |

**成功响应示例**:
```json
{
  "code": 200,
  "msg": "success",
  "data": true
}
```

**失败响应示例**:
```json
{
  "code": 500,
  "msg": "预约创建失败",
  "data": null
}
```

### 2. 根据客户ID查询预约列表

**接口说明**: 查询指定客户的所有预约记录

**请求方式**: `GET`

**接口路径**: `/getAppointmentsByClientId/{clientId}`

**路径参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| clientId | Long | 是 | 客户ID |

**请求示例**:
```
GET /client/getAppointmentsByClientId/1
```

**响应参数**:

| 参数名 | 类型 | 说明 |
|--------|------|------|
| code | Integer | 响应码 |
| msg | String | 响应消息 |
| data | Array | 预约列表 |

**响应数据结构**:

| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | Long | 预约ID |
| clientId | Long | 客户ID |
| lawerId | Long | 律师ID |
| createTime | String | 预约时间 |
| caseId | Long | 关联案件ID |

**成功响应示例**:
```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "clientId": 1,
      "lawerId": 1,
      "createTime": "2025-02-10T09:30:00",
      "caseId": 7
    },
    {
      "id": 21,
      "clientId": 1,
      "lawerId": 1,
      "createTime": "2025-04-01T14:25:00",
      "caseId": 28
    }
  ]
}
```

### 3. 根据律师ID查询预约列表

**接口说明**: 查询指定律师的所有预约记录

**请求方式**: `GET`

**接口路径**: `/getAppointmentsByLawerId/{lawerId}`

**路径参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| lawerId | Long | 是 | 律师ID |

**请求示例**:
```
GET /client/getAppointmentsByLawerId/1
```

**响应示例**:
```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "clientId": 1,
      "lawerId": 1,
      "createTime": "2025-02-10T09:30:00",
      "caseId": 7
    },
    {
      "id": 21,
      "clientId": 21,
      "lawerId": 1,
      "createTime": "2025-04-01T14:25:00",
      "caseId": 28
    }
  ]
}
```

### 4. 根据预约ID查询预约详情

**接口说明**: 查询单个预约的详细信息

**请求方式**: `GET`

**接口路径**: `/getAppointmentById/{id}`

**路径参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| id | Long | 是 | 预约ID |

**请求示例**:
```
GET /client/getAppointmentById/1
```

**响应示例**:
```json
{
  "code": 200,
  "msg": "success",
  "data": {
    "id": 1,
    "clientId": 1,
    "lawerId": 1,
    "createTime": "2025-02-10T09:30:00",
    "caseId": 7
  }
}
```

### 5. 删除预约

**接口说明**: 删除指定的预约记录

**请求方式**: `DELETE`

**接口路径**: `/deleteAppointment/{id}`

**路径参数**:

| 参数名 | 类型 | 必填 | 说明 |
|--------|------|------|------|
| id | Long | 是 | 预约ID |

**请求示例**:
```
DELETE /client/deleteAppointment/1
```

**响应示例**:
```json
{
  "code": 200,
  "msg": "success",
  "data": true
}
```

## 数据模型

### AppointmentDTO（预约请求参数）
```java
{
  "clientId": Long,      // 客户ID
  "lawerId": Long,       // 律师ID
  "caseId": Long,        // 案件ID（可选）
  "createTime": String   // 预约时间（可选，默认当前时间）
}
```

### Appointment（预约实体）
```java
{
  "id": Long,            // 预约ID（自动生成）
  "clientId": Long,      // 客户ID
  "lawerId": Long,       // 律师ID
  "createTime": String,  // 预约时间
  "caseId": Long         // 关联案件ID
}
```

## 错误码说明

| 错误码 | 说明 | 处理建议 |
|--------|------|----------|
| 200 | 成功 | 操作成功 |
| 400 | 请求参数错误 | 检查请求参数格式和必填项 |
| 500 | 服务器内部错误 | 联系系统管理员 |

## 使用注意事项

1. **时间格式**: 所有时间字段使用ISO 8601格式：`yyyy-MM-ddTHH:mm:ss`
2. **ID验证**: 创建预约前请确保clientId和lawerId存在
3. **数据关联**: caseId为可选字段，可为null
4. **时间默认**: 如不指定createTime，系统将使用当前时间
5. **权限控制**: 实际使用时可根据需要添加权限验证

## 前端调用示例

### JavaScript/TypeScript示例
```javascript
// 创建预约
async function createAppointment(appointmentData) {
  try {
    const response = await fetch('/client/createAppointment', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(appointmentData)
    });
    const result = await response.json();
    return result;
  } catch (error) {
    console.error('创建预约失败:', error);
  }
}
 
// 查询客户预约
async function getClientAppointments(clientId) {
  try {
    const response = await fetch(`/client/getAppointmentsByClientId/${clientId}`);
    const result = await response.json();
    return result;
  } catch (error) {
    console.error('查询预约失败:', error);
  }
}
```

### Vue.js示例
```javascript
export default {
  methods: {
    async createAppointment() {
      const appointmentData = {
        clientId: this.clientId,
        lawerId: this.lawerId,
        caseId: this.caseId,
        createTime: this.selectedTime
      };
      
      const result = await this.$http.post('/client/createAppointment', appointmentData);
      if (result.code === 200) {
        this.$message.success('预约创建成功');
      } else {
        this.$message.error(result.msg);
      }
    }
  }
}
```

## 数据库表结构参考

```sql
CREATE TABLE `appointment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约单号',
  `client_id` bigint NULL DEFAULT NULL COMMENT '客户id',
  `lawer_id` bigint NULL DEFAULT NULL COMMENT '律师id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '预约时间',
  `case_id` bigint NULL DEFAULT NULL COMMENT '预约案件id',
  PRIMARY KEY (`id`)
);
```

## 更新日志

- **v1.0** (2026-02-05): 初始版本，包含基本预约功能
- 创建预约
- 查询预约列表
- 查询预约详情
- 删除预约
  我已经为您创建了完整的预约功能接口文档。这个文档包含了以下内容：

📋 接口文档概览
1. 完整的API接口说明
   创建客户预约 (POST /createAppointment)
   查询客户预约列表 (GET /getAppointmentsByClientId/{clientId})
   查询律师预约列表 (GET /getAppointmentsByLawerId/{lawerId})
   查询预约详情 (GET /getAppointmentById/{id})
   删除预约 (DELETE /deleteAppointment/{id})
2. 详细的参数说明
   每个接口的请求参数、响应参数
   数据类型、是否必填、示例值
   完整的请求响应示例
3. 前端对接指南
   JavaScript/TypeScript调用示例
   Vue.js调用示例
   错误处理建议
4. 技术规范
   基础URL和认证方式
   数据格式和字符编码
   错误码说明
   使用注意事项
5. 数据模型
   AppointmentDTO（请求参数模型）
   Appointment（响应数据模型）
   数据库表结构参考
   🚀 主要特点
   标准化格式 - 遵循RESTful API设计规范
   详细示例 - 每个接口都有完整的请求响应示例
   前端友好 - 提供多种前端框架的调用示例
   错误处理 - 包含完整的错误码说明
   实用性强 - 包含实际使用注意事项
   📝 文档位置
   文档保存在 G:\SpringAI\law_system\docs\appointment-api.md

请先接受上述文档修改预览，然后前端开发人员就可以根据这个文档进行对接开发了。

这个文档将极大方便前端开发人员理解和使用预约功能接口，提高开发效率。

"↑↓" 切换历史输入，"Shift+Enter" 换行



DeepSeek-V3.1

