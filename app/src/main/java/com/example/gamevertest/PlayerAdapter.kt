package com.example.gamevertest
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gamevertest.PlayerModel

class PlayerAdapter(private val playerlist:ArrayList<PlayerModel>): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.player_list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayerAdapter.ViewHolder, position: Int) {
        val currentPlayer = playerlist[position]
        holder.showPlayerName.text = currentPlayer.playerName
    }


    override fun getItemCount(): Int {
        return playerlist.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val showPlayerName : TextView = itemView.findViewById(R.id.showPlayerName)
    }

}