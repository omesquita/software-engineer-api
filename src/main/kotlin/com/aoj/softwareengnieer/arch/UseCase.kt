package com.aoj.softwareengnieer.arch

abstract class UseCase<in P, out O> {

    operator fun invoke(params: P): O {
        return this.execute(params)
    }

    abstract fun execute(params: P): O
}