package org.example.gameoflife.core

open class Cell(
  private var alive: Boolean
) {
  private val neighbors = mutableListOf<Cell>()

  fun setNeighbors(neighbors: List<Cell>) {
    this.neighbors.addAll(neighbors)
  }

  fun tick() {
    val aliveNeighbors = getAliveNeighbors()
    if (alive && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
      kill()
    } else if (!alive && aliveNeighbors == 3) {
      ressurect()
    }
  }


  fun kill() {
    alive = false
    refresh()
  }

  fun ressurect() {
    alive = true
    refresh()
  }

  fun isAlive(): Boolean {
    return alive
  }

  open fun refresh() {}

  private fun getAliveNeighbors(): Int {
    return neighbors.count { it.isAlive() }
  }
}
