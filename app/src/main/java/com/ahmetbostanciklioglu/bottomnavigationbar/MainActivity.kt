package com.ahmetbostanciklioglu.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ahmetbostanciklioglu.bottomnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //View binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Call replace() function
        replace(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> replace(HomeFragment())
                R.id.item_account -> replace(AccountFragment())
                R.id.item_search -> replace(SearchFragment())
                R.id.item_logout -> finish()
                else -> {
                    replace(HomeFragment())
                }
            }
            true
        }
    }

    //Replace Activity with fragment
    private fun replace(withFragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, withFragment).commit()
    }
}