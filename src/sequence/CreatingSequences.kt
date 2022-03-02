package sequence

import kotlin.random.Random

fun main() {
    // 1. 조건을 만족하는 인수들로만 무한 sequence 생성
    //    람다 블록의 결과로 null 이 반환되는 경우, sequence 생성 종료
    val seq1 = generateSequence {
        Random.nextInt(10).takeIf { it > 3 }
    }
    println(seq1.toList())

    // 2. seed 값을 첫 원소로 하고, 주어진 연산으로 seed 값을 바꿔가며 무한 sequence 생성
    val seq2 = generateSequence(1) { it * 2 }
    println(seq2.take(10).toList())

    // 3. yield 로 커스텀한 sequence 생성
    val seq3 = sequence {
        var start = 0
        while (true) {
            yield(start++)
        }
    }
    println(seq3.take(10).toList())

    val seq4 = sequence {
        yield(1)
        yieldAll(7..10)
        yieldAll(listOf(15, 16, 21, 22, 23))
    }
    println(seq4.filter { it % 2 == 0 }.toList())
}