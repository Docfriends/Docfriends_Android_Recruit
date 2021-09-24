package com.smparkworld.docfriends.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.smparkworld.docfriends.data.repository.UserRepository
import com.smparkworld.docfriends.model.HomeUiModel
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

            // User 정보를 API에 요청하고 User의 이름을 통해 HomeUiModel.Header를 생성.
            // 임시로 아래와 같이 사용
            val header = HomeUiModel.Header("닥톡님이 궁금한 증상을 알려주세요.")

            _flow.value = Pager(
                PagingConfig(pageSize = 10)
            ) {
                userRepository.getHome(search)
            }.flow.map {
                it.map { item -> item as HomeUiModel }
                    .insertHeaderItem(item = header)
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