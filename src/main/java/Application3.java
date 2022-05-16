import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;


public class Application3 {
    public static void main(String[] args) {
        System.setProperty("HADOOP_USER_NAME","root");
        Configuration cf=new Configuration();
        cf.set("fs.defaultFS","hdfs://localhost:9000");
        cf.set("dfs.replication","1");
        try {
            for (int i=1;i<=3;i++) {
                FileSystem fs = FileSystem.get(cf);
                Path path1 = new Path("/BDCC/CPP/Cours/CoursCPP"+i);
                Path path2 = new Path("CoursCPP"+i);
                fs.copyToLocalFile(path1,path2);
                Path path3 = new Path("CoursCPP"+i);
                Path path4 = new Path("/BDCC/JAVA/Cours");
                fs.copyFromLocalFile(path3,path4);
                fs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}