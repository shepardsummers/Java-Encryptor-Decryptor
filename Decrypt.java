import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Decrypter by Shepard Summers
 * Input message to be decrypted [00001111, 00001111, 00001111] (should be seperated by a comma and a space)
 * Then input encryption key used to encrypt
 * 
 * Designed to be used with corresponding encryptor
 * 
 */

public class Decrypt {
    public static void main(String[] args) throws Exception {

        
        Scanner sc3 = new Scanner(System.in);
        System.out.print("Enter message to be decrypted: ");
        String msg = sc3.nextLine();

        String[] newMsg = msg.split(", ");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an 8 digit binary key: ");
        String key = sc.nextLine();
        char[] keyNew = key.toCharArray();

        ArrayList<String> decryptMsg = new ArrayList<String>();

        for (int i = 0; i < newMsg.length; i++) {
            
            char[] binaryFin = {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
            char[] temp = newMsg[i].toCharArray();

            for (int e = 0; e < 8; e++) {

                if (temp[e] == keyNew[e]) {
                    binaryFin[e] = '1';
                } else if (temp[e] != keyNew[e]) {
                    binaryFin[e] = '0';
                }
                else {
                    System.out.println("AHHHHHHHH");
                }
            }

            String binTemp = new String(binaryFin);

            decryptMsg.add(binTemp);

        }

        //System.out.println(decryptMsg);

        File binList = new File("Bin.txt");

        char[] finMsg = new char[msg.length()];

        for (int e = 0; e < decryptMsg.size(); e++) {
            
            String ch = decryptMsg.get(e);

            Scanner sc2 = new Scanner(binList); 

            while (sc2.hasNextLine()) {

                String line = sc2.nextLine();

                String[] lineSplit = line.split(" ");

                if (line.equals("  00100000")) {
                    if (ch.equals("00100000")){
                        finMsg[e] = ' ';
                    }
                }

                String half = lineSplit[1];

                char[] lineArray = line.toCharArray();

                if (lineSplit[1].equals(ch)) {
                    
                    char temp = lineArray[0];

                    finMsg[e] = temp;

                    break;
                }
            }
        }
        System.out.println("-------------------------------------");
        System.out.println(finMsg);
        System.out.println("-------------------------------------");
    }
}
