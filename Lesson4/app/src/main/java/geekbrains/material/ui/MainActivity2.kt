package geekbrains.material.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbrains.material.R
import geekbrains.material.ui.picture.PictureOfTheDayFragment
import geekbrains.material.ui.planetsAndMoons.EarthFragment
import geekbrains.material.ui.planetsAndMoons.MoonFragment
import kotlinx.android.synthetic.main.main_activity2.*

class MainActivity2 :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)
        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_picture_of_the_day -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container2, PictureOfTheDayFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container2, EarthFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_moon -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container2, MoonFragment())
                        .commitAllowingStateLoss()
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container2, PictureOfTheDayFragment())
                        .commitAllowingStateLoss()
                    true
                }
            }
        }
        bottom_navigation_view.selectedItemId=R.id.bottom_view_picture_of_the_day
        bottom_navigation_view.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_picture_of_the_day -> {
                    //Item tapped
                }
                R.id.bottom_view_earth -> {
                    //Item tapped
                }
                R.id.bottom_view_moon -> {
                    //Item tapped
                }
            }
        }
    }
}