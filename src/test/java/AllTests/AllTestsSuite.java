package AllTests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.ListTest;
import util.SetTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ListTest.class, SetTest.class})
public class AllTestsSuite {
}
