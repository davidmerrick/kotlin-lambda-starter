package com.merricklabs.lambda.handlers.logic

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.merricklabs.lambda.IntegrationTestBase
import io.kotlintest.shouldBe
import org.apache.http.HttpStatus
import org.koin.test.get
import org.mockito.Mockito
import org.testng.annotations.Test

class HelloWorldLogicTest : IntegrationTestBase() {

    private val mockInput = APIGatewayProxyRequestEvent()
    private val mockContext = Mockito.mock(Context::class.java)

    @Test
    fun `Hello world should return hello world`() {
        val logic = get<HelloWorldLogic>()
        val response = logic.handleRequest(mockInput, mockContext)
        response.statusCode shouldBe HttpStatus.SC_OK
        response.body shouldBe MESSAGE
    }
}
