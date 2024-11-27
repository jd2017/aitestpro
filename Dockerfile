#使用OpenJDK作为基础镜像
FROM openjdk:17-jdk-alpine

# 将jar文件复制到镜像的/app目录下
# 注意：这里的your-springboot-app.jar应该替换为你实际的jar文件名
COPY target/aitestpro-0.0.1-SNAPSHOT.jar /app/aitestpro-0.0.1-SNAPSHOT.jar 

#设置工作目录为/app
WORKDIR /app

#设置时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo > /etc/timezone

# 暴露应用程序端口（Spring Boot默认是8080）
EXPOSE 8080

# 设置容器启动时执行的命令
# 这里使用java -jar来运行jar文件
ENTRYPOINT ["java", "-jar", "aitestpro-0.0.1-SNAPSHOT.jar"]
