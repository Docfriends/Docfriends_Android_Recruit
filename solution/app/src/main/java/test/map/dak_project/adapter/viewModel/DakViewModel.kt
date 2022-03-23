package test.map.dak_project.adapter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import test.map.dak_project.dakmodel_Package.Consult
import test.map.dak_project.dakmodel_Package.DakItem


//뷰모델 생성
class DakViewModel : ViewModel() {

    private val _consultItem = MutableLiveData<List<Consult>>()

    private val _dakItem = MutableLiveData<List<DakItem>>()


    val consultItem : LiveData<List<Consult>>
        get() = _consultItem


    val dakitem : LiveData<List<DakItem>>
        get() = _dakItem



    fun setConsultItem(list: List<Consult>?){
        _consultItem.value = list!!
    }

    fun setDakItem(list : List<DakItem>?){
        _dakItem.value = list!!
    }


}