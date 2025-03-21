package com.example.miwok

object WordData {
    val numbers = listOf(
        Word("lutti", "one", R.drawable.number_one, R.raw.number_one),
        Word("otiiko", "two", R.drawable.number_two, R.raw.number_two),
        Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three),
        Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four),
        Word("massokka", "five", R.drawable.number_five, R.raw.number_five),
        Word("temmokka", "six", R.drawable.number_six, R.raw.number_six),
        Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven),
        Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight),
        Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine),
        Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten)
    )

    val family = listOf(
        Word("əpə", "father", R.drawable.family_father, R.raw.family_father),
        Word("əṭa", "mother", R.drawable.family_mother, R.raw.family_mother),
        Word("angsi", "son", R.drawable.family_son, R.raw.family_son),
        Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter),
        Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother),
        Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother),
        Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister),
        Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister),
        Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother),
        Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather)
    )

    val colors = listOf(
        Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red),
        Word("chokokki", "green", R.drawable.color_green, R.raw.color_green),
        Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown),
        Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray),
        Word("kululli", "black", R.drawable.color_black, R.raw.color_black),
        Word("kelelli", "white", R.drawable.color_white, R.raw.color_white),
        Word("ṭopiisə", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow),
        Word("chiwiiṭə", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow)
    )

    val phrases = listOf(
        Word("minto wuksus?", "Where are you going?", null, R.raw.phrase_where_are_you_going),
        Word("tinnə oyaase'nə", "What is your name?", null, R.raw.phrase_what_is_your_name),
        Word("oyaaset...", "My name is...", null, R.raw.phrase_my_name_is),
        Word("michəksəs?", "How are you feeling?", null, R.raw.phrase_how_are_you_feeling),
        Word("kuchi achit", "I’m feeling good.", null, R.raw.phrase_im_feeling_good),
        Word("əənəs'aa?", "Are you coming?", null, R.raw.phrase_are_you_coming),
        Word("həə’əənəm", "Yes, I’m coming.", null, R.raw.phrase_im_coming),
        Word("əənəm", "I’m coming.", null, R.raw.phrase_yes_im_coming),
        Word("yoowutis", "Let’s go.", null, R.raw.phrase_lets_go),
        Word("ənni’nem", "Come here.", null, R.raw.phrase_come_here)
    )
}
