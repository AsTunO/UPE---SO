package Problema01;

public class TPasswordGenerator extends Thread {
    
    private Buffer generatedPasswords;
    private Long startIndex;
    private Long endIndex;

    public TPasswordGenerator(Buffer generatedPasswords, int threadIndex, int passwordLength, int THREADS) {

        this.generatedPasswords = generatedPasswords;
        long max = (long) Math.pow(10, passwordLength) - 1;
        long intervalSize = (long) Math.ceil((double) (max + 1) / THREADS);
        this.startIndex = threadIndex * intervalSize;
        this.endIndex = Math.min(max, (threadIndex + 1) * intervalSize - 1);
    }

    public void run() {
        for(Long i = this.startIndex; i <= this.endIndex; i++){
            try{
                generatedPasswords.put(i);
            }catch(Exception e) {}
        }
    }

    public Buffer getGeneratedPasswords() {
        return this.generatedPasswords;
    }

    public void setGeneratedPasswords(Buffer generatedPasswords) {
        this.generatedPasswords = generatedPasswords;
    }

    public Long getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }

    public Long getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(Long endIndex) {
        this.endIndex = endIndex;
    }
}