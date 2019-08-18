package mvp.model;

import org.junit.Before;
import org.junit.Test;
import ua.test.mvp.model.Game;
import ua.test.mvp.model.MostValuablePlayer;
import ua.test.mvp.service.DataService;
import ua.test.mvp.service.ProcessorService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Dreval Viacheslav on 18.08.2019.
 */

public class MainTest {

    private DataService dataService;
    private ProcessorService processorService;

    @Before
    public void setUp() {
        dataService = new DataService();
        processorService = new ProcessorService();
    }

    @Test
    public void testCsvFileReader() throws URISyntaxException, IOException {
        Path path = Paths.get(this.getClass().getResource("/example/csv").toURI());
        List<Game> games = dataService.readCSVData(path);
        assert games.size() == 2;
    }

    @Test
    public void testCsvBasketballContentReader() throws URISyntaxException, IOException {
        Path path = Paths.get(this.getClass().getResource("/example/csv/basketball.csv").toURI());
        List<Game> games = dataService.readCSVData(path);
        assert games.size() == 1;
        assert games.get(0).getResultRecords().size() == 6;
    }

    @Test
    public void testCsvHandballContentReader() throws URISyntaxException, IOException {
        Path path = Paths.get(this.getClass().getResource("/example/csv/handball.csv").toURI());
        List<Game> games = dataService.readCSVData(path);
        assert games.size() == 1;
        assert games.get(0).getResultRecords().size() == 6;
    }

    @Test
    public void testMVPCalculation() throws URISyntaxException, IOException {
        Path path = Paths.get(this.getClass().getResource("/example/csv").toURI());
        List<Game> games = dataService.readCSVData(path);
        MostValuablePlayer mostValuablePlayer = processorService.calculateMVP(games);
        assert "nick3".equals(mostValuablePlayer.getNickName()) && 54 == mostValuablePlayer.getCalculatedScore();
    }

}
