# Use uma imagem do OpenJDK como base
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copie o JAR gerado pelo Spring Boot para dentro do container
COPY target/*.jar app.jar

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]