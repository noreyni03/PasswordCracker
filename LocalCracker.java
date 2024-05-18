public abstract class LocalCracker extends PasswordCrackerFactory {
    @Override
    public PasswordCracker createPasswordCracker() {
        return (PasswordCracker) this;
    }
}
