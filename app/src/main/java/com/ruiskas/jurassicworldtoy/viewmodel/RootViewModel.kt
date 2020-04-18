package com.ruiskas.jurassicworldtoy.viewmodel

import com.eurekup.lunegate.viewmodel.base.BaseViewModel
import com.ruiskas.jurassicworldtoy.domain.usecases.DoWait
import es.correos.widget.presentation.navigation.coordinator.AppCoordinator
import kotlinx.coroutines.launch

class RootViewModel(
    private val appCoordinator: AppCoordinator,
    private val doWait: DoWait
) : BaseViewModel() {
    private val SPLASH_TIME = 7L

    init {
        loadConfiguration()
    }

    fun loadConfiguration() {
        scope.launch {
            doWait(DoWait.Params.forTime(SPLASH_TIME))
            appCoordinator.goToHome()
        }
    }
}