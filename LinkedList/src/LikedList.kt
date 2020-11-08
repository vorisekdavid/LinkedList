class LinkedList<E>(
    private val value: E,
    private val next: LinkedList<E>?
) : List<E> {
    override val size: Int
        get() {
            val nextSize: Int? = next?.size
            return 1 + (next?.size ?: 0)
        }

    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")

    }

    override fun get(index: Int): E {
        return when (index) {
            0 -> value
            else -> if (next == null) throw ArrayIndexOutOfBoundsException()
            else next[index - 1]
        }

    }

    override fun indexOf(element: E): Int {
        TODO("Not yet implemented")

    }

    override fun lastIndexOf(element: E): Int {
        TODO("Not yet implemented")
    }
}
