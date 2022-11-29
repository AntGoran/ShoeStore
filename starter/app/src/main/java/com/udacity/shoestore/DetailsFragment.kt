package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class DetailsFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()

    // private val shoeData = Shoe("", 0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this
        binding.shoe = Shoe()

        binding.saveButton.setOnClickListener {
            shoeViewModel.addShoe(shoeViewModel.shoe)
            findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
        }

//        shoeViewModel.company.observe(viewLifecycleOwner, Observer { company ->
//            binding.shoeCompanyEditText.setText(company)
//        })
//
//        shoeViewModel.name.observe(viewLifecycleOwner, Observer { name ->
//            binding.shoesNameEditText.setText(name)
//        })
//
//        shoeViewModel.size.observe(viewLifecycleOwner, Observer { size ->
//            binding.shoeSizeEditText.setText(size)
//        })
//
//        shoeViewModel.description.observe(viewLifecycleOwner, Observer { description ->
//            binding.shoeDescriptionEditText.setText(description)
//        })
//
//        binding.saveButton.setOnClickListener {
//            shoeViewModel.save(
//
//                binding.shoeCompanyEditText.text.toString(),
//                binding.shoesNameEditText.text.toString(),
//                binding.shoeSizeEditText.text.toString(),
//                binding.shoeDescriptionEditText.text.toString()
//            )
//            findNavController().navigate(R.id.action_detailsFragment_to_shoeListFragment)
//        }


        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailsFragment_to_shoeListFragment)
        )



        return binding.root
    }

}