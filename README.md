# Navegación Compose

Aplicación móvil desarrollada para practicar la navegación entre diferentes pantallas mediante Kotlin, Jetpack Compose y Navigation Compose.

## Descripción

El proyecto presenta una aplicación con cuatro pantallas principales: inicio, perfil, detalles y ajustes. El usuario puede desplazarse entre ellas mediante una barra de navegación inferior.

La aplicación también incorpora transiciones animadas, conservación del estado de navegación y una opción para cambiar la interfaz a un tema oscuro.

## Funcionalidades

- Navegación entre cuatro pantallas.
- Barra de navegación inferior.
- Identificación visual de la pantalla seleccionada.
- Transiciones de entrada y salida con efecto de desvanecimiento.
- Conservación del estado de las pantallas.
- Prevención de destinos duplicados.
- Cambio del tema visual.
- Componentes e iconos de Material Design.
- Diseño reutilizable para las diferentes pantallas.

## Pantallas

### Inicio

Muestra un mensaje de bienvenida al usuario.

### Perfil

Presenta información básica del perfil y un icono representativo.

### Detalles

Explica el propósito académico de la aplicación y su relación con el aprendizaje de navegación en Android.

### Ajustes

Permite cambiar la apariencia de la aplicación a un tema azul oscuro.

## Tecnologías utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Navigation Compose
- Material Design 3
- AndroidX
- Gradle con Kotlin DSL
- Java 17

## Navegación

Las rutas de la aplicación se encuentran definidas mediante una clase sellada:

- `home`
- `profile`
- `details`
- `settings`

El componente `NavHost` administra las pantallas y establece `home` como destino inicial.

La barra inferior utiliza `NavigationBar` y `NavigationBarItem` para permitir el desplazamiento entre las distintas secciones.

## Transiciones

Las pantallas utilizan animaciones de desvanecimiento:

- `fadeIn` para la entrada.
- `fadeOut` para la salida.
- Duración de 500 milisegundos.

Estas transiciones proporcionan una navegación más fluida entre las secciones.

## Cambio de tema

La aplicación comienza con un fondo turquesa claro. Desde la pantalla de ajustes, el usuario puede activar un tema azul oscuro.

Al cambiar el tema también se actualiza el color del texto para conservar una presentación legible.

## Estructura principal

### `MainActivity.kt`

Contiene la actividad principal y todos los componentes de la interfaz.

### `MainAppNavigation`

Administra:

- El controlador de navegación.
- El tema seleccionado.
- La barra inferior.
- El contenedor de las pantallas.
- Las transiciones animadas.

### `BottomNavigationBar`

Construye la barra de navegación y administra el destino seleccionado.

### `ScreenLayout`

Proporciona una estructura visual reutilizable para todas las pantallas.

### Componentes de pantalla

- `HomeScreen`
- `ProfileScreen`
- `DetailsScreen`
- `SettingsScreen`

Cada componente representa una sección específica de la aplicación.

## Requisitos

- Android Studio.
- Java 17.
- Android SDK 24 o superior.
- Emulador o dispositivo Android.

Versiones principales configuradas:

- SDK mínimo: 24
- SDK objetivo: 36
- SDK de compilación: 36

## Instalación y ejecución

1. Descargar el proyecto.
2. Abrir la carpeta `navegacioncompose` en Android Studio.
3. Esperar la sincronización de Gradle.
4. Seleccionar un dispositivo físico o virtual.
5. Presionar **Run** para ejecutar la aplicación.

## Instrucciones de uso

1. Abrir la aplicación.
2. Utilizar la barra inferior para cambiar de pantalla.
3. Visitar las secciones de inicio, perfil, detalles y ajustes.
4. Entrar en **Ajustes**.
5. Presionar **Cambiar a modo oscuro** para modificar el tema.

## Aprendizajes obtenidos

Este proyecto permite practicar:

- Navegación con Jetpack Compose.
- Creación y administración de rutas.
- Uso de `NavHostController`.
- Diseño de barras de navegación.
- Conservación del estado.
- Componentes reutilizables.
- Manejo de estados con `remember`.
- Animaciones entre pantallas.
- Aplicación de temas dinámicos.
- Diseño de interfaces con Material Design 3.

## Estado del proyecto

Proyecto académico funcional desarrollado para aplicar conceptos de navegación en la materia de Desarrollo Móvil.

## Autora

María Ramírez
