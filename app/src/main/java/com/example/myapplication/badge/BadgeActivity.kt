package com.example.myapplication.badge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_badge.*

/**
 * 应用角标
 */
class BadgeActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, BadgeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)
        addBtn.setOnClickListener {
            BadgeUtils.setCount(10, this)
        }
    }
}