package com.smparkworld.docfriends.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.smparkworld.docfriends.data.repository.UserRepository
import com.smparkworld.docfriends.model.HomeUiModel
import com.smparkworld.docfriends.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _flow = MutableLiveData<Flow<PagingData<HomeUiModel>>>()
    val flow: LiveData<Flow<PagingData<HomeUiModel>>> = _flow

    private var _search: String? = null

    fun loadHome(search: String? = null) {
        _search = search

        viewModelScope.launch {

            // API에서 User 정보를 가져온 후 Pager생성. 임시로 아래와 같이 사용.
            val user = User("닥톡", "")

            _flow.value = Pager(
                PagingConfig(pageSize = 10)
            ) {
                userRepository.getHome(search)
            }.flow.map { data ->
                data.insertHeaderItem(item = HomeUiModel.Header(user))
                    .insertSeparators { before, after ->
                        if (before != null && after != null) HomeUiModel.Separator else null
                    }
            }.cachedIn(viewModelScope)
        }
    }

    fun setUsersLoadState(loadState: CombinedLoadStates?) {
        val state = loadState?.refresh
        _loading.value = state is LoadState.Loading

        if (state is LoadState.Error) {
            state.error.printStackTrace()
        }
    }

    fun refresh() {
        loadHome(_search)
    }
}