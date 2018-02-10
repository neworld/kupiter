package lt.neworld.kupiter

import org.junit.jupiter.api.DynamicContainer
import org.junit.jupiter.api.DynamicNode
import org.junit.jupiter.api.DynamicTest

fun testFactory(tests: DynamicTestHelper.() -> Unit): List<DynamicNode> {
    val helper = DynamicTestHelper()
    helper.tests()
    return helper.tests
}

class DynamicTestHelper internal constructor() {
    private val _tests = mutableListOf<DynamicNode>()

    internal val tests: List<DynamicNode>
        get() = _tests

    fun test(name: String, test: () -> Unit) {
        _tests += DynamicTest.dynamicTest(name, test)
    }

    fun container(name: String, tests: DynamicTestHelper.() -> Unit) {
        val helper = DynamicTestHelper()
        helper.tests()
        _tests += DynamicContainer.dynamicContainer(name, helper._tests)
    }
}