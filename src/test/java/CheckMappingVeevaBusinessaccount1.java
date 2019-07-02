import csv.Extractor;
import database.DatabaseReader;
import models.entities.veeva.semarchy.sd.SdOrganization;
import org.junit.Test;
import parquet.ConvertToParquetRunner;

import java.sql.Connection;
import java.util.ArrayList;

public class CheckMappingVeevaBusinessaccount1 {
    @Test
    public void run() throws Exception {
        ConvertToParquetRunner runner = new ConvertToParquetRunner();
        runner.runPython("/home/alex/IdeaProjects/Rgn-master/src/main/java/parquet/csv_to_parquet_util_job.py",
                "/home/alex/IdeaProjects/Rgn-master/src/main");
    }
}
