package tictactoe

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.setState

class Square(): RComponent<Square.Props, Square.State>() {

    override fun RBuilder.render() {
        button(classes = "square") {
            +(state.value ?: "")
            attrs.onClickFunction = {
                setState {
                    value = "X"
                }
            }
        }
    }

    interface Props: RProps {
        var value: String?
    }

    interface State: RState {
        var value: String?
    }
}

fun RBuilder.square(value: String?) = child(Square::class) {
    attrs.value = value
}
