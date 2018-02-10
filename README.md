[![](https://jitpack.io/v/neworld/kupiter.svg)](https://jitpack.io/#neworld/kupiter)
![](https://img.shields.io/badge/DSL-Junit5-brightgreen.svg)

Kupiter is Kotlin DSL for [Junit5](https://junit.org/junit5/). 
Current API is only for [dynamic tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests).

### Get it

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'lt.neworld:kupiter:v1.0.0'
}
```

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

### License

```
MIT License

Copyright (c) 2018 Andrius Semionovas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```