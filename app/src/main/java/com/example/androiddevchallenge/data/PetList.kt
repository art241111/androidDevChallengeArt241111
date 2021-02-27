/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

/**
 * Creating a list of animals.
 *
 *  @author Artem Gerasimov (artem241120@gmail.com)
 */
fun getPetList(): List<Pet> {
    return listOf(
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet1,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet2,
            description = getDescription()
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet3,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet4,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet5,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet1,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet2,
            description = getDescription()
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet3,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet4,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet5,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet1,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet2,
            description = getDescription()
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet3,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet4,
            description = getDescription(),
        ),
        Pet(
            name = getName(),
            year = getYear(),
            image = R.drawable.pet5,
            description = getDescription(),
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
    return (1..4).random().toDouble()
}

private fun getDescription(): String {
    val description = listOf(
        "We own a handbag dog. That at least is what my mother calls her, probably because she" +
            " takes him shopping in her handbag. She is a miniature Yorkshire terrier and she" +
            " is a delight. Her most attractive quality is that she is friendly to everyone, " +
            "especially children. They love her molten-brown eyes and her glossy fur. " +
            "She also has the cutest little paws. " +
            "They are like a fox’s paws and she loves to dig up " +
            "the garden with them. She also has a small, marshmallow tail. It is soft and " +
            "white so we just call it the marshmallow.\n" +
            "\n She can be very ladylike and fussy about her food at times. She turns her " +
            "nose up at dog food but would snap your hand off for a chocolate digestive." +
            " Her small, sharp teeth make short work of any treats we give her. She is always" +
            " playful and that is why we adore her. Her whip-thin body is very energetic. " +
            "I’m sure she believes she’s a gazelle or a cheetah at times! Although she can " +
            "be as temperamental as a human child, we wouldn’t swop her for anything.",
        "He is an athlete, or thinks he is, when we take him to the park. His speciality is " +
            "the discus (known as the Frisbee to us). It doesn’t seem to matter" +
            " what angle you throw it to him. He will contort his body in all" +
            " manner of impossible ways just to jump up and pluck it out of the" +
            " air. My own opinion is that we should have a doggie Olympics to " +
            "celebrate these wonderful specimens of the animal world."
    )
    return description[(description.indices).random()]
}
