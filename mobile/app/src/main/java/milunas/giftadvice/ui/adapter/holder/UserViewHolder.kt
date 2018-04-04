package milunas.giftadvice.ui.adapter.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import milunas.giftadvice.model.Group
import milunas.giftadvice.ui.activity.GroupDetailsActivity

/**
 * Created by Łukasz on 03.04.2018.
 */
class UserViewHolder (val view: View, private var group: Group? = null) : RecyclerView.ViewHolder(view) {

    companion object {
        val GROUP_ID_KEY = "GROUP_ID"
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, GroupDetailsActivity::class.java)
            intent.putExtra(GROUP_ID_KEY, group?.id)
            view.context.startActivity(intent)
        }
    }
}