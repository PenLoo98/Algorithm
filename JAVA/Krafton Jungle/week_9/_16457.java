import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _16457 {
    static int n, m, k, max = 0;
    static int[] quest; // 각 퀘스트가 가진 스킬
    static int usedSkills; // 모든 퀘스트에서 1번이상 사용된 스킬

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 키의 개수
        m = Integer.parseInt(st.nextToken()); // 퀘스트의 개수
        k = Integer.parseInt(st.nextToken()); // 퀘스트당 스킬의 개수

        quest = new int[m]; // 각 퀘스트가 가진 스킬
        usedSkills = 0; // 모든 퀘스트에서 1번이상 사용된 스킬

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int skill = Integer.parseInt(st.nextToken());
                quest[i] |= (1 << (skill - 1));
                usedSkills |= (1 << (skill - 1));
            }
        }

        // System.out.println("quest: " + Arrays.toString(quest));
        // System.out.println("usedSkills: " + Integer.toBinaryString(usedSkills));

        // 인덱스0, key=0부터 시작해 n개의 스킬을 뽑는다.
        getMaxClearQuest(0,0,n); 

        System.out.println(max);
    }

    // 재귀적으로 n개의 스킬을 뽑아 클리어할 수 최대 퀘스트 수를 구한다.
    static void getMaxClearQuest(int idx, int key, int cnt) {
        // System.out.println("solve(" + idx + "," + key + "," + cnt + ")");
        if (cnt == 0) {
            int clear = 0;
            for (int i = 0; i < m; i++) {
                if ((quest[i] & key) == quest[i]) {
                    clear++;
                }
            }
            max = Math.max(max, clear);
            return;
        }

        for (int i = idx; i < 2 * n; i++) {
            getMaxClearQuest(i + 1, key | (1 << i), cnt - 1);
        }
    }
}