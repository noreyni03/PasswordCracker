import java.util.HashSet;
import java.util.List;

public class DictionaryLocalCracker extends LocalCracker implements PasswordCracker {

    private List<String> dictionary;

    public DictionaryLocalCracker(List<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    @Override
    public void crackPassword(String hashedPassword) {
        dictionaryAttack(hashedPassword);
    }

    private void dictionaryAttack(String hashedPassword) {
        if (dictionary == null) {
            System.out.println("Default dictionary is not set.");
            return;
        }

        dictionaryAttack(hashedPassword, dictionary);
    }

    private void dictionaryAttack(String hashedPassword, List<String> customDictionary) {
        System.out.println("Cracking password using dictionary###");

        HashSet<String> hashedDictionary = new HashSet<>();
        for (String word : customDictionary) {
            hashedDictionary.add(HashUtils.md5(word));
        }

        for (String hashedWord : hashedDictionary) {
            if (hashedWord.equals(hashedPassword)) {
                System.out.println("Password cracked using dictionary: " + hashedWord);
                return;
            }
        }

        System.out.println("Password not found in dictionary.");
    }
}
