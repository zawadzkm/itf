package pl.cloudtechnologie.itf.load;

import java.util.ArrayList;

public class GenerateBidRequestLoad {

    static int WORKERS_NO = 5;
    static  int WORKER_TIME = 10*1000;

    public static void main(String[] args) {
        GenerateBidRequestLoad t = new GenerateBidRequestLoad();
        t.run();
    }

    public void run() {

        long total = 0, start = System.currentTimeMillis();
        ArrayList<BidRequestLoadWorker> workers = new ArrayList<BidRequestLoadWorker>();

        for (int i=0; i<WORKERS_NO ; i++) {
            BidRequestLoadWorker w = new BidRequestLoadWorker(WORKER_TIME);
            workers.add(w);
            w.start();
        }
        for (BidRequestLoadWorker w : workers) {
            try {
                w.join();
                total += w.getMsgs();
                System.out.println(w.getMsgs());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long duration = System.currentTimeMillis()-start;
        float speed = total/(float)duration*1000;
        System.out.println(String.format("%,.1f msg/s", speed));
    }
}
