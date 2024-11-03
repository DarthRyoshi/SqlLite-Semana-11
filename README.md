# SqlLite App

## Descripción del Proyecto
SqlLite App es una aplicación de Android que permite gestionar datos de usuarios mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar) utilizando una base de datos SQLite. La aplicación proporciona una interfaz simple para agregar, visualizar y eliminar registros de usuarios.

## Funcionalidades Implementadas
- **Agregar Usuarios**: Permite a los usuarios ingresar su nombre, edad y RUT, y almacenar esta información en la base de datos.
- **Actualizar Usuarios**: Los usuarios pueden seleccionar un registro existente para editar y actualizar la información.
- **Eliminar Usuarios**: Permite eliminar registros de usuarios de la base de datos.
- **Visualización de Usuarios**: Utiliza un `RecyclerView` para mostrar una lista de todos los registros de usuarios almacenados.

## Estructura del Proyecto
El proyecto contiene las siguientes clases principales:
- **MainActivity.java**: Clase principal que maneja la interfaz de usuario y la lógica de la aplicación.
- **DataModel.java**: Modelo de datos que representa una entrada de usuario en la base de datos.
- **DatabaseHelper.java**: Clase que gestiona la creación y acceso a la base de datos SQLite.
- **DataAdapter.java**: Adaptador para el `RecyclerView` que gestiona la visualización de los datos en la lista.

## Requisitos
- **Android Studio**: La aplicación debe ejecutarse en Android Studio (recomendado versión 4.0 o superior).
- **SDK de Android**: Nivel mínimo de API 16 (Android 4.1).
- **Dispositivo Android o Emulador**: Configurado para pruebas.

## Configuración y Ejecución en Android Studio

### 1. Clonar el Repositorio
   Clona el repositorio en tu computadora local con el siguiente comando:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_DIRECTORIO>
