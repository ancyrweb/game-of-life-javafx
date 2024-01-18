package org.example.gameoflife

import javafx.scene.layout.GridPane
import kotlin.random.Random

class GameBoard(private val grid: GridPane) {
  var cells: Array<Array<Cell>> = Array(Config.CELLS_X) { i ->
    Array(Config.CELLS_Y) { j ->
      val isAlive = Random.nextInt(100) < 20;
      Cell(
        grid,
        i,
        j,
        isAlive
      )
    }
  }

  fun reset() {
    for (i in 0 until Config.CELLS_X) {
      for (j in 0 until Config.CELLS_Y) {
        if (Random.nextInt(100) < 20) {
          cells[i][j].ressurect()
        } else {
          cells[i][j].kill()
        }
      }
    }
  }

  fun tick() {
    for (i in 0 until Config.CELLS_X) {
      for (j in 0 until Config.CELLS_Y) {
        val cell = cells[i][j]
        val aliveNeighbors = getAliveNeighbors(i, j)
        
        if (cell.isAlive()) {
          if (aliveNeighbors < 2 || aliveNeighbors > 3) {
            cell.kill()
          }
        } else {
          if (aliveNeighbors == 3) {
            cell.ressurect()
          }
        }
      }
    }
  }

  fun getAliveNeighbors(i: Int, j: Int): Int {
    var aliveNeighbors = 0
    for (x in -1..1) {
      for (y in -1..1) {
        if (x == 0 && y == 0) {
          continue
        }

        val neighborI = i + x
        val neighborJ = j + y

        if (neighborI < 0 || neighborI >= Config.CELLS_X || neighborJ < 0 || neighborJ >= Config.CELLS_Y) {
          continue
        }

        if (cells[neighborI][neighborJ].isAlive()) {
          aliveNeighbors++
        }
      }
    }

    return aliveNeighbors
  }

}
