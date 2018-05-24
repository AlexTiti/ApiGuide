package com.example.administrator.apiguide.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author  : Alex
 * @email   : 18238818283@sina.cn
 * @date    : 2018/05/24
 * @version : V 2.0.0
 */
class Adapter(var fm: FragmentManager) : FragmentPagerAdapter(fm) {

     var arrayList: ArrayList<Fragment>? = null
         set(value) {
        field = value
    }

    override fun getItem(position: Int): Fragment {
        return arrayList!!.get(position)
    }

    override fun getCount(): Int {
        return arrayList!!.size
    }


    fun add(fragment: Fragment){
        arrayList?.add(fragment)
        notifyDataSetChanged()
    }

    fun remove(fragment: Fragment){
        arrayList?.remove(fragment)
        notifyDataSetChanged()
    }

    fun insert(position: Int,fragment: Fragment){
        arrayList?.add(position,fragment)
        notifyDataSetChanged()
    }

    fun replace(position: Int,fragment: Fragment){

        arrayList?.set(position,fragment)
        notifyDataSetChanged()
    }
}