package observerDesignPattern.observer;

import observerDesignPattern.observable.StockObservable;

public class SmsAlertObserver implements NotificationAlertObserver{

    String mobileNumber;
    StockObservable observable;

    //Constructor Injection
    public SmsAlertObserver(String mobileNumber, StockObservable observable) {
        this.observable = observable;
        this.mobileNumber = mobileNumber;
    }
    @Override
    public void update() {
        sendEmail(mobileNumber, "Product is in stock");
    }

    private void sendEmail(String mobileNumber, String msg) {
        //sent email code
        System.out.println("sms sent to mobile no : " + mobileNumber);
    }
}
