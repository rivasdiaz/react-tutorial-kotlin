package tictactoe

import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button

class Square(): RComponent<Square.Props, RState>() {

    override fun RBuilder.render() {
        button(classes = "square") {
            +(props.value ?: "")
            attrs.onClickFunction = props.onClickFunction
        }
    }

    interface Props: RProps {
        var value: String?
        var onClickFunction: (Event) -> Unit
    }
}

fun RBuilder.square(value: String?, onClickFunction: (Event) -> Unit) = child(Square::class) {
    attrs.value = value
    attrs.onClickFunction = onClickFunction
}
