package com.example.lmcxml.di

import com.example.lmcxml.core.di.GlobalDI
import kotlin.reflect.KClass

class GlobalDiImpl: GlobalDI {

    private val classes = mutableMapOf<Any, Any>()
    override fun <T : Any> get(class_: KClass<T>): T {
        if (classes[class_] != null) {
            return classes[class_] as T
        } else {
            throw ClassNotFoundException("Instance of $class_ not found.")
        }
    }

    override fun <T : Any> add(key: KClass<T>, object_: T) {
        classes[key] = object_
    }

}