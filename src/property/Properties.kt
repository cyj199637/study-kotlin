package property

class Person (val name: String, var age: Int) {
    var height = 0
    var weight = 0
        private set

    fun grow(extra: Int) {
        // compiler access directly
        height += extra
    }

    // backing field 없이 다른 field 들을 통해 property 정의
    val isStudent: Boolean
        get() {
            return age < 20
        }
}

// Lambda 이므로 한 번 실행 후, 실행 결과가 foo1 에 저장된다.
val foo1: Int = run {
    println("Calculating the answer...")
    42
}

// foo2 에 대한 getter 이므로 호출될 때마다 연산을 수행한다.
val foo2: Int
    get() {
        println("Calculating the answer...")
        return 42
    }

enum class State {
    ON,
    OFF
}

class StateLogger {
    private var boolState = false

    var state = false
        set(value) {
            println("State has changed: $field -> $value")
            field = value
        }

    var state2: State
        get() = if (boolState) State.ON else State.OFF
        set(value) {
            boolState = value == State.ON
        }
}

fun main() {
    val person = Person("Alice", 14)

    println(person.name)
    person.age = 13
    println(person.age)

    println(person.isStudent)

    // compiler call via accessor
    println(person.height)
    person.grow(160)
    // compiler call via accessor
    println(person.height)

    println(person.weight)
//    person.weight = 50  // compile error

    // How many times the phrase "Calculating the answer..." will be printed?
    println("$foo1 $foo1 $foo2 $foo2")

    val stateLogger = StateLogger()

    stateLogger.state = true
    println(stateLogger.state)

    println(stateLogger.state2)
    stateLogger.state2 = State.OFF
    println(stateLogger.state2)
}