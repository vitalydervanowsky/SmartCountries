package by.dzrvnsk.smartcountries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.dzrvnsk.smartcountries.databinding.ActivityMainBinding
import by.dzrvnsk.smartcountries.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (supportFragmentManager.findFragmentById(R.id.container) == null)
            supportFragmentManager.beginTransaction()
                .add(binding.container.id, LoginFragment())
                .commit()
    }
}