package kr.co.softcampus.solution.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val owner : AppCompatActivity,
    private val list: List<DocFriendsResponse>,
    private val listconsult : List<DocFriendsResponse.Consult>,
    private val listexpert : List<DocFriendsResponse.Expert>,
    private val listcompany : List<DocFriendsResponse.Company>,
    var text:String = ""
) :    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class ConsultViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_qna_title)
        val context : TextView = itemView.findViewById(R.id.tv_qna_content)
        val answercnt : TextView = itemView.findViewById(R.id.tv_qna_answer)
        val date : TextView = itemView.findViewById(R.id.tv_qna_date)
        val hashtag : TextView = itemView.findViewById(R.id.tv_qna_hashtag)
    }

    inner class ExpertViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val rvdoctor : RecyclerView = itemView.findViewById(R.id.rv_doctor)
    }

    inner class HospitalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val rvhospital : RecyclerView = itemView.findViewById(R.id.rv_hospital)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View

        if (viewType == IMAGE_TYPE3) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_hospital, parent, false)
            return HospitalViewHolder(view)
        } else if (viewType == IMAGE_TYPE2){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_doctor, parent, false)
            return ExpertViewHolder(view)
        }
        else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_qna, parent, false);
            return ConsultViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ConsultViewHolder) {
            title.text = listconsult[position].title
            context.text = listconsult[position].context
            answercnt.text = "답변" + listconsult[position].answerCnt.toString()
            date.text = convertLongToTime(listconsult[position].regDate)

            if (listconsult[position].tagList.isNotEmpty()) {
                text = ""
                for (i in listconsult[position].tagList.indices) {
                    text += "#" + "${listconsult[position].tagList[i].name} "
                }
                hashtag.text = text
            }
        }

//        if(position == 3 ){
//            val expertviewholder = holder as ExpertViewHolder
//            expertviewholder.rvdoctor.adapter = DoctorAdapter(owner,listexpert)
//            expertviewholder.rvdoctor.layoutManager = LinearLayoutManager(owner,LinearLayoutManager.HORIZONTAL,false)
//        }
//
//        if(position == 4){
//            val hospitalviewholder = holder as HospitalViewHolder
//            hospitalviewholder.rvhospital.adapter = HospitalAdapter(owner,listcompany)
//            hospitalviewholder.rvhospital.layoutManager = LinearLayoutManager(owner,LinearLayoutManager.HORIZONTAL,false)
//            }
    }

    override fun getItemCount(): Int {
        return listconsult.size
    }

    override fun getItemViewType(position: Int): Int {
        if (listconsult[position].type == IMAGE_TYPE){
            return IMAGE_TYPE
        }
        else if(listexpert[position].type == IMAGE_TYPE2){
            return IMAGE_TYPE2
        }
        else{
            return IMAGE_TYPE3
        }
    }

    // Long from Json transform to Date
    fun convertLongToTime (time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd")
        return format.format(date)
    }
}