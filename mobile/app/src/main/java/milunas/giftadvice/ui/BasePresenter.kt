package milunas.giftadvice.ui

import milunas.giftadvice.dependencie.component.DaggerPresenterInjector
import milunas.giftadvice.dependencie.component.PresenterInjector
import milunas.giftadvice.dependencie.module.ContextModule
import milunas.giftadvice.dependencie.module.NetworkModule
import milunas.giftadvice.ui.groups.GroupsPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    open fun onViewCreated(){}

    open fun onViewDestroyed(){}

    private fun inject() {
        when (this) {
            is GroupsPresenter -> injector.inject(this)
        }
    }
}