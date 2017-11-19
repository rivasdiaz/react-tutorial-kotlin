package tictactoe

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class Board(): RComponent<Board.Props, RState>() {

    fun RBuilder.renderSquare(i: Int) {
        square(
                value = props.squares[i],
                onClickFunction = { props.onClickFunction(i) })
    }

    override fun RBuilder.render() {
        div {
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

    interface Props: RProps {
        var squares: Array<String?>
        var onClickFunction: (Int) -> Unit
    }
}

fun RBuilder.board(squares: Array<String?>, onClickFunction: (Int) -> Unit) = child(Board::class) {
    attrs.squares = squares
    attrs.onClickFunction = onClickFunction
}
