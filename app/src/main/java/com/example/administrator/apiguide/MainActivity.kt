package com.example.administrator.apiguide

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.util.Log
import android.view.Menu
import com.android.debug.hv.ViewServer
import com.example.administrator.apiguide.config.DataFragment
import com.example.administrator.apiguide.lifecycler.LifeCyclerActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val stringName = "Name"
    private val fragmentManger: FragmentManager by lazy {
        supportFragmentManager
    }
    private var dataFragment: DataFragment? = null
    val builder: StringBuilder by lazy {
        StringBuilder()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewServer.get(this).addWindow(this)

        dataFragment = fragmentManger.findFragmentByTag(stringName) as DataFragment?
        dataFragment ?: let {
            dataFragment = DataFragment()
            fragmentManger.beginTransaction().add(dataFragment, stringName).commit()

        }
        btn_main_trans.setOnClickListener { startActivity(Intent(this@MainActivity, LifeCyclerActivity::class.java)) }
        dataFragment?.run {
            for (it in list) {
                builder.append(it)
            }
        }
        tv_main_show.text = builder.toString()
        resources.getStringArray(R.array.array)

        resources.getQuantityString(R.plurals.plurals, 1, "Second")
        resources.getString(R.string.format, 2, "NAme")
        val string = String.format(resources.getString(R.string.welcome_messages), "A", 10)
        Html.fromHtml(string)
    }

    override fun onDestroy() {
        super.onDestroy()
        dataFragment?.run {
            list.add("ListA")
            list.add("ListB")
        }
        ViewServer.get(this).removeWindow(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(stringName, "Name")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        tv_main_show.text = savedInstanceState?.getString(stringName, "Default")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_menu, menu)
        return true
    }
}
