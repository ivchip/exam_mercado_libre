# Mercado Libre (Mutant Exam)

## Requerimientos:

- Java 11
- Maven
- Docker
- MySQL 5.7 (opcional)

## Pasos para ejecutar ambiente con Docker

1. **Clone la aplicación**
   ```bash
   git clone https://github.com/ivchip/exam_mercado_libre.git
   cd exam_mercado_libre
   ```

2. **Compile la aplicación**
   ```bash
   mvn install
   ```

3. **Construir la imagen de docker**
   ```bash
   docker-compose build
   ```

4. **Iniciar docker**
   ```bash
   docker-compose up -d
   ```

5. **Verificar las instancias**
   ```bash
   docker ps
   ```

6. **Conectarse a MySQL por consola o MySQL Workbench, las credenciales estan en el archivo docker-compose.yml y 
   ejecutar script**   
   ```bash
   CREATE DATABASE IF NOT EXISTS db_mutant DEFAULT CHARACTER SET utf8;
   USE db_mutant;

   CREATE TABLE IF NOT EXISTS person (
   id BIGINT NOT NULL AUTO_INCREMENT,
   dna VARCHAR(1000) NOT NULL,
   mutant TINYINT NOT NULL,
   PRIMARY KEY (id),
   UNIQUE INDEX dna_UNIQUE (dna ASC));
   ```

7. **Después de ejecutar los pasos anteriores sin errores, en el navegador vaya a la url**
   ```bash
   http://localhost:9090/swagger-ui.html#/
   ```
## Pasos para ejecutar ambiente local

1. **Clone la aplicación**
   ```bash
   git clone https://github.com/ivchip/exam_mercado_libre.git
   cd exam_mercado_libre
   ```

2. **Conectarse a MySQL por consola o MySQL Workbench y ejecutar script**
   ```bash
   CREATE DATABASE IF NOT EXISTS db_mutant DEFAULT CHARACTER SET utf8;
   USE db_mutant;

   CREATE TABLE IF NOT EXISTS person (
   id BIGINT NOT NULL AUTO_INCREMENT,
   dna VARCHAR(1000) NOT NULL,
   mutant TINYINT NOT NULL,
   PRIMARY KEY (id),
   UNIQUE INDEX dna_UNIQUE (dna ASC));
   ```
 
3. **Modifique el archivo application.properties para colocar sus credenciales de MySQL**
   ```bash
   cd src/main/java/resources/application.properties
   ```

4. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```

5. **Después de ejecutar los pasos anteriores sin errores, en el navegador vaya a la url**
   ```bash
   http://localhost:9090/swagger-ui.html#/
   ```
## DEMO