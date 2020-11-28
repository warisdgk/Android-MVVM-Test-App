package com.warisdgk.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.warisdgk.data.entities.Post
import com.warisdgk.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        setUpToolbarBackButton()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLocalPostObserver()
        arguments?.getInt(KEY_POST_ID)?.let { viewModel.setPostId(it) }
    }

    private fun setUpToolbarBackButton() {
        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
    }

    private fun setupLocalPostObserver() {
        viewModel.localPost.observe(viewLifecycleOwner, Observer {
            bindPost(it)
        })
    }

    private fun bindPost(post: Post?) {
        binding.title.text = post?.title
        binding.etBody.setText(post?.body)
    }

    companion object {
        const val KEY_POST_ID = "postId"
    }

}