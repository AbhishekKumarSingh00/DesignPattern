package observerDesignPattern.observer;

import observerDesignPattern.observable.StockObservable;

public class EmailAlertObserver implements NotificationAlertObserver{

    String emailId;
    StockObservable observable;

    //Constructor Injection
    public EmailAlertObserver(String emailId, StockObservable observable) {
        this.observable = observable;
        this.emailId = emailId;
    }
    @Override
    public void update() {
        sendEmail(emailId, "Product is in stock");
    }

    private void sendEmail(String emailId, String msg) {
        //sent email code
        System.out.println("mail sent to : " + emailId);
    }
}
