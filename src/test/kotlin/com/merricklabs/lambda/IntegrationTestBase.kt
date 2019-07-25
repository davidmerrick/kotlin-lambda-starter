package com.merricklabs.lambda

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

open class IntegrationTestBase : KoinTest {

    @BeforeMethod
    protected fun beforeMethod() {
        startKoin {
            modules(HelloWorldModule)
        }
    }

    @AfterMethod
    protected fun afterMethod() {
        stopKoin()
    }

}