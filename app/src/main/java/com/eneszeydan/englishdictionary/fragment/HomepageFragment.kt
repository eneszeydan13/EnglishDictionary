package com.eneszeydan.englishdictionary.fragment

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eneszeydan.englishdictionary.R
import com.eneszeydan.englishdictionary.databinding.FragmentHomepageBinding
import com.eneszeydan.englishdictionary.viewmodel.HomepageFragmentViewModel


class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding : FragmentHomepageBinding
    private lateinit var viewModel : HomepageFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        //TODO: Observe LiveData and bind it to layout

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel : HomepageFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)

    }


    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.getWordInfo(query)
        return true
    }


    override fun onQueryTextChange(query: String): Boolean {
        viewModel.getWordInfo(query)
        return true
    }

}