class Archive(val name: String) {
    var content: MutableList<Note> = ArrayList()
    fun putInArchive(note: Note) {
        content.add(note)
    }

    fun getFromArchive(index: Int): Note {
        return content.get(index)

    }
}
data class Note(val title: String, val text: String)