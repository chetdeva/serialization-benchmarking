package com.chetdeva.serializationbenchmarking

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 05/04/18
 */
data class Movie(
        val title: String,
        val director: Director
)

data class Director(
        val person: Person
)

data class Person(
        val name: String
)