public class ConsumerClass extends Thread {

    int index;
    Buffer bufferController;

    public ConsumerClass(Buffer bufferController, int i) {
        this.index = i;
        this.bufferController = bufferController;
    }
    
    public void run() {
        try {
            while(true){
                sleep(2500);
                int park = bufferController.getPark();
                System.out.println("Turma " + (index+1) + " visitou o parque " + (park+1) +" !");

            }
        }catch(Exception e) {}
    }
}