package com.example.lmcxml.core.di

import kotlin.reflect.KClass

interface GlobalDI {
    fun <T : Any> get(class_: KClass<T>): T
    fun <T : Any> add(key: KClass<T>, object_: T)
}

interface CriticDiComponent {
    fun getCriticDi(): GlobalDI = DiProvider.di
}

inline fun <reified T : Any> criticDi(): Lazy<T> =
    lazy(LazyThreadSafetyMode.SYNCHRONIZED) { DiProvider.di.get(T::class) }
