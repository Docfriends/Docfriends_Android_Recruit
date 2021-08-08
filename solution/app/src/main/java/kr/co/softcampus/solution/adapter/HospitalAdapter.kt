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

class HospitalAdapter (
    private val owner : AppCompatActivity,
    private val listcompany : List<DocFriendsResponse.Company>,
    var text:String = ""
) :    RecyclerView.Adapter<HospitalAdapter.ViewHolderClass>() {

    inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivhospital: ImageView = itemView.findViewById(R.id.iv_hospital)
        val tvhospitalname : TextView = itemView.findViewById(R.id.tv_hospitalname)
        var tvhospitallocation : TextView = itemView.findViewById(R.id.tv_hospitallocation)
        var tvhospitallocationetc : TextView = itemView.findViewById(R.id.tv_hospitallocationetc)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view: View?
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview_hospitaldetail, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        with(holder) {
            tvhospitalname.text = listcompany[position].companyName
            tvhospitallocation.text = listcompany[position].address
            tvhospitallocationetc.text = listcompany[position].addressEtc
            if (listcompany[position].introPath != null) {
                Glide.with(owner).load(listcompany[position].introPath).into(ivhospital)
            }
            else {
                Log.d("TEST", "TEST")
            }
            //make hashtag and bind with textview
        }
    }

    override fun getItemCount(): Int {
        return listcompany.size
    }
}
