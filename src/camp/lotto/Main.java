package camp.lotto;

/**
 * Created by mindwing on 2015-12-13.
 */
public class Main {
    LottoNumbers thisWeekLotto = new LottoNumbers();
    int[] gradeList = new int[6];

    public static void main(String[] args) {
        Main main = new Main();
        main.go();
    }

    void go() {
        long startTime = System.currentTimeMillis();

        LottoRunner lottoRunner1 = new LottoRunner(1, 200000);
        LottoRunner lottoRunner2 = new LottoRunner(200001, 400000);
        LottoRunner lottoRunner3 = new LottoRunner(400001, 600000);
        LottoRunner lottoRunner4 = new LottoRunner(600001, 800000);
        LottoRunner lottoRunner5 = new LottoRunner(800001, 1000000);

        Thread thread1 = new Thread(lottoRunner1);
        Thread thread2 = new Thread(lottoRunner2);
        Thread thread3 = new Thread(lottoRunner3);
        Thread thread4 = new Thread(lottoRunner4);
        Thread thread5 = new Thread(lottoRunner5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("\n1등: %d\n2등: %d\n3등: %d\n4등: %d\n5등: %d",
                gradeList[1], gradeList[2], gradeList[3], gradeList[4], gradeList[5]);


        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.printf("\n\n *** 총 소요시간: %d밀리초\n", elapsedTime);
    }

    class LottoRunner implements Runnable {
        int start, end;

        LottoRunner(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i = i + 1) {
                LottoNumbers myLotto = new LottoNumbers();

                int grade = myLotto.getMatchGrade(thisWeekLotto);

                gradeList[grade]++;

                if (grade > 0 && grade <= 3) {
                    System.out.printf("%d번째: %d등\n", i, grade);
                }
            }
        }
    }
}
