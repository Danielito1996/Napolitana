package com.elitec.napolitana.Domain.Entities

data class Producto( override val id: Int,
    val nombre: String?="",
    val precio: Double?=0.0,
    var descripcion: String?=""
) : IEntities