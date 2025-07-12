# Sistema de Circulación Vehicular

Sistema integral para verificar restricciones de pico y placa, compuesto por un frontend web en Angular y un backend en Spring Boot.

## Descripción General

El Sistema de Circulación Vehicular permite a los usuarios consultar si un vehículo puede circular en una fecha y hora específicas según las reglas de pico y placa. Utiliza una arquitectura de microservicios que separa la interfaz de usuario de la lógica de negocio.

## Arquitectura del Sistema

[Diagrama en IcePanel](https://s.icepanel.io/c5i3O3QAMFPgk3/yBs5)

**Componentes:**
- **Frontend (Angular)**: Interfaz web responsiva para consultas de usuarios.
- **Backend (Spring Boot)**: API REST que procesa las reglas de circulación.
- **Comunicación**: Conexión HTTP/REST entre frontend y backend.

## Componentes del Sistema

### 1. Vehicle Circulation App (Frontend)

**Tecnologías:**
- Angular 19.2.0
- TypeScript 5.7.2
- RxJS para manejo reactivo
- CSS3 para estilos

**Funcionalidades:**
- Formulario intuitivo para ingresar datos del vehículo.
- Visualización de resultados de circulación.
- Interfaz responsiva y moderna.
- Integración con la API REST del backend.

### 2. Vehicle Circulation Service (Backend)

**Tecnologías:**
- Spring Boot 3.5.3
- Java 17
- Maven para gestión de dependencias
- Spring Web para API REST
- Spring Validation para validaciones
- Lombok para reducir código boilerplate

**Funcionalidades:**
- API REST para verificar restricciones vehiculares.
- Validación robusta de datos de entrada.
- Lógica de negocio para reglas de pico y placa.
- Mapeo automático entre DTOs y modelos de dominio.
- Manejo de excepciones y respuestas HTTP adecuadas.

## Prerrequisitos

### Para el Backend (Spring Boot):
- Java JDK 17 o superior
- Puerto 8080 disponible

### Para el Frontend (Angular):
- Node.js 18 o superior
- npm 9 o superior
- Angular CLI 19.2.15
- Puerto 4200 disponible

## Despliegue

### 1. Despliegue Local (Modo Desarrollo)

#### Backend
1. Navega al directorio del servicio:
   ```bash
   cd vehicle-circulation-service/vehicle-circulation-checker
   ```
2. Compila el proyecto:
   ```bash
   ./mvnw clean compile
   ```
3. Empaqueta la aplicación:
   ```bash
   ./mvnw package
   ```
4. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
   La API estará disponible en: `http://localhost:8080`

   **Endpoint principal:**
   - `POST /api/circulation/check` - Verifica circulación vehicular.

#### Frontend
1. Navega al directorio de la aplicación:
   ```bash
   cd vehicle-circulation-app
   ```
2. Instala dependencias:
   ```bash
   npm install
   ```
3. Ejecuta en modo desarrollo:
   ```bash
   npm start
   ```
   O con Angular CLI:
   ```bash
   ng serve
   ```
   La aplicación estará disponible en: `http://localhost:4200`

### 2. Despliegue con Ejecutables

#### Backend (usando el JAR)
1. Asegúrate de que el archivo `vehicle-circulation-checker-0.0.1-SNAPSHOT.jar` esté en el directorio raíz o en la ubicación deseada.
2. Verifica que Java 17 esté instalado:
   ```bash
   java -version
   ```
3. Ejecuta el JAR:
   ```bash
   java -jar vehicle-circulation-checker-0.0.1-SNAPSHOT.jar
   ```
   La API estará disponible en: `http://localhost:8080`

   **Nota**: Si necesitas configurar un puerto diferente o propiedades específicas, usa un archivo `application.properties` o pasa argumentos, por ejemplo:
   ```bash
   java -jar vehicle-circulation-checker-0.0.1-SNAPSHOT.jar --server.port=8081
   ```

#### Frontend (usando la carpeta dist/)
1. Asegúrate de que la carpeta `dist/` contenga los archivos compilados. Si no, genera los archivos de producción:
   ```bash
   cd vehicle-circulation-app
   ng build --prod
   ```
2. Sirve los archivos estáticos desde `dist/` usando un servidor web. Opciones:
   - **Con un servidor local (http-server)**:
     ```bash
     npx http-server dist/
     ```
     La aplicación estará disponible en: `http://localhost:8080` (o el puerto indicado).
   - **Con Nginx** (ejemplo de configuración):
     1. Copia la carpeta `dist/` a `/var/www/html/` o la ruta configurada en Nginx.
     2. Configura Nginx para redirigir rutas a `index.html`:
        ```nginx
        server {
            listen 80;
            server_name localhost;
            root /var/www/html;
            index index.html;

            location / {
                try_files $uri $uri/ /index.html;
            }
        }
        ```
     3. Reinicia Nginx:
        ```bash
        sudo systemctl restart nginx
        ```
   - **Con plataformas de hosting** (Netlify, Vercel, Firebase, etc.):
     1. Sube la carpeta `dist/` a la plataforma.
     2. Configura redirecciones para SPAs (por ejemplo, `/* /index.html 200` en Netlify).

### 3. Verificación del Despliegue
1. Accede a `http://localhost:4200` (o el puerto del frontend).
2. Ingresa una placa vehicular (ej: ABC-1234).
3. Selecciona fecha y hora.
4. Verifica que el resultado se muestre correctamente.

## Autores

- **Christian Jácome** - *Desarrollo inicial* - [ChrisJMora](https://github.com/ChrisJMora)

**Versión del Sistema:** 1.0.0  
**Última actualización:** Julio 2025
