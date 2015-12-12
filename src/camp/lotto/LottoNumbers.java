package camp.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * [LottoNumbers example]
 * example for "Java for Android" of "Android Camp", Fast Campus
 * <p>
 * Created by mindwing on 2015-12-13.
 */
public class LottoNumbers {
    private static Random rnd = new Random();
    private Set<Integer> numbers = new HashSet<>();
    private int extraNumber;

    LottoNumbers() {
        rollNumbers();
    }

    public void rollNumbers() {
        Set<Integer> newNumbers = new HashSet<>();
        for (newNumbers.clear(); newNumbers.size() < 6; ) {
            newNumbers.add(rnd.nextInt(45) + 1);
        }

        int newExtra = rnd.nextInt(45) + 1;
        for (; !newNumbers.contains(newExtra); newExtra = rnd.nextInt(45) + 1) ;

        numbers = newNumbers;
        extraNumber = newExtra;
    }

    public String getMatchGrade(LottoNumbers _anotherLotto) {
        String grade = null;
        int matchCount = getMatchCount(_anotherLotto);

        switch (matchCount) {
            case 0:
            case 1:
            case 2:
                grade = "꽝";
                break;

            case 3:
                grade = "5등";
                break;

            case 4:
                grade = "4등";
                break;

            case 5:
                if (_anotherLotto.containsExtra(extraNumber)) {
                    grade = "2등";
                } else {
                    grade = "3등";
                }
                break;

            case 6:
                grade = "1등";
                break;
        }

        return grade;
    }

    private int getMatchCount(LottoNumbers _anotherLotto) {
        int matchCount = 0;

        for (int number : numbers) {
            if (_anotherLotto.containsNumber(number)) {
                matchCount += 1;
            }
        }

        return matchCount;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    public boolean containsExtra(int _extraNumber) {
        return extraNumber == _extraNumber;
    }

    public String toString() {
        return String.format("%s *%s", numbers.toString(), extraNumber);
    }
}
