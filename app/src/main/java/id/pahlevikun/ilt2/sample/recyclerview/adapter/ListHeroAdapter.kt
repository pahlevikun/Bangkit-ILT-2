package id.pahlevikun.ilt2.sample.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.pahlevikun.ilt2.sample.R
import id.pahlevikun.ilt2.sample.recyclerview.model.Hero
import java.util.*

class ListHeroAdapter(
    private val listHero: ArrayList<Hero>,
    private val onItemClick: ((Hero) -> Unit)? = null
) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    /**
     * Set on item click callback
     * This is optional method to use as listener
     *
     * @param onItemClickCallback
     */
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_recyclerview_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        with(holder) {
            imgPhoto.setImageResource(photo)
            tvName.text = name
            tvDescription.text = description
            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(listHero[position])
                onItemClick?.invoke(listHero[position])
            }
        }
    }

    override fun getItemCount(): Int = listHero.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}
