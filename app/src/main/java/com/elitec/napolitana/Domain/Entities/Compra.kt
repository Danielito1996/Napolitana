package com.elitec.napolitana.Domain.Entities

data class Compra(
    override val id: Int,
    val fecha: String,
    val monto: Int,
    val productos: List<Producto>
): IEntities