@file:Suppress("unused")

package milunas.giftadvice.util

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import milunas.giftadvice.ui.groups.GroupsAdapter

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: GroupsAdapter) {
    view.adapter = adapter
}


@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}