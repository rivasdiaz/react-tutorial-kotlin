package tictactoe

import react.dom.render
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    window.onload = {
        val root = document.getElementById("root") ?: throw IllegalStateException()
        render(root) {
            game()
        }
    }
}
