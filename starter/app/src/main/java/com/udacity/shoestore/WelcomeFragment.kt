package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)

        binding.welcomeGoButton.setOnClickListener{
            val action= WelcomeScreenFragmentDirections.actionWelcomeFragmentToInstructionsScreen()
            NavHostFragment.findNavController(this).navigate(action)
        }
        // Hide the toolbar
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.visibility = View.GONE
        return binding.root
    }


}
