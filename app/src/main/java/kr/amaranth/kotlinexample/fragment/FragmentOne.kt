package kr.amaranth.kotlinexample.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.amaranth.kotlinexample.databinding.FragmentOneBinding

private const val ARG_PARAM1 = "fragment_arg1"
private const val ARG_PARAM2 = "fragment_arg2"

class FragmentOne : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    interface OnDataPassListener {
        fun onDataPass(data: String)
    }

    private lateinit var dataPassListener: OnDataPassListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPassListener = context as OnDataPassListener
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
    ): View {
        val binding = FragmentOneBinding.inflate(inflater)

        binding.fragmentOneTvArg1.text = param1
        binding.fragmentOneTvArg2.text = param2

        binding.buttonDataPass.setOnClickListener {
            dataPassListener.onDataPass("I'm fragment data")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FragmentOne.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic fun newInstance(param1: String, param2: String) =
//                FragmentOne().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
//                }
//    }
}