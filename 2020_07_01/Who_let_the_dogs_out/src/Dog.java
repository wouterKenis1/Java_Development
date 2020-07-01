public class Dog {
    private static void bark(){
        System.out.println("woof woof!");
    }
    private static  void beg(){
        System.out.println("awoooooo!");
    }
    private static void chase(){
        System.out.println("GRRRRRR!");
    }

    public static void react(String command){
        switch(command.toLowerCase()) {
            case "speak":
                bark();
                break;
            case "beg":
                beg();
                break;
            case "look, the postman!":
                chase();
        }
    }
}
