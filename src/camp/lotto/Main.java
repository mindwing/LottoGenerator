package camp.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mindwing on 2015-12-13.
 */
public class Main {
    public static void main(String[] args) {
        LottoNumbers thisWeekLotto = new LottoNumbers();
        int[] gradeList = new int[6];

        for (int i = 0; i < 100000; i = i + 1) {
            LottoNumbers myLotto = new LottoNumbers();

//        System.out.println(thisWeekLotto);
//        System.out.println(myLotto);

            int grade = myLotto.getMatchGrade(thisWeekLotto);

            gradeList[grade]++;

            if (grade > 0 && grade <= 3) {
                System.out.printf("%d번째: %d등\n", i, grade);
            }
        }

        System.out.printf("\n1등: %d\n2등: %d\n3등: %d\n4등: %d\n5등: %d",
                gradeList[1], gradeList[2], gradeList[3], gradeList[4], gradeList[5]);
    }
}
