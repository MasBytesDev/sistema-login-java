# Sistema de Login Básico

Este es un sistema de login básico desarrollado en Java, utilizando las siguientes tecnologías:

- Java JDK 21
- JPA para la gestión de la persistencia.
- Java Swing para la interfaz gráfica.
- MySQL (Wamp Server) como base de datos.
- Apache NetBeans como entorno de desarrollo integrado (IDE).
  
El proyecto implementa una validación simple de usuarios y contraseñas que se ingresan manualmente en una base de datos MySQL. No se incluyen operaciones CRUD completas, ya que el enfoque está únicamente en la lectura y validación de los usuarios existentes.

# Características

- Interfaz gráfica desarrollada con Java Swing.
- Validación de usuarios contra una base de datos relacional en MySQL.
- Sistema funcional y mínimo, ideal para aprender los fundamentos de la autenticación en Java.

# Requisitos

- Java JDK 21 instalado.
- Apache NetBeans o cualquier IDE compatible con Maven.
- Servidor Wamp (o cualquier servidor que soporte MySQL).
- Dependencia de JPA configurada con javax.persistence.
  
# Configuración de la Base de Datos

- Crear una base de datos en MySQL, por ejemplo, login_db.
- Crear una tabla llamada usuario con la siguiente estructura:

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(50) NOT NULL,
    contrasenia VARCHAR(50) NOT NULL
);

Insertar manualmente algunos usuarios para las pruebas:

INSERT INTO usuario (nombreUsuario, contrasenia) 
VALUES ('admin', '1234'), ('user1', 'pass1'), ('user2', 'pass2');

Configurar el archivo persistence.xml para conectar el proyecto con la base de datos:

<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
    <persistence-unit name="loginPU">
        <class>com.masbytes.login.logica.Usuario</class>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/login_db" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="tu_contraseña" />
            <property name="javax.persistence.schema-generation.database.action" value="none" />
        </properties>
    </persistence-unit>
</persistence>
              
# Estructura del Proyecto

El proyecto está organizado de la siguiente forma:

- com.masbytes.login.logica: Contiene la lógica principal y las clases del modelo (Usuario, Controladora).
- com.masbytes.login.persistencia: Maneja la persistencia con JPA (UsuarioJpaController, ControladoraPersistencia).
- com.masbytes.login.igu: Incluye la interfaz gráfica (Principal).
- Login: Punto de entrada principal del programa (main).

# Cómo Ejecutar el Proyecto

- Clona el repositorio:

      git clone https://github.com/tu_usuario/nombre_del_repositorio.git

- Abre el proyecto en Apache NetBeans o tu IDE preferido.

- Verifica la conexión con la base de datos en el archivo persistence.xml.

- Ejecuta la clase Login para iniciar la aplicación.

# Funcionamiento

- Ingresa el nombre de usuario y contraseña previamente registrados en la base de datos.
- Si la combinación es correcta, el sistema muestra un mensaje de bienvenida.
- Si no, se notificará si el usuario o la contraseña son incorrectos.

# Licencia

Este proyecto es de uso libre para fines educativos y personales. Si deseas contribuir, ¡será un gusto recibir mejoras y comentarios!
