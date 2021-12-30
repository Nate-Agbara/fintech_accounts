package com.fintech.accounts;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * @author: Nathan
 */
@Suite
@SelectClasses({DataStoreSystemsHealthTest.class, AccountsApplicationTests.class, RepositoryTest.class})
public class ContinousIntegrationTestSuite {

    //Intentionally empty - Test suite annotations set up is enough
}
