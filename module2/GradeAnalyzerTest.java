import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 
import java.util.ArrayList; 
import java.util.Arrays; 
 
public class GradeAnalyzerTest { 
 
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() { 
        ArrayList<Integer> scores = new ArrayList<>(); 
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100)); 
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }
 
    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75)); 
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    } 
 
    @Test
    void calculateAverage_returnsDouble_notInteger() { 
        // 1 + 2 = 3, divided by 2 = 1.5, not 1
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2)); 
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test 
    void calculateAverage_handlesAllSameValues() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88)); 
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores)); 
    }

    @Test
    void calculateAverage_withTenScores_returnsExactAverage() {
    ArrayList<Integer> scores = new ArrayList<>();

    scores.add(70);
    scores.add(75);
    scores.add(80);
    scores.add(85);
    scores.add(90);
    scores.add(95);
    scores.add(60);
    scores.add(65);
    scores.add(100);
    scores.add(80);

    double average = GradeAnalyzer.calculateAverage(scores);

    assertEquals(80.0, average);
    }
}