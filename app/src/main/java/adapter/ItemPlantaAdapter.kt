package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.slots.casino.game.squarecanvasdemo.R
import com.squareup.picasso.Picasso
import data.ItemPlanta

class ItemPlantaAdapter(private val mList: List<ItemPlanta>, mainImage: ImageView, selectFloorItem : ItemPlanta) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val ivFloor: ImageView = mainImage
    val selectFloorItem : ItemPlanta = selectFloorItem
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_planta, parent, false)

        val viewItem = ItemPlantaAdapter.ViewHolder(view)

        viewItem.itemView.setOnClickListener() {
            val pathFile = "https://aacserveis.com/test/${viewItem.tvFitxerPlanta.text}"
            Picasso.get()
                .load(pathFile)
                .into(ivFloor)
            selectFloorItem.codiPlanta = viewItem.tvCodiPlanta.text.toString()
            selectFloorItem.descPlanta = viewItem.tvDescPlanta.text.toString()
            selectFloorItem.fitxerPlanta = viewItem.tvFitxerPlanta.text.toString()
        }
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val id = holder.itemView.findViewById<TextView>(R.id.tvCodiPlanta).context
        val ItemsViewModel = mList[position]

        holder.itemView.findViewById<TextView>(R.id.tvCodiPlanta).text = ItemsViewModel.codiPlanta
        holder.itemView.findViewById<TextView>(R.id.tvDescPlanta).text = ItemsViewModel.descPlanta
        holder.itemView.findViewById<TextView>(R.id.tvFitxerPlanta).text =
            ItemsViewModel.fitxerPlanta

        if (position % 2 == 0) {
            holder.itemView.findViewById<TextView>(R.id.tvCodiPlanta)
                .setBackgroundColor(id.getColor(R.color.pyjamas))
            holder.itemView.findViewById<TextView>(R.id.tvDescPlanta)
                .setBackgroundColor(id.getColor(R.color.pyjamas))
            holder.itemView.findViewById<TextView>(R.id.tvFitxerPlanta)
                .setBackgroundColor(id.getColor(R.color.pyjamas))
        }
    }
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvCodiPlanta: TextView = itemView.findViewById(R.id.tvCodiPlanta)
        val tvDescPlanta: TextView = itemView.findViewById(R.id.tvDescPlanta)
        val tvFitxerPlanta: TextView = itemView.findViewById(R.id.tvFitxerPlanta)
    }
}
