@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var num = n
    val list = mutableListOf<Int>()
    var i = 1
    while (num > 1) {
        i += 1
        while (num % i == 0) {
            list.add(i)
            num /= i
        }
    }
    return list
}

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String =
    factorize(n).joinToString(separator = "*")

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var num = n
    val list = mutableListOf<Int>()
    while (num > 0) {
        val digit = num % base
        list.add(digit)
        num /= base
    }
    return list.reversed()
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var number = 0
    for (i in digits) {
        number = number * base + i
    }
    return number
}

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var num = n
    val russian = mutableListOf<String>()
    if (num % 100 in 10..19) {
        when (num % 100) {
            10 -> russian.add(0, "десять")
            11 -> russian.add(0, "одиннадцать")
            12 -> russian.add(0, "двенадцать")
            13 -> russian.add(0, "тринадцать")
            14 -> russian.add(0, "четырнадцать")
            15 -> russian.add(0, "пятнадцать")
            16 -> russian.add(0, "шестнадцать")
            17 -> russian.add(0, "семнадцать")
            18 -> russian.add(0, "восемнадцать")
            else -> russian.add(0, "девятнадцать")
        }
        num /= 100
    } else {
        when (num % 10) {
            1 -> russian.add(0, "один")
            2 -> russian.add(0, "два")
            3 -> russian.add(0, "три")
            4 -> russian.add(0, "четыре")
            5 -> russian.add(0, "пять")
            6 -> russian.add(0, "шесть")
            7 -> russian.add(0, "семь")
            8 -> russian.add(0, "восемь")
            9 -> russian.add(0, "девять")
        }
        if (num == 0) return "ноль"
        num /= 10
        when (num % 10) {
            2 -> russian.add(0, "двадцать")
            3 -> russian.add(0, "тридцать")
            4 -> russian.add(0, "сорок")
            5 -> russian.add(0, "пятьдесят")
            6 -> russian.add(0, "шестьдесят")
            7 -> russian.add(0, "семьдесят")
            8 -> russian.add(0, "восемьдесят")
            9 -> russian.add(0, "девяносто")
        }
        num /= 10
    }
    when (num % 10) {
        1 -> russian.add(0, "сто")
        2 -> russian.add(0, "двести")
        3 -> russian.add(0, "триста")
        4 -> russian.add(0, "четыреста")
        5 -> russian.add(0, "пятьсот")
        6 -> russian.add(0, "шестьсот")
        7 -> russian.add(0, "семьсот")
        8 -> russian.add(0, "восемьсот")
        9 -> russian.add(0, "девятьсот")
    }
    num /= 10
    if (num == 0) return russian.joinToString(separator = " ")
    if (num % 100 in 10..19) {
        when (num % 100) {
            10 -> russian.add(0, "десять тысяч")
            11 -> russian.add(0, "одиннадцать тысяч")
            12 -> russian.add(0, "двенадцать тысяч")
            13 -> russian.add(0, "тринадцать тысяч")
            14 -> russian.add(0, "четырнадцать тысяч")
            15 -> russian.add(0, "пятнадцать тысяч")
            16 -> russian.add(0, "шестнадцать тысяч")
            17 -> russian.add(0, "семнадцать тысяч")
            18 -> russian.add(0, "восемнадцать тысяч")
            else -> russian.add(0, "девятнадцать тысяч")
        }
        num /= 100
        if (num == 0) return russian.joinToString(separator = " ")
    } else {
        when (num % 10) {
            0 -> russian.add(0, "тысяч")
            1 -> russian.add(0, "одна тысяча")
            2 -> russian.add(0, "две тысячи")
            3 -> russian.add(0, "три тысячи")
            4 -> russian.add(0, "четыре тысячи")
            5 -> russian.add(0, "пять тысяч")
            6 -> russian.add(0, "шесть тысяч")
            7 -> russian.add(0, "семь тысяч")
            8 -> russian.add(0, "восемь тысяч")
            else -> russian.add(0, "девять тысяч")
        }
        num /= 10
        if (num == 0) return russian.joinToString(separator = " ")
        when (num % 10) {
            2 -> russian.add(0, "двадцать")
            3 -> russian.add(0, "тридцать")
            4 -> russian.add(0, "сорок")
            5 -> russian.add(0, "пятьдесят")
            6 -> russian.add(0, "шестьдесят")
            7 -> russian.add(0, "семьдесят")
            8 -> russian.add(0, "восемьдесят")
            9 -> russian.add(0, "девяносто")
        }
        num /= 10
    }
    if (num == 0) return russian.joinToString(separator = " ")
    when (num % 10) {
        1 -> russian.add(0, "сто")
        2 -> russian.add(0, "двести")
        3 -> russian.add(0, "триста")
        4 -> russian.add(0, "четыреста")
        5 -> russian.add(0, "пятьсот")
        6 -> russian.add(0, "шестьсот")
        7 -> russian.add(0, "семьсот")
        8 -> russian.add(0, "восемьсот")
        else -> russian.add(0, "девятьсот")
    }
    return russian.joinToString(separator = " ")
}
