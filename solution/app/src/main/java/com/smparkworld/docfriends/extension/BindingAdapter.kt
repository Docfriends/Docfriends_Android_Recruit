package com.smparkworld.docfriends.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("hiddenBy")
fun hiddenBy(fab: FloatingActionButton, recyclerView: RecyclerView) {
    recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0) fab.hide() else fab.show()
        }
    })
}