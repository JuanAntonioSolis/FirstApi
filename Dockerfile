FROM docker.io/eclipse-temurin:25-jre-jammy
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# podman build -t springapiejemplo:1.0 .
# podman image list
# podman run -p 8080:8080 --name springapp --network=host -d -t springapiejemplo:1.0
# podman stop springapp
# podman start springapp
# podman stats
# podman logs -f springapp
# podman rm springapp

# CAMBIOS
# En EC2 AWS
# git pull
# ./gradlew bootJar
# Volver a generar imagen: podman build -t springapiejemplo:1.0 .
# Lanzar contenedor: podman run -p 8080:8080 --name springapp --network=host -d -t springapiejemplo:1.0
