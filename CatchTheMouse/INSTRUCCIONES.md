# 📱 Instrucciones para Ejecutar "Atrapa el Ratón"

## 🔧 Requisitos Previos

1. **Android Studio** (descarga desde [developer.android.com](https://developer.android.com/studio))
2. **Java Development Kit (JDK)** 8 o superior
3. **Android SDK** con API 21+

## 📥 Pasos de Instalación

### Paso 1: Descargar y Abrir el Proyecto
```bash
git clone https://github.com/paulaortiz2008p-dev/snake-game-android.git
cd snake-game-android/CatchTheMouse
```

### Paso 2: Abrir en Android Studio
1. Abre Android Studio
2. Click en **File** → **Open**
3. Selecciona la carpeta `CatchTheMouse`
4. Espera a que se sincronicen las dependencias

### Paso 3: Configurar el Emulador
1. Click en **Tools** → **Device Manager**
2. Click en **Create Device**
3. Selecciona un dispositivo (ej: Pixel 4)
4. Selecciona una API Level (21 o superior)
5. Click en **Next** y luego **Finish**

### Paso 4: Ejecutar el Juego
1. Selecciona el emulador creado en el dropdown
2. Click en el botón **Run** (ícono de play verde)
3. ¡Espera a que se instale en el emulador!

## 🎮 Cómo Jugar

1. **Abre la app** "Atrapa el Ratón"
2. **Presiona "Comenzar"** para iniciar el juego
3. **Toca los ratones** que aparecen en la pantalla
4. **Gana 10 puntos** por cada ratón atrapado
5. **El juego dura 30 segundos**
6. **Presiona "Reiniciar"** para jugar de nuevo

## 📊 Puntuación
- 🐭 Ratón atrapado = 10 puntos
- ⏱️ Tiempo total = 30 segundos
- 🎯 Objetivo = Atrapar la máxima cantidad de ratones

## 🐛 Solución de Problemas

### El emulador no inicia
- Asegúrate de tener habilitada la virtualización en BIOS
- Intenta crear un emulador con API 28 o inferior

### Errores de compilación
- Limpia el proyecto: **Build** → **Clean Project**
- Reconstruye: **Build** → **Rebuild Project**
- Sincroniza Gradle: **File** → **Sync Now**

### El juego corre lento
- Cierra otras aplicaciones
- Aumenta la RAM del emulador en Device Manager

## 📚 Conceptos Programados

- **Kotlin**: Lenguaje de programación moderno para Android
- **Custom Views**: Creación de vistas personalizadas con Canvas
- **Eventos táctiles**: Manejo de MotionEvent
- **Timers**: CountDownTimer para el contador regresivo
- **Threading**: Dibujo continuo en el lienzo
- **Recursos Android**: Layouts XML, colores, strings

## 🎓 Nivel Educativo

Este proyecto es apropiado para:
- ✅ Estudiantes de Bachillerato (Sexto Semestre)
- ✅ Introducción a desarrollo Android
- ✅ Aprendizaje de Kotlin
- ✅ Programación orientada a objetos

## 💡 Posibles Mejoras Futuras

1. Agregar diferentes niveles de dificultad
2. Sonidos y efectos de vibración
3. Sistema de vidas
4. Ratones que se mueven
5. Tabla de puntuaciones (leaderboard)
6. Logros y badges

---

**¡Diviértete jugando y aprendiendo!** 🎉