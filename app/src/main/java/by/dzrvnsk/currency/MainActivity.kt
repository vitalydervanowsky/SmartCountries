package by.dzrvnsk.currency

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.dzrvnsk.currency.databinding.ActivityMainBinding
import by.dzrvnsk.currency.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .add(binding.container.id, LoginFragment())
            .commit()
    }
}