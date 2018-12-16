package zo.den.testtask4.data.util

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response

class CacheInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return if (request.method() == "GET") {
            if (isNetworkAvailable()) {
                chain.proceed(request).newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", String.format("max-age=%d", 24 * 60 * 60))
                        .build()
            } else {
                chain.proceed(request).newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", String.format("only-if-cached"))
                        .build()
            }
        } else {
            chain.proceed(request)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val networkInfo = manager?.activeNetworkInfo
        var isAvailable = false
        if (networkInfo != null && networkInfo.isConnected) {
            isAvailable = true
        }
        return isAvailable
    }
}