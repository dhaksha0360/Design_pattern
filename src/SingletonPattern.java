public class SingletonPattern {

    // Singleton class
    static class Singleton {
        // This static variable holds the single instance of the Singleton class.
        private static Singleton instance;

        // The constructor is private, so no one else can create an instance.
        private Singleton() {}

        // This method provides the single instance of the class.
        // If the instance doesn't exist yet, it creates it.
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        // A simple method to demonstrate the functionality of the Singleton.
        public void showMessage() {
            System.out.println("Hello from the Singleton!");
        }
    }

    // The main method is where the program starts.
    public static void main(String[] args) {
        // Get the single instance of the Singleton class.
        Singleton singleton = Singleton.getInstance();
        // Call the showMessage method to see the output.
        singleton.showMessage();
    }
}
