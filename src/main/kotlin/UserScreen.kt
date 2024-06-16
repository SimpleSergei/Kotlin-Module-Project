import java.util.Scanner

class UserScreen {

    fun showArchiveList(archiveList: MutableList<Archive>) {
        print("0. Выход\n1. Создать архив \n")
        var i = 2
        for (archive in archiveList) {
            println("${i}. Архив «${archive.name}»")
            i++
        }
    }

    fun showNotesList(notesList: Archive) {
        println("Архив «${notesList.name}»")
        print("0. Назад\n1. Создать заметку \n")
        var i = 2
        for (arhives in notesList.content) {
            println("${i}. Заметка «${arhives.title}»")
            i++
        }
    }

    fun createArchive(): Archive {
        println("Введите название архива")
        var archiveName = Scanner(System.`in`).nextLine()
        while (archiveName.trim() == "") {
            println("Название архива не может быть пустым. Введите название архива")
            archiveName = Scanner(System.`in`).nextLine()
        }
        return Archive(archiveName)
    }

    fun createNote(): Note {
        println("Введите название заметки")
        var title = Scanner(System.`in`).nextLine()
        while (title.trim() == "") {
            println("Название заметки не может быть пустым. Введите название заметки")
            title = Scanner(System.`in`).nextLine()
        }
        println("Введите текст заметки")
        var text = Scanner(System.`in`).nextLine()
        while (text.trim() == "") {
            println("Заметка не может быть пустой. Введите текст заметки")
            text = Scanner(System.`in`).nextLine()
        }
        return Note(title, text)
    }

    fun showNote(note: Note) {
        println("* * * * * * * * * * *")
        println("Заметка «${note.title}»")
        println(note.text)
        println("* * * * * * * * * * *")
        print("Нажмите Enter чтобы продолжить")
        Scanner(System.`in`).nextLine()
    }
}