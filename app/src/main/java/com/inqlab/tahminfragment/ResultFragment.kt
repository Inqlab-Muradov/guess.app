package com.inqlab.tahminfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.inqlab.tahminfragment.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private var _binding :FragmentResultBinding? = null
    private val binding get() = _binding!!

    private val args:ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val condition = args.condition

        if (condition) {
            binding.resultText.text = "Congratulations"
            binding.imageView.setImageResource(R.drawable.winner)
        }else{
            binding.resultText.text = "You are loser"
            binding.imageView.setImageResource(R.drawable.loser)
        }


    }

}