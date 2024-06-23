package com.elitec.napolitana.Domain.Modules

import com.elitec.napolitana.Data.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

	@Singleton
	@Provides
	fun provideRetrofit():Retrofit {
		return Retrofit.Builder().baseUrl("https://MyUrl.com/API")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	@Provides
	fun provideApiServices(retrofit: Retrofit): ApiServices {
		return retrofit.create(ApiServices::class.java)
	}
}