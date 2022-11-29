package com.udacity.shoestore.models

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR


class ShoeViewModel : ViewModel(), Observable {

    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR._all)
            }
        }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoes

    fun addShoe(item: Shoe?) {
        item?.let {
            shoes.value?.add(item)
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

//    private val _company = MutableLiveData<String>()
//    val company : LiveData<String> = _company
//
//    private val _name = MutableLiveData<String>()
//    val name : LiveData<String> = _name
//
//    private val _size = MutableLiveData<String>()
//    val size : LiveData<String> = _size
//
//    private val _description = MutableLiveData<String>()
//    val description : LiveData<String> = _description
//
//    fun save (company: String, name: String, size: String, description: String) {
//        _company.value = company
//        _name.value = name
//        _size.value = size
//        _description.value = description
//    }
}