package it.reply.iriscube.unito

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

/**
 * Custom assertion to verify that the number of items in the RecyclerView is the same as the one passed as a parameter
 *
 * @param the number of element expected on the RecyclerView
 */
class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {

        // TODO verify that the number of items in the RecyclerView is the same as the one passed as a parameter

    }
}
