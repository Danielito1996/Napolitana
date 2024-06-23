package com.elitec.napolitana.Domain.Entities

data class Productos(override val Id:Int,
					 var Nombre: String?="",
					 var Precio: Double?=0.0,
					 var Descripcion: String?=""):IEntities
