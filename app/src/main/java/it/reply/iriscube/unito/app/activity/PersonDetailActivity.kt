package it.reply.iriscube.unito.app.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import it.reply.iriscube.unito.datasource.api.Person

/**
 * Created by Reply.
 */
class PersonDetailActivity : AppCompatActivity() {

    companion object {

        const val PERSON_ID_EXTRA = "person_id"

        fun newIntent(context: Context, person: Person): Intent =
            Intent(context, PersonDetailActivity::class.java).apply {
                putExtra(PERSON_ID_EXTRA, person.id)
            }
    }


}