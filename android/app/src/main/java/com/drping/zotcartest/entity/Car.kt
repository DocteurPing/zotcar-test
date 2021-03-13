package com.drping.zotcartest.entity

import java.io.Serializable

class Car(
    val brand: String,
    val model: String,
    val registration: String,
    val oil: String,
    val seat: String,
    val door: String,
    val desc: String,
    val image: String
) : Serializable