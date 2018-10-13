package com.github.posko.core.data.api.config

import com.github.posko.core.data.api.generator.ServiceGenerator

interface ServiceConfiguration {

    fun getConfig() : ServiceGenerator.Builder
}