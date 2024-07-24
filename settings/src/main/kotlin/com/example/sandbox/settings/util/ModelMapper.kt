package com.example.sandbox.settings.util

interface ModelMapper<Domain, Destination> {
    fun to(domain: Domain): Destination
    fun from(destination: Destination): Domain
}