# Blog Application REST API

Welcome to the Blog Application REST API project! This application is a simple blog management system built using Spring Boot. It allows users to create, read, update, and delete blog posts via a RESTful API.

## Features

- **CRUD Operations**: Create, Read, Update, And Delete Blog posts.
- **User Management**: Register and authenticate users.
- **Category Management**: Add and manage category for blog posts.
- **Search**: Search blog posts by title and category.
- **JWT Authentication**: Secure authentication with JSON Web Tokens.
- **H2 Database**: In-memory database for development and testing.

## Technologies Used

- **Spring Boot**: For building the RESTful API.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: In-memory database for development and testing.
- **Spring Security**: For authentication and authorization.
- **Maven**: For project build and dependency management.
- **Swagger**: API documentation and testing.
- **JUnit**: For testing.
- **Docker**: For containerization and deployment.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Docker (optional, for running in container)

### Clone the Repository

```bash
git clone https://github.com/Yash2462/Blog-app-SpringBoot.git
cd blog-application
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

#### Option 1: Run with Maven

```bash
mvn spring-boot:run
```

#### Option 2: Run with Docker

1. Build the Docker image:
```bash
docker build -t blog-application:latest .
```

2. Run the container:
```bash
docker run -d --rm -p 8080:8080 --name blog-app blog-application:latest
```

3. Stop the container when done:
```bash
docker stop blog-app
```

## API Endpoints

### Swagger Documentation

Access the interactive API documentation at:
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs

### H2 Console

Access the H2 database console at:
- http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:blog_app`
- Username: `sa`
- Password: (empty)

### Key Endpoints

- **Authentication**:
  - `POST /api/auth/signup` - Register a new user
  - `POST /api/auth/login` - Login user

- **User Management**:
  - `GET /api/users/me` - Get current user profile
  - `GET /api/users` - Get all users (Admin only)
  - `DELETE /api/users/{userId}` - Delete user (Admin only)

- **Post Management**:
  - `GET /api/posts` - Get all posts
  - `POST /api/posts` - Create new post
  - `GET /api/posts/{postId}` - Get post by ID
  - `PUT /api/posts/{postId}` - Update post
  - `DELETE /api/posts/{postId}` - Delete post

- **Category Management**:
  - `GET /api/categories` - Get all categories
  - `POST /api/categories` - Create new category
  - `GET /api/categories/{categoryId}` - Get category by ID

- **Comment Management**:
  - `GET /api/comments/post/{postId}` - Get comments for a post
  - `POST /api/comments` - Add comment to post

## Testing

Run tests with Maven:

```bash
mvn test
```

## Actuator Endpoints

Spring Boot Actuator is enabled for monitoring:

- Health check: http://localhost:8080/actuator/health

-- happy coding ✌😉

---

# 博客应用 REST API

欢迎使用博客应用 REST API 项目！这是一个使用 Spring Boot 构建的简单博客管理系统。它允许用户通过 RESTful API 创建、读取、更新和删除博客文章。

## 功能特性

- **CRUD 操作**：创建、读取、更新和删除博客文章
- **用户管理**：用户注册和身份验证
- **分类管理**：添加和管理博客文章分类
- **搜索功能**：按标题和分类搜索博客文章
- **JWT 认证**：使用 JSON Web Tokens 进行安全认证
- **H2 数据库**：用于开发和测试的内存数据库

## 技术栈

- **Spring Boot**：构建 RESTful API
- **Spring Data JPA**：数据库交互
- **H2 Database**：用于开发和测试的内存数据库
- **Spring Security**：认证和授权
- **Maven**：项目构建和依赖管理
- **Swagger**：API 文档和测试
- **JUnit**：单元测试
- **Docker**：容器化和部署

## 快速开始

### 前置要求

- Java 17 或更高版本
- Maven 3.6 或更高版本
- Docker（可选，用于容器化运行）

### 克隆仓库

```bash
git clone https://github.com/Yash2462/Blog-app-SpringBoot.git
cd blog-application
```

### 构建项目

```bash
mvn clean install
```

### 运行应用

#### 方式一：使用 Maven 运行

```bash
mvn spring-boot:run
```

#### 方式二：使用 Docker 运行

1. 构建 Docker 镜像：
```bash
docker build -t blog-application:latest .
```

2. 运行容器：
```bash
docker run -d --rm -p 8080:8080 --name blog-app blog-application:latest
```

3. 完成后停止容器：
```bash
docker stop blog-app
```

## API 端点

### Swagger 文档

访问交互式 API 文档：
- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs

### H2 控制台

访问 H2 数据库控制台：
- http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:blog_app`
- 用户名：`sa`
- 密码：（空）

### 主要端点

- **认证接口**：
  - `POST /api/auth/signup` - 注册新用户
  - `POST /api/auth/login` - 用户登录

- **用户管理**：
  - `GET /api/users/me` - 获取当前用户信息
  - `GET /api/users` - 获取所有用户（仅管理员）
  - `DELETE /api/users/{userId}` - 删除用户（仅管理员）

- **文章管理**：
  - `GET /api/posts` - 获取所有文章
  - `POST /api/posts` - 创建新文章
  - `GET /api/posts/{postId}` - 根据 ID 获取文章
  - `PUT /api/posts/{postId}` - 更新文章
  - `DELETE /api/posts/{postId}` - 删除文章

- **分类管理**：
  - `GET /api/categories` - 获取所有分类
  - `POST /api/categories` - 创建新分类
  - `GET /api/categories/{categoryId}` - 根据 ID 获取分类

- **评论管理**：
  - `GET /api/comments/post/{postId}` - 获取文章的评论
  - `POST /api/comments` - 添加评论

## 测试

使用 Maven 运行测试：

```bash
mvn test
```

## Actuator 端点

Spring Boot Actuator 已启用监控功能：

- 健康检查：http://localhost:8080/actuator/health

## 项目结构

```
blog-application/
├── src/
│   ├── main/
│   │   ├── java/com/blog_app/
│   │   │   ├── config/          # 配置类（安全、JWT、Swagger 等）
│   │   │   ├── constant/        # 常量定义
│   │   │   ├── controller/      # REST 控制器
│   │   │   ├── entity/          # JPA 实体
│   │   │   ├── exception/       # 自定义异常
│   │   │   ├── repository/      # 数据访问层
│   │   │   ├── response/        # 响应对象
│   │   │   ├── service/         # 服务接口
│   │   │   └── serviceImpl/     # 服务实现
│   │   └── resources/
│   │       ├── application.properties  # 应用配置
│   │       └── ...
│   └── test/                    # 测试代码
├── Dockerfile                   # Docker 构建文件
├── pom.xml                      # Maven 配置
└── README.md                    # 项目文档
```

## 安全配置

项目使用 Spring Security 和 JWT 进行认证：

- 公开端点：`/api/auth/**`、`/swagger-ui/**`、`/v3/api-docs/**`、`/actuator/**`
- 需要认证的端点：所有其他 API 端点
- JWT Token 通过 `Authorization` 头传递：`Bearer <token>`

## 常见问题

### 1. 如何重置数据库？

由于使用 H2 内存数据库，重启应用后数据库会自动重置。

### 2. 如何查看数据库内容？

访问 H2 控制台：http://localhost:8080/h2-console

### 3. 如何修改端口？

在 `application.properties` 中修改 `server.port` 配置。

---

-- 快乐编码 ✌😉
