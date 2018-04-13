package com.chetdeva.serializationbenchmarking

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.squareup.moshi.Moshi


class MainActivity : AppCompatActivity() {

    private val gson by lazy { Gson() }
    private val moshi by lazy { Moshi.Builder().build() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesStr = getMovies()

        benchMarkGson(moviesStr)
        benchMarkMoshi(moviesStr)
    }

    private fun benchMarkGson(rawStr: String) {
        val timeStart = System.currentTimeMillis()

        val movies: List<Movie>? = gson.fromJson(rawStr)

        val timeEnd = System.currentTimeMillis()

        println("Benchmarking Gson ${movies?.toString()}")
        println("Gson took: ${timeEnd - timeStart}")
    }

    private fun benchMarkMoshi(rawStr: String) {
        val timeStart = System.currentTimeMillis()

        val jsonAdapter = moshi.adapter<List<Movie>>(List::class.java)
        val movies: List<Movie>? = jsonAdapter.fromJson(rawStr)

        val timeEnd = System.currentTimeMillis()

        println("Benchmarking Moshi ${movies?.toString()}")
        println("Moshi took: ${timeEnd - timeStart}")
    }

    class Mapper(var value: Any?) {

        fun map(key: String): Mapper {
            val dict = value as Map<String, Any>
            return Mapper(dict[key])
        }

        fun <T> type() = value as T
    }

    @Synchronized
    private fun getMovies(): String {
        return ResourceHelper.openRawResource(resources, R.raw.movies)
    }
}
