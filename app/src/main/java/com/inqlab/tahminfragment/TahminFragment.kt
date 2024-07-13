package com.inqlab.tahminfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.inqlab.tahminfragment.databinding.FragmentTahminBinding

class TahminFragment : Fragment() {

    private var _binding: FragmentTahminBinding ?= null
    private val binding  get() = _binding!!

    private val args : TahminFragmentArgs by navArgs()

    private var heart : Int = 5

    private var chance : Int = 6

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTahminBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val number = args.number

        binding.button3.setOnClickListener {

            val tahmin = binding.tahminText.text.toString().trim()


            if (tahmin.isNotEmpty()) {

                if (tahmin.toInt()>number) {
                    heart--

                    if (heart==0) {
                        findNavController().navigate(TahminFragmentDirections.actionTahminFragmentToResultFragment(false))
                    }
                    binding.helpText.text = "Decrease the number"
                    chance--
                    when(chance) {
                        5-> {binding.heart5.visibility = View.INVISIBLE}
                        4-> {binding.heart4.visibility = View.INVISIBLE}
                        3-> {binding.heart3.visibility = View.INVISIBLE}
                        2-> {binding.heart2.visibility = View.INVISIBLE}
                        1-> {binding.heart1.visibility = View.INVISIBLE}

                    }

                }else if(tahmin.toInt()<number) {
                    heart--
                    if (heart==0) {
                        findNavController().navigate(TahminFragmentDirections.actionTahminFragmentToResultFragment(false))
                        return@setOnClickListener
                    }

                    binding.helpText.text ="Encrease the number"
                    chance--
                    when(chance) {
                        5-> {binding.heart5.visibility = View.INVISIBLE}
                        4-> {binding.heart4.visibility = View.INVISIBLE}
                        3-> {binding.heart3.visibility = View.INVISIBLE}
                        2-> {binding.heart2.visibility = View.INVISIBLE}
                        1-> {binding.heart1.visibility = View.INVISIBLE}

                    }

                }else{
                    findNavController().navigate(TahminFragmentDirections.actionTahminFragmentToResultFragment(true))
                }


            }else{

                Toast.makeText(this.context,"Enter your number!!!",Toast.LENGTH_SHORT).show()

            }

        }

    }

}