package com.example.sandbox.flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Function to download a file asynchronously
suspend fun downloadFileAsync(url: String, counter: Int): String {
    delay((1000 * counter).toLong()) // Simulate downloading file from URL, replace with actual download code
    return "Downloaded file: $url" // Return the file path or some identifier
}

// Function to download multiple files and emit each download result as a flow
@OptIn(ExperimentalCoroutinesApi::class)
fun downloadFilesAsFlow(urls: List<String>): Flow<String> = flow {
    var counter = urls.size
    emitAll(
        urls.map { url ->
            flow {
                emit(downloadFileAsync(url, 1))
            }
        }
            .asFlow()
            .flatMapMerge { it }
    )
}

// Example usage
fun main() {
    // List of URLs to download
    val urls = listOf("url1", "url2", "url3")

    val downloads = downloadFilesAsFlow(urls)
    // Launch download operations and obtain Flow of download results
    runBlocking(Dispatchers.Default) {
        downloads.collect { result ->
            println("Downloaded: $result")
        }
    }
}

