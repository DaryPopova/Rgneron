import csv.Extractor;
import database.DatabaseReader;
import models.entities.veeva.semarchy.sd.SdOrganization;
import org.junit.Test;
import parquet.ConvertToParquetRunner;

import java.sql.Connection;
import java.util.ArrayList;

public class CheckMappingVeevaBusinessaccount2 {
    @Test
    public void run() throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();
        Connection connection = databaseReader.createConnection("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");

        ArrayList sdOrganizations = databaseReader.readDbTableToListOfEntities(connection, SdOrganization.class, "semarchy_dloc2.sd_organization");
        Extractor extractor = new Extractor();
        extractor.writeEntitiesToCsv(sdOrganizations);
    }
}
