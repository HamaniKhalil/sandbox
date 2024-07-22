package com.example.sandbox.preferences.util

interface ModelMapper<Domain, Destination> {
    fun to(domain: Domain): Destination
    fun from(destination: Destination): Domain
}