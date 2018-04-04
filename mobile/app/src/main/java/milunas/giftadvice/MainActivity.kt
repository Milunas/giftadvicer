package milunas.giftadvice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import milunas.giftadvice.ui.activity.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}

