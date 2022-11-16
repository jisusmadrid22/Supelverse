package com.yzdev.supelverse.data.remote.dto

data class PlayerBattleLogBsDto(
    val items: List<Item>,
    val paging: Paging
) {
    data class Item(
        val battle: Battle,
        val battleTime: String,
        val event: Event
    ) {
        data class Battle(
            val duration: Int,
            val mode: String,
            val result: String,
            val starPlayer: StarPlayer?,
            val teams: List<List<Team>>,
            val type: String
        ) {
            data class StarPlayer(
                val brawler: Brawler,
                val name: String,
                val tag: String
            ) {
                data class Brawler(
                    val id: Int,
                    val name: String,
                    val power: Int,
                    val trophies: Int
                )
            }

            data class Team(
                val brawler: Brawler,
                val name: String,
                val tag: String
            ) {
                data class Brawler(
                    val id: Int,
                    val name: String,
                    val power: Int,
                    val trophies: Int
                )
            }
        }

        data class Event(
            val id: Int,
            val map: String,
            val mode: String
        )
    }

    data class Paging(
        val cursors: Cursors
    ) {
        class Cursors
    }
}