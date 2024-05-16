FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/restful-api-mvc-0.0.1-SNAPSHOT.jar /app/restful-api-mvc.jar
EXPOSE 8080
CMD ["java","-jar","/app/restful-api-mvc.jar"]



# docker run -d \
#     --name postgres-sql \
#     -p 5432:5432 \
#     -e POSTGRES_PASSWORD=password \
#     -e POSTGRES_USER=postgres \
#     -e POSTGRES_DB=api_courses \
#     -v /var/lib/postgresql/data \
#     postgres

#change the jdbc url to container name
# docker build -t spring/rest-mvc .
#docker network create spring-boot-net
#docker network connect spring-boot-net postgres-sql
# docker run --network spring-boot-net spring/rest-mvc
#docker run -p 8080:8080 --network spring-boot-net spring/rest-mvc
# docker run -d --name spring-boot -p 8080:8080 spring/rest-mvc


