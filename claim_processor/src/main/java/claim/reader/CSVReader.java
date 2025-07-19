package claim.reader;

import claim.entity.Claim;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVReader implements Reader {
    private final char separator;

    public CSVReader(char separator) {
        this.separator = separator;
    }

    @Override
    public List<Claim> read(String path) throws IOException {
       try (var reader = new InputStreamReader(Files.newInputStream(Path.of(path)))) {
           CsvToBean<Claim> csvToBean = new CsvToBeanBuilder<Claim>(reader)
                   .withSeparator(separator)
                   .withThrowExceptions(true)
                   .withType(Claim.class)
                   .withIgnoreLeadingWhiteSpace(true)
                   .build();
           return csvToBean.parse();
       }
    }
}
