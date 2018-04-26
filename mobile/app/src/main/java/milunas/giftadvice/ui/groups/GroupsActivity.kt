package milunas.giftadvice.ui.groups

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import milunas.giftadvice.R
import milunas.giftadvice.databinding.ActivityGroupsBinding
import milunas.giftadvice.model.Group
import milunas.giftadvice.ui.BaseActivity

class GroupsActivity : BaseActivity<GroupsPresenter>(), GroupsView{

    private lateinit var binding: ActivityGroupsBinding


    private val postsAdapter = GroupsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_groups)
        binding.adapter = postsAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateGroups(posts: List<Group>) {
        postsAdapter.updateGroups(posts)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): GroupsPresenter {
        return GroupsPresenter(this)
    }
}