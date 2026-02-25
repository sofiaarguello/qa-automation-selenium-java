
#![Java](https://img.shields.io/badge/Java-17-blue)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-orange)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

# qa-automation-selenium-java qa-automation-selenium-java
# E2E Automation Framework - SauceDemo (Standard User Flow)

Este proyecto es un framework de automatización de pruebas de extremo a extremo (E2E) desarrollado para validar los flujos críticos de la plataforma **SauceDemo**. 

## 🚀 Tecnologías Utilizadas
* **Lenguaje:** Java 11
* **Librería:** Selenium WebDriver
* **Framework de Pruebas:** TestNG
* **Gestor de Dependencias:** Maven
* **Patrón de Diseño:** Page Object Model (POM)
* **Reportes:** TestNG Reports / Extent Reports

## 🛠️ Estructura del Proyecto
El proyecto sigue el patrón **Page Object Model (POM)** para garantizar que el código sea mantenible y reutilizable:
* `src/main/java/pages`: Contiene las clases que representan las páginas web y sus locatarios.
* `src/test/java/tests`: Contiene los scripts de prueba organizados por suites.
* `testng.xml`: Archivo de configuración para la ejecución de pruebas en paralelo o secuencial.

## 🧪 Escenarios Automatizados
1. **Login:** Validación de credenciales válidas y manejo de errores.
2. **Carrito de Compras:** Agregar productos y verificar persistencia.
3. **Checkout:** Flujo completo desde la carga de datos hasta la confirmación de orden.

## 🏁 Cómo ejecutar las pruebas
1. Clonar el repositorio: `git clone https://github.com/sofiaarguello/tu-repo.git`
2. Navegar a la carpeta: `cd tu-repo`
3. Ejecutar comando Maven: `mvn test`
