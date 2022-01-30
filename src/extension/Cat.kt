package extension

class Cat : Animal {
    private var name: String = ""

    constructor(name: String) {
        this.name = name
    }

    fun getName(): String = name
}