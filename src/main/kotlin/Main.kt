import java.util.Scanner

fun main(args: Array<String>) {
    val storage: MutableList<Archive> = ArrayList()
    val screen = UserScreen()
    println("Добро пожаловать в заметки")

    while (true) {
        screen.showArchiveList(storage)
        val userCommand = Scanner(System.`in`).nextLine()
        when (userInput(userCommand,storage.size)) {
            -2 -> println("Некорректный ввод. Введите цифру, соответствующую пункту меню.")
            -1 -> println("Некорректный ввод. Архив не найден.")
            0 -> break
            1 -> storage.add(screen.createArchive())
            else -> while (true) {
                screen.showNotesList(storage.get(userCommand.toInt() - 2))
                val userCommand2 = Scanner(System.`in`).nextLine()
                when (userInput(userCommand2, storage[userCommand.toInt() -2 ].content.size)) {
                    -2 -> println("Некорректный ввод. Введите цифру, соответствующую пункту меню.")
                    -1 -> println("Некорректный ввод. Заметка не найдена.")
                    0 -> break
                    1 -> storage[userCommand.toInt() - 2].putInArchive(screen.createNote())
                    else -> screen.showNote(storage.get(userCommand.toInt() - 2).getFromArchive(userCommand2.toInt() - 2))
                }
            }
        }
    }
}
fun userInput(command: String, max: Int):Int {
    try {
        command.toInt()
    }
    catch (e:Exception) {
        return (-2)
    }
    if (command.toInt()>max+1) return -1
    return command.toInt()
}




