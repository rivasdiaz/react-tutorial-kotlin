package tictactoe

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button

class Square(): RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        button(classes = "square") {/* TODO */}
    }
}

fun RBuilder.square() = child(Square::class) {}
