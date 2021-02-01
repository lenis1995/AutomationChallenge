package com.utest.certification.tasks;

import com.utest.certification.utils.SelectRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

import static com.utest.certification.userinterfaces.signup.FirstStepElements.DAY_OPTIONS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SetDay implements Task {

    public SetDay(Target target){
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byIndex(SelectRandom.date(actor,DAY_OPTIONS)).from(target)
        );
    }
    public static SetDay as(Target target) {
        return instrumented(SetDay.class,target);
    }

    private final Target target;
}
