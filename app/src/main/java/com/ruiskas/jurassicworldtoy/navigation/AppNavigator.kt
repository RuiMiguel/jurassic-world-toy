package com.ruiskas.jurassicworldtoy.navigation

import androidx.navigation.fragment.findNavController
import com.ruiskas.jurassicworldtoy.navigation.base.BaseNavigator
import com.ruiskas.jurassicworldtoy.ui.splash.SplashFragmentDirections

class AppNavigator : BaseNavigator.AppBaseNavigator() {

    fun goBack() {
        if (fragment?.childFragmentManager?.backStackEntryCount == 0) {
            activity?.finish()
        } else {
            fragment?.findNavController()?.popBackStack()
        }
    }

    fun goToHome() {
        fragment?.findNavController()?.navigate(SplashFragmentDirections.actionToScreenMain())
    }

    fun goToLibrary() {
    }

    fun goToMap() {
    }

    fun goToCombat() {
    }

    fun goToProfile() {
    }

    fun goToPlayers() {
    }
}