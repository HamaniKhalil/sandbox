package com.example.sandbox.ktor.services

import com.example.sandbox.ktor.models.MediaDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

class EstatesService(
    private val client: HttpClient,
) : MicroService() {
    override val name: String = "ms-estates"

    suspend fun upload(
        id: String,
        images: Map<String, ByteArray>,
    ): List<MediaDto> =
        client
            .put("$name/my/$id/images") {
                headers {

                }
                setBody(
                    MultiPartFormDataContent(
                        formData {
                            images.forEach { (filename, image) ->
                                append(
                                    key = "files",
                                    value = image,
                                    headers = Headers.build {
                                        append(HttpHeaders.ContentDisposition, "filename=${filename}")
                                        append(HttpHeaders.ContentType, ContentType.Image.JPEG)
                                    }
                                )
                            }
                        }
                    )
                )
            }
            .body() as? List<MediaDto> ?: listOf()


    suspend fun update(media: MediaDto): MediaDto? =
        client.put("$name/images") {
            setBody(media)
        }
            .body() as? MediaDto?
}