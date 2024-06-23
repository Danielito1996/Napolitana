package com.elitec.napolitana.Data

import android.renderscript.Element.DataType
import com.elitec.napolitana.Domain.Entities.IEntities
import com.elitec.napolitana.Domain.Entities.Productos
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
	@GET("URL")
	suspend fun <T:IEntities> getData(): Response<T>
}