# devops

# Herramientas utilizadas:

1) Backend microservicios (JAVA, springboot)
2) Manejador de dependencias (Maven)
3) Repositorio de código (GitHub)
4) Pruebas unitarias (Junit)
5) Repositorio imagenes docker (GCR)
6) Cluster kubernetes (GKE)
7) CI/CD (CircleCI)

# Pruebas ambiente local

1) Descargar el proyecto de github (https://github.com/diegoarcedev/devops.git)
2) Ejecutar el comando "mvn clean install"
3) Ejecutar test locales "mvn test"
4) Para levantar el proyecto se lo puede realizar localizando la clase "DevopsApplication.java" y ejecutamos el método main (springboot local)
5) Se levantará en "http://localhost:8080"
6) Antes de llamar al endPoint "DevOps" se obtiene el token con la siguiente petición del tipo GET "http://localhost:8081/login"

# Ejecutar las pruebas creando la imagen docker
1) Descargar las dependencias "mvn clean install"
2) Crear la imagen docker con el siguiente comando "docker build -t devops:0.0.1-SNAPSHOT ."
3) Iniciar el contenedor con el comando "docker run -p 8080:8080 devops:0.0.1-SNAPSHOT"

# Implementación del loadBalancer en kubernates
1) Los archivos utilizados se encuentran en la carpeta "kubernates_files"
2) Para obtener el token utilizamos el enpoint: "http://35.226.115.123:8081/login" (NOTA: es HTTP)
    La respuesta sería así (un string) :   eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkZXZvcHMiLCJpYXQiOjE2NDQ0NjU1NDcsInN1YiI6InRlc3QgZGV2b3BzIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY0NDQ2NjA2N30.5IF0bW0YV-neYmDUN8fj3W9R2g1gdwFIdmzEiM-DI68

3) Una vez obtenido el token se realiza la prueba según lo solicitado (El siguiente es solo un ejemplo, reemplazar los valores según corresponda)
   curl -X POST \
   -H "X-Parse-REST-API-Key: 2f5ae96c-b558-4c7b-a590-a501ae1c3f6c" \
   -H "X-JWT-KWY: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkZXZvcHMiLCJpYXQiOjE2NDQzNzcyMDksInN1YiI6InRlc3QgZGV2b3BzIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY0NDM3NzcyOX0.hJxtGZkGD44UL9BAxE_QQh6dMxee1ABL2-y0WKKHkNA" \
   -H "Content-Type: application/json" \
   -d '{ "message" : "This is a test", "to": "Juan Perez", "from": "Rita Asturia", "timeToLifeSec" : 45 }' \
   http://35.226.115.123:8081/DevOps


# URL TOKEN 
http://35.226.115.123:8081/login
Nota: no se necesita parámetros y es del tipo GET

# URL ENDPOINT /DevOps
http://35.226.115.123:8081/DevOps
Nota: se necesitan los parámetros descritos en la prueba enviada (Tipo Post)





