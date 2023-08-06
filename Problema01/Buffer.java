package Problema01;

import java.util.ArrayList;

public class Buffer {

    final int MAX_SIZE = 20;
    ArrayList<Long> generatedPasswords = new ArrayList<Long>();

    public void put(Long newPassword) {
        if(generatedPasswords.size() < MAX_SIZE) {
            generatedPasswords.add(newPassword);
            try{
                synchronized(generatedPasswords) {
                    generatedPasswords.notify();
                }
            }catch(Exception e) {}
        }else {
            synchronized(generatedPasswords) {
                try{
                    generatedPasswords.wait();
                }catch(Exception e) {}
            }
        }
    }

    public Long getValue() {
        Long value = null;

        if(generatedPasswords.size() == 0) {
            synchronized(generatedPasswords) {
                try{
                    generatedPasswords.wait();
                }catch(Exception e) {}
            }
        }else {
            if(generatedPasswords.size() == MAX_SIZE) {

                value = generatedPasswords.remove(0);

                synchronized(generatedPasswords) {
                    try{
                        generatedPasswords.notify();
                    }catch(Exception e) {}
                }
            }else {
                value = generatedPasswords.remove(0);
            }
        }
        return value;
    }
    
}
