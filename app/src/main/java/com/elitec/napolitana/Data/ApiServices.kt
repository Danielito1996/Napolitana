package com.elitec.napolitana.Data

import com.elitec.napolitana.Domain.Entities.IEntities
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServices {
  	//Son esta variante puedo controlar la ruta de la solicitudes , montandose en la API base definida en los modulos
	@GET("{endpoint}")
	suspend fun <T: IEntities> getData(@Path("endpoint") endpoint: String): Response<T>

	@POST("{endpoint}")
	suspend fun <T: IEntities> postData(@Path("endpoint") endpoint: String, @Body data: T): Response<T>

	@PUT("{endpoint}")
	suspend fun <T: IEntities> putData(@Path("endpoint") endpoint: String, @Body data: T): Response<T>

	@DELETE("{endpoint}")
	suspend fun <T: IEntities> deleteData(@Path("endpoint") endpoint: String): Response<T>
}