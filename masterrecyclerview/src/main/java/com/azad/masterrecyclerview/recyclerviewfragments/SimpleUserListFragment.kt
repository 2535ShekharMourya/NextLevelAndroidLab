package com.azad.masterrecyclerview.recyclerviewfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.azad.masterrecyclerview.R
import com.azad.masterrecyclerview.adapters.SimpleUserListAdapter
import com.azad.masterrecyclerview.databinding.FragmentSimpleUserListBinding

class SimpleUserListFragment : Fragment() {
    private var _binding: FragmentSimpleUserListBinding? = null
    private val binding get() = _binding!!
    private var userList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_simple_user_list, container, false)
        _binding = FragmentSimpleUserListBinding.inflate(inflater, container, false)

        // Get a reference to the root view from the binding.
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUserList()
        recyclerviewSetup()

    }
    fun setupUserList(){
        for (i in 1..100){
            userList.add("User $i")
        }
    }
    fun recyclerviewSetup(){
        binding.userListRV.layoutManager = LinearLayoutManager(requireContext())
        binding.userListRV.adapter = SimpleUserListAdapter(requireContext(), userList)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SimpleUserListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SimpleUserListFragment().apply {

            }
    }
}