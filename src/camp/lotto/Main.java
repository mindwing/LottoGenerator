package camp.lotto;

/**
 * Created by mindwing on 2015-12-13.
 */
public class Main {
    public static void main(String[] args) {
        LottoNumbers thisWeekLotto = new LottoNumbers();

        for (int i = 0; i < 1000; i = i + 1) {
            LottoNumbers myLotto = new LottoNumbers();

//        System.out.println(thisWeekLotto);
//        System.out.println(myLotto);

            String grade = myLotto.getMatchGrade(thisWeekLotto);
            if (!"꽝".equals(grade)) {
                System.out.println(i + "번째: " + myLotto.getMatchGrade(thisWeekLotto));
            }
        }
    }
}
