package com.merricklabs.lambda

import com.merricklabs.lambda.resources.ResourceConfigBuilder
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import java.net.URI

const val BASE_URI = "http://localhost:8080"

open class IntegrationTestBase : KoinTest {

    private var server: HttpServer? = null

    @BeforeMethod
    protected fun beforeMethod() {
        startKoin {
            modules(HelloWorldModule)
        }
        initResources()
    }

    @AfterMethod
    protected fun afterMethod() {
        stopKoin()
        server!!.shutdown()
    }

    private fun initResources() {
        val resourceConfigBuilder by inject<ResourceConfigBuilder>()
        val resourceConfig = resourceConfigBuilder.build()
        server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig)
    }
}