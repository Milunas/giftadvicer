package milunas.giftadvice.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import milunas.giftadvice.R
import milunas.giftadvice.provider.UserProvider
import milunas.giftadvice.ui.adapter.UserAdapter

class UserActivity : AppCompatActivity() {

    private val baseUrl = "http://10.0.2.2:8080/user/"
    private lateinit var recyclerView : RecyclerView
    private lateinit var userAdapter : UserAdapter
    private lateinit var userLayoutManager : LinearLayoutManager

    override fun onResume() {
        super.onResume()
        loadData(buildUrl())
        userAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        prepareView()
        applyView()

        val createNewGroup = findViewById<Button>(R.id.new_group_btn)
        createNewGroup.setOnClickListener{
            val intent = Intent(this, CreateGroupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun prepareView(){
        recyclerView  = findViewById(R.id.recyclerView_user)
        userAdapter = UserAdapter()
        userLayoutManager = LinearLayoutManager(this)
    }

    private fun applyView(){
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = userLayoutManager
            adapter = userAdapter
        }
    }

    private fun buildUrl() : String{
        return baseUrl + intent.getStringExtra("USER_ID") + "/group"
    }

    private fun loadData(url: String) = launch(UI) {
            val task = async(CommonPool) { UserProvider.loadData(url) }
            val result = task.await()
            userAdapter.setElements(result)
            userAdapter.notifyDataSetChanged()
        }
    }

