package tictactoe

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class Board(): RComponent<RProps, RState>() {

    fun RBuilder.renderSquare(i: Int) {
        square()
    }

    override fun RBuilder.render() {
        val status = "Next player: X"

        div {
            div(classes = "status") { +status }
            div(classes = "board-row") {
                renderSquare(0)
                renderSquare(1)
                renderSquare(2)
            }
            div(classes = "board-row") {
                renderSquare(3)
                renderSquare(4)
                renderSquare(5)
            }
            div(classes = "board-row") {
                renderSquare(6)
                renderSquare(7)
                renderSquare(8)
            }
        }
    }
}

fun RBuilder.board() = child(Board::class) {}
