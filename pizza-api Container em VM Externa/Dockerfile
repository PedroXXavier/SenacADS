# Imagem base Java 17
FROM openjdk:17

# Copiar o Maven wrapper e o pom.xml para o Docker
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copiar o código fonte
COPY src src

# Buildar a aplicação
RUN ./mvnw package -DskipTests

# Executa a aplicação
ENTRYPOINT ["java", "-jar", "target/pizzademo-1.0.jar"]

#----------------------------------
# Explicações dos comandos usados:
#----------------------------------
# [COPY]        faz a cópia de um conteúdo externo para dentro do Docker
# [RUN]         executa comandos no Docker
# [ENTRYPOINT]  indica qual aplicação e respectivos parâmetros
