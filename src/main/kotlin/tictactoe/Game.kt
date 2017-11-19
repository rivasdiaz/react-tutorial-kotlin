package tictactoe

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.div
import react.dom.li
import react.dom.ol
import react.setState

class Game(): RComponent<RProps, Game.State>() {

    init {
        state.apply {
            history = arrayOf(HistoryEntry(Array<String?>(9) { null }))
            xIsNext = true
        }
    }

    fun handleClick(i: Int) {
        val history = state.history
        val current = state.history.last()
        val squares = current.squares.copyOf()
        if (calculateWinner(squares) != null || squares[i] != null)
            return
        squares[i] = if (state.xIsNext) "X" else "O"
        setState {
            this.history = history + HistoryEntry(squares)
            xIsNext = !state.xIsNext
        }
    }

    fun calculateWinner(squares: Array<String?>): String? {
        val solutions = arrayOf(
                arrayOf(0, 1, 2),
                arrayOf(3, 4, 5),
                arrayOf(6, 7, 8),
                arrayOf(0, 3, 6),
                arrayOf(1, 4, 7),
                arrayOf(2, 5, 8),
                arrayOf(0, 4, 8),
                arrayOf(2, 4, 6))
        for (solution in solutions){
            val (a, b, c) = solution
            if (squares[a] != null && squares[a] == squares[b] && squares[a] == squares[c])
                return squares[a]
        }
        return null
    }

    fun jumpTo(step: Int) {
        TODO()
    }

    fun RBuilder.movesNodes() =
            state.history.mapIndexed { step, move ->
                val desc =
                        if (step != 0)
                            "Go to move #$step"
                        else
                            "Go to game start"
                li {
                    button {
                        +desc
                        attrs.onClickFunction = { jumpTo(step) }
                    }
                }
            }

    override fun RBuilder.render() {
        val history = state.history
        val current = history.last()
        val winner = calculateWinner(current.squares)
        val status =
                if (winner != null)
                    "Winner: $winner"
                else
                    "Next player: ${if (state.xIsNext) "X" else "O"}"

        div(classes = "game") {
            div(classes = "game-board") {
                board(current.squares) {
                    handleClick(it)
                }
            }
            div(classes = "game-info") {
                div { +status }
                ol { movesNodes() }
            }
        }
    }

    interface State: RState {
        var history: Array<HistoryEntry>
        var xIsNext: Boolean
    }

    data class HistoryEntry(var squares: Array<String?>)
}

fun RBuilder.game() = child(Game::class) {}
