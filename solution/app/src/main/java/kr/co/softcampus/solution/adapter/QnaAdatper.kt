package kr.co.softcampus.solution.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.softcampus.solution.databinding.ItemRecyclerviewQnaBinding
import kr.co.softcampus.solution.model.DocFriendsResponse

/**
 * @author Gnoss
 * @email silmxmail@naver.com
 * @created 2021-08-03
 * @desc
 */
class QnaAdatper(
    private val list: List<DocFriendsResponse.Consult>
) :    RecyclerView.Adapter<QnaAdatper.ViewHolderClass>(){

    var text : String = ""
    inner class ViewHolderClass(private val binding : ItemRecyclerviewQnaBinding): RecyclerView.ViewHolder(binding.root){
        val title : TextView = binding.tvQnaTitle
        val context : TextView = binding.tvQnaContent
        val answercnt : TextView = binding.tvQnaAnswer
        val date : TextView = binding.tvQnaDate
        val hashtag : TextView = binding.rvQnaHashtag
//        fun setView(item : TEST.Consult) {
//            with(binding) {
//                consult = item
//                holderView = this@ViewHolderClass
//                executePendingBindings()
//            }
//        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = ItemRecyclerviewQnaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderClass(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

//        with(holder) {
//            setView(list[position])
//        }
//    }
//        val consultItem = list[position].consultList[position]
        with(holder) {
            title.text = list[position].title
            context.text = list[position].context
            answercnt.text= "답변" + list[position].answerCnt.toString()
            date.text = list[position].regDate.toString()
            Log.d("RESPONSE9","${list[position]}")
            Log.d("RESPONSE11","${list}")
            Log.d("RESPONSE","${list.size}")
            if (list[position].tagList.size!=0) {
                for (i in 0..list[position].tagList.size-1) {
                    text += "{${list[position].tagList[i].name}"
                    if ( i == list[position].tagList.size){
                        hashtag.text = text
                    }
                    else{
                        hashtag.text = ""
                    }
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
}
