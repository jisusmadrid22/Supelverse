package com.yzdev.supelverse.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlayerBsDto(
    @SerializedName("3vs3Victories") val threeVictory: Int,
    val bestRoboRumbleTime: Int,
    val bestTimeAsBigBrawler: Int,
    val brawlers: List<Brawler>,
    val club: Club,
    val duoVictories: Int,
    val expLevel: Int,
    val expPoints: Int,
    val highestPowerPlayPoints: Int,
    val highestTrophies: Int,
    val icon: Icon,
    val isQualifiedFromChampionshipChallenge: Boolean,
    val name: String,
    val nameColor: String,
    val soloVictories: Int,
    val tag: String,
    val trophies: Int
) {
    data class Brawler(
        val gadgets: List<Gadget>,
        val gears: List<Gear>,
        val highestTrophies: Int,
        val id: Int,
        val name: String,
        val power: Int,
        val rank: Int,
        val starPowers: List<StarPower>,
        val trophies: Int
    ) {
        data class Gadget(
            val id: Int,
            val name: String
        )

        data class Gear(
            val id: Int,
            val level: Int,
            val name: String
        )

        data class StarPower(
            val id: Int,
            val name: String
        )
    }

    data class Club(
        val name: String,
        val tag: String
    )

    data class Icon(
        val id: Int
    )
}