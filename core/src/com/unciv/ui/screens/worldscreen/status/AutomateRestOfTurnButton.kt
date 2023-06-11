package com.unciv.ui.screens.worldscreen.status

import com.unciv.logic.automation.civilization.NextTurnAutomation
import com.unciv.ui.components.KeyboardBinding
import com.unciv.ui.components.extensions.keyShortcuts
import com.unciv.ui.components.extensions.onActivation
import com.unciv.ui.images.IconTextButton
import com.unciv.ui.images.ImageGetter
import com.unciv.ui.screens.worldscreen.WorldScreen

class AutomateRestOfTurnButton :
    IconTextButton("", ImageGetter.getImage("OtherIcons/Settings"), 30) {

    var worldScreen: WorldScreen? = null

    init {
        labelCell.pad(10f)
        onActivation { worldScreen?.let { automateRestOfTurn(it) } }
        keyShortcuts.add(KeyboardBinding.AutomateRestOfTurn)
    }

    fun update(worldScreen: WorldScreen) {
        this.worldScreen = worldScreen
    }

    private fun automateRestOfTurn(worldScreen: WorldScreen) {
        NextTurnAutomation.automateCivMoves(worldScreen.viewingCiv)
        worldScreen.nextTurn()
    }
}
