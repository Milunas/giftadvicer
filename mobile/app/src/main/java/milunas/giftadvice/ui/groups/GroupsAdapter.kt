package milunas.giftadvice.ui.groups

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import milunas.giftadvice.R
import milunas.giftadvice.model.Group
import milunas.giftadvice.databinding.ItemGroupBinding

class GroupsAdapter (private val context: Context) : RecyclerView.Adapter<GroupsAdapter.GroupsViewHolder>() {

    private var posts: List<Group> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GroupsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemGroupBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_group, parent, false)
        return GroupsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: GroupsViewHolder?, position: Int) {
        holder?.bind(posts[position])
    }

    fun updateGroups(posts: List<Group>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class GroupsViewHolder(private val binding:  ItemGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(group: Group) {
            binding.group = group
            binding.executePendingBindings()
        }
    }
}