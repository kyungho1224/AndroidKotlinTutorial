package kr.amaranth.kotlinexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kr.amaranth.kotlinexample.databinding.ActivityFragmentBinding
import kr.amaranth.kotlinexample.fragment.FragmentOne

class FragmentActivity : AppCompatActivity(), View.OnClickListener, FragmentOne.OnDataPassListener {

    private val fragmentOne = FragmentOne()
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragmentCommit.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()

            val bundle = Bundle()
            bundle.putString("fragment_arg1", "Hello Fragment!")
            bundle.putString("fragment_arg2", "GoodBye Fragment!")
            fragmentOne.arguments = bundle

            fragmentTransaction.replace(R.id.ll_container, fragmentOne)
            fragmentTransaction.commit()
        }

        binding.btnFragmentRemove.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentOne)
        fragmentTransaction.commit()
    }

    override fun onDataPass(data: String) {
        Snackbar.make(findViewById(R.id.ll_container), data, Snackbar.LENGTH_SHORT).show()
    }

}