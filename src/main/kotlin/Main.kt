import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.SupervisorJob

// Главная функция приложения. Она запускает корутины для часов различной длительности и звука
suspend fun main() {
    coroutineScope() {
        // Запуск корутины для часов "tick" с длительностью 5 секунд
        launch {
            clock(5, "tick")
        }
        // Запуск корутины для часов "tack" с длительностью 7 секунд
        launch {
            clock(7, "tack")
        }
        // Запуск корутины для часов "tuck" с длительностью 10 секунд
        launch {
            clock(10, "tuck")
        }
    }
}

// Функция, представляющая часы с звуком, которая работает внутри корутины
suspend fun clock(seconds: Int, sound: String) {
    // Цикл для эмуляции течения времени в течение указанного количества секунд
    for (i in 0 until seconds - 1) {
        // Приостановка выполнения на 1000 миллисекунд (1 секунда)
        delay(1000L)
        // Вывод звука и текущего момента времени в терминал
        println("$sound (${i + 1})\t")
    }
    // Дополнительная задержка на 1 секунду после завершения основного цикла
    delay(1000)
    // Вывод сообщения о "взрыве" после истечения указанного времени
    println("$sound ($seconds) = BOOM")
}
