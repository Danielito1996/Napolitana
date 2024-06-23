package com.elitec.napolitana.Domain.Entities

data class Mercancias(override val id:Int,
					  val nombre:String?="",
					  val unidadMedida:String?="",
					  val medida:Double?=0.0): IEntities
