package milunas.giftadvice.ui.groups

import android.support.annotation.StringRes
import milunas.giftadvice.model.Group
import milunas.giftadvice.ui.BaseView

interface GroupsView : BaseView {

    fun updateGroups(posts: List<Group>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}