import csv.CsvReader;
import models.EntitiesBuilder;
import models.entities.Entity;
import models.entities.veeva.csv.Businessaccount;
import models.entities.veeva.csv.Personaccount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static models.Logger.log;

public class CsvReaderRunner {

    @Test
    public void runReadCsv() throws Exception {
        CsvReader csvReader = new CsvReader();
        ArrayList<Businessaccount> businessaccounts = csvReader.readCsvToListOfEntities(Businessaccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\businessaccount.csv");
        ArrayList<Personaccount> personaccounts = csvReader.readCsvToListOfEntities(Personaccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\personaccount.csv");

        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(businessaccounts, personaccounts);
        for (Entity businessAccount: businessaccounts) {
            log(businessAccount);
        }
    }
}