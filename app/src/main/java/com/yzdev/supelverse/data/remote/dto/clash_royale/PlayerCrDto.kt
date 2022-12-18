package com.yzdev.supelverse.data.remote.dto.clash_royale

data class PlayerCrDto(
    val achievements: List<Achievement>,
    val arena: Arena,
    val badges: List<Badge>,
    val battleCount: Int,
    val bestTrophies: Int,
    val cards: List<Card>,
    val challengeCardsWon: Int,
    val challengeMaxWins: Int,
    val clanCardsCollected: Int,
    val currentDeck: List<CurrentDeck>,
    val currentFavouriteCard: CurrentFavouriteCard,
    val donations: Int,
    val donationsReceived: Int,
    val expLevel: Int,
    val expPoints: Int,
    val leagueStatistics: LeagueStatistics,
    val losses: Int,
    val name: String,
    val starPoints: Int,
    val tag: String,
    val threeCrownWins: Int,
    val totalDonations: Int,
    val totalExpPoints: Int,
    val tournamentBattleCount: Int,
    val tournamentCardsWon: Int,
    val trophies: Int,
    val warDayWins: Int,
    val wins: Int
) {
    data class Achievement(
        val completionInfo: Any?,
        val info: String,
        val name: String,
        val stars: Int,
        val target: Int,
        val value: Int
    )

    data class Arena(
        val id: Int,
        val name: String
    )

    data class Badge(
        val iconUrls: IconUrls,
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val progress: Int,
        val target: Int?
    ) {
        data class IconUrls(
            val large: String
        )
    }

    data class Card(
        val count: Int,
        val iconUrls: IconUrls,
        val id: Int,
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val starLevel: Int?
    ) {
        data class IconUrls(
            val medium: String
        )
    }

    data class CurrentDeck(
        val count: Int,
        val iconUrls: IconUrls,
        val id: Int,
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val starLevel: Int
    ) {
        data class IconUrls(
            val medium: String
        )
    }

    data class CurrentFavouriteCard(
        val iconUrls: IconUrls,
        val id: Int,
        val maxLevel: Int,
        val name: String
    ) {
        data class IconUrls(
            val medium: String
        )
    }

    data class LeagueStatistics(
        val bestSeason: BestSeason,
        val currentSeason: CurrentSeason
    ) {
        data class BestSeason(
            val id: String,
            val trophies: Int
        )

        data class CurrentSeason(
            val trophies: Int
        )
    }
}