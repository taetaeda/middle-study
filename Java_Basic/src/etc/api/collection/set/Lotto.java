package etc.api.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Lotto {
    static Random r = new Random();

    static int prize1 = 0; // 1등 당첨 횟수를 세는 변수
    static int prize2 = 0; // 2등 당첨 횟수를 세는 변수
    static int prize3 = 0; // 3등 당첨 횟수를 세는 변수
    static int prize4 = 0; // 4등 당첨 횟수를 세는 변수
    static int prize5 = 0; // 5등 당첨 횟수를 세는 변수
    static int failCnt = 0; // 꽝 횟수를 세는 변수
    static int ticketCount = 0; // 구매한 로또 티켓 수를 세는 변수

    public static Set<Integer> createLotto() {
        Set<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            int randomNumber = r.nextInt(45) + 1;
            lottoNumbers.add(randomNumber);
        }
        return lottoNumbers;
    }
    //List로 선언할 경우
//    List<Integer> lotto = new ArrayList<>();
//    while(lotto.size() < 6) {
//    	int num = r.nextInt(45) + 1;
//    	if(lotto.contains(num)) {
//    		lotto.add(num);
//    	}
//    }
//    return lotto;
    
    //
//    Set<Integer> lotto = new HashSet<>();
//    while(lotto.size() < 6) {
//    	int num = r.nextInt(45) + 1;
//    	if(lotto.contains(num)) {
//    		lotto.add(num);
//    	}
//    }
//    return lotto; 이 다음에 public stati Set<Integer> createLotto까지

    public static int createBonusNum(Set<Integer> winningNumbers) {
        while (true) {
            int bonusNumber = r.nextInt(45) + 1;
            if (!winningNumbers.contains(bonusNumber)) { //만약에 보너스넘버 포함되어있지 않아? 리턴해줘
                return bonusNumber;
            }
        }
    }

    public static int checkLottoNumber(Set<Integer> winningNumbers, Set<Integer> myNumbers, int bonusNumber) {
        int matchedNumbers = 0;
        for (int myNumber : myNumbers) {
            if (winningNumbers.contains(myNumber)) {
                matchedNumbers++;
            }
        }

        if (matchedNumbers == 6) {
            return 1;
        } else if (matchedNumbers == 5 && myNumbers.contains(bonusNumber)) {
            return 2;
        } else if (matchedNumbers == 5) {
            return 3;
        } else if (matchedNumbers == 4) {
            return 4;
        } else if (matchedNumbers == 3) {
            return 5;
        } else {
            return 0; // 꽝
        }
    }

    public static void main(String[] args) {
        Set<Integer> winningNumbers = createLotto();
        System.out.println("당첨 번호: " + winningNumbers);

        int bonusNumber = createBonusNum(winningNumbers); // 보너스 번호 고정
        System.out.println("보너스 번호: " + bonusNumber);

        long totalSpent = 0; // 누적 구매 금액 늘어나게 해주는

        while (true) {
            Set<Integer> myNumbers = createLotto();
            ticketCount++;
            totalSpent += 1000;

            int result = checkLottoNumber(winningNumbers, myNumbers, bonusNumber);
            if (result == 1) {
                prize1++;
                System.out.println("1등 당첨!");
                System.out.println("누적 1등 당첨 횟수: " + prize1);
                System.out.println("누적 2등 당첨 횟수: " + prize2);
                System.out.println("누적 3등 당첨 횟수: " + prize3);
                System.out.println("누적 4등 당첨 횟수: " + prize4);
                System.out.println("누적 5등 당첨 횟수: " + prize5);
                System.out.println("누적 꽝 횟수: " + failCnt);
                System.out.println("누적 구매 금액: " + totalSpent + "원");
                System.out.println("누적 구매한 로또 티켓 수: " + ticketCount + "장");
                break;
            } else if (result == 2) {
                prize2++;
            } else if (result == 3) {
                prize3++;
            } else if (result == 4) {
                prize4++;
            } else if (result == 5) {
                prize5++;
            } else {
                failCnt++;
            }
        }
    }
}
