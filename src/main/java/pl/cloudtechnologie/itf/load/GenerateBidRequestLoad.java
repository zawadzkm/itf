package pl.cloudtechnologie.itf.load;

import org.apache.flink.api.java.utils.ParameterTool;

import java.io.IOException;
import java.util.ArrayList;

public class GenerateBidRequestLoad {

    private ParameterTool parameter;
    public static String PROPERTIES_PATH = "itf.properties";

    public static void main(String[] args) {
        try {
            GenerateBidRequestLoad load = new GenerateBidRequestLoad();
            load.getProperties();
            load.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getProperties() throws IOException {
        parameter = ParameterTool.fromPropertiesFile(PROPERTIES_PATH);
        System.out.println(parameter.toMap().toString());
    }

    public void run() throws IOException {

        long total = 0, start = System.currentTimeMillis();
        ArrayList<BidRequestLoadWorker> workers = new ArrayList<BidRequestLoadWorker>();

        int workers_no = parameter.getInt("itf.test.requestload.workers_no");
        int workers_time = parameter.getInt("itf.test.requestload.time");

        for (int i=0; i<workers_no; i++) {
            BidRequestLoadWorker w = new BidRequestLoadWorker(workers_time);
            workers.add(w);
            w.start();
        }
        for (BidRequestLoadWorker w : workers) {
            try {
                w.join();
                total += w.getMessages();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long duration = System.currentTimeMillis()-start;
        float speed = total/(float)duration*1000;
        System.out.println(String.format("%,.1f msg/s", speed));
    }
}
