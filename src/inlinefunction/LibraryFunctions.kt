package inlinefunction

fun main() {
    val foo = run {
        println("run is inline function.")
        "foo"
    }

    val email = getEmail()
    if (email != null) {
        println(email)
    }

    email?.let { println(it) }
    getEmail()?.let { println(it) }
    getEmail()?.let { email -> sendEmail(email) }

    if (email is String) {
        println(email)
    }

    "aeweogjal;kjg;oaiejg;lj".takeIf { it.length > 20 }
        ?.let { println(it) }
    "aeweogjal;kjg;oaiejg;lj".takeUnless { it.length > 20 }
        ?.let { println(it) }

    repeat(10) {
        print("$it\t")
    }
}

fun getEmail(): String? = null
fun sendEmail(email: String) {
    println("Start sending to $email")
}

interface Session { val user: User }
interface User { val nickname: String }
class FacebookUser(val accountId: Int, override val nickname: String) : User

fun analyzeUserSession(session: Session) {
    // 1. 명시적 타입 체크 (is)
    // 인터페이스에 정의된 프로퍼티의 경우, open or custom getter 이슈로 smart cast가 되지 않아서 3번처럼 사용해야 함.
//    if (session.user is FacebookUser) {
//        println(session.user.accountId)
//    }

    // 2. 인터페이스 프로퍼티 타입 체크를 위한 변수 할당
    val user = session.user
    if (user is FacebookUser) {
        println(user.accountId)
    }

    // 3. let을 사용한 변수 할당 없는 인터페이스 프로퍼티 타입 체크
    (session.user as? FacebookUser)?.let{ println(it.accountId) }
}