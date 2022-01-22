package com.saehyun.feedapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.saehyun.feedapplication.ui.ProductActivity

class MainAdapter(
    val context: Context,
    val productData: List<GetProductsQuery.GetProduct>
) : RecyclerView.Adapter<MainAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvName = itemView?.findViewById<TextView>(R.id.tvName)
        val tvPrice = itemView?.findViewById<TextView>(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.product_rv_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val data: GetProductsQuery.GetProduct = productData.get(position)

        holder.run {
            tvName?.text = data.name
            tvPrice?.text = data.price.toString()

            itemView.setOnClickListener {
                val intent = Intent(context, ProductActivity::class.java)
                intent.putExtra("id", data.id)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return productData.size
    }
}