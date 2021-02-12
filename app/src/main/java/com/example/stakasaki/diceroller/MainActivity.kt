package com.example.stakasaki.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            Log.d("MainActivity", "tapped on rollButton")
            //Toast.makeText(this, "Rolled Dice!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val myDiceLeft = Dice(6)
        val myDiceRight = Dice(6)

        val diceResultLeft = myDiceLeft.roll()
        val diceResultRight = myDiceRight.roll()

        val resultImageLeft = when (diceResultLeft) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val resultImageRight = when (diceResultRight) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageview_dice_left.setImageResource(resultImageLeft)
        imageview_dice_right.setImageResource(resultImageRight)
        imageview_dice_left.contentDescription = diceResultLeft.toString()
        imageview_dice_right.contentDescription = diceResultRight.toString()
    }
    
    class Dice(val numSides: Int) {
        fun roll(): Int { return (1..numSides).random() }
    }
}
