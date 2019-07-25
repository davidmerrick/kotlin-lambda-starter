package com.merricklabs.lambda.handlers.logic

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import mu.KotlinLogging
import org.apache.http.HttpStatus
import org.koin.core.KoinComponent

private val log = KotlinLogging.logger {}
const val MESSAGE = "Hello, world!"

class HelloWorldLogic : KoinComponent {
    fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context): APIGatewayProxyResponseEvent {
        log.info(MESSAGE)
        return APIGatewayProxyResponseEvent().apply {
            statusCode = HttpStatus.SC_OK
            body = MESSAGE
        }
    }
}