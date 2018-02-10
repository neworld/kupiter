Kupiter is Kotlin DLS for [Junit5](https://junit.org/junit5/). 
Current API is only for [dynamic tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests).

### Examples

Dynamic test:
```kotlin
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
```
```kotlin
@TestFactory
fun `for`() = testFactory {
    for (i in 1..5) {
        test(i.toString()) {
            assertNotEquals(0, i)
        }
    }
}
```

More examples could be found in [the source](src/test/kotlin/lt/neworld/kupiter/samples)