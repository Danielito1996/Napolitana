package com.elitec.napolitana.Domain

import com.elitec.napolitana.Domain.Entities.Compra
import com.elitec.napolitana.Domain.Entities.ElementTypes
import com.elitec.napolitana.Domain.Entities.IEntities
import com.elitec.napolitana.Domain.Entities.Mercancias
import com.elitec.napolitana.Domain.Entities.Producto
import javax.inject.Inject

class GenericFactory @Inject constructor(): IGenericsFactory {
	override fun <T : IEntities> ConstruirElemento  (tipo: ElementTypes, id: Int): T {
		return when (tipo) {
			ElementTypes.Productos -> Producto(id) as T
			ElementTypes.Mercancias -> Mercancias(id) as T
			ElementTypes.Compras -> Compra(id) as T
		}
	}
}