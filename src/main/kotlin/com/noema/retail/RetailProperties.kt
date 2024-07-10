package com.noema.retail

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "retail")

class RetailProperties(
    var authenticationUrl: String = "",
)