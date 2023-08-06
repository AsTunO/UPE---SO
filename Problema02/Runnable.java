public class Runnable {
    public static void main(String[] args) {

        final int PARKS_NUMBER = 5;
        final int CLASSES_NUMBER = 10;

        Buffer bufferController = new Buffer(CLASSES_NUMBER);
        
        for(int i = 0; i < PARKS_NUMBER; i++) { new ProducerPark(bufferController, i).start(); }
        for(int i = 0; i < CLASSES_NUMBER; i++) { new ConsumerClass(bufferController, i).start(); }
    }
}