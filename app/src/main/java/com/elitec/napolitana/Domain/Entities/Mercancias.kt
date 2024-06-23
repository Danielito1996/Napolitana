package com.elitec.napolitana.Domain.Entities

data class Mercancias(override val Id:Int,
					  val Nombre:String?="",
					  val UnidadMedida:String?="",
					  val Medida:Double?=0.0): IEntities
