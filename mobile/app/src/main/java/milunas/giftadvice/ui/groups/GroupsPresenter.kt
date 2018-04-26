package milunas.giftadvice.ui.groups

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import milunas.giftadvice.R
import milunas.giftadvice.network.UserApi
import milunas.giftadvice.ui.BasePresenter
import javax.inject.Inject

class GroupsPresenter(groupsView: GroupsView) : BasePresenter<GroupsView>(groupsView){
    @Inject
    lateinit var userApi: UserApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    fun loadPosts() {
        view.showLoading()
        subscription = userApi
                .getGroups()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { groupList -> view.updateGroups(groupList) },
                        { view.showError(R.string.unknown_error) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}