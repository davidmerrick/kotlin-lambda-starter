package com.merricklabs.lambda.handlers.logic

import org.koin.core.KoinComponent

const val HELLO_WORLD = "Hello, world!"

class HelloLogic : KoinComponent {
    fun sayHello() = HELLO_WORLD
}