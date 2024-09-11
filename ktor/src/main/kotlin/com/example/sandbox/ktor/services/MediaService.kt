package com.example.sandbox.ktor.services

import com.example.sandbox.ktor.models.MediaDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

class MediaService(
    private val client: HttpClient,
) : MicroService() {
    override val name: String = "ms-media"

    suspend fun upload(
        filename: String,
        image: ByteArray,
    ): MediaDto? =
        client
            .post("$name/images") {
                setBody(
                    MultiPartFormDataContent(
                        formData {
                            append(
                                key = "file",
                                value = image,
                                headers = Headers.build {
                                    append(HttpHeaders.ContentDisposition, "filename=${filename}")
                                    append(HttpHeaders.ContentType, ContentType.Image.JPEG)
                                }
                            )
                        }
                    )
                )
            }
            .body() as? MediaDto


    suspend fun update(media: MediaDto): MediaDto? =
        client.put("$name/images") {
            setBody(media)
        }
            .body() as? MediaDto?
}