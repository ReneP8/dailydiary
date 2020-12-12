package de.rbaving.dailydiary

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.format.DateTimeFormatter

class EntryAdapter(
        private val entries: MutableList<DiaryEntry>
) : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {

    class EntryViewHolder(entryView: View) : RecyclerView.ViewHolder(entryView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        return EntryViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_diary_entry,
                        parent,
                        false
                )
        )
    }

    fun addEntry(entry: DiaryEntry) {
        entries.add(entry)
        notifyItemInserted(entries.size - 1)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val currentEntry = entries[position]
        holder.itemView.apply {
            this.findViewById<TextView>(R.id.tvDate).text = currentEntry.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            this.findViewById<TextView>(R.id.tvContent).text = currentEntry.content
        }
    }

    override fun getItemCount(): Int {
        return entries.size
    }
}