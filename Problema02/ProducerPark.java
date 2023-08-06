public class ProducerPark extends Thread {

    int index;
    Buffer bufferController;

    public ProducerPark(Buffer bufferController, int i) {
        this.index = i;
        this.bufferController = bufferController;
    }
    
    public void run() {
        try {
            while(true) {
                sleep(2000);
                System.out.println("Parque " + (index+1) + " esta aberto!");
                bufferController.putPark(index);
            }
        } catch(Exception e) {}
    }
}
