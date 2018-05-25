package com.example.administrator.apiguide.lifecycler

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.administrator.apiguide.R
import kotlinx.android.synthetic.main.activity_life_cycler.*
import kotlinx.android.synthetic.main.activity_live_data.*

class LifeCyclerActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var lifecycleRegistry: LifecycleRegistry
    private lateinit var mModel: TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycler)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)

        var myObserver = MyObserver(lifecycle, object : CallBack {
            override fun update() {
                Toast.makeText(this@LifeCyclerActivity, "Toast", Toast.LENGTH_SHORT).show()
            }
        })
        lifecycle.addObserver(myObserver)

        mModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        val nameObservable = Observer<String> {
            textView.text = it
        }

        mModel.mCurrent!!.observe(this, nameObservable)

        btnChange.setOnClickListener { mModel.mCurrent!!.value = "AAAAA" }
        btnB.setOnClickListener { mModel.mCurrent!!.value = "BBBBB" }

    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
