package tictactoe

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button

class Square(): RComponent<Square.Props, RState>() {

    override fun RBuilder.render() {
        button(classes = "square") { +props.value.toString() }
    }

    interface Props: RProps {
        var value: Int
    }
}

fun RBuilder.square(value: Int) = child(Square::class) {
    attrs.value = value
}
