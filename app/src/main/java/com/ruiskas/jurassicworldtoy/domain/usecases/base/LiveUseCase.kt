package com.ruiskas.jurassicworldtoy.domain.usecases.base

import androidx.lifecycle.LiveData
import arrow.core.Either
import com.ruiskas.jurassicworldtoy.domain.error.Failure

abstract class LiveUseCase<Type, in Params> where Type : Any? {
    abstract fun run(params: Params? = null): LiveData<Either<Failure, Type>>

    @JvmOverloads
    operator fun invoke(
        params: Params? = null
    ): LiveData<Either<Failure, Type>> {
        return run(params)
    }
}