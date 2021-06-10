package utils;

import cucumber.api.Result;
import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestStepFinished;
import io.qameta.allure.Allure;
import steps.Hook;

import java.io.ByteArrayInputStream;

public class CustomCucumberAfterStepListener implements ConcurrentEventListener {
    private EventHandler<TestStepFinished> testStepFinish= new EventHandler<TestStepFinished>() {
        @Override
        public void receive(TestStepFinished testStepFinished) {
            if((testStepFinished.result.getStatus()!= Result.Type.PASSED) && (testStepFinished.result.getStatus()!=Result.Type.SKIPPED))
            {
                Allure.addAttachment("screenshot","image/png",new ByteArrayInputStream(new Hook().saveScreenshot()),"png");
            }
        }
    };
    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class, testStepFinish);
    }
}
