package lt.neworld.kupiter.samples

import lt.neworld.kupiter.testFactory
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestFactory

class Simple {
    @TestFactory
    fun tree() = testFactory {
        test("simple") {
            assertTrue(true)
        }

        test("simple2") {
            assertTrue(true)
        }

        container("container") {
            test("deep test") {
                assertTrue(true)
            }

            container("deeper container") {
                test("very deep test") {
                    assertTrue(true)
                }
            }
        }
    }

    @TestFactory
    fun `for`() = testFactory {
        for (i in 1..5) {
            test(i.toString()) {
                assertNotEquals(0, i)
            }
        }
    }

    @TestFactory
    fun iterate() = testFactory {
        ITEMS.forEach { word ->
            container(word) {
                test("not empty") {
                    assertTrue(word.isNotEmpty())
                }
                test("have enough symbols") {
                    assertTrue(word.length > 1)
                }
            }
        }
    }

    companion object {
        val ITEMS = "The quick brown fox jumps over the lazy dog".split(" ")
    }
}
