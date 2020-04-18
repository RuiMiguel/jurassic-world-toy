package com.ruiskas.jurassicworldtoy.navigation.base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import org.koin.core.KoinComponent
import org.koin.core.inject

sealed class BaseNavigator : KoinComponent {
    abstract class AppBaseNavigator : BaseNavigator()
    abstract class FeatureBaseNavigator : BaseNavigator()

    private val navigatorLifecycle: NavigatorLifecycle by inject()

    protected var activity: FragmentActivity?
        get() = navigatorLifecycle.activity
        set(value) {
            navigatorLifecycle.activity = value
        }

    protected val fragment: Fragment?
        get() = activity?.supportFragmentManager?.primaryNavigationFragment


    protected fun clearBackStackTo(clear: Boolean, @IdRes to: Int ): NavOptions? {
        return if(clear) {
            navOptions {
                popUpTo = to
            }
        }
        else null
    }
}