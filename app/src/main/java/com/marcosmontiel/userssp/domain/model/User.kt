package com.marcosmontiel.userssp.domain.model

data class User(
    val id: Long = 0,
    val name: String = "",
    val lastName: String = "",
    val url: String = "",
) {

    fun getFullName(): String = "$name $lastName"

    companion object {

        fun getUsers(): List<User> = listOf(
            User(
                name = "Juan",
                lastName = "Juarez",
                url = "https://firebasestorage.googleapis.com/v0/b/games-learning.appspot.com/o/Posts%2F3ba3ac98-6487-4cd5-9dc8-5d00831e498f6845442358286615801.jpg?alt=media&token=f671ccdb-5fac-4bed-baaa-9394d2dddcc7"
            ),
            User(name = "Maria", lastName = "Juarez"),
            User(name = "Martha", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
            User(name = "Marlene", lastName = "Juarez"),
        )

    }

}
