package tn.demo.todoapptest.main.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import tn.demo.todoapptest.R
import tn.demo.todoapptest.main.model.Todo
import java.util.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private var listItems: List<Todo> = Collections.emptyList()
    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_todo, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        val todo = listItems[position]

        holder.idTodo.text = todo.id.toString()
        holder.memoTv.text = todo.memo
        holder.descriptionTv.text = todo.description
        holder.priorityTv.text = todo.priority.toString()

    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    fun setItems(listItems: List<Todo>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(@Nullable onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    inner class ListViewHolder(itemView: View) : ViewHolder(itemView),
        View.OnClickListener {
        var idTodo: TextView
        var memoTv: TextView
        var descriptionTv: TextView
        var priorityTv: TextView

        override fun onClick(v: View?) {
            // onItemClickListener?.onItemClick(listItems[adapterPosition].id)
        }

        init {
            itemView.setOnClickListener(this)
            idTodo = itemView.findViewById(R.id.tv_id_todo)
            memoTv = itemView.findViewById(R.id.tv_memo)
            descriptionTv = itemView.findViewById(R.id.tv_description)
            priorityTv = itemView.findViewById(R.id.tv_priority)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(url: String)
    }

}