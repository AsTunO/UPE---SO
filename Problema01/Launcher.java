package Problema01;

public class Launcher {
    public static void main(String[] args) {
        final Long PASSWORD = 123456789L;
        final int THREADS = 10;

        Buffer generatedPasswords = new Buffer();

        for(int x = 0; x < THREADS; x++) {
            new TPasswordGenerator(generatedPasswords, x, 10, THREADS).start();
            new TPasswordChecker(generatedPasswords, PASSWORD).start();
        } 
    }
}