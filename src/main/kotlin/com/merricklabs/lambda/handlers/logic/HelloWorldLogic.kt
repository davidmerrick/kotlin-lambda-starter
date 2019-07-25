package com.merricklabs.lambda.handlers.logic

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import org.apache.http.HttpStatus
import org.koin.core.KoinComponent

class HelloWorldLogic : KoinComponent {
    fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context) = APIGatewayProxyResponseEvent().apply {
        statusCode = HttpStatus.SC_OK
        body = "Hello, world!"
    }
}