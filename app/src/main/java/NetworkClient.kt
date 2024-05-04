import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

object NetworkClient {
    private val client = OkHttpClient()

    fun sendMessage(message: String, apiKey: String, callback: Callback) {
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val body = "{\"prompt\": \"$message\", \"max_tokens\": 50}".toRequestBody(mediaType)
        val request = Request.Builder()
                .url("https://api.openai.com/v1/engines/text-davinci-003/completions")
                .post(body)
                .addHeader("Authorization", "Bearer $apiKey")
                .build()

        client.newCall(request).enqueue(callback)
    }
}