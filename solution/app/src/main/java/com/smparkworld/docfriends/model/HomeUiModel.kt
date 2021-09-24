package com.smparkworld.docfriends.model

import androidx.recyclerview.widget.DiffUtil

sealed class HomeUiModel {

    data class Header(val user: User) : HomeUiModel(), HomeItem
    data class ItemConsult(val consult: Consult) : HomeUiModel()
    data class ItemExperts(val experts: List<Expert>): HomeUiModel()
    data class ItemCompanies(val companies: List<Company>) : HomeUiModel()
    object Separator : HomeUiModel()

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<HomeUiModel>() {

            override fun areItemsTheSame(oldItem: HomeUiModel, newItem: HomeUiModel): Boolean {
                return if (oldItem is Header && newItem is Header) {
                    oldItem.user.imgUrl == newItem.user.imgUrl
                } else if (oldItem is ItemConsult && newItem is ItemConsult) {
                    oldItem.consult.seq == newItem.consult.seq
                } else if (oldItem is ItemExperts  && newItem is ItemExperts) {
                    oldItem.experts == newItem.experts
                } else if (oldItem is ItemCompanies && newItem is ItemCompanies) {
                    oldItem.companies == newItem.companies
                } else {
                    false
                }
            }

            override fun areContentsTheSame(oldItem: HomeUiModel, newItem: HomeUiModel): Boolean {
                return if (oldItem is Header && newItem is Header) {
                    oldItem.user == newItem.user
                } else if (oldItem is ItemConsult && newItem is ItemConsult) {
                    oldItem.consult == newItem.consult
                } else if (oldItem is ItemExperts  && newItem is ItemExperts) {
                    oldItem.experts.mapIndexed { idx, e -> newItem.experts[idx] == e }        // imgUrl이 Unique 이기 때문에 비교
                                   .reduce { acc, b -> acc && b }
                } else if (oldItem is ItemCompanies && newItem is ItemCompanies) {
                    oldItem.companies.mapIndexed { idx, c -> newItem.companies[idx] == c }    // imgUrl이 Unique 이기 때문에 비교
                                     .reduce { acc, b -> acc && b }
                } else {
                    false
                }
            }
        }
    }
}

interface HomeItem