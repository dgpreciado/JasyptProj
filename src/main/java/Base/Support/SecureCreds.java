package Base.Support;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.jasypt.util.digest.*;
import org.jasypt.util.password.*;
import org.jasypt.util.password.rfc2307.RFC2307MD5PasswordEncryptor;
import org.jasypt.util.password.rfc2307.RFC2307SHAPasswordEncryptor;
import org.jasypt.util.password.rfc2307.RFC2307SMD5PasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class SecureCreds {
    public static void main(String[] args) {

/*        // plain text encrypt > https://www.youtube.com/watch?v=AgrHibiiF94
        AES256TextEncryptor aes256TextEncryptor = new AES256TextEncryptor();
        //BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

        //StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
        String secretKey = "Password123";

        aes256TextEncryptor.setPassword(secretKey);
        String message = "This is important message";
        String encryptedMessage =  aes256TextEncryptor.encrypt(message);

        System.out.println(encryptedMessage);

        //to decrypt
        String plainText = aes256TextEncryptor.decrypt(encryptedMessage);
        System.out.println(plainText);
*/

        /*Password encrytp - https://www.youtube.com/watch?v=H2yGaZL0ch0 */
        RFC2307MD5PasswordEncryptor rfc2307MD5PasswordEncryptor = new RFC2307MD5PasswordEncryptor();
        /* Uses MD5 password encryption scheme defined in RFC2307 */

        RFC2307SHAPasswordEncryptor rfc2307SHAPasswordEncryptor = new RFC2307SHAPasswordEncryptor();
        /* Uses SHA-1 password encryption scheme defined in RFC2307 */

        RFC2307SMD5PasswordEncryptor rfc2307SMD5PasswordEncryptor = new RFC2307SMD5PasswordEncryptor();
        /* Uses SMD5 password encryption scheme defined in RFC2307 */

        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword(System.getenv("Dennis"));
        standardPBEStringEncryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        standardPBEStringEncryptor.setIvGenerator(new RandomIvGenerator());
        String man_pass = "hello Darling!";
        String man_enc = standardPBEStringEncryptor.encrypt(man_pass);
        System.out.println("encrypted "+ man_enc);
        System.out.println("decrypted "+ standardPBEStringEncryptor.decrypt(man_enc));

        /*password */
        AES256TextEncryptor aes256TextEncryptor = new AES256TextEncryptor();
        aes256TextEncryptor.setPassword(System.getenv("dennis"));

//        System.out.println(aes256TextEncryptor.encrypt("appleseed"));


        /*Environmental variables*/
        System.out.println(System.getenv("Dennis"));
        System.out.println(System.getenv("Dennis1"));

        Properties prop = new Properties();
        try {

            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "./src/main/resources/config.properties");/*path to file**/
            prop.load(ip);
        }catch (IOException e){
            e.printStackTrace();
        }
        String pass = prop.getProperty("datasource.password");
        System.out.println(pass);
        String decrypt = aes256TextEncryptor.decrypt(pass);
        System.out.println(decrypt);
/*        //MD5
        String password1 = "Password123";
        String encryptedPassword_md5 = rfc2307MD5PasswordEncryptor.encryptPassword(password1);
        System.out.println(encryptedPassword_md5);
        boolean passwordMatch_md5 = rfc2307MD5PasswordEncryptor.checkPassword(password1, encryptedPassword_md5);
        System.out.println("MD5: does "+password1+" = "+encryptedPassword_md5+" and the answer is "+passwordMatch_md5);

        //SHA1
        String encryptPassword_sha1 = rfc2307SHAPasswordEncryptor.encryptPassword(password1);
        System.out.println(encryptPassword_sha1);
        boolean passwordMatch_sha1 = rfc2307SHAPasswordEncryptor.checkPassword(password1, encryptPassword_sha1);
        System.out.println("SHA1: does "+password1+" = "+encryptPassword_sha1+" and the answer is "+passwordMatch_md5);

        //SMD5
        rfc2307SMD5PasswordEncryptor.setSaltSizeBytes(8);
        String encryptPassword_smd5 = rfc2307SMD5PasswordEncryptor.encryptPassword(password1);
        System.out.println(encryptPassword_smd5);
        boolean passwordMatch_smd5 = rfc2307SMD5PasswordEncryptor.checkPassword(password1, encryptPassword_smd5);
        System.out.println("SMD5: does "+password1+" = "+encryptPassword_smd5+" and the answer is "+passwordMatch_smd5);
*/

//        Boolean passwordMatch = rfc2307SMD5PasswordEncryptor.checkPassword("password123", "{SMD5}Qik2yX3MEFFTOSkdan9vUPalmpz5onUT");
//        System.out.println(passwordMatch);
//
//        Boolean passwordMatch2 = rfc2307SMD5PasswordEncryptor.checkPassword("password123", "{SMD5}84O2fSB3h488Ohq3DIpRqm1GIFI64taE");
//        System.out.println(passwordMatch2);
//
//        Boolean passwordMatch3 = rfc2307SMD5PasswordEncryptor.checkPassword("password123", "{SMD5}n/zYoePRpH+SyCSiU6dUdGaUpxpjY55j");
//        System.out.println(passwordMatch3);
    }
}
