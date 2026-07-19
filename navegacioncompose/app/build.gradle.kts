plugins {
    alias(libs.plugins.android.application)
    // Habilita el compilador de Compose bajo el estándar de Kotlin 2.0+
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.tu.paquete.navegacioncompose" // Mantén tu paquete original aquí
    compileSdk = 36

    defaultConfig {
        applicationId = "com.tu.paquete.navegacioncompose"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        // Activa el soporte nativo para Jetpack Compose
        compose = true
        viewBinding = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// EL BLOQUE KOTLIN SE COLOCA AQUÍ (FUERA Y ABAJO DE ANDROID)
kotlin {
    jvmToolchain(17)
}

dependencies {
    // Componentes base del sistema
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // --- ECOSISTEMA JETPACK COMPOSE (BOM compatible con Kotlin 2.0) ---
    val composeBom = platform("androidx.compose:compose-bom:2024.05.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Componentes de UI, Gráficos y Material Design 3
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Integración obligatoria con el ciclo de vida de las Actividades
    implementation("androidx.activity:activity-compose:1.9.0")

    // --- REQUISITO ESPECÍFICO DE LA ARQUITECTURA DE NAVEGACIÓN ---
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Herramientas de depuración y desarrollo
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Pruebas unitarias y de integración instrumentadas
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}