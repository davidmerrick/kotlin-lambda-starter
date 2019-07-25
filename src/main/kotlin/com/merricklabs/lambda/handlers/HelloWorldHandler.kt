package com.merricklabs.lambda.handlers

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.merricklabs.lambda.HelloWorldModule
import com.merricklabs.lambda.handlers.logic.HelloWorldLogic
import org.koin.core.context.startKoin

class HelloWorldHandler : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private val logic: HelloWorldLogic

    init {
        startKoin {
            modules(HelloWorldModule)
        }
        logic = HelloWorldLogic()
    }

    override fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        return logic.handleRequest(input, context)
    }
}