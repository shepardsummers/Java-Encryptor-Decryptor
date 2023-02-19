import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Encrypter by Shepard Summers
 * Input message to be encryptend
 * Then input encryption key
 * 
 * Outputs in the form of: [00001111, 00001111, 00001111]
 * 
 * Designed to be used with the corresponding decryptor
 * 
 */

public class Encrypt{

    public static void main(String[] args) throws Exception {

        Scanner sc3 = new Scanner(System.in);
        System.out.print("Enter message to be encrypted: ");
        String msg = sc3.nextLine();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an 8 digit binary key: ");
        String key = sc.nextLine();

        File binList = new File("Bin.txt");

        char[] msgNew = msg.toCharArray();

        ArrayList<String> binMsg = new ArrayList<String>();

        for (int e = 0; e < msg.length(); e++) {

            char i = msgNew[e];

            Scanner sc2 = new Scanner(binList); 

            while (sc2.hasNextLine()) {

                String line = sc2.nextLine();
                char[] lineArray = line.toCharArray();

                if (lineArray[0] == i) {
                    String temp = "";
                    for (int g = 0; g < line.length(); g++) {
                        if (g > 1) {
                            temp = temp + lineArray[g];
                        }
                    }
                    binMsg.add(temp);
                    break;
                }
            }
        }

        char[] keyNew = key.toCharArray();

        ArrayList<String> encryptMsg = new ArrayList<String>();

        for (int i = 0; i < msg.length(); i++) {
            
            char[] binaryFin = {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
            char[] temp = binMsg.get(i).toCharArray();

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

            encryptMsg.add(binTemp);

        }        

        System.out.println("-------------------------------------");
        System.out.println(encryptMsg);
        System.out.println("-------------------------------------");
    }

}