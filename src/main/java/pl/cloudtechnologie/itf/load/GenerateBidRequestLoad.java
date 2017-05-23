package pl.cloudtechnologie.itf.load;

import java.util.ArrayList;

public class GenerateBidRequestLoad {

    static int WORKERS_NO = 10;
    static  int WORKER_MESSAGES = 100000;

    public static void main(String[] args) {
        GenerateBidRequestLoad t = new GenerateBidRequestLoad();
        t.run();
    }

    public void run() {

        long t1 = System.currentTimeMillis();
        ArrayList<BidRequestLoadWorker> bidRequestLoadWorkers = new ArrayList<BidRequestLoadWorker>();

        for (int i=0; i<WORKERS_NO ; i++) {
            BidRequestLoadWorker w = new BidRequestLoadWorker(WORKER_MESSAGES);
            bidRequestLoadWorkers.add(w);
            w.start();
        }
        for (BidRequestLoadWorker w : bidRequestLoadWorkers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(WORKERS_NO*WORKER_MESSAGES+" messages processed in "+(System.currentTimeMillis()-t1)+" miliseconds");
        long t2 = System.currentTimeMillis()-t1;
        long msgs = WORKERS_NO*WORKER_MESSAGES;
        float speed = msgs/(float)t2*1000;

        System.out.println(String.format("%,.1f msg/s", speed));
    }
}
