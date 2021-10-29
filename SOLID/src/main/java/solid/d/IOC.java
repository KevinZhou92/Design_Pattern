package solid.d;

import java.util.ArrayList;
import java.util.List;

// Bad Example
class UserServiceTest {
    public boolean doTest() {
        return true;
    }

    public void main(String[] args) {
        // This part can be put into a framework
        if (doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }
}

// Good Example
// No need to manually execute the test case, just extend base class TestCase
// Implement doTest() method, and register testcase, everything else is controlled
// by framework
abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    public abstract boolean doTest();
}

class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

    public static void main(String[] args) {
        for (TestCase tc : testCases){
            tc.run();
        }
    }
}
