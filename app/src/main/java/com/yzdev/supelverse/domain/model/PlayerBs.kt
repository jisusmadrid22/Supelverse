package com.yzdev.supelverse.domain.model

import com.google.gson.annotations.SerializedName
import com.yzdev.supelverse.data.remote.dto.PlayerDto

data class PlayerBs(
    val threeVictory: Int,
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

fun PlayerDto.toPlayerBs(): PlayerBs{
    return PlayerBs(
        threeVictory = threeVictory,
        bestRoboRumbleTime = bestRoboRumbleTime,
        bestTimeAsBigBrawler = bestTimeAsBigBrawler,
        brawlers = brawlers.toPlayerBsBrawlers(),
        club = club.toPlayerBsClub(),
        duoVictories = duoVictories,
        expLevel = expLevel,
        expPoints = expPoints,
        highestTrophies = highestTrophies,
        highestPowerPlayPoints = highestPowerPlayPoints,
        icon = icon.toPlayerBsIcon(),
        isQualifiedFromChampionshipChallenge = isQualifiedFromChampionshipChallenge,
        name = name,
        nameColor = nameColor,
        soloVictories = soloVictories,
        tag = tag,
        trophies = trophies
    )
}

/** Cast Brawlers ******************************************************************/
fun List<PlayerDto.Brawler>.toPlayerBsBrawlers(): List<PlayerBs.Brawler>{
    return this.map {
        PlayerBs.Brawler(
            gadgets = it.gadgets.toPlayerBsBrawlersGadgets(),
            gears = it.gears.toPlayerBsBrawlersGears(),
            highestTrophies = it.highestTrophies,
            id = it.id,
            name = it.name,
            power = it.power,
            rank = it.rank,
            starPowers = it.starPowers.toPlayerBsBrawlersStarPowers(),
            trophies = it.trophies
        )
    }
}

fun List<PlayerDto.Brawler.Gadget>.toPlayerBsBrawlersGadgets(): List<PlayerBs.Brawler.Gadget>{
    return this.map {
        PlayerBs.Brawler.Gadget(
            id = it.id,
            name = it.name
        )
    }
}

fun List<PlayerDto.Brawler.Gear>.toPlayerBsBrawlersGears(): List<PlayerBs.Brawler.Gear>{
    return this.map {
        PlayerBs.Brawler.Gear(
            id = it.id,
            name = it.name,
            level = it.level
        )
    }
}

fun List<PlayerDto.Brawler.StarPower>.toPlayerBsBrawlersStarPowers(): List<PlayerBs.Brawler.StarPower>{
    return this.map {
        PlayerBs.Brawler.StarPower(
            id = it.id,
            name = it.name
        )
    }
}

/*********************************************************************************************************/

/** Cast Club *********************************************************************************************/
fun PlayerDto.Club.toPlayerBsClub(): PlayerBs.Club{
    return PlayerBs.Club(
        name = name,
        tag = tag
    )
}

/************************************************************************************************************/

/** Cast Icon ************************************************************************************************/
fun PlayerDto.Icon.toPlayerBsIcon(): PlayerBs.Icon{
    return PlayerBs.Icon(
        id = id
    )
}

/*************************************************************************************************************/