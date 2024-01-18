package org.example.gameoflife

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.MenuBar
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.stage.Stage

class HelloApplication : Application() {
  private lateinit var board: GameBoard

  override fun start(stage: Stage) {
    val grid = GridPane()
    board = GameBoard(grid)

    val ticker = Ticker(board)
    ticker.start()

    val menuBar = MenuBar()
    val gameMenu = GameMenu(board, ticker, menuBar)

    val root = BorderPane()
    root.top = menuBar
    root.center = grid

    val scene = Scene(
      root,
    )

    stage.isResizable = false
    stage.scene = scene
    stage.title = "Hello!"
    stage.show()
  }
}

fun main() {
  Application.launch(HelloApplication::class.java)
}