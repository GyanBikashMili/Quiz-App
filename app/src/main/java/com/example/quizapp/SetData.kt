package com.example.quizapp

object SetData {
    const val name: String = "name"
    const val score: String = "score"

    fun getQuestion(): ArrayList<QuestionData> {

        var que: ArrayList<QuestionData> = arrayListOf()

        var question1 = QuestionData(
            "Who won the Man of the Match award in the 2014 World Cup final?",
            1,
            "Mario Götze",
            "Sergio Aguero",
            "Lionel Messi",
            "Bastian Schweinsteiger",
            1,
            R.drawable.messi


        )
        var question2 = QuestionData(
            "This iconic kit was the 2018 World Cup kit for which country?",
            2,
            "Mexico",
            "Brazil",
            "Nigeria",
            "Costa Rica",
            3,
            R.drawable.nigeria
        )
        var question3 = QuestionData(
            "Which footballer holds the record for the highest number of assists in the Premier League?",
            3,
            "Cesc Fabregas",
            "Ryan Giggs",
            "Frank Lampard",
            "Paul Scholes",
            2,
            R.drawable.premierleague
        )
        var question4 = QuestionData(
            "Which team did Porto beat in the 2004 Champions League final?",
            4,
            "Bayern Munich",
            "Deportivo La Coruña",
            "Barcelona",
            "Monaco",
            4,
            R.drawable.porto
        )
        var question5 = QuestionData(
            "Gareth Bale’s breakthrough moment came in the 2010-11 season, when he scored a second half hat-trick against which team?",
            5,
            "Inter Milan",
            "AC Milan",
            "Juventus",
            "Napoli",
            1,
            R.drawable.bale
        )
        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}