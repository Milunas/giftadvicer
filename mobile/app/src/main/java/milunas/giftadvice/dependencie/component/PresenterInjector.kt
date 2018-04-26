package milunas.giftadvice.dependencie.component

import dagger.BindsInstance
import dagger.Component
import milunas.giftadvice.dependencie.module.ContextModule
import milunas.giftadvice.dependencie.module.NetworkModule
import milunas.giftadvice.ui.BaseView
import milunas.giftadvice.ui.groups.GroupsPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {

    fun inject(groupsPresenter: GroupsPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}