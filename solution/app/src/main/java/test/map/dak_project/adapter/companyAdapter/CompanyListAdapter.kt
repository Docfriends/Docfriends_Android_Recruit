package test.map.dak_project.adapter.companyAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import test.map.dak_project.dakmodel_Package.Company
import test.map.dak_project.databinding.CompanylistItemBinding

//[ CompanyList 아답터 생성 ]
class CompanyListAdapter : RecyclerView.Adapter<CompanyListAdapter.CompanyListViewHolder>() {
    lateinit var companymodel: List<Company>

    inner class CompanyListViewHolder(val binding: CompanylistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Company) {
            binding.companyitem = item

            Glide.with(itemView).load(item.introPath).into(binding.companyImageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListViewHolder {
        val view =
            CompanylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompanyListViewHolder, position: Int) {
        holder.bind(companymodel[position])
    }

    override fun getItemCount(): Int {
        return companymodel.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitlist(list: List<Company>?) {
        companymodel = list!!
        notifyDataSetChanged()
    }
}