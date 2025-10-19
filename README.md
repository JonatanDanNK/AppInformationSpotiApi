# Spotify Info App

Aplicación Android desarrollada en **Kotlin** con **Jetpack Compose**, **Retrofit** y **Hilt (Dagger)**.  
Permite consultar artistas del género **Pop** desde la API pública de **Spotify**, ver sus **álbumes** y las **canciones** de cada álbum.

---

## Características principales

- Autenticación con **Spotify API** mediante `client_credentials` (token automático)
- Arquitectura limpia (**MVVM + Clean Architecture**)
- Inyección de dependencias con **Hilt**
- Llamadas HTTP con **Retrofit + OkHttp**
- UI declarativa con **Jetpack Compose**
- Navegación entre pantallas con **Navigation Compose**

---

## Estructura del proyecto

app/
├── data/
│ ├── network/ → Interfaces de Retrofit para interactuar con las APIs de Spotify (SpotifyApi, SpotifyAuthApi).
│ ├── repository/ → Implementaciones de repositorios que actúan como la fuente de datos principal, conectando las APIs con la capa de dominio.
│ └── di/ → Módulos de inyección de dependencias con Hilt, como NetworkModule para configurar Retrofit.
├── domain/
│ ├── GetArtistsListUseCase.kt → Caso de uso para obtener una lista de artistas.
│ ├── GetAlbumsByArtistUseCase.kt → Caso de uso para obtener los álbumes de un artista específico.
│ └── GetTracksByAlbumUseCase.kt → Caso de uso para obtener las pistas de un álbum.
├── ui/
│ ├── view/ → Contiene las pantallas de la interfaz de usuario implementadas con Jetpack Compose (ej. ArtistScreen, AlbumsScreen).
│ └── viewmodel/ → Contiene los ViewModels que gestionan la lógica de presentación de las pantallas.
└── MainActivity.kt → El punto de entrada de la aplicación.

---

## Configuración del entorno (paso a paso)

### Instalar Android Studio

Descarga e instala la última versión de **Android Studio (Ladybug o superior)**:   
[https://developer.android.com/studio](https://developer.android.com/studio)

Durante la instalación asegúrate de incluir:
- Android SDK 36 o superior
- Kotlin
- Android Virtual Device (AVD) Manager
- Intala un emulador de android studio 
- 

# Guía: Cómo instalar un emulador en Android Studio

## 1. Abrir el Administrador de Dispositivos (Device Manager)

1.  Inicia Android Studio y abre un proyecto.
2.  Ve al menú superior y selecciona **View > Tool Windows > Device Manager**.
3.  También puedes usar el ícono del Administrador de dispositivos en la barra de herramientas, que se parece a un teléfono o una tableta.

## 2. Crear un nuevo dispositivo virtual

1.  En la ventana del *Device Manager*, haz clic en el botón `+ Create virtual device`.
2.  Selecciona la **categoría de dispositivo** que deseas emular (por ejemplo, `Phone`, `Tablet`, `Wear OS`, etc.).
3.  Elige un modelo de dispositivo específico (se recomienda un dispositivo de la línea Pixel, como el Pixel 6, por su compatibilidad con los servicios de Google Play) y haz clic en **Next**.

## 3. Descargar la imagen del sistema (versión de Android)

1.  En la siguiente pantalla, elige la **imagen del sistema** (la versión de Android) para el emulador.
2.  Si la versión de Android no está descargada, haz clic en el ícono de **Download** junto a la versión que prefieras (por ejemplo, Android U).
3.  Acepta la licencia y espera a que la descarga se complete.

## 4. Configurar y finalizar la creación

1.  Una vez descargada la imagen, **selecciónala** en la lista y haz clic en **Next**.
2.  **Configura los detalles del AVD**:
    *   **Nombre del AVD:** Asigna un nombre personalizado o deja el predeterminado.
    *   **Orientación:** Elige la orientación inicial (`Portrait` o `Landscape`).
    *   **Configuraciones avanzadas:** Puedes ajustar la memoria RAM, el almacenamiento, y otros detalles aquí.
3.  Haz clic en **Finish** para completar el proceso.

## 5. Iniciar el emulador

1.  El emulador recién creado aparecerá en la lista del *Device Manager*.
2.  Haz clic en el botón de **Play** (el ícono de triángulo) junto al nombre del emulador para iniciarlo.
3.  El primer inicio puede tardar varios minutos. Ten paciencia.

Una vez que el emulador esté en funcionamiento, ya puedes ejecutar tus aplicaciones de Android directamente en él desde Android Studio.

---

### Clonar o importar el proyecto

Abre Android Studio → **File > Open**  
Selecciona la carpeta raíz del proyecto (la que contiene `app/` y `build.gradle`).

O si tienes Git configurado:
[```bash git clone https://github.com/tuusuario/SpotifyInfoApp.git]


# Compilación y ejecución

Sigue estos pasos para compilar y ejecutar la aplicación en Android Studio:

1.  Abre el proyecto en Android Studio.
2.  Haz clic en el botón de **Run 'app'** en la barra de herramientas, que tiene un ícono con forma de triángulo.
3.  Selecciona un **emulador** o un **dispositivo físico Android** que esté conectado a tu computadora.
4.  La aplicación se iniciará y mostrará la lista de artistas populares.

# Funcionalidades

Una vez que la aplicación esté en marcha, podrás navegar y explorar el contenido de la siguiente manera:

*   **Ver álbumes de un artista**: Toca sobre el nombre de un artista en la lista para ver todos sus álbumes.
*   **Ver canciones de un álbum**: Dentro de la pantalla de álbumes de un artista, toca sobre la carátula de un álbum para ver todas las canciones que contiene.



