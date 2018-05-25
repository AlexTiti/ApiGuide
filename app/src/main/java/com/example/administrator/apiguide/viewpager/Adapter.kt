package com.example.administrator.apiguide.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.util.SparseArray
import android.view.ViewGroup

/**
 * @author  : Alex
 * @email   : 18238818283@sina.cn
 * @date    : 2018/05/24
 * @version : V 2.0.0
 */
class Adapter(var fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var mapBefore: SparseArray<String> = SparseArray()
    var mapUpdate: SparseArray<String> = SparseArray()

    var arrayList: ArrayList<Fragment>? = null
        set(value) {
            field = value
            setMapBefore()
            setMapUpdate()
        }

    private fun setMapBefore() {
        mapBefore.clear()
        for (i in 0 until arrayList!!.size) {
            mapBefore.put(getItemId(i).toInt(), i.toString())
        }
    }

    private fun setMapUpdate() {
        mapUpdate.clear()
        for (i in 0 until arrayList!!.size) {
            mapUpdate.put(getItemId(i).toInt(), i.toString())
        }
    }

    override fun getItem(position: Int): Fragment {
        return arrayList!!.get(position)
    }

    override fun getCount(): Int {
        return arrayList!!.size
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        return super.instantiateItem(container, position)
    }


    override fun getItemPosition(`object`: Any?): Int {
        var hasCode = `object`!!.hashCode()
        var position = mapUpdate.get(hasCode)
        if (position == null) {
            return PagerAdapter.POSITION_NONE
        } else {
            for (i in 0 until arrayList!!.size) {
                var key = mapBefore.keyAt(i)
                if (key == hasCode) {
                    var positionBefore = mapBefore.get(key)
                    return if (position == positionBefore) {
                        PagerAdapter.POSITION_UNCHANGED
                    } else {
                        PagerAdapter.POSITION_NONE
                    }
                }
            }
        }
        return PagerAdapter.POSITION_UNCHANGED
    }

    override fun getItemId(position: Int): Long {
        return arrayList!![position]?.hashCode().toLong()
    }


    fun add(fragment: Fragment) {
        arrayList?.add(fragment)
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        arrayList?.remove(arrayList!![position])
        notifyDataSetChanged()
    }

    fun insert(position: Int, fragment: Fragment) {
        arrayList?.add(position, fragment)
        notifyDataSetChanged()
    }

    fun replace(position: Int, fragment: Fragment) {

        arrayList?.set(position, fragment)
        notifyDataSetChanged()
    }


}