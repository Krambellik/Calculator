//Create by Yaroslav Denisov for Kata Academy
import java.util.TreeMap;
public class Converter {
    TreeMap<Character, Integer> roman = new TreeMap<>();
    TreeMap<Integer, String> arabian = new TreeMap<>();
    public Converter() {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        arabian.put(1000, "M");
        arabian.put(900, "CM");
        arabian.put(500, "D");
        arabian.put(400, "CD");
        arabian.put(100, "C");
        arabian.put(90, "XC");
        arabian.put(50, "L");
        arabian.put(40, "XL");
        arabian.put(10, "X");
        arabian.put(9, "IX");
        arabian.put(5, "V");
        arabian.put(4, "IV");
        arabian.put(1, "I");
    }
    public boolean roman(String number){ return roman.containsKey(number.charAt(0)); }
    public String arabToRoman(int num) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabian.floorKey(num);
            roman = roman + arabian.get(arabianKey);
            num = num - arabianKey;
        } while (num != 0);
        return roman;
    }
    public int romanToArab(String input) {
        int end = input.length() - 1;
        char[] arr = input.toCharArray();
        int arabian;
        int result = roman.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = roman.get(arr[i]);
            if (arabian < roman.get(arr[i + 1])) {
                result = result - arabian;
            } else {
                result = result + arabian;
            }
        }
        return result;
    }
}