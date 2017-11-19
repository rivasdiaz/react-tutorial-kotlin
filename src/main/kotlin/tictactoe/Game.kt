package tictactoe

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div

class Game(): RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        div(classes = "game") {
            div(classes = "game-board") {
                board()
            }
            div(classes = "game-info") {
                div {/* status */}
                div {/* TODO */}
            }
        }
    }
}

fun RBuilder.game() = child(Game::class) {}
