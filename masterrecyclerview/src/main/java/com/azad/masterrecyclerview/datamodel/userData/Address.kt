package com.azad.masterrecyclerview.datamodel.userData

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)