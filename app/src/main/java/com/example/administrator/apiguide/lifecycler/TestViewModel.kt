package com.example.administrator.apiguide.lifecycler

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * @author  : Alex
 * @email   : 18238818283@sina.cn
 * @date    : 2018/05/25
 * @version : V 2.0.0
 */
class TestViewModel : ViewModel() {

    var mCurrent: MutableLiveData<String>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

}