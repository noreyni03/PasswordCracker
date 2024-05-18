import java.math.BigInteger;
import java.security.MessageDigest;

public class HashUtils {

    public static String md5(String input) {
        try {
            // Créer un objet MessageDigest pour l'algorithme MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Calculer le hash du message
            byte[] messageDigest = md.digest(input.getBytes());
            // Convertir le tableau de bytes en représentation hexadécimale
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            // Ajouter des zéros initiaux pour garantir une longueur de 32 caractères
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
