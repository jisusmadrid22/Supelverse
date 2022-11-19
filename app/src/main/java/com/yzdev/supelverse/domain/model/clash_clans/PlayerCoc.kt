package com.yzdev.supelverse.domain.model.clash_clans

import com.yzdev.supelverse.data.remote.dto.clash_clans.PlayerCocDto
import com.yzdev.supelverse.domain.model.brawl_stars.PlayerBs

data class PlayerCoc(
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

fun PlayerCocDto.toPlayerCoc(): PlayerCoc{
    return PlayerCoc(
        achievements = achievements.toPlayerCocAchievements(),
        attackWins = attackWins,
        bestTrophies = bestTrophies,
        bestVersusTrophies = bestVersusTrophies,
        builderHallLevel = builderHallLevel,
        clan = clan.toPlayerCocClan(),
        clanCapitalContributions = clanCapitalContributions,
        defenseWins = defenseWins,
        donations = donations,
        donationsReceived = donationsReceived,
        expLevel = expLevel,
        heroes = heroes.toPlayerCocHeroes(),
        labels = labels.toPlayerCocLabels(),
        name = name,
        role = role,
        spells = spells.toPlayerCocSpells(),
        tag = tag,
        townHallLevel = townHallLevel,
        troops = troops.toPlayerCocTroops(),
        trophies = trophies,
        versusBattleWinCount = versusBattleWinCount,
        versusBattleWins = versusBattleWins,
        versusTrophies = versusTrophies,
        warPreference = warPreference,
        warStars = warStars
    )
}

/** Cast achievements ******************************************************************/
private fun List<PlayerCocDto.Achievement>.toPlayerCocAchievements(): List<PlayerCoc.Achievement>{
    return this.map {
        PlayerCoc.Achievement(
            completionInfo = it.completionInfo,
            info = it.info,
            name = it.name,
            stars = it.stars,
            target = it.target,
            value = it.value,
            village = it.village
        )
    }
}

/*********************************************************************************************************/

/** Cast clans ******************************************************************/
private fun PlayerCocDto.Clan.toPlayerCocClan(): PlayerCoc.Clan{
    return PlayerCoc.Clan(
        badgeUrls = badgeUrls.toPlayerCocClanBadgeUrl(),
        clanLevel = clanLevel,
        name = name,
        tag = tag
    )
}

private fun PlayerCocDto.Clan.BadgeUrls.toPlayerCocClanBadgeUrl(): PlayerCoc.Clan.BadgeUrls{
    return PlayerCoc.Clan.BadgeUrls(
        large = large,
        medium = medium,
        small = small
    )
}

/*********************************************************************************************************/

/** Cast heroes ******************************************************************/
private fun List<PlayerCocDto.Heroe>.toPlayerCocHeroes(): List<PlayerCoc.Heroe>{
    return this.map {
        PlayerCoc.Heroe(
            name = it.name,
            village = it.village,
            level = it.level,
            maxLevel = it.maxLevel
        )
    }
}

/*********************************************************************************************************/

/** Cast labels ******************************************************************/
private fun List<PlayerCocDto.Label>.toPlayerCocLabels(): List<PlayerCoc.Label>{
    return this.map {
        PlayerCoc.Label(
            name = it.name,
            iconUrls = it.iconUrls.toPlayerCocLabelIconUrl(),
            id = it.id
        )
    }
}

private fun PlayerCocDto.Label.IconUrls.toPlayerCocLabelIconUrl(): PlayerCoc.Label.IconUrls{
    return PlayerCoc.Label.IconUrls(
        medium = medium,
        small = small
    )
}

/*********************************************************************************************************/

/** Cast spells ******************************************************************/
private fun List<PlayerCocDto.Spell>.toPlayerCocSpells(): List<PlayerCoc.Spell>{
    return this.map {
        PlayerCoc.Spell(
            name = it.name,
            village = it.village,
            level = it.level,
            maxLevel = it.maxLevel
        )
    }
}

/*********************************************************************************************************/

/** Cast troops ******************************************************************/
private fun List<PlayerCocDto.Troop>.toPlayerCocTroops(): List<PlayerCoc.Troop>{
    return this.map {
        PlayerCoc.Troop(
            name = it.name,
            village = it.village,
            level = it.level,
            maxLevel = it.maxLevel
        )
    }
}

/*********************************************************************************************************/
