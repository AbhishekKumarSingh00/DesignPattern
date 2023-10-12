package observerDesignPattern;

import observerDesignPattern.observable.IphoneObservable;
import observerDesignPattern.observable.StockObservable;
import observerDesignPattern.observer.EmailAlertObserver;
import observerDesignPattern.observer.NotificationAlertObserver;
import observerDesignPattern.observer.SmsAlertObserver;

 /*
 * Implement when we have observable many observers are observing
 *
 * Example: "Notify me" button whenever a product goes out of stock from Amazon.in
 */


public class Store {

    public static void main(String args[]) {

        StockObservable iphoneStockObservable = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailAlertObserver("abc@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserver("xyz@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new SmsAlertObserver("1111111", iphoneStockObservable);

        //adding subscriber;
        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
    }

}
