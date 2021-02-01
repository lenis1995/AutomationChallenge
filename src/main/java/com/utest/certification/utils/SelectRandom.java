package com.utest.certification.utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.Random;

public class SelectRandom {

    public static int date(Actor actor, Target target) {
        Random rand = new Random();
        List<WebElementFacade> optionsList = target.resolveAllFor(actor);
        int optionsSize= optionsList.size();
        return rand.nextInt(optionsSize);
    }

}


