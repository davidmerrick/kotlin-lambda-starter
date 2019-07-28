package com.merricklabs.lambda.resources

import com.merricklabs.aion.resources.mappers.HttpExceptionMapper
import com.merricklabs.aion.resources.mappers.IllegalArgumentExceptionMapper
import com.merricklabs.lambda.resources.filters.CorsFilter
import org.glassfish.jersey.server.ResourceConfig
import org.koin.core.KoinComponent
import org.koin.core.inject

class ResourceConfigBuilder : KoinComponent {

    private val calendarResource by inject<HelloResource>()

    fun build() = ResourceConfig()
            .register(calendarResource)
            .register(HttpExceptionMapper::class.java)
            .register(CorsFilter::class.java)
            .register(IllegalArgumentExceptionMapper::class.java)!!
}