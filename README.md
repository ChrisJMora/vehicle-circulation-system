# Vehicle Circulation System

Sistema completo para verificar restricciones vehiculares de pico y placa, compuesto por un frontend web desarrollado en Angular y un servicio backend desarrollado en Spring Boot.

## Descripción General

El Sistema de Circulación Vehicular permite a los usuarios verificar si un vehículo puede circular en una fecha y hora específica, basándose en las restricciones de pico y placa vigentes. El sistema está diseñado con una arquitectura de microservicios que separa la lógica de presentación del procesamiento de reglas de negocio.

## Arquitectura del Sistema

[Diagrama en IcePanel](https://s.icepanel.io/c5i3O3QAMFPgk3/yBs5)

El sistema está compuesto por:

- **Frontend (Angular)**: Interfaz web responsiva para consultas de usuarios
- **Backend (Spring Boot)**: API REST que procesa las reglas de circulación vehicular
- **Comunicación**: Conexión HTTP/REST entre frontend y backend

## Componentes del Sistema

### 1. Vehicle Circulation App (Frontend)

**Tecnologías:**
- Angular 19.2.0
- TypeScript 5.7.2
- RxJS para manejo reactivo
- CSS3 para estilos

**Funcionalidades:**
- Formulario intuitivo para ingreso de datos del vehículo
- Visualización de resultados de circulación
- Interfaz responsiva y moderna
- Integración con API REST del backend

### 2. Vehicle Circulation Service (Backend)

**Tecnologías:**
- Spring Boot 3.5.3
- Java 17
- Maven para gestión de dependencias
- Spring Web para API REST
- Spring Validation para validaciones
- Lombok para reducir código boilerplate

**Funcionalidades:**
- API REST para verificación de restricciones vehiculares
- Validación robusta de datos de entrada
- Lógica de negocio para reglas de pico y placa
- Mapeo automático entre DTOs y modelos de dominio
- Manejo de excepciones y respuestas HTTP apropiadas

## Plan de Despliegue

### Prerequisitos

#### Para el Backend (Spring Boot):
- Java JDK 17 o superior
- Maven 3.6 o superior
- Puerto 8080 disponible

#### Para el Frontend (Angular):
- Node.js 18 o superior
- npm 9 o superior
- Angular CLI 19.2.15
- Puerto 4200 disponible

### Despliegue Local

#### 1. Configuración del Backend

```bash
# Navegar al directorio del servicio
cd vehicle-circulation-service/vehicle-circulation-checker

# Compilar el proyecto
./mvnw clean compile

# Empaquetar la aplicación
./mvnw package

# Ejecutar la aplicación
./mvnw spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

**Endpoints principales:**
- `POST /api/circulation/check` - Verificar circulación vehicular

#### 2. Configuración del Frontend

```bash
# Navegar al directorio de la aplicación
cd vehicle-circulation-app

# Instalar dependencias
npm install

# Ejecutar en modo desarrollo
npm start

# O ejecutar con ng serve
ng serve
```

La aplicación estará disponible en: `http://localhost:4200`

#### 3. Verificación del Despliegue

1. Acceder a `http://localhost:4200`
2. Ingresar una placa vehicular (ej: ABC-1234)
3. Seleccionar fecha y hora
4. Verificar que se muestre el resultado correctamente

## Autores

- **Christian Jácome** - *Desarrollo inicial* - [ChrisJMora](https://github.com/ChrisJMora)

**Versión del Sistema:** 1.0.0  
**Última actualización:** Julio 2025
