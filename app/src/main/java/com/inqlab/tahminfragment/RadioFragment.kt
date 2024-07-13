package com.inqlab.tahminfragment

import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.inqlab.tahminfragment.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {

    private var _binding :FragmentRadioBinding? = null
    private val binding  get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRadioBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {

            val radio  = binding.radioGroup.checkedRadioButtonId

            var number = 0

            when(radio) {

                R.id.radioButton1->{
                     number = (0..99).random()
                }
                R.id.radiobutton2->{
                     number = (100..199).random()
                }

                R.id.radioButton3 -> {

                     number = (200..299).random()
                }

            }

            Toast.makeText(this.context,"$number",Toast.LENGTH_SHORT).show()

            findNavController().navigate(RadioFragmentDirections.actionRadioFragment2ToTahminFragment(number))

        }
    }
}