fun <T> swap(arr: Array<T>, from: Int, to: Int): Array<T> {
    val aux = arr[from]
    arr[from] = arr[to]
    arr[to] = aux
    return arr
}

// Heap's algorithm generates all possible permutations of n objects. 
// https://en.wikipedia.org/wiki/Heap%27s_algorithm
fun <T> heaps(k: Int, a: Array<T>, block: (Array<T>) -> Unit) {
    var arr = a
    if (k == 1) {
        block(arr)
    } else {
        for (i in 0 until k) {
            heaps(k - 1, arr, block)
            when {
                k % 2 == 0 -> {
                    arr = swap(arr, i, k - 1)
                }
                else -> {
                    arr = swap(arr, 0, k - 1)
                }
            }
        }
    }
}

fun main() {
    var elements = arrayOf(1,2,3,4)
    heaps(4, elements) {
        println(it.joinToString())
    }
}
