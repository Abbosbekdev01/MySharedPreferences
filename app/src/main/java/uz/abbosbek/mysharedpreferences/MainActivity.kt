package uz.abbosbek.mysharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import uz.abbosbek.mysharedpreferences.databinding.ActivityMainBinding
import uz.abbosbek.mysharedpreferences.models.User
import uz.abbosbek.mysharedpreferences.utils.MySharedPreferences

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        list = ArrayList()
        MySharedPreferences.init(this)
        loadData()

        binding.btnSave.setOnClickListener {
            list.add(User(binding.textInputEditTextName.text.toString(), binding.textInputEditTextNumber.text.toString().toInt()))
            loadData()
        }

    }

    private fun loadData() {
        var str = ""
        list.forEach {
            str += "${it.name} ${it.number} \n\n"
        }

        binding.tvText.text = str
    }
}