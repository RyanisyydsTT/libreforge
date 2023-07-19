package com.willfp.libreforge.conditions.impl

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.conditions.Condition
import org.bukkit.entity.Player

object ConditionInLava : Condition<NoCompileData>("in_lava") {

    override fun isMet(player: Player, config: Config, compileData: NoCompileData): Boolean {
        return player.isInLava
    }

}