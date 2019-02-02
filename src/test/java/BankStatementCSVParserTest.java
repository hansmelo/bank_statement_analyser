import com.monsterend.domain.BankTransaction;
import com.monsterend.parser.BankStatementCSVParser;
import com.monsterend.parser.BankStatementParser;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class BankStatementCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "15-04-1987, -27.67, Rewe";

        BankTransaction result = statementParser.parseFrom(line);

        LocalDate date = LocalDate.of(1987, Month.APRIL, 15);
        BankTransaction expected = new BankTransaction(date, -27.67, "Rewe");

        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        assertEquals(expected.getDescription(), result.getDescription());
    }

}
