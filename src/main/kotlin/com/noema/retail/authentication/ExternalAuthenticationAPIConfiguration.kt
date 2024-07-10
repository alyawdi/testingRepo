package com.noema.retail.authentication

import com.noema.retail.RetailProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ExternalAuthenticationAPIConfiguration( private val retailProperties: RetailProperties) {

    @Bean
    suspend fun externalAPI(): ExternalAuthenticationAPI {
        return ExternalAuthenticationAPI(url = retailProperties.authenticationUrl);
    }

}