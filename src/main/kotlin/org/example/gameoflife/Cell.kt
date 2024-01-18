package org.example.gameoflife

import javafx.event.EventHandler
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType

class Cell(
  private var grid: GridPane,
  private var i: Int,
  private var j: Int,
  private var alive: Boolean
) {
  private val cell =
    Rectangle(
      Config.CELL_SIZE.toDouble(),
      Config.CELL_SIZE.toDouble()
    )

  init {
    cell.fill = if (alive) Color.BLACK else Color.WHITE
    cell.stroke = Color.web("#C0C0C0")
    cell.strokeWidth = 0.5
    cell.strokeType = StrokeType.INSIDE
    cell.onMouseClicked = EventHandler {
      if (alive) {
        kill()
      } else {
        ressurect()
      }
    }

    grid.add(cell, i, j)
  }

  fun isAlive(): Boolean {
    return alive
  }

  fun kill() {
    alive = false
    refresh()
  }

  fun ressurect() {
    alive = true
    refresh()
  }

  fun refresh() {
    cell.fill = if (alive) Color.BLACK else Color.WHITE
  }
}
