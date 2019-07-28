package com.merricklabs.lambda.resources

import com.merricklabs.lambda.BASE_URI
import com.merricklabs.lambda.IntegrationTestBase
import com.merricklabs.lambda.handlers.logic.HELLO_WORLD
import io.kotlintest.shouldBe
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.http.HttpStatus
import org.testng.annotations.Test

class HelloResourceTest : IntegrationTestBase() {

    private val okHttpClient = OkHttpClient()

    @Test
    fun `Resource should return "hello, world!"`(){
        val request = Request.Builder()
                .url(BASE_URI)
                .get()
                .build()
        val response = okHttpClient.newCall(request).execute()
        response.code shouldBe HttpStatus.SC_OK
        response.body!!.string() shouldBe HELLO_WORLD
    }
}
