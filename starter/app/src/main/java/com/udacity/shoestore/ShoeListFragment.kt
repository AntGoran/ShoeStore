package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class ShoeListFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.lifecycleOwner = this

        shoeViewModel.getShoeLiveData().observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()) {
                createShoes(it)
            }
        })

        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_detailsFragment)
        )
        // It looks like it is deprecated
        setHasOptionsMenu(true)

        return binding.root
    }

    // It looks like it is deprecated
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun createShoes(shoe: List<Shoe>) {
        context?.let { context ->
            val layout = binding.shoeList
            shoe.forEach{shoe ->
                val shoeLayout = ShoesNewView(context)
                shoeLayout.newShoe(shoe)
                layout.addView(shoeLayout)
            }
        }
    }
}