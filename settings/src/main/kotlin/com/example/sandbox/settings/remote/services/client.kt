package com.example.sandbox.settings.remote.services

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


val client = HttpClient(CIO) {

    defaultRequest {
        url("http://localhost/tablet/")

        headers["Authorization"] =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyIiwianRpIjoiNWJmYzIyMDMwOTJhMjY5YWFmZGRhMTQ1OGJhZTcxYmVmNmRiYTk3YWEzYWE3NmQ1Y2QyNWRiNGE3MzQzNTNjMDAxODQwMDQ2YTgyNGY4M2UiLCJpYXQiOjE3MjE4MjQyNDcsIm5iZiI6MTcyMTgyNDI0NywiZXhwIjoxNzIxOTEwNjQ2LCJzdWIiOiIxNyIsInNjb3BlcyI6WyIqIl0sImJveGVzIjpbXSwiYWRtaW4iOnRydWV9.E5z4uFYxI44U2Fws3zEy6EsIPggkAMJd14VLI4sORq9C2Tv1Rt4ssbEQrh5G7hhEqe8HM29tjVuyPSHbKPsCt5xuYKI1sX5lGbfnjsI6KmKIYz6hbXWytvGKcn5whjw1VtiQb4Bf8wb4DFIQEoqmnLTaUza1eBODPR4uxuQ5nGb5DzcY5neElU2Hd4woWxIPDCD1ynW8M1UBwF02J7ggz_ueRFf6_NRbw5eDEoRsz2q5Quyqm8pRLP3MRWEGoDlL92vlKmp2ok4ieWEvCA4k31Q59BFxoh2kLFGSnROovLLNpty6Tx_Rby1SPCbFXnBsjZS4ySZO2U8bsgvHk0Y2fw1KlnMVR7mcTcJfJUl_PqVJGaNNVo82o6jCvWNZWcyTFrLkS4wuUU8djFFRRplz44ALKX-9VC8x0nYpvhZ8Rhw_u32kU899kNDmijxkQcxHex0pnBRWowcavFb9QeU_vlVBRSYjQ-xqOAdDjayVXRBh7Uz6-Ws9TrsHPRJpddo_-LY1CZzTbfyYfE4qk9hGf3y5RZz6Hgmu3W1y2P3layMCYzNQjgjMxSx3vnI-ZAXt8WPXGhJvCx9eAB1FPTpO8_k7li8OI8qcd0nkly3eG2hjW9cKMrQ_eKsic8rcgUyJEg2YsLnUApixDGGzjPgHznsvtfZ-g2srYVV0tgWQKRI"

        contentType(ContentType.Application.Json)
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }

    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
        )
    }
}