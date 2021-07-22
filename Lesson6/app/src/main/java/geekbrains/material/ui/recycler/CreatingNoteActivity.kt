package geekbrains.material.ui.recycler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbrains.material.R
import kotlinx.android.synthetic.main.creating_note_activity.*

class CreatingNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creating_note_activity)
        button3.setOnClickListener {
             val position = savedInstanceState?.getInt("position")
             val name = nameOfNote.text
             val note =note.text
             setResult(RESULT_OK, Intent().apply{
                 putExtra("position",position)
                 putExtra("name",name)
                 putExtra("note",note)
             })
             finish()
        }
    }
}