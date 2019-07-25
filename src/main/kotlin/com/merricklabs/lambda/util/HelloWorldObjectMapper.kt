package com.merricklabs.lambda.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class HelloWorldObjectMapper : ObjectMapper() {

    init {
        this.registerModule(KotlinModule())
    }
}