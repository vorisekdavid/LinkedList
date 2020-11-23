class LinkedList<E>(
    private val value: E,
    private val next: LinkedList<E>?
) : List<E> {
    override val size: Int
        get() {
            val nextSize: Int? = next?.size
            return 1 + (next?.size ?: 0)
        }

    override fun contains(element: E): Boolean = indexOf(element) >= 0


    override fun get(index: Int): E {
        return when (index) {
            0 -> value
            else -> {
                if (next == null) throw ArrayIndexOutOfBoundsException()
                else next[index - 1]
            }
        }

    }

    override fun indexOf(element: E): Int {
        if (value == element) return 0
        else if (next != null) {
            val index = next.indexOf(element)
            if (index != -1) return index + 1
        }
        return -1
    }

    override fun lastIndexOf(element: E): Int {
        val lastIndexFoundByChildren: Int? = when{
            next != null -> next.lastIndexOf(element)
            else -> -1
        }
        return when (lastIndexFoundByChildren) {
            -1 -> when (element){
                value -> 0
                else -> -1
            }
            else -> lastIndexFoundByChildren + 1
        }
    }
}