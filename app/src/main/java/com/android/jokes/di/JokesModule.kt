package com.android.jokes.di

import android.app.Application
import androidx.room.Room
import com.android.jokes.BuildConfig
import com.android.jokes.common.Constants
import com.android.jokes.data.remote.JokesApi
import com.android.jokes.data.repository.JokeRepositoryImpl
import com.android.jokes.data.room.AppDatabase
import com.android.jokes.data.room.daos.JokeDao
import com.android.jokes.domain.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JokesModule {


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        return OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideJokesApi(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokesApi::class.java)

    @Provides
    fun provideJokeRepository(jokesApi: JokesApi, jokeDao: JokeDao): JokeRepository {
        return JokeRepositoryImpl(jokesApi = jokesApi, jokeDao = jokeDao)
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            Constants.DB_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun provideJokesDao(appDatabase: AppDatabase): JokeDao {
        return appDatabase.jokeDao
    }
}