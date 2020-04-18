package com.ruiskas.jurassicworldtoy.di

import com.ruiskas.jurassicworldtoy.viewmodel.MainViewModel
import com.ruiskas.jurassicworldtoy.viewmodel.RootViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ruiskas.jurassicworldtoy.domain.usecases.DoWait
import com.ruiskas.jurassicworldtoy.navigation.AppNavigator
import com.ruiskas.jurassicworldtoy.navigation.base.NavigatorLifecycle
import es.correos.widget.presentation.navigation.coordinator.AppCoordinator
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

@JvmField
val presentationModule: Module = module {
    //region Navigation
    single { NavigatorLifecycle() }

    single { AppNavigator() }
    single { AppCoordinator(appNavigator = get()) }
    //endregion

    viewModel {
        RootViewModel(
            appCoordinator = get(),
            doWait = get()
        )
    }

    viewModel {
        MainViewModel(
            appCoordinator = get()
        )
    }
}

@JvmField
val domainModule: Module = module {
    //region UseCases
    factory {
        DoWait()
    }

    //endregion
}

@JvmField
val dataModule: Module = module {
    single { getGson() } bind (Gson::class)

    //region Repositories

    //endregion

    //region Datasources

    //endregion

    //region ApiServices

    //endregion
}

object Property {
    const val API_URL = "API_URL"
}

@JvmField
val baseModules = listOf(presentationModule, domainModule, dataModule)

fun getGson(): Gson = GsonBuilder().serializeNulls().create()