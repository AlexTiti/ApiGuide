package com.example.administrator.apiguide.config


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.administrator.apiguide.R
import com.google.android.gms.plus.PlusOneButton


/**
 * A fragment with a Google +1 button.
 */
class DataFragment : Fragment() {

    var list = mutableListOf("Original")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


}
