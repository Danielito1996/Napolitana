package com.elitec.napolitana.Domain

import com.elitec.napolitana.Domain.Entities.ElementTypes
import com.elitec.napolitana.Domain.Entities.IEntities

interface IGenericsFactory {
	fun <T:IEntities> ConstruirElemento(tipo:ElementTypes,id:Int):T
}