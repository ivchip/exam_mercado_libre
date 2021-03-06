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

2. **Construir la imagen de docker**
   ```bash
   docker-compose build
   ```

3. **Iniciar docker**
   ```bash
   docker-compose up -d
   ```

4. **Verificar las instancias**
   ```bash
   docker ps
   ```

5. **Después de ejecutar los pasos anteriores sin errores, en el navegador vaya a la url**
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
   cd .docker/setup.sql
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
   ```bash
   http://ec2-18-222-124-107.us-east-2.compute.amazonaws.com/swagger-ui.html#/
   ```

## Endpoints
   ```bash
   Método: POST
   URL: http://ec2-18-222-124-107.us-east-2.compute.amazonaws.com/api/v1/mutant
   Entrada: {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}
   ```
   ```bash
   Método: GET
   URL: http://ec2-18-222-124-107.us-east-2.compute.amazonaws.com/api/v1/stats
   Salida: {"count_mutant_dna":50, "count_human_dna":100: "ratio":0.5}
   ```
