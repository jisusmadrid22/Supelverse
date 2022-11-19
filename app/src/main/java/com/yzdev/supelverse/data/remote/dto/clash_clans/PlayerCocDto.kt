package com.yzdev.supelverse.data.remote.dto.clash_clans

data class PlayerCocDto(
    val achievements: List<Achievement>,
    val attackWins: Int,
    val bestTrophies: Int,
    val bestVersusTrophies: Int,
    val builderHallLevel: Int,
    val clan: Clan,
    val clanCapitalContributions: Int,
    val defenseWins: Int,
    val donations: Int,
    val donationsReceived: Int,
    val expLevel: Int,
    val heroes: List<Heroe>,
    val labels: List<Label>,
    val name: String,
    val role: String,
    val spells: List<Spell>,
    val tag: String,
    val townHallLevel: Int,
    val troops: List<Troop>,
    val trophies: Int,
    val versusBattleWinCount: Int,
    val versusBattleWins: Int,
    val versusTrophies: Int,
    val warPreference: String,
    val warStars: Int
) {
    data class Achievement(
        val completionInfo: String?,
        val info: String,
        val name: String,
        val stars: Int,
        val target: Int,
        val value: Int,
        val village: String
    )

    data class Clan(
        val badgeUrls: BadgeUrls,
        val clanLevel: Int,
        val name: String,
        val tag: String
    ) {
        data class BadgeUrls(
            val large: String,
            val medium: String,
            val small: String
        )
    }

    data class Heroe(
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    )

    data class Label(
        val iconUrls: IconUrls,
        val id: Int,
        val name: String
    ) {
        data class IconUrls(
            val medium: String,
            val small: String
        )
    }

    data class Spell(
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    )

    data class Troop(
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    )
}