package es.correos.widget.presentation.navigation.coordinator

import com.ruiskas.jurassicworldtoy.navigation.AppNavigator

class AppCoordinator(
    private val appNavigator: AppNavigator
) {
    fun goBack() {
        appNavigator.goBack()
    }

    fun goToHome() {
        appNavigator.goToHome()
    }

    fun goToLibrary() {
        appNavigator.goToLibrary()
    }

    fun goToMap() {
        appNavigator.goToMap()
    }

    fun goToCombat() {
        appNavigator.goToCombat()
    }

    fun goToProfile() {
        appNavigator.goToProfile()
    }

    fun goToPlayers() {
        appNavigator.goToPlayers()
    }
}