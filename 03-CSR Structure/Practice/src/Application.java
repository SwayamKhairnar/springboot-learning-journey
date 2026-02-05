public class Application {
    public static void main(String[] args) {

        services service = new services();     // created
        Coltroller controller = new Coltroller(service); // injected

        controller.print();
    }
}
