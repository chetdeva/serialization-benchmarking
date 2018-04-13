package com.chetdeva.serializationbenchmarking

import android.content.res.Resources
import okio.Okio
import java.io.IOException

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 05/04/18
 */
object ResourceHelper {

    @Throws(IOException::class)
    fun openRawResource(resources: Resources, resourceId: Int): String {
        val source = Okio.source(resources.openRawResource(resourceId))
        val buffer = Okio.buffer(source)
        try {
            return buffer.readUtf8()
        } finally {
            try {
                buffer.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}