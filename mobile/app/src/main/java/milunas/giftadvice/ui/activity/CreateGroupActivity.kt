package milunas.giftadvice.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import milunas.giftadvice.R
import milunas.giftadvice.model.Group
import milunas.giftadvice.provider.UserProvider

class CreateGroupActivity : AppCompatActivity() {
    private val baseUrl : String = "http://10.0.2.2:8080/user/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        val group = Group(null,"Coco", null, null)
        val btn = findViewById<Button>(R.id.add_group_btn)
        btn.setOnClickListener {
            addGroup(group)
            Toast.makeText(this, "Created!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addGroup(group: Group) = launch(UI){
        val task = async(CommonPool) {
            UserProvider.addNewGroup(buildUrl(),group)
        }
        val response = task.await()
        println(response)
    }

    private fun buildUrl() : String{
        return baseUrl + intent.getStringExtra("USER_ID") + "/group"
    }

}