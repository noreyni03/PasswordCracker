import java.util.List;

public class Principale {

    public static void main(String[] args) {
        // Exemple de mots de passe à tester
        String password1 = "momo";
        String password2 = "cisse";
        String password3 = "1998";

        // Créer des hash MD5 de ces mots de passe
        String hash1 = HashUtils.md5(password1);
        String hash2 = HashUtils.md5(password2);
        String hash3 = HashUtils.md5(password3);

        // Afficher les hash pour vérification
        System.out.println("Hash de momo : " + hash1);
        System.out.println("Hash de cisse : " + hash2);
        System.out.println("Hash de 1998 : " + hash3);

        // Créer une instance de BruteforceLocalCracker et tester
        BruteforceLocalCracker bruteforcer = new BruteforceLocalCracker();
        System.out.println("Test d'attaque par Bruteforce Cracker:");
        bruteforcer.crackPassword(hash1); // Réussit pour des mots courts avec force brute

        // Créer une instance de DictionaryLocalCracker avec un petit dictionnaire
        List<String> dictionary = List.of("hello", "cisse", "world", "password", "1998", "admin", "momo");
        DictionaryLocalCracker dictionaryCracker = new DictionaryLocalCracker(dictionary);
        System.out.println("Test d'attaque par Dictionary Cracker:");
        dictionaryCracker.crackPassword(hash2); // Réussit avec une attaque de dictionnaire
        dictionaryCracker.crackPassword(hash3); // Réussit aussi
    }
}
