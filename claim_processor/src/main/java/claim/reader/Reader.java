package claim.reader;

import claim.entity.Claim;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Claim> read(String path) throws IOException;
}
