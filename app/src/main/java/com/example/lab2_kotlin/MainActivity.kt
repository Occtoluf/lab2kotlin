package com.example.lab2_kotlin

import android.graphics.Typeface
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private var changedFont : Boolean = false

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myLayout = findViewById<ConstraintLayout>(R.id.root)
        val itId = item.itemId
        val text = myLayout.findViewById<TextView>(R.id.my_text)

        if (itId == R.id.red) {
            myLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
            return true
        }
        else if (itId == R.id.green) {
            myLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            return true
        }
        else if (itId == R.id.blue) {
            myLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            return true
        }
        else if (itId == R.id.fontchanger){
            if (!changedFont){
                text.setTypeface(ResourcesCompat.getFont(this, R.font.pressstart2p_regular))
                changedFont = true
                return true
            }
            else{
                text.setTypeface(ResourcesCompat.getFont(this, R.font.asimovian_regular))
                changedFont = false
                return true
            }
        }
        else if (itId == R.id.exit) {
            finish()
            return true
        }
        else return super.onOptionsItemSelected(item)
    }
}
