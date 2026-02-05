public class Coltroller {
    private services service;
    Coltroller(services service){
        this.service=service;
    }
    public void print(){
        service.do_something();
    }
//    public static void main(String[] args){
//        Coltroller.print();
//    }

}