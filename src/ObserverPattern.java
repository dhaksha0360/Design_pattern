import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    // Observer interface
    interface Observer {
        // This method is called to update the observer with a message.
        void update(String message);
    }

    // Subject interface
    interface Subject {
        // Method to add an observer.
        void addObserver(Observer observer);
        // Method to remove an observer.
        void removeObserver(Observer observer);
        // Method to notify all observers.
        void notifyObservers();
    }

    // ConcreteSubject class
    static class ConcreteSubject implements Subject {
        // A list to hold all the observers.
        private List<Observer> observers = new ArrayList<>();
        private String message;

        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

        // This method sets a new message and notifies all observers.
        public void setMessage(String message) {
            this.message = message;
            notifyObservers();
        }
    }

    // ConcreteObserver class
    static class ConcreteObserver implements Observer {
        private String name;

        public ConcreteObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " received message: " + message);
        }
    }

    // The main method is where the program starts.
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // Adding observers to the subject.
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Setting a new message, which notifies all observers.
        subject.setMessage("Hello Observers!");
    }
}
