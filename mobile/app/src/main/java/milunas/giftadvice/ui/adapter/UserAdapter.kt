package milunas.giftadvice.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.group_row.view.*
import milunas.giftadvice.R
import milunas.giftadvice.model.Group
import milunas.giftadvice.ui.adapter.holder.UserViewHolder

class UserAdapter (private var groups: List<Group> = ArrayList()) : RecyclerView.Adapter<UserViewHolder>(){

    fun setElements(elements : List<Group>){
        groups = elements
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.group_row,parent,false)
        return UserViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val group: Group = groups[position]
        holder?.view?.group_name?.text = "Gifts for: " + group.giftedPersonName
    }

    override fun getItemCount(): Int {
        return groups.size
    }
}