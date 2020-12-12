package de.rbaving.dailydiary

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private lateinit var entryAdapter: EntryAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        entryAdapter = EntryAdapter(mutableListOf())
        val rv: RecyclerView = findViewById<RecyclerView>(R.id.rvDiaryEntries)
        rv.adapter = entryAdapter
        rv.layoutManager = LinearLayoutManager(this)

        findViewById<FloatingActionButton>(R.id.addEntryButton).setOnClickListener {
            val entryDate = LocalDateTime.now()
            val content = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

            val entry = DiaryEntry(entryDate, 0, content)
            entryAdapter.addEntry(entry)
        }
    }
}