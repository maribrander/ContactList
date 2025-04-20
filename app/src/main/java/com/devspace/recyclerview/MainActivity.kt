package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener{
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener{
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener {contact ->
            val intent = Intent (this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

private val contacts = listOf(
    Contact(
        "Roque",
        "+55 (81) 99547-2758",
        R.drawable.sample5
    ),
    Contact(
        "Yoongi",
        "+55 (81) 99887-2758",
        R.drawable.sample10
    ),
    Contact(
        "Haewon",
        "+55 (81) 99287-2558",
        R.drawable.sample9
    ),
    Contact(
        "Taehyung",
        "+55 (81) 99287-9878",
        R.drawable.sample1
    ),
    Contact(
        "Bae",
        "+55 (81) 99287-6558",
        R.drawable.sample4
    ),
    Contact(
        "Jimin",
        "+55 (81) 99287-2758",
        R.drawable.sample12
    ),
    Contact(
        "Jiwoo",
        "+55 (81) 99287-2758",
        R.drawable.sample14
    ),

    Contact(
        "Hoseok",
        "+55 (81) 99387-2758",
        R.drawable.sample2
    ),

    Contact(
        "Lily",
        "+55 (81) 99387-2758",
        R.drawable.sample3
    ),
)