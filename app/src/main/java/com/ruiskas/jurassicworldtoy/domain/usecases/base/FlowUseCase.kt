package com.ruiskas.jurassicworldtoy.domain.usecases.base

import arrow.core.Either
import com.ruiskas.jurassicworldtoy.domain.error.Failure
import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<Type, in Params> where Type : Any? {
    abstract fun run(params: Params? = null): Flow<Either<Failure, Type>>

    @JvmOverloads
    operator fun invoke(
        params: Params? = null
    ): Flow<Either<Failure, Type>> {
        return run(params)
    }
}