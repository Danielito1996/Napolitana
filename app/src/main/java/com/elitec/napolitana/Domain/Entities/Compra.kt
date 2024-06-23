package com.elitec.napolitana.Domain.Entities

data class Compra(
    override val id: Int,
    val fecha: String?="",
    var monto: Double=0.0,
    var productos: List<Producto>?= null
): IEntities