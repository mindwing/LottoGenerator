package camp.lotto;

/**
 * Created by mindwing on 2015-12-13.
 */
public class Main {
    public static void main(String[] args) {
        LottoNumbers thisWeekLotto = new LottoNumbers();
        LottoNumbers myLotto = new LottoNumbers();

        System.out.println(thisWeekLotto);
        System.out.println(myLotto);
        System.out.println(myLotto.getMatchGrade(thisWeekLotto));
    }
}
