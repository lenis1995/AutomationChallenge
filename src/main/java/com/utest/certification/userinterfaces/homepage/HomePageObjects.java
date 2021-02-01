package com.utest.certification.userinterfaces.homepage;

import net.serenitybdd.screenplay.targets.Target;

public class HomePageObjects {

   public static final Target JOIN_TODAY_BUTTON = Target.the("Join Today Button").locatedBy("//*[@class='nav navbar-nav']/following-sibling::ul/li[2]");
}
