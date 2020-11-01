package com.nick.junit.helper;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( {StringHelperTest.class, QuickBeforeAfterTest.class} )
public class JUnit5TestSuiteExample {
}
