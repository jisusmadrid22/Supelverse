package com.yzdev.supelverse.domain.model

import com.yzdev.supelverse.data.remote.dto.PlayerBattleLogBsDto

data class PlayerBattleLogBs(
    val items: List<Item>
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
}

fun PlayerBattleLogBsDto.toPlayerBattleLogBs(): PlayerBattleLogBs{
    return PlayerBattleLogBs(
        items = items.toPlayerBattleLogBsItems()
    )
}

/** Cast items battle log ******************************************************************************/
private fun List<PlayerBattleLogBsDto.Item>.toPlayerBattleLogBsItems(): List<PlayerBattleLogBs.Item>{
    return this.map {
        PlayerBattleLogBs.Item(
            battle = it.battle.toPlayerBattleLogBsItemsBattle(),
            battleTime = it.battleTime,
            event = it.event.toPlayerBattleLogBsItemsEvent()
        )
    }
}

private fun PlayerBattleLogBsDto.Item.Battle.toPlayerBattleLogBsItemsBattle(): PlayerBattleLogBs.Item.Battle{
    return PlayerBattleLogBs.Item.Battle(
        duration = duration,
        mode = mode,
        result = result,
        starPlayer = starPlayer?.toPlayerBattleLogBsItemsBattleStarPlayer(),
        teams = teams.toPlayerBattleLogBsItemsBattleTeam(),
        type = type
    )
}

private fun PlayerBattleLogBsDto.Item.Battle.StarPlayer.toPlayerBattleLogBsItemsBattleStarPlayer(): PlayerBattleLogBs.Item.Battle.StarPlayer{
    return PlayerBattleLogBs.Item.Battle.StarPlayer(
        brawler = brawler.toPlayerBattleLogBsItemsBattleStarPlayerBrawler(),
        name = name,
        tag = tag
    )
}

private fun PlayerBattleLogBsDto.Item.Battle.StarPlayer.Brawler.toPlayerBattleLogBsItemsBattleStarPlayerBrawler(): PlayerBattleLogBs.Item.Battle.StarPlayer.Brawler{
    return PlayerBattleLogBs.Item.Battle.StarPlayer.Brawler(
        id = id,
        name = name,
        power = power,
        trophies = trophies
    )
}

private fun List<List<PlayerBattleLogBsDto.Item.Battle.Team>>.toPlayerBattleLogBsItemsBattleTeam(): List<List<PlayerBattleLogBs.Item.Battle.Team>>{
    return this.map {
        it.map {item->
            PlayerBattleLogBs.Item.Battle.Team(
                brawler = item.brawler.toPlayerBattleLogBsItemsBattleTeamBrawler(),
                name = item.name,
                tag = item.tag
            )
        }
    }
}

private fun PlayerBattleLogBsDto.Item.Battle.Team.Brawler.toPlayerBattleLogBsItemsBattleTeamBrawler(): PlayerBattleLogBs.Item.Battle.Team.Brawler{
    return PlayerBattleLogBs.Item.Battle.Team.Brawler(
        id = id,
        name = name,
        power = power,
        trophies = trophies
    )
}

private fun PlayerBattleLogBsDto.Item.Event.toPlayerBattleLogBsItemsEvent(): PlayerBattleLogBs.Item.Event{
    return PlayerBattleLogBs.Item.Event(
        id = id,
        map = map,
        mode = mode
    )
}

/*******************************************************************************************************/
