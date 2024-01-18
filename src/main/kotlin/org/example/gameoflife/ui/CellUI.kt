package org.example.gameoflife.ui

import javafx.event.EventHandler
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType
import org.example.gameoflife.core.Cell

class CellUI(
  grid: GridPane,
  i: Int,
  j: Int,
  alive: Boolean
) : Cell(alive) {
  private val cell =
    Rectangle(
      Config.CELL_SIZE.toDouble(),
      Config.CELL_SIZE.toDouble()
    )

  init {
    cell.fill = if (alive) Color.BLACK else Color.WHITE
    cell.stroke = Color.web("#E0E0E0")
    cell.strokeWidth = 0.5
    cell.strokeType = StrokeType.INSIDE
    cell.onMouseClicked = EventHandler {
      if (isAlive()) {
        kill()
      } else {
        ressurect()
      }
    }

    grid.add(cell, i, j)
  }

  override fun refresh() {
    cell.fill = if (isAlive()) Color.BLACK else Color.WHITE
  }
}
