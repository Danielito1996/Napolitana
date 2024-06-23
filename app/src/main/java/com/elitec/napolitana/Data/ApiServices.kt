package com.elitec.napolitana.Data

import com.elitec.napolitana.Domain.Entities.IEntities
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
	@GET("https://192.168.68.220:7062/api")
	suspend fun <T:IEntities> getData(): Response<T>
}