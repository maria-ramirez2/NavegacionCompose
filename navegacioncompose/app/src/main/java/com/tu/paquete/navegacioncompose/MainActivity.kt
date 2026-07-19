package com.tu.paquete.navegacioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

// Definición de Colores
val TurquoiseLight = Color(0xFFB2EBF2)
val NavyBlue = Color(0xFF1A237E)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppNavigation()
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object Details : Screen("details")
}

@Composable
fun MainAppNavigation() {
    val navController = rememberNavController()
    // Estado global para el color de la aplicación
    var isNavyTheme by remember { mutableStateOf(false) }
    val currentThemeColor = if (isNavyTheme) NavyBlue else TurquoiseLight
    val contentColor = if (isNavyTheme) Color.White else Color.Black

    Scaffold(
        bottomBar = { BottomNavigationBar(navController, currentThemeColor, contentColor) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .padding(innerPadding)
                .background(currentThemeColor),
            enterTransition = { fadeIn(animationSpec = tween(500)) },
            exitTransition = { fadeOut(animationSpec = tween(500)) }
        ) {
            composable(Screen.Home.route) { HomeScreen(contentColor) }
            composable(Screen.Profile.route) { ProfileScreen(contentColor) }
            composable(Screen.Settings.route) {
                SettingsScreen(contentColor) { isNavyTheme = true }
            }
            composable(Screen.Details.route) { DetailsScreen(contentColor) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController, bgColor: Color, contentColor: Color) {
    val items = listOf(
        Triple(Screen.Home.route, "Home", Icons.Filled.Home),
        Triple(Screen.Profile.route, "Perfil", Icons.Filled.Person),
        Triple(Screen.Details.route, "Detalles", Icons.Filled.Info),
        Triple(Screen.Settings.route, "Ajustes", Icons.Filled.Settings)
    )

    NavigationBar(containerColor = bgColor) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label, tint = contentColor) },
                label = { Text(label, color = contentColor) },
                selected = currentRoute == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

// Plantilla Base para todas las pantallas
@Composable
fun ScreenLayout(
    title: String,
    imageVector: ImageVector,
    contentColor: Color,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = contentColor
        )

        Spacer(modifier = Modifier.height(30.dp))

        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(150.dp),
            tint = contentColor
        )

        Spacer(modifier = Modifier.height(30.dp))

        content()

        Spacer(modifier = Modifier.weight(1f))

        // Texto del Ingeniero persistente arriba de la barra
        Text(
            text = "Ingeniero Desarrollador: María Ramirez",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            color = contentColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun HomeScreen(contentColor: Color) {
    ScreenLayout("Hola, Bienvenido", Icons.Filled.ThumbUp, contentColor) {
        Text(
            "¡Es un gusto tenerte de vuelta!",
            textAlign = TextAlign.Center,
            color = contentColor,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ProfileScreen(contentColor: Color) {
    ScreenLayout("Perfil", Icons.Filled.AccountCircle, contentColor) {
        Text(
            text = "Nombre de Usuario",
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = contentColor
        )
    }
}

@Composable
fun SettingsScreen(contentColor: Color, onThemeChange: () -> Unit) {
    ScreenLayout("Ajustes", Icons.Filled.Settings, contentColor) {
        Text("Configura tu experiencia visual", color = contentColor)

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = onThemeChange,
            colors = ButtonDefaults.buttonColors(containerColor = NavyBlue)
        ) {
            Text("CAMBIAR A MODO OSCURO", color = Color.White)
        }
    }
}

@Composable
fun DetailsScreen(contentColor: Color) {
    ScreenLayout("Detalles del Proyecto", Icons.Filled.Info, contentColor) {
        Text(
            text = "esta aplicacion se desarrollo para aplicar los conceptos de navegacion en kotlin para la materia de desarrollo movil",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = contentColor,
            lineHeight = 26.sp
        )
    }
}

