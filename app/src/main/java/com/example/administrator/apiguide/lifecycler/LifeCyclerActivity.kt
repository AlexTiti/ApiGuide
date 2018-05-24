package com.example.administrator.apiguide.lifecycler

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.administrator.apiguide.R

class LifeCyclerActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var lifecycleRegistry: LifecycleRegistry;
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
