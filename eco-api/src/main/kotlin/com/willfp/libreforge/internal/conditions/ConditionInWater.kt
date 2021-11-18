package com.willfp.libreforge.internal.conditions

import com.willfp.eco.core.config.interfaces.JSONConfig
import com.willfp.libreforge.api.conditions.Condition
import com.willfp.libreforge.api.provider.LibReforgeProviders
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.player.PlayerMoveEvent

class ConditionInWater: Condition("in_water") {
    @EventHandler(
        priority = EventPriority.MONITOR,
        ignoreCancelled = true
    )
    fun handle(event: PlayerMoveEvent) {
        val player = event.player

        if (event.from.world?.getBlockAt(event.from)?.type == event.to.world?.getBlockAt(event.to)?.type) {
            return
        }

        LibReforgeProviders.updateEffects(player)
    }

    override fun isConditionMet(player: Player, config: JSONConfig): Boolean {
        return player.isInWater
    }
}