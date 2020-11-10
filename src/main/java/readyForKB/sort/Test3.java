package readyForKB.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * created by victory_woo on 2020/11/10
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 5, 1}));
    }

    /*
     * 첫 번째 접근 방법.
     * */

    /*public static int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            int count = citations[i];

            if (i <= count && count <= len - i) hIndex = i;
        }
        return hIndex + 1;
    }*/

    /*public static int solution(int[] citations) {
        Arrays.sort(citations);

        int len = citations.length;
        int hIndex = 0;
        for (int i = 0; i < len; i++) {
            int citation = citations[i];
            int lCnt = 0, rCnt = 0;

            for (int j = 0; j <= i; j++) {
                if (citations[j] <= citation) lCnt++;
            }

            for (int j = i; j < len; j++) {
                if (citation <= citations[j]) rCnt++;
            }

            if (lCnt <= citation && citation <= rCnt) hIndex = citation;
        }
        return hIndex;
    }*/

    /*
     * 접근 방법.
     * 정렬 문제이긴 하지만, 정렬하지 않아도 된다.
     * citations 배열 자체가 논문의 인용 횟수를 담은 배열이다.
     * 인용 횟수의 max 값을 찾는다.
     * [3,0,6,1,5] 에서는 6이 max.
     * 그렇다면 최대 6번까지 인용 횟수가 있다는 것이다.
     * 따라서 0번부터 6번까지 i번 이상 인용된 논문이 i편 이상이고 나머지 논문이 i편 이하 인용되었다면
     * h 인덱스는 i가 된다.
     * */
    public static int solution(int[] citations) {
        int hIndex = 0;

        int max = Arrays.stream(citations).max().getAsInt();
        for (int i = 0; i <= max; i++) {
            int upCount = 0, downCount = 0;

            for (int citation : citations) {
                if (i <= citation) upCount++;
                else downCount++;
            }

            System.out.println(i + "번 이상 인용된 논문은 " + upCount + "편이고, " + i + "번 이하 인용된 논문" + downCount + "편입니다.");

            if (i <= upCount && downCount <= i) hIndex = i;
        }

        return hIndex;
    }
}
