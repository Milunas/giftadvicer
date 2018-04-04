package milunas.giftadvice.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import milunas.giftadvice.R
import milunas.giftadvice.model.User
import milunas.giftadvice.provider.UserProvider

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btn = findViewById<Button>(R.id.login_button)
        btn.setOnClickListener{
            goIn(userPrepare())
        }
    }

    private fun goIn(user: User)= launch(UI) {
        val task = async(CommonPool) { UserProvider.goIn(user)}
        val result = task.await()
        val intent = Intent(this@LoginActivity, UserActivity::class.java)
        intent.putExtra("USER_ID", result.header("Localization"))
        startActivity(intent)
    }

    private fun userPrepare(): User {
        val userName = findViewById<EditText>(R.id.user_name)
        val userPassword = findViewById<EditText>(R.id.user_password)
        val userNameStr = userName.text.toString()
        val userPasswordStr = userPassword.text.toString()
        return User(null, userNameStr, userPasswordStr)
    }

}