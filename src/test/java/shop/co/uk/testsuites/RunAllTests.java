package shop.co.uk.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shop.co.uk.service.ShoppingCartServiceTests;
import shop.co.uk.web.ShopRestControllerTest;

/**
 * This is a suite, which runs all tests
 * @author abidrehman
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ShopRestControllerTest.class, ShoppingCartServiceTests.class })
public class RunAllTests {

}
