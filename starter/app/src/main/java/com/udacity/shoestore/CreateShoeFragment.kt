package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentCreateShoeBinding
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.fragment_create_shoe.*

class CreateShoeFragment : Fragment() {
    private lateinit var binding: FragmentCreateShoeBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_create_shoe,container,false)

        binding.saveButton.setOnClickListener{
            val name = nameBox.text.toString()
            val size = sizeBox.text.toString()
            val company = companyBox.text.toString()
            val description = descriptionBox.text.toString()
            viewModel.addShoe(name, size, company, description)

            val action= CreateShoeFragmentDirections.actionCreateShoeFragmentToShoeListingFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        binding.cancelButton.setOnClickListener{

            binding.nameBox.text.clear()
            binding.sizeBox.text.clear()
            binding.companyBox.text.clear()
            binding.descriptionBox.text.clear()
            val action= CreateShoeFragmentDirections.actionCreateShoeFragmentToShoeListingFragment()
            NavHostFragment.findNavController(this).navigate(action)


        }
        return binding.root
    }


}
