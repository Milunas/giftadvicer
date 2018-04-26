package milunas.giftadvice.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import milunas.giftadvice.ui.groups.GroupsActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, GroupsActivity::class.java)
        startActivity(intent)
    }
}