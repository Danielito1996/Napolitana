package com.elitec.napolitana.Domain.Repository

import com.elitec.napolitana.Data.ApiServices
import com.elitec.napolitana.Domain.Entities.IEntities
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiServices:ApiServices) {
	suspend fun <T:IEntities> getEndpointData(): Response<T> {
		return apiServices.getData()
	}
}