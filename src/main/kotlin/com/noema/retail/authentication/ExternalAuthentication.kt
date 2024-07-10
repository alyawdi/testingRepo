package com.noema.retail.authentication

import org.springframework.stereotype.Component


@Component
class AuthenticationService( private val externalAuthentication: ExternalAuthenticationAPI) {
    suspend fun authenticate (username: String) {
        println("Authenticating user $username")
    }

}


class ExternalAuthenticationAPI(url: String) {

}

