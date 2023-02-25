package ru.myitschool.lab23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import java.time.LocalDate

class MyDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog,container, false)
        val btn: Button = view.findViewById(R.id.button)
        val type: Spinner = view.findViewById(R.id.spinner)
        val amount: EditText = view.findViewById(R.id.editTextTextPersonName)
        btn.setOnClickListener {
            // Создаваться объект Operation
            // изменение ViewModel
            (activity as MainActivity).myViewModel.addOperation(
                Operation(type.selectedItem.toString(), LocalDate.now(), amount.text.toString().toDouble() ))
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}