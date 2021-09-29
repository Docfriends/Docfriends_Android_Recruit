package com.smparkworld.docfriends.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.smparkworld.docfriends.data.remote.UserRemoteDataSource
import com.smparkworld.docfriends.model.HomeUiModel
import com.smparkworld.docfriends.model.Result.Error
import com.smparkworld.docfriends.model.Result.Success

class HomePagingSource(
    private val remoteDataSource: UserRemoteDataSource,
    private val search: String?
) : PagingSource<Int, HomeUiModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeUiModel> {

        return try {
            val nextPage = params.key ?: 1

            val result = remoteDataSource.getHome(search)
            if (result is Success) {
                with(result.data) {
                    val data = mutableListOf<HomeUiModel>().apply {
                        addAll(consults.map { HomeUiModel.ItemConsult(it) })
                        add(expertsPosition - 1, HomeUiModel.ItemExperts(experts))
                        add(companiesPosition - 1, HomeUiModel.ItemCompanies(companies))
                    }

                    val isAvailable = (pageMap.pageNum * pageMap.rowPerPage < pageMap.totalCnt)
                    LoadResult.Page(
                        data = data,
                        prevKey = null,
                        nextKey = if (isAvailable) nextPage + 1 else null
                    )
                }
            } else {
                throw (result as Error).e
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HomeUiModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}