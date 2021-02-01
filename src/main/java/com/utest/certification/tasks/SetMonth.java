package com.utest.certification.tasks;

import com.utest.certification.utils.SelectRandom;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import static com.utest.certification.userinterfaces.signup.FirstStepElements.MONTH_OPTIONS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SetMonth implements Task {

    public SetMonth(Target target){
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byIndex(SelectRandom.date(actor,MONTH_OPTIONS)).from(target)
        );
    }
    public static SetMonth as(Target target) {
        return instrumented(SetMonth.class,target);
    }

    private final Target target;
}
