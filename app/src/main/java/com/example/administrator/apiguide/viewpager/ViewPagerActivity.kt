package com.example.administrator.apiguide.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.example.administrator.apiguide.R
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() ,View.OnClickListener{


    var array :ArrayList<Fragment> = arrayListOf()
    lateinit var adapter: Adapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        array.add(OneFragment.newInstance("A","A"))
        array.add(OneFragment.newInstance("B","B"))
        array.add(OneFragment.newInstance("C","C"))

        adapter = Adapter(supportFragmentManager)
        adapter.arrayList = array
        viewPager.adapter = adapter

        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v){
            button2 -> adapter.add(OneFragment.newInstance("D","D"))
            button3 -> adapter.insert(1,OneFragment.newInstance("E","E"))
            button6 -> adapter.replace(2,OneFragment.newInstance("F","F"))
            button7 -> adapter.remove(OneFragment.newInstance("G","G"))
            else -> adapter.notifyDataSetChanged()
        }
    }


}
