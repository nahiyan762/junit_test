package org.example.testWithoutMockito.dummy;

public class DummyEmailService implements EmailService{
    @Override
    public void sendEmail(String message) {
        throw new IllegalArgumentException("Nothing to do, it's dummy!.....");
    }
}
