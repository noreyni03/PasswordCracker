public class BruteforceLocalCracker extends LocalCracker implements PasswordCracker {

    @Override
    public void crackPassword(String hashedPassword) {
        bruteForceCrack(hashedPassword);
    }

    private void bruteForceCrack(String hashedPassword) {
        System.out.println("Cracking password by brute force###");
        int maxLength = 5;

        for (int length = 1; length <= maxLength; length++) {
            bruteForceHelper(hashedPassword, "", length);
        }
    }

    private void bruteForceHelper(String hashedPassword, String attempt, int length) {
        char[] charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        if (length == 0) {
            String hashedAttempt = HashUtils.md5(attempt);
            if (hashedAttempt.equals(hashedPassword)) {
                System.out.println("Password cracked by brute force: " + attempt);
                return;
            }
        } else {
            for (char c : charset) {
                bruteForceHelper(hashedPassword, attempt + c, length - 1);
            }
        }
    }
}
