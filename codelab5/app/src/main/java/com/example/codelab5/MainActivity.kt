package com.example.codelab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.view.MotionEvent
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //resource file > type > id name
//        val rollButton: Button = findViewById(R.id.button)
//        rollButton.setOnClickListener {
//            rollDice()
//        }
        val rootLayout = findViewById<View>(R.id.rootLayout)

        rootLayout.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Action to perform when the screen is touched
                    // Replace this with your desired functionality
                    rollDice()
                }
            }
            true
        }
    }
    //custom function inside my main class
    //roll the Coin and display the random generated number
    /**
     * Roll the Coin and update the screen
     */
    private fun rollDice() {
        val dice = Dice(2)  //creating object of dice class
        val diceRoll = dice.rollDice()  //calling roll function of Dice class

        //connecting the textview
        // val resultTextView: TextView= findViewById(R.id.textview)
        //  resultTextView.text = diceRoll.toString()

        //creating image view
        val diceImage: ImageView = findViewById(R.id.imageView)

        when (diceRoll)
        {
            1 -> { diceImage.setImageResource(R.drawable.head)
            val toast = Toast.makeText(this, "head", Toast.LENGTH_SHORT)
            toast.show()}

            2 -> {diceImage.setImageResource(R.drawable.tail)
                val toast = Toast.makeText(this, "tail", Toast.LENGTH_SHORT)
                toast.show()}
        }

    }
}
class Dice(private val numsides:Int)
{
    fun rollDice():Int{
        return (1..numsides).random()
    }
}