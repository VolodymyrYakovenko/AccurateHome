import android.util.Log
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import java.nio.charset.Charset

class RequestInterceptor : Interceptor {
    private val UTF8 = Charset.forName("UTF-8")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        // Log request body
        val requestBody = request.body
        val requestBodyString = requestBody?.let {
            val buffer = Buffer()
            it.writeTo(buffer)
            buffer.readString(UTF8)
        }

        Log.d("API", "$requestBodyString")

        return chain.proceed(request)
    }
}