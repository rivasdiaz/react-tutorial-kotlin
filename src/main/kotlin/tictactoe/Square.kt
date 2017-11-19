package tictactoe

import kotlinx.html.js.onClickFunction
import org.w3c.dom.events.Event
import react.RBuilder
import react.dom.button

fun RBuilder.square(value: String?, onClickFunction: (Event) -> Unit) =
    button(classes = "square") {
        +(value ?: "")
        attrs.onClickFunction = onClickFunction
    }
