package pl.cloudtechnologie.itf.load;

import org.apache.flink.api.java.utils.ParameterTool;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateSegmentsLoadGenerator {

    private ParameterTool parameter;
    public static String PROPERTIES_PATH = "itf.properties";

    public static void main(String[] args) {
        try {
            UpdateSegmentsLoadGenerator load = new UpdateSegmentsLoadGenerator();
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
        ArrayList<UpdateSegmentsLoadWorker> workers = new ArrayList<UpdateSegmentsLoadWorker>();

        int workers_no = parameter.getInt("itf.test.updateload.workers_no");
        int workers_time = parameter.getInt("itf.test.updateload.time");

        for (int i=0; i<workers_no; i++) {
            UpdateSegmentsLoadWorker w = new UpdateSegmentsLoadWorker(workers_time);
            workers.add(w);
            w.start();
        }
        for (UpdateSegmentsLoadWorker w : workers) {
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
