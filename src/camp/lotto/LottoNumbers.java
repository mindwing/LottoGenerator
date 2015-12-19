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

    public int getMatchGrade(LottoNumbers _anotherLotto) {
        int grade = 0;
        int matchCount = getMatchCount(_anotherLotto);

        if (matchCount == 3) {
            grade = 5;
        } else if (matchCount == 4) {
            grade = 4;
        } else if (matchCount == 5) {
            if (_anotherLotto.containsExtra(extraNumber)) {
                grade = 2;
            } else {
                grade = 3;
            }
        } else if (matchCount == 6) {
            grade = 1;
        }

        return grade;
    }

    private int getMatchCount(LottoNumbers _anotherLotto) {
        int matchCount = 0;

        for (int number : numbers) {
            if (_anotherLotto.containsNumber(number)) {
                matchCount = matchCount + 1;
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
        return numbers.toString() + " *" + extraNumber;
    }
}
