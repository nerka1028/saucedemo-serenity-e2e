1. Prerrequisitos:
- Sistema operativo: Windows 11
- IntelliJ IDEA: versión 2025.2.3
- JDK: versión 17 (añadido en variable de entorno JAVA_HOME)
- Gradle: versión 9.1.0 (con wrapper configurado)
- Google Chrome: versión 141.0.7390.55 actualizada (compatible con WebDriver)
- Serenity Version: '3.9.8'
- WebDriver ChromeDriver: versión 141.0.73 (debe coincidir con la de Chrome)
- Variables de entorno configuradas correctamente para JDK y Gradle

2. Comandos de instalación (en terminal o consola):
- ./gradlew clean build --refresh-dependencies (para descargar todas las dependencias necesarias)
- ./gradlew clean build (limpia y compila el proyecto)
- ./gradlew test (ejecuta los tests automatizados)
- ./gradlew aggregate (genera los reportes con Serenity)

3. Instrucciones para ejecutar los tests:
- Clona el proyecto en tu máquina local
- Abre el proyecto en IntelliJ IDEA
- Verifica que `chromedriver.exe` esté ubicado en `src/test/resources/drivers/`
- Ejecuta el comando: `./gradlew clean test aggregate`
- Abre el reporte en: `target/site/serenity/index.html`

4. Información adicional:
- Si necesitas desactivar el administrador de contraseñas de Chrome, se ha configurado mediante opciones de Chrome en ChromeCustomOptions y CustomChromeDriver
- Las pruebas pueden ejecutarse en modo headless (sin abrir navegador) modificando las propiedades en `build.gradle`
