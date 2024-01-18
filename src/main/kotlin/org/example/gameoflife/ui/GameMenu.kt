package org.example.gameoflife.ui

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem

class GameMenu(
  private val board: GameBoard,
  private val ticker: Ticker,
  menuBar: MenuBar
) {
  init {
    val fileMenu = Menu("Game")
    fileMenu.items.addAll(
      createMenu("Tick") {
        board.tick()
      },
      createMenu("Faster") {
        ticker.faster()
      },
      createMenu("Slower") {
        ticker.slower()
      },
      createMenu("Stop") {
        ticker.stop()
      },
      createMenu("Start") {
        ticker.start()
      },
      createMenu("Reset") {
        board.reset()
      }
    )

    menuBar.menus.add(fileMenu)
  }

  fun createMenu(name: String, handler: EventHandler<ActionEvent>): MenuItem {
    val menuItem = MenuItem(name)
    menuItem.onAction = handler
    return menuItem
  }
}