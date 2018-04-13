package com.chetdeva.serializationbenchmarking

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 05/04/18
 */
inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object : TypeToken<T>() {}.type)
