package com.merricklabs.lambda

import com.merricklabs.lambda.handlers.logic.HelloWorldLogic
import com.merricklabs.lambda.util.HelloWorldObjectMapper
import org.koin.dsl.module

val HelloWorldModule = module {
    single { HelloWorldLogic() }
    single { HelloWorldObjectMapper() }
}