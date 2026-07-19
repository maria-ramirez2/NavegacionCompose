// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

        // Sus plugins existentes (Android)
        alias(libs.plugins.android.application) apply false

        // El plugin de Kotlin debe ser 2.0.0 o superior
        id("org.jetbrains.kotlin.android") version "2.0.20" apply false

        // NUEVO REQUISITO: Declarar el plugin del compilador de Compose
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.20" apply false
    }
