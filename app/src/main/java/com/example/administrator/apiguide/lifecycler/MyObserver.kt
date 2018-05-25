package com.example.administrator.apiguide.lifecycler

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

/**
 * @author  : Alex
 * @email   : 18238818283@sina.cn
 * @date    : 2018/05/23
 * @version : V 2.0.0
 */
class MyObserver(var lifecycle: Lifecycle, var callback: CallBack) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun connectOnCreate() {
        p("connectOnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun connectOnResume() {
            p("connectOnResume")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun disConnectOnPause() {
        p("disConnectOnPause")
    }

    fun p(string: String) {
        callback.update()
    }
}