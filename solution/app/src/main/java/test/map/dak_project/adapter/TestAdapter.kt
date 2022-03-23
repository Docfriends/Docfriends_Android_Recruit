package test.map.dak_project.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import test.map.dak_project.R
import test.map.dak_project.adapter.expertAdapter.ExpertListAdapter
import test.map.dak_project.adapter.expertAdapter.ExpertTagListAdater
import test.map.dak_project.dakmodel_Package.*
import test.map.dak_project.databinding.ConsultlistItemBinding
import test.map.dak_project.databinding.ExpertlistItemBinding
import test.map.dak_project.databinding.ExpertmainItemBinding
import java.lang.IllegalArgumentException
import kotlin.coroutines.coroutineContext

//[multi 아답터 실패]
class TestAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var entityModel: List<EntityModel>
    lateinit var tagListAdapter: TagListAdapter
    lateinit var expertlistAdater: ExpertListAdapter



    inner class ConsultViewHolder(var binding: ConsultlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Consult) {
            binding.titleTextView.text = item.title
            binding.contextTextView.text = item.context
            binding.answerCntTextView.text = item.answerCnt.toString()
            binding.regDate.text = item.regDate.toString()

            tagListAdapter = TagListAdapter()
            binding.tagListRecyclerView.apply {
                adapter = tagListAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                tagListAdapter.submitList(item.tagList)
            }
        }

    }




    inner class ExpertTitleViewHolder(val binding: ExpertmainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DakItem) {
            expertlistAdater = ExpertListAdapter()


            binding.expertTitleRecyclerView.apply {
                adapter = expertlistAdater
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                expertlistAdater.submitList(item.expertList)
            }
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            consult_type1 -> {
                val view = ConsultlistItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ConsultViewHolder(view)
            }
            expert_type2 -> {
                val view = ExpertmainItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ExpertTitleViewHolder(view)
            }
            else -> {
                throw IllegalArgumentException("Error")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


//        is HomeRecylcerViewHolder.DirectorViewHolder -> holder.bind(items[position] as HomeRecyclerViewItem.Director)
        when(holder) {

            is ConsultViewHolder -> holder.bind(entityModel[position].consult as Consult)
            is ExpertTitleViewHolder -> holder.bind(entityModel[position].dakItem as DakItem)

        }


    }

    override fun getItemCount(): Int {
        return entityModel.size
    }



    override fun getItemViewType(position: Int): Int {
        return entityModel[position].type
//        return when (entityModel[position].type){
//           Consult->{
//                1
//            }
//        }
    }

    companion object {
        private const val consult_type1 = 1
        private const val expert_type2 = 2
        private const val multi_type3 = 3
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<EntityModel>) {
        entityModel = list
        notifyDataSetChanged()
    }





}