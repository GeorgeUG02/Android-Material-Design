package geekbrains.material.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbrains.material.R
import geekbrains.material.ui.MainActivity
import kotlinx.android.synthetic.main.st_activity.*

class SettingsThemeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.st_activity)
        button.setOnClickListener {
            if (radioButton2.isChecked) {
                MainActivity.theme=R.style.AppTheme
                setResult(RESULT_OK,Intent())
                finish()
            }
            else if (radioButton3.isChecked) {
                MainActivity.theme=R.style.AppTheme2
                setResult(RESULT_OK,Intent())
                finish()
            }
            else if (radioButton4.isChecked) {
                MainActivity.theme=R.style.AppTheme3
                setResult(RESULT_OK,Intent())
                finish()
            }
            else {
                setResult(RESULT_OK,Intent())
                finish()
            }
        }
    }
}