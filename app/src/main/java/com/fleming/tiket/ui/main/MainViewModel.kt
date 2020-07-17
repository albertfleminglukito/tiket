package com.fleming.tiket.ui.main

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fleming.tiket.base.scheduler.BaseSchedulerProvider
import com.fleming.tiket.domain.entity.User
import com.fleming.tiket.domain.usecase.GetUsersUseCase
import com.fleming.tiket.ui.base.BaseViewModel
import com.fleming.tiket.ui.main.pagination.UserPagination
import javax.inject.Inject

class MainViewModel @Inject constructor(
    mGetUsersUseCase: GetUsersUseCase,
    mSchedulers: BaseSchedulerProvider
): BaseViewModel() {

    @VisibleForTesting
    internal var mPagination = UserPagination(mGetUsersUseCase, mSchedulers, compositeDisposable)
    val users: LiveData<PagedList<User>> = mPagination.getDataSource()
    val loadingState: LiveData<Boolean> = mPagination.getLoadingState()
    val errorState: LiveData<Int> = mPagination.getErrorState()

    fun refreshSearch(keyword: String = "") {
        mPagination.refresh(keyword)
    }

}
