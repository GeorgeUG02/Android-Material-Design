package geekbarains.material.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbarains.material.R
import geekbarains.material.ui.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
companion object{
    var theme:Int=0
    const val REQUEST_CODE=100
}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if(MainActivity.theme!=0){
                intent=getIntent()
                finish()
                startActivity(intent)
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (MainActivity.theme!=0)
            setTheme(MainActivity.theme)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}
