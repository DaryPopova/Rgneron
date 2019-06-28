package parquet;

import org.junit.jupiter.api.Test;

/*
run python process for running python script that convert csv to parquet
 */
public class ConvertToParquetRunner {
    ProcessBuilder builder = new ProcessBuilder("/usr/bin/python3.6",
            "-u",
            "/home/alex/IdeaProjects/Rgn-master/src/main/java/parquet/csv_to_parquet_util_job.py",
            "/home/alex/IdeaProjects/Rgn-master/src/main");
    @Test
    public void run() throws Exception {
        if (builder.inheritIO().start().waitFor() != 0) {
            throw new Exception();
        }
    }

}
