package com.eneszeydan.englishdictionary.fragment

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eneszeydan.englishdictionary.R
import com.eneszeydan.englishdictionary.databinding.FragmentHomepageBinding
import com.eneszeydan.englishdictionary.model.Word
import com.eneszeydan.englishdictionary.viewmodel.HomepageFragmentViewModel
import java.util.*


class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding : FragmentHomepageBinding
    private lateinit var viewModel : HomepageFragmentViewModel
    lateinit var tts:TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.fragment = this

        tts = TextToSpeech(requireContext()) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.UK
            }
        }


        viewModel.word.observe(viewLifecycleOwner, {word ->
            binding.word = word
            word?.let {
                it.word?.let { it1 -> Log.d("Word", it1) }
            }
        })

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


    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            Log.d("Query", query)
            viewModel.getWordInfo(query)
        }
        hideKeyboard()
        return true
    }

    private fun hideKeyboard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }


    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            Log.d("Query", query)
            viewModel.getWordInfo(query)
        }
        return true
    }

    fun playSound(word:Word){
         tts.speak(word.word, TextToSpeech.QUEUE_FLUSH, null, null)
    }

}