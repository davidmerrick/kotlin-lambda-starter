package com.merricklabs.lambda

import com.merricklabs.lambda.handlers.logic.HelloWorldLogic
import org.koin.dsl.module

val HelloWorldModule = module {
    single { HelloWorldLogic() }
}