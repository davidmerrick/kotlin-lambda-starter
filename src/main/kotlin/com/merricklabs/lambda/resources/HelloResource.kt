package com.merricklabs.lambda.resources

import com.merricklabs.lambda.handlers.logic.HelloLogic
import org.koin.core.KoinComponent
import org.koin.core.inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/")
class HelloResource: KoinComponent {
    private val logic by inject<HelloLogic>()

    @GET
    fun sayHello(): Response {
        return Response.ok(logic.sayHello()).build()
    }
}