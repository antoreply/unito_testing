package it.reply.iriscube.unito.app.utils

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Created by Reply on 2020-04-19.
 */

object EspressoIdlingRsource {

    const val RESOURCE = "RESOURCE"

    val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }
    }
}