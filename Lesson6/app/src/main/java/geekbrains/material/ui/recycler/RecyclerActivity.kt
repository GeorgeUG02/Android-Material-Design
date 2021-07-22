package geekbrains.material.ui.recycler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import geekbrains.material.R
import kotlinx.android.synthetic.main.activity_recycler.*
import kotlinx.android.synthetic.main.creating_note_activity.*

class RecyclerActivity: AppCompatActivity() {
    private lateinit var itemTouchHelper: ItemTouchHelper
    private lateinit var adapter: RecyclerActivityAdapter
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK){
            val position = data?.getIntExtra("position",0)
            val name = data?.getStringExtra("name")
            val note =data?.getStringExtra("note")
            adapter.data.add(position!!,Data(name!!,note!!))
            adapter.notifyItemInserted(position)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val data = arrayListOf(
           Data( "Заметка", "Это заметка по умолчанию"),
            Data( "Заметка", "Это заметка по умолчанию")
        )

        adapter = RecyclerActivityAdapter(
            data,
            object : RecyclerActivityAdapter.OnStartDragListener {
                override fun onStartDrag(viewHolder: RecyclerView.ViewHolder) {
                    itemTouchHelper.startDrag(viewHolder)
                }
            }
        )

        recyclerView.adapter = adapter
        recyclerActivityFAB.setOnClickListener {
            startActivityForResult(Intent(this,CreatingNoteActivity::class.java).apply {
                putExtra("position",adapter.itemCount)
            },1)
        }
        itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}