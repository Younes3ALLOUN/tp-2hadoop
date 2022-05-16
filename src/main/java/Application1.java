import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) throws IOException {


            for (int i=0;i<3;i++) {
                Configuration cf = new Configuration();
                System.setProperty("HADOOP_USER_NAME", "root");
                cf.set("fs.defaultFS", "hdfs://localhost:9000");
                cf.set("dfs.replication", "1");
                FileSystem fs = FileSystem.get(cf);
                System.out.println("contenu du fichier CoursCPP" + (i + 1));
                Path path = new Path("/BDCC/CPP/Cours/CoursCPP" + (i + 1));
                FSDataInputStream fsis = fs.open(path);

                // preparation du lecteur sequentiel :
                InputStreamReader isr = new InputStreamReader(fsis);
                BufferedReader br = new BufferedReader(isr);

                String ligne = br.readLine();
                while (ligne!=null){
                    System.out.println(ligne);
                    ligne= br.readLine();
                }
            fsis.close();

            }
    }
}