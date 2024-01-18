package org.example.gameoflife

import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.EventHandler
import javafx.util.Duration

class Ticker(private val board: GameBoard) {
  private var timeline: Timeline = Timeline(
    KeyFrame(
      Duration.seconds(1.0),
      EventHandler {
        board.tick()
      }
    )
  )


  init {
    timeline.cycleCount = Timeline.INDEFINITE
  }

  fun start() {
    timeline.play()
  }

  fun stop() {
    timeline.stop()
  }

  fun faster() {
    timeline.rate *= 2
  }

  fun slower() {
    timeline.rate /= 2
  }
}