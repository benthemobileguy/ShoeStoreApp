package com.udacity.shoestore
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ViewShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel


class ShoeListingFragment : Fragment(R.layout.fragment_shoe_listing) {


    private lateinit var binding: FragmentShoeListingBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackPressedConfiguration()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_shoeListingFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_listing,
            container,
            false)
        binding.createShoeButton.setOnClickListener{
            val action= ShoeListingFragmentDirections.actionShoeListingFragmentToCreateShoeFragment()
            NavHostFragment.findNavController(this).navigate(action)

        }
        binding.lifecycleOwner = this
        binding.shoeViewModel = viewModel
        setHasOptionsMenu(true)
        // Hide the toolbar
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.title = "My Shoes"
        toolbar?.visibility = View.VISIBLE

        viewModel.shoesList.observe(viewLifecycleOwner, Observer { shoesList ->
            for (shoe in shoesList) {
                addShoeToView(container, shoe)
            }
        })
        return binding.root
    }

    private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {
        val shoeBinding: ViewShoeBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.view_shoe, container, false
        )
        shoeBinding.shoe = shoe
        binding.shoeListView.addView(shoeBinding.root)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Show the toolbar again when the fragment is destroyed
        // Hide the toolbar
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.visibility = View.GONE
    }
    private fun setBackPressedConfiguration() {
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val i = Intent()
                i.action = Intent.ACTION_MAIN
                i.addCategory(Intent.CATEGORY_HOME)
                startActivity(i)
            }
        })
    }


}