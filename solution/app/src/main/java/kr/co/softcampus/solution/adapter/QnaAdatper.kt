package kr.co.softcampus.solution.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.softcampus.solution.databinding.ItemRecyclerviewQnaBinding
import kr.co.softcampus.solution.model.DocFriendsResponse
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Gnoss
 * @email silmxmail@naver.com
 * @created 2021-08-03
 * @desc
 */
class QnaAdatper(
    private val list: List<DocFriendsResponse.Consult>,
    var text:String = ""
) :    RecyclerView.Adapter<QnaAdatper.ViewHolderClass>(){

    inner class ViewHolderClass(private val binding : ItemRecyclerviewQnaBinding): RecyclerView.ViewHolder(binding.root){
        val title : TextView = binding.tvQnaTitle
        val context : TextView = binding.tvQnaContent
        val answercnt : TextView = binding.tvQnaAnswer
        val date : TextView = binding.tvQnaDate
        val hashtag : TextView = binding.tvQnaHashtag
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = ItemRecyclerviewQnaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        with(holder) {
            title.text = list[position].title
            context.text = list[position].context
            answercnt.text= "답변" + list[position].answerCnt.toString()
            date.text = convertLongToTime(list[position].regDate)

            //make hashtag and bind with textview
            if (list[position].tagList.isNotEmpty()) {
                text = ""
                for (i in list[position].tagList.indices) {
                    text += "#"+"${list[position].tagList[i].name} "
                }
                hashtag.text = text
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    // Long from Json transform to Date
    fun convertLongToTime (time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd")
        return format.format(date)
    }
}
