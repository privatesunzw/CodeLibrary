package com.sunzw.test.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunzw.test.R
import com.sunzw.test.databinding.FragmentTest4Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 *
 */
class TestFragment4 : Fragment() {
    private lateinit var mBinding: FragmentTest4Binding
    private var param1: String? = null
    private var param2: String? = null

    companion object {
        fun newInstance(param1: String, param2: String) =
            TestFragment4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTest4Binding.inflate(layoutInflater)
        return mBinding.root
    }


}