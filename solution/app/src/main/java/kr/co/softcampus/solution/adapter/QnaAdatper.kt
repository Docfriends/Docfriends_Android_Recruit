package kr.co.softcampus.solution.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.softcampus.solution.R
import kr.co.softcampus.solution.databinding.*
import kr.co.softcampus.solution.model.DocFriendsResponse
import kr.co.softcampus.solution.model.DocFriendsResponse.Companion.IMAGE_TYPE
import kr.co.softcampus.solution.model.DocFriendsResponse.Companion.IMAGE_TYPE2
import kr.co.softcampus.solution.model.DocFriendsResponse.Companion.IMAGE_TYPE3
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Gnoss
 * @email silmxmail@naver.com
 * @created 2021-08-03
 * @desc
 */
class QnaAdatper(
    private val list: List<DocFriendsResponse>,
    private val listconsult : List<DocFriendsResponse.Consult>,
    private val listexpert : List<DocFriendsResponse.Expert>,
    private val listcompany : List<DocFriendsResponse.Company>,
    var text:String = ""
) :    RecyclerView.Adapter<QnaAdatper.ViewHolderClass>(){

    inner class ViewHolderClass(private val binding : ItemRecyclerviewQnaBinding): RecyclerView.ViewHolder(binding.root){
        val title : TextView = binding.tvQnaTitle
        val context : TextView = binding.tvQnaContent
        val answercnt : TextView = binding.tvQnaAnswer
        val date : TextView = binding.tvQnaDate
        val hashtag : TextView = binding.tvQnaHashtag
    }

    inner class ViewHolderClass2(private val binding : ItemRecyclerviewDoctordetailBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivdoctor: ImageView = itemView.findViewById(R.id.iv_doctor)
        val tvdoctorname : TextView = itemView.findViewById(R.id.tv_doctor_name)
        val tvdoctorkind : TextView = itemView.findViewById(R.id.tv_doctor_kind)
        var tvdoctorhospital : RatingBar = itemView.findViewById(R.id.tv_doctor_hospital)
    }

    inner class ViewHolderClass3(private val binding : ItemRecyclerviewHospitaldetailBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivhospital: TextView = itemView.findViewById(R.id.iv_hospital)
        val tvhospitalname : TextView = itemView.findViewById(R.id.tv_hospitalname)
        var tvhospitallocation : RatingBar = itemView.findViewById(R.id.tv_hospitallocation)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = ItemRecyclerviewQnaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val obj = list[position]
        if(obj.consultList[position].type == IMAGE_TYPE){
            (holder as ViewHolderClass).title.text = listconsult[position].title
            holder.context.text = listconsult[position].context
            holder.answercnt.text = "답변" + listconsult[position].answerCnt.toString()
            holder.date.text = convertLongToTime(listconsult[position].regDate)
            if (listconsult[position].tagList.isNotEmpty()) {
                text = ""
                for (i in listconsult[position].tagList.indices) {
                    text += "#"+"${listconsult[position].tagList[i].name} "
                }
                holder.hashtag.text = text
            }
        }
        if(obj.expertList[position].type == IMAGE_TYPE2){
            (holder as ViewHolderClass2).tvdoctorhashtag.text = listexpert[position].companyName
            holder.tvdoctorkind.text = "("+listexpert[position].typeName+")"
            holder.answercnt.text = "답변" + listconsult[position].answerCnt.toString()
            holder.date.text = convertLongToTime(listconsult[position].regDate)
            if (listconsult[position].tagList.isNotEmpty()) {
                text = ""
                for (i in listconsult[position].tagList.indices) {
                    text += "#"+"${listconsult[position].tagList[i].name} "
                }
                holder.hashtag.text = text
            }
        }
        if(obj.companyList[position].type == IMAGE_TYPE3){
            (holder as ViewHolderClass3).title.text = listconsult[position].title
            holder.context.text = listconsult[position].context
            holder.answercnt.text = "답변" + listconsult[position].answerCnt.toString()
            holder.date.text = convertLongToTime(listconsult[position].regDate)
            if (listconsult[position].tagList.isNotEmpty()) {
                text = ""
                for (i in listconsult[position].tagList.indices) {
                    text += "#"+"${listconsult[position].tagList[i].name} "
                }
                holder.hashtag.text = text
            }
        }

//        Log.d("TEST", "onCreate: ${list}")
//        with(holder) {
//            title.text = listconsult[position].title
//            context.text = listconsult[position].context
//            answercnt.text= "답변" + listconsult[position].answerCnt.toString()
//            date.text = convertLongToTime(listconsult[position].regDate)
//
//            //make hashtag and bind with textview
//            if (listconsult[position].tagList.isNotEmpty()) {
//                text = ""
//                for (i in listconsult[position].tagList.indices) {
//                    text += "#"+"${listconsult[position].tagList[i].name} "
//                }
//                hashtag.text = text
//            }
//        }
    }
    override fun getItemCount(): Int {
        return listconsult.size
    }
    override fun getItemViewType(position: Int): Int {
        if (listconsult[position].type == IMAGE_TYPE){
            Log.d("TEST2","${listconsult[position].type}")
            Log.d("TEST2","${listconsult[position].type}")
            return IMAGE_TYPE
        }
        if(listexpert[position].type == IMAGE_TYPE2){
            Log.d("TEST2","${listexpert[position].type}")
            return IMAGE_TYPE2
        }

        if (listcompany[position].type == IMAGE_TYPE3){
            Log.d("TEST2","${listcompany[position].type}")
            return IMAGE_TYPE3
        }
        return Log.d("TEST","ERROR")
    }

    // Long from Json transform to Date
    fun convertLongToTime (time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd")
        return format.format(date)
    }
}
