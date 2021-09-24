package com.smparkworld.docfriends.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.smparkworld.docfriends.data.repository.UserRepository
import com.smparkworld.docfriends.model.HomeUiModel
import kotlinx.coroutines.flow.Flow
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

            _flow.value = userRepository.getHome(_search)
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