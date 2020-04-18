package com.ruiskas.jurassicworldtoy.domain.usecases.base

import com.ruiskas.jurassicworldtoy.domain.error.Failure
import arrow.core.Either

abstract class UseCase<out Type, in Params> where Type : Any? {
    abstract fun run(params: Params? = null): Either<Failure, Type>

    @JvmOverloads
    operator fun invoke(
        params: Params? = null
    ): Either<Failure, Type> {
        return run(params)
    }
}