public class AdapterPattern {

    // Target interface
    interface Target {
        // This is the method clients will use.
        void request();
    }

    // Adaptee class
    static class Adaptee {
        // This method needs to be adapted.
        public void specificRequest() {
            System.out.println("Called specificRequest in Adaptee");
        }
    }

    // Adapter class
    static class Adapter implements Target {
        private Adaptee adaptee;

        // Constructor takes an Adaptee object.
        public Adapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            // The adapter translates the request to the specific request.
            adaptee.specificRequest();
        }
    }

    // The main method is where the program starts.
    public static void main(String[] args) {
        // Create an Adaptee instance.
        Adaptee adaptee = new Adaptee();
        // Create an Adapter instance with the Adaptee.
        Target target = new Adapter(adaptee);
        // Call the request method on the adapter.
        target.request();
    }
}

