package com.warisdgk.ui.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.warisdgk.R
import com.warisdgk.databinding.FragmentHomeBinding
import com.warisdgk.utils.Resource
import com.warisdgk.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding by autoCleared()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSendButton()
        setupPostObserver()
    }

    private fun setupSendButton() {
        binding.btnSend.setOnClickListener {
            activity?.hideKeyboard(binding.btnSend)
            fetchPost()
        }
    }

    private fun fetchPost() {
        val postId = binding.etPostId.text.toString()
        val isValidPostId = isValidInput(postId)
        if (isValidPostId) {
            viewModel.allowNavigate = true
            binding.btnSend.isEnabled = false
            viewModel.setPostId(getIntPostId(postId))
        }
    }

    private fun isValidInput(postId: String): Boolean {
        if (postId.isBlank()) {
            showToast(getString(R.string.error_msg_empty_post_id))
            return false
        }

        val id = try {
            postId.toInt()
        } catch (exception: NumberFormatException) {
            Timber.tag(TAG).d(exception)
            -1
        }

        if (id == -1 || id == 0) {
            showToast(getString(R.string.error_msg_invalid_post_id))
            return false
        }
        return true
    }

    private fun getIntPostId(postId: String): Int {
        return try {
            postId.toInt()
        } catch (exception: NumberFormatException) {
            Timber.tag(TAG).d(exception)
            -1
        }
    }

    private fun setupPostObserver() {
        viewModel.postData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.btnSend.isEnabled = true

                    if (viewModel.allowNavigate) {
                        if (it.data?.title.isNullOrEmpty() || it.data?.body.isNullOrEmpty()) {
                            showToast(getString(R.string.error_msg_empty_content))
                        } else {
                            navigateToDetails(it.data?.id)
                        }
                    }
                }

                Resource.Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.btnSend.isEnabled = true
                    showToast(it.message)
                }

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun navigateToDetails(postId: Int?) {
        findNavController().navigate(
            R.id.action_homeFragment_to_detailsFragment,
            bundleOf(KEY_POST_ID to postId)
        )
        viewModel.allowNavigate = false
    }

    private fun showToast(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    companion object {
        const val KEY_POST_ID = "postId"
        private const val TAG = "HomeFragment"
    }

}