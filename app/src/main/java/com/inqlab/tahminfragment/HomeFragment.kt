package com.inqlab.tahminfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.inqlab.tahminfragment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding :FragmentHomeBinding?= null
    private val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

            val name = binding.nameText.text.toString()
            val password = binding.password.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty()) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToRadioFragment2())
            }else{
                Toast.makeText(this.context,"Enter name and password",Toast.LENGTH_SHORT).show()
            }

        }


    }

}