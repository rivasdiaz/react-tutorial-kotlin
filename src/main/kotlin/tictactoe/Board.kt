package tictactoe

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.setState

class Board(): RComponent<RProps, Board.State>() {

    init {
        state.squares = Array(9) { null }
    }

    fun RBuilder.renderSquare(i: Int) {
        square(
                value = state.squares[i],
                onClickFunction = { handleClick(i) })
    }

    fun handleClick(i: Int) {
        val updatedSquares = state.squares.copyOf()
        updatedSquares[i] = "X"
        setState {
            squares = updatedSquares
        }
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

    interface State: RState {
        var squares: Array<String?>
    }
}

fun RBuilder.board() = child(Board::class) {}
