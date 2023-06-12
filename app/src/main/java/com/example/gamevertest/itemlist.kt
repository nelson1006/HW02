package com.example.gamevertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class itemlist : AppCompatActivity() {

    private val itemNames = arrayOf("黑色切割者","嗜血者","暮色黑刃","冰霜之心","殞落王者之劍","石像鬼磐核","荊棘之甲","好戰者鎧甲",)
    private val itemImageIds = arrayOf(R.drawable.blackcleaver,
    R.drawable.bloodthirster,
    R.drawable.duskblade,
    R.drawable.frozenheart,
    R.drawable.ruinedblade,
    R.drawable.stoneplate,
    R.drawable.thornmail,
    R.drawable.warmogarmor)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemlist)

        val listView = findViewById<ListView>(R.id.listView)
        val list = ArrayList<HashMap<String, Any>>()
        for(i in itemNames.indices){
            val map = HashMap<String, Any>()
            map["itemName"]=itemNames[i]
            map["itemImage"]=itemImageIds[i]
            list.add(map)
        }
        val fromData=arrayOf("itemName","itemImage")
        val toData = intArrayOf(R.id.itemtextView,R.id.itemimageView)
        val simpleAdapter= SimpleAdapter(this,list,R.layout.list_row_items,fromData,toData)
        listView.adapter = simpleAdapter
    }
}