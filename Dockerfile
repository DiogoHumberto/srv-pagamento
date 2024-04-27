# Etapa 1: Construção do aplicativo
FROM openjdk:21-slim AS builder

RUN apt-get update && \
    apt-get install -y maven && \
    apt-get clean;

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn package -DskipTests

# Etapa 3: Preparação da imagem final
FROM openjdk:21-slim
WORKDIR /app
# Copie o JAR construído a partir da etapa anterior
COPY --from=builder /app/target/*.jar application.jar
# Defina o comando de inicialização do aplicativo
CMD ["java", "-jar", "application.jar"]