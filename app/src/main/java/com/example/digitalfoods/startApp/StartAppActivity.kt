package com.example.digitalfoods.startApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.digitalfoods.R
import com.example.digitalfoods.login.MainActivity
import com.example.digitalfoods.restaurantes.RestaurantesActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class StartAppActivity : AppCompatActivity() {

    private val viewPager : ViewPager2 by lazy { findViewById(R.id.view_pager_startApp)}
    private val indicator : TabLayout by lazy { findViewById(R.id.indicator)}
    private val buttonNext : Button by lazy { findViewById(R.id.button_next_startApp)}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_app)

        //viewPager.isUserInputEnabled = false

        setupViewPager()
        listeningButton()

    }


    private fun setupViewPager(){

        val listFragments = listOf(
            SampleFragment1(),
            SampleFragment2(),
            SampleFragment3(),
        )

        viewPager.adapter = IntroAdapter(this, listFragments)
        TabLayoutMediator(indicator, viewPager){ _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int){
                super.onPageSelected(position)
            }
        })
    }


    var nextPage: Boolean = false
    fun listeningButton(){

        buttonNext.setOnClickListener{
            viewPager.currentItem = viewPager.currentItem + 1

            if(nextPage){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            if(viewPager.currentItem == 2){
                buttonNext.text = "Entendi"
                nextPage = true
            }
        }
    }


}