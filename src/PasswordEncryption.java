import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PasswordEncryption {
    public static String shiftCharacters(String input) {
        // Cek jika panjang password memenuhi syarat
        if (input.length() < 8 || input.length() > 15) {
            return "Invalid password length!";
        }

        // Step 1: Mengubah 5 karakter huruf sesudah
        StringBuilder shiftedInput = new StringBuilder();
        for (char c : input.toCharArray()) {
            // Proses yang mengubah 5 karakter huruf sesudahnya dan menyimpan nilainya ke dalam StringBuilder
            shiftedInput.append((char) ((c - 'A' + 5) % 26 + 'A'));
        }
        System.out.println("Hasil Langkah 1: " + shiftedInput.toString());

        // Step 2: Menukar 3 huruf pertama dan 3 huruf terakhir
        // Membuat antrian untuk menyimpan tiga huruf pertama
        Queue<Character> charQueue = new ArrayDeque<>();
        // Menambahkan tiga huruf pertama ke antrian
        for (int i = 0; i < 3; i++) {
            charQueue.add(shiftedInput.charAt(i));
        }
        // Mengambil karakter selain 3 huruf pertama dan 3 huruf terakhir
        String middle = shiftedInput.substring(3, shiftedInput.length() - 3);
        // Menambahkan tiga huruf terakhir ke antrian
        String lastThree = shiftedInput.substring(shiftedInput.length() - 3);

        StringBuilder shiftedStringBuilder = new StringBuilder();
        shiftedStringBuilder.append(lastThree);
        shiftedStringBuilder.append(middle);
        while (!charQueue.isEmpty()) {
            shiftedStringBuilder.append(charQueue.poll());
        }
        System.out.println("Hasil Langkah 2: " + shiftedStringBuilder.toString());

        // Step 3: Balik urutan seluruh karakter
        // Membuat string baru dengan urutan karakter terbalik
        String reversedString = new StringBuilder(shiftedStringBuilder.toString()).reverse().toString();
        System.out.println("Hasil Langkah 3: " + reversedString);

        return reversedString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String input = scanner.nextLine();
        String output = shiftCharacters(input);
        System.out.println("Input : " + input);
        System.out.println("Output: " + output);
    }
}