package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeDetailViewModel
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {
    private val shoesViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var detailViewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false)

        detailViewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
        binding.shoeViewModel = detailViewModel
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener {
            navigateToShoeList()
        }

        binding.saveButton.setOnClickListener {
            if (detailViewModel.validateFields()) {
                val shoe = detailViewModel.buildShoe()
                shoesViewModel.addShoe(shoe)
                navigateToShoeList()
            } else {
                Toast.makeText(context, getString(R.string.empty_fields_warning), Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun navigateToShoeList() {
        findNavController().navigate(ShoeDetailFragmentDirections.actionCreateShoeFragmentToShoeListingFragment())
    }

}
