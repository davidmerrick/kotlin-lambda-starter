package com.merricklabs.lambda

import com.fasterxml.jackson.databind.ObjectMapper
import com.merricklabs.lambda.handlers.logic.HelloLogic
import com.merricklabs.lambda.resources.HelloResource
import com.merricklabs.lambda.resources.ResourceConfigBuilder
import com.merricklabs.lambda.util.HelloWorldObjectMapper
import org.koin.dsl.module

val HelloWorldModule = module {
    single { HelloLogic() }
    single { HelloResource() }
    single { ResourceConfigBuilder() }
    single { HelloWorldObjectMapper() as ObjectMapper }
}