package kr.co.softcampus.solution.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.softcampus.solution.R
import kr.co.softcampus.solution.model.DocFriendsResponse
import java.text.SimpleDateFormat
import java.util.*

class DoctorAdapter (
    private val owner : AppCompatActivity,
    private val listexpert : List<DocFriendsResponse.Expert>,
    var text:String = ""
    ) :    RecyclerView.Adapter<DoctorAdapter.ViewHolderClass>() {

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivdoctor: ImageView = itemView.findViewById(R.id.iv_doctor)
        val tvdoctorname: TextView = itemView.findViewById(R.id.tv_doctor_name)
        val tvdoctorkind: TextView = itemView.findViewById(R.id.tv_doctor_kind)
        val tvdoctorhashtag: TextView = itemView.findViewById(R.id.tv_doctor_hashtag)
        var tvdoctorhospital: TextView = itemView.findViewById(R.id.tv_doctor_hospital)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view: View?
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_doctordetail, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        with(holder) {
            tvdoctorname.text = listexpert[position].name
            tvdoctorkind.text = listexpert[position].typeName
            tvdoctorhospital.text = listexpert[position].companyName
            if (listexpert[position].profileImagePath != null) {
                Glide.with(owner).load(listexpert[position].profileImagePath).into(ivdoctor)
            } else {
                Log.d("TEST", "TEST")
            }
            //make hashtag and bind with textview
            if (listexpert[position].tagList.isNotEmpty()) {
                text = ""
                for (i in listexpert[position].tagList.indices) {
                    text += "#" + "${listexpert[position].tagList[i].name} "
                }
                tvdoctorhashtag.text = text
            }
        }
    }

    override fun getItemCount(): Int {
        return listexpert.size
    }
}
