package com.udacity.shoestore

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.databinding.ShoeListLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoesNewView: LinearLayout {

    constructor(context: Context) : super(context)
  //  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    //constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ShoeListLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_list_layout, this, false)

    fun newShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoesNameEditText.text = shoe.name
            shoeCompanyEditText.text = shoe.company
            shoeSizeEditText.text = shoe.size.toString()
            shoeDescriptionEditText.text = shoe.description
        }
    }
}
