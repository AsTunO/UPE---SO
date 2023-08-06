import java.util.ArrayList;

public class Buffer {

    int classesNumber;
    int parkState = 0;

    ArrayList<Integer> parks = new ArrayList<Integer>();

    public Buffer(int classesNumber) {
        this.classesNumber = classesNumber;
    }

    public void putPark(int park) {
        if(parkState < classesNumber){
            parks.add(park);
            synchronized(parks) {
                try {
                    parks.notify();
                } catch (Exception e) {}
            }
        }else {
            this.parkState = 0;
            synchronized(parks) {
                try {
                    parks.wait();
                } catch (Exception e) {}
            }
        }
    }

    public int getPark() {

        int valor = -1;

        if(this.parkState == 0) {
            this.parkState += 1;
            synchronized(parks) {
                try {
                    parks.wait();
                } catch (Exception e) {}
            }
        }else {
            if(parks.size() == 1) {
                valor = parks.remove(0);
                synchronized(parks) {
                    try {
                        parks.notify();
                    
                    } catch (Exception e) {}
                }
            }else {
                valor = parks.remove(0);
            }
        }
        return valor;
    }
}