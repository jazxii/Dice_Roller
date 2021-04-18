package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button =findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        start()
    }
    fun start(){
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage2.setImageResource(R.drawable.dice_1)
    }
    private fun rollDice() {

        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        /**
         * or we can use
         * val toast= Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
         * toast.show()
         */
        //Rolloing of Dice1
        val dice = Dice(6)
        val resultTextView: TextView = findViewById(R.id.r2)
        val roll1 =  dice.roll()
        resultTextView.text = roll1.toString()
        //or we can do TextView = findViewById(R.id.r2).text = dice.roll().toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.contentDescription = roll1.toString()
        when (roll1) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        /**
         * or
         * val drawableResource = when (diceRoll) {
         * 1 -> R.drawable.dice_1
         * 2 -> R.drawable.dice_2
         * 3 -> R.drawable.dice_3
         * 4 -> R.drawable.dice_4
         * 5 -> R.drawable.dice_5
         * else -> R.drawable.dice_6
         * }
         *
         * diceImage.setImageResource(drawableResource)
         **/

        //rolling of dice2
        val dice2 = Dice(6)
        val resultTextView2: TextView = findViewById(R.id.r3)
        val roll2 = dice.roll()
        resultTextView2.text = roll2.toString()
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        diceImage.contentDescription = roll2.toString()
        when (roll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}