package geekbrains.material.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import geekbrains.material.R
import geekbrains.material.ui.picture.BottomNavigationDrawerFragment
import geekbrains.material.ui.planetsAndMoons.ViewPagerAdapter
import geekbrains.material.ui.planetsAndMoons.ZoomOutPageTransformer
import geekbrains.material.ui.settings.SettingsThemeActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
companion object{
    var theme:Int=0
    const val REQUEST_CODE=100
}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if(MainActivity.theme!=0){
                val intent=intent
                finish()
                startActivity(intent)
            }
    }
    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        menuInflater.inflate(R.menu.menu_bottom_bar,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> {
                val intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.app_bar_settings -> {
                val intent = Intent(applicationContext, SettingsThemeActivity::class.java)
                startActivityForResult(intent, MainActivity.REQUEST_CODE)
            }
            android.R.id.home -> {
                BottomNavigationDrawerFragment().show(supportFragmentManager, "tag")
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (MainActivity.theme!=0)
        {
            setTheme(MainActivity.theme)

        }

        setContentView(R.layout.main_activity)
        /*
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment())
                .commitAllowingStateLoss()
        }
        */
        view_pager.adapter = ViewPagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
        val mPager: ViewPager = findViewById(R.id.view_pager)
        mPager.setPageTransformer(true, ZoomOutPageTransformer())
        try {
            this.setSupportActionBar(findViewById(R.id.bottom_app_bar))
        }
        catch(e:Exception){

        }

    }

}
