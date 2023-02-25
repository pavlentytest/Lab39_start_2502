package ru.myitschool.lab23

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

class MyViewModel : ViewModel() {
    private val _list: MutableLiveData<ArrayList<Operation>> = MutableLiveData(
        arrayListOf(Operation("Income", LocalDate.now(), 0.0))
    )
    val list: LiveData<ArrayList<Operation>> = _list

    // по аналогии
    // balance

    fun addOperation(op: Operation) {
        _list.value = _list.value?.apply { add(op) }
        // пересчет баланса
    }

    fun removeOperation(index: Int) {
        _list.value?.removeAt(index)
        // пересчет баланса
    }

    fun duplicateOperation(index: Int){
        _list.value?.let { addOperation(it.get(index)) }
        // пересчет баланса
    }
}