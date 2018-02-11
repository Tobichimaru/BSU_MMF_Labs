/*
    Определить, удовлетворяет ли файл маске.
    Маска может содержать символы ? (произвольный символ)
    и не более ондой * (произвольное количество произвольных символов) 
 */
package maskapp;

public class MaskApp { 
        
    public static boolean isCorrect(String str, String mask) {
        if (mask == null || str == null) return false;
        if (mask.length() == 0 || str.length() == 0) return false;
                
        int pos = mask.indexOf('*');
        if (pos == -1) pos = mask.length();
        for (int i = 0; i < pos; i++) {
            if (mask.charAt(i) != '?' && str.charAt(i) != mask.charAt(i)) {
                return false;
            }
        }
            
        int j = str.length();
        for (int i = mask.length() - 1; i > pos; i--) {
            j--;
            if (mask.charAt(i) != '?' && str.charAt(j) != mask.charAt(i)) {
                return false;
            }
        }
            
        return true;
    }

    public static void main(String[] args) {
        String mask = "?or*.d??";
        System.out.println(isCorrect("fort.doc", mask));
        System.out.println(isCorrect("ford.doc", mask));    
        System.out.println(isCorrect("lord2.dir", mask));
        System.out.println(isCorrect("orsk.dat", mask));
        System.out.println(isCorrect("port", mask));
    }
}
