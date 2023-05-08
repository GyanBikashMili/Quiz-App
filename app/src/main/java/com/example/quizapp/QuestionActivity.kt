package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.Result

class QuestionActivity : AppCompatActivity() {

    private var Name: String? = null
    private var score: Int = 0
    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)
        val submit = findViewById<Button>(R.id.submit)

        Name = intent.getStringExtra(SetData.name)

        questionList = SetData.getQuestion()
        setQuestion()

        opt_1.setOnClickListener {
            selectedOptionStyle(opt_1, 1)
        }
        opt_2.setOnClickListener {
            selectedOptionStyle(opt_2, 2)
        }

        opt_3.setOnClickListener {
            selectedOptionStyle(opt_3, 3)
        }

        opt_4.setOnClickListener {
            selectedOptionStyle(opt_4, 4)
        }

        submit.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correct_ans) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                } else {
                    score++
                }
                setColor(question.correct_ans, R.drawable.correct_question_option)
                if (currentPosition == questionList!!.size)
                    submit.text = "FINISH"
                else
                    submit.text = "Go to Next"
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }

                    else -> {
                        val intent = Intent(this, Result::class.java)
                        intent.putExtra(SetData.name, Name.toString())
                        intent.putExtra(SetData.score, score.toString())
                        intent.putExtra("Total Size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }
    }

    fun setColor(opt: Int, color: Int) {
        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)
        when (opt) {
            1 -> {
                opt_1.background = ContextCompat.getDrawable(this, color)
            }

            2 -> {
                opt_2.background = ContextCompat.getDrawable(this, color)
            }

            3 -> {
                opt_3.background = ContextCompat.getDrawable(this, color)
            }

            4 -> {
                opt_4.background = ContextCompat.getDrawable(this, color)
            }

        }
    }


    fun setQuestion() {

        val progress_bar = findViewById<ProgressBar>(R.id.progress_bar)
        val progress_text = findViewById<TextView>(R.id.progress_text)
        val questiontext = findViewById<TextView>(R.id.question_text)
        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)
        val questionImage = findViewById<ImageView>(R.id.question_image)
        val question = questionList!![currentPosition - 1]
        setOptionStyle()
        progress_bar.progress = currentPosition
        progress_bar.max = questionList!!.size
        progress_text.text = "${currentPosition}" + "/" + "${questionList!!.size}"
        questiontext.text = question.question
        opt_1.text = question.option_one
        opt_2.text = question.option_two
        opt_3.text = question.option_three
        opt_4.text = question.option_four
        questionImage.setImageResource(question.image)

    }

    fun setOptionStyle() {

        val opt_1 = findViewById<TextView>(R.id.opt_1)
        val opt_2 = findViewById<TextView>(R.id.opt_2)
        val opt_3 = findViewById<TextView>(R.id.opt_3)
        val opt_4 = findViewById<TextView>(R.id.opt_4)
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt_1)
        optionList.add(0, opt_2)
        optionList.add(0, opt_3)
        optionList.add(0, opt_4)

        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int) {
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}