package parquet;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ConvertToParquetRunner {
    ProcessBuilder builder = new ProcessBuilder("C:\\Python33\\python.exe",
            "-u",
            "home/alex/IdeaProjects/Rgn-master/src/main/java/parquet/csv_to_parquet_util_job.py",
            "--arg1",
            "argumentValue");
    @Test
    public void run() throws IOException {
        builder.start();
    }
}
