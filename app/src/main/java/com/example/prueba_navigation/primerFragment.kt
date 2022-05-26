package com.example.prueba_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prueba_navigation.databinding.FragmentHomeBinding
import com.example.prueba_navigation.databinding.FragmentPrimerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [primerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class primerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private var _binding: FragmentPrimerBinding?=null;
    private val binding get() = _binding!!

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
        // Inflate the layout for this fragment
        _binding=FragmentPrimerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //recuperar argumentos
        val bundle=arguments
        if(bundle == null){
            Log.e("s","bundle vacio")
            return
        }
        //extraer esos argumentos o parametros enviados
        val arg=primerFragmentArgs.fromBundle(bundle)
        if(arg.saludo.isNullOrBlank()){
            Log.e("error","vacio")
        }else{
            binding.textFragmen1.text=arg.saludo
        }


        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_primerFragment_to_homeFragment)

        }
        binding.btnFrag2.setOnClickListener {

            var quemada = "dato enviado de fragment1"
            var act= primerFragmentDirections.actionPrimerFragmentToSegundoFragment(quemada)
            findNavController().navigate(act)

        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment primerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            primerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}