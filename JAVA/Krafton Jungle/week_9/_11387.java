import java.util.*;
import java.io.*;

public class _11387 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] weapon = new int[4][5];
        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                weapon[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.print(Arrays.deepToString(weapon));

        // 크리가 파부의 무기를 장착할 때 -> -[크리 무기]+[파부 무기]
        int criChangeAttack = weapon[0][0] - weapon[2][0] + weapon[3][0];
        int criChangeStrength = weapon[0][1] - weapon[2][1] + weapon[3][1];
        int criChangeCritical = weapon[0][2] - weapon[2][2] + weapon[3][2];
        int criChangeCriticalDamage = weapon[0][3] - weapon[2][3] + weapon[3][3];
        int criChangeAttackSpeed = weapon[0][4] - weapon[2][4] + weapon[3][4];

        // 파부가 크리의 무기를 장착할 때 -> -[파부 무기]+[크리 무기]
        int fabooChangeAttack = weapon[1][0] - weapon[3][0] + weapon[2][0];
        int fabooChangeStrength = weapon[1][1] - weapon[3][1] + weapon[2][1];
        int fabooChangeCritical = weapon[1][2] - weapon[3][2] + weapon[2][2];
        int fabooChangeCriticalDamage = weapon[1][3] - weapon[3][3] + weapon[2][3];
        int fabooChangeAttackSpeed = weapon[1][4] - weapon[3][4] + weapon[2][4];

        // 상황별 전투력 계산
        double originCri = calculateCombatPower(weapon[0][0], weapon[0][1], weapon[0][2], weapon[0][3], weapon[0][4]);
        double changeCri = calculateCombatPower(criChangeAttack, criChangeStrength, criChangeCritical, criChangeCriticalDamage, criChangeAttackSpeed);
        double originFaboo = calculateCombatPower(weapon[1][0], weapon[1][1], weapon[1][2], weapon[1][3], weapon[1][4]);
        double changeFaboo = calculateCombatPower(fabooChangeAttack, fabooChangeStrength, fabooChangeCritical, fabooChangeCriticalDamage, fabooChangeAttackSpeed);
        
        // 변경된 전투력이 더 높다면 +, 낮다면 -, 같다면 0 출력
        printResult(originCri, changeCri);
        printResult(originFaboo, changeFaboo);
    }

    static double calculateCombatPower(int attack, int strength, int critical, int criticalDamage, int attackSpeed) {
        double critRate = Math.min(critical / 100.0, 1);
        double critEffect = critRate * criticalDamage / 100.0;
        double speedBonus = attackSpeed / 100.0;
    
        return attack * (1 + strength / 100.0) * ((1 - critRate) + critEffect) * (1 + speedBonus);
    }    

    static void printResult(double origin, double change){
        if(origin > change){
            System.out.println("-");
        }
        else if(origin < change){
            System.out.println("+");
        }
        else{
            System.out.println("0");
        }
    }
}