package com.example.rvcustommultitypeadapter_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rvcustommultitypeadapter_2.adapter.CustomAdapter
import com.example.rvcustommultitypeadapter_2.databinding.ActivityMainBinding
import com.example.rvcustommultitypeadapter_2.model.Member

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        context = this
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)

    }

    private fun initViews() {
        bin.recyclerview.layoutManager = GridLayoutManager(this, 1)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(context, members)
        bin.recyclerview.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..50) {
            if (i % 10 == 0) {
                members.add(Member("Samandar", "Asiydinov $i", false))
            } else {
                members.add(Member("Samandar", "Asiydinov $i", true))
            }
        }
        return members
    }
}