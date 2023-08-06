package Problema01;

public class TPasswordChecker extends Thread {
    
    private Buffer generatedPasswords;
    private Long PASSWORD;

    public TPasswordChecker(Buffer generatedPasswords, Long PASSWORD) {
        this.generatedPasswords = generatedPasswords;
        this.PASSWORD = PASSWORD;
    } 

    public void run() {
            Long passwordGenerated = generatedPasswords.getValue();
            if(passwordGenerated == PASSWORD) {
                System.out.println("Senha encontrada : " + passwordGenerated);
            }
        }
}
