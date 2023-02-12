package ga.gamerique.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.btnRollDice)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val imgDiceView: Int = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        val diceImg : ImageView = findViewById(R.id.imgDice)
        diceImg.animate().apply {
            duration = 1000
            rotationYBy(360f)
        }.withEndAction {
            diceImg.animate().apply {
                duration = 1000
                rotationYBy(3600f)
            }.start()

        }
        diceImg.setImageResource(imgDiceView)
    }
}