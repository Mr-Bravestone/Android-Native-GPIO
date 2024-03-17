package com.example.android_native_gpio
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.pin.text = ItemsViewModel.pin
        holder.inout.id = ItemsViewModel.inout
        holder.readValue.text = ItemsViewModel.readValue
        holder.readBtn.text = ItemsViewModel.readBtn
        holder.onoffSw.text = ItemsViewModel.onoffSw

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val pin: TextView = itemView.findViewById(R.id.pinNumTv)
        val inout: RadioGroup = itemView.findViewById(R.id.directionRadio)
        val readValue: TextView = itemView.findViewById(R.id.readDataTv)
        val readBtn: Button = itemView.findViewById(R.id.readBtn)
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        val onoffSw: Switch = itemView.findViewById(R.id.onoffSw)


    }
}
