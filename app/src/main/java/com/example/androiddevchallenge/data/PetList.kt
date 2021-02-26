package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

fun getPetList(): List<Pet> {
    return listOf(
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet1,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet2,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet3,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet4,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet5,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet1,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet2,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet3,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet4,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet5,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet1,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet2,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet3,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet4,
            description = "sdfgdsgsg",
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet5,
            description = "sdfgdsgsg",
        ),
    )
}

private fun getName(): String {
    val names = listOf(
        "Jordan", "Max", "Rocky", "Cooper", "Bear", "Bentley"
    )
    return names[(names.indices).random()]
}

private fun getYear(): Double {
    return (0..3).random().toDouble()
}