package Models;

public class TextAnimation {
    public static void PrintAnimated(String text, long miliseconds) {
        if (miliseconds < 0) return;
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
    public static void PrintAnimated(String text){
        PrintAnimated(text, 20);
    }
}
