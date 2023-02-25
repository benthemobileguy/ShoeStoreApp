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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        initObservers()
        setHasOptionsMenu(true)
        // Hide the toolbar
        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.title = "My Shoes"
        toolbar?.visibility = View.VISIBLE
        binding.createShoeButton.setOnClickListener{
            val action= ShoeListingFragmentDirections.actionShoeListingFragmentToCreateShoeFragment()
            NavHostFragment.findNavController(this).navigate(action)

        }

        return binding.root
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

    private fun initObservers() {
        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            val iterator = it.listIterator()
            for (item in iterator) {
                val _name = TextView(this.context)
                _name.text = item.name
                val _size = TextView(this.context)
                _size.text = item.size
                val _company = TextView(this.context)
                _company.text = item.company
                val _description = TextView(this.context)
                val typefaceBold = resources.getFont(R.font.inter_bold)
                val typefaceBold = resources.getFont(R.font.inter_medium)
                _description.text = item.description
                _name.setTextColor(Color.parseColor("#504359"))
                _size.setTextColor(Color.parseColor("#504359"))
                _company.setTextColor(Color.parseColor("#504359"))
                _description.setTextColor(Color.parseColor("#504359"))
                _name.textSize= 18F
                _size.textSize=16F
                _company.textSize=16F
                _description.textSize=16F
                _name.setTypeface(typefaceBold)
                _size.setTypeface(typefaceBold)
                _company.setTypeface(typefaceBold)
                _description.setTypeface(typefaceBold)
                val parentLayout = LinearLayout(this.context)
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(5,0,5,25)
                parentLayout.orientation = LinearLayout.VERTICAL

                parentLayout.setBackgroundColor(Color.parseColor("#efdcf5"))
                parentLayout.setPadding(10,10,10,10)
                parentLayout.addView(_name)
                parentLayout.addView(_size)
                parentLayout.addView(_company)
                parentLayout.addView(_description)
                binding.shoeListView.addView(parentLayout,params)


            }
        })
    }

    private fun goToShoeList() {
        findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailsFragment)
    }

}