package com.elitec.napolitana.Domain

import com.elitec.napolitana.Domain.Entities.ElementTypes
import com.elitec.napolitana.Domain.Entities.IEntities
import com.elitec.napolitana.Domain.Entities.Productos
import java.lang.annotation.ElementType
import javax.inject.Inject

class GenericFactory @Inject constructor(): IGenericsFactory {
	override fun <T : IEntities> ConstruirElemento  (tipo: ElementTypes, id: Int): T {
		return when (tipo) {
			ElementTypes.Productos -> Productos(id) as T
			ElementTypes.Mercancias -> Productos(id) as T
		}
	}
}