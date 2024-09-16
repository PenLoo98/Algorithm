import java.io.*;

public class _20125 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 판의 크기 
        char[][] board = new char[n][n]; // 판

        for(int i=0; i<n; i++){
            board[i] = br.readLine().toCharArray();
        }

        // System.out.println(Arrays.deepToString(board));

        int leftArmLength = 0;
        int rightArmLength = 0;
        int leftLegLength = 0;
        int rightLegLength = 0;
        int bodyLength = 0;
        boolean isHeadFind = false;
        int headX = 0;
        int headY = 0;
        int heartX = 0;
        int heartY = 0;
        int bodyX = 0; // 몸통의 끝
        int bodyY = 0; // 몸통의 끝

        // 왼팔, 오른팔, 왼다리, 오른다리, 몸통의 개수를 센다.
        // i가 행(y), j가 열(x)
        // 머리를 찾는다.
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 맨 처음 만나는 *은 머리
                if(!isHeadFind && board[i][j]=='*'){
                    isHeadFind = true;
                    headY = i;
                    headX = j;
                    // 심장의 위치 출력 (x,y)
                    bw.write((i+2) + " " + (j+1) + "\n");
                    break;
                }
            }
        }

        // 왼팔의 길이
        heartX = headX;
        heartY = headY+1;
        while(true){
            if(heartX>0 && board[heartY][heartX-1]=='*'){
                leftArmLength++;
                heartX--;
            }
            else{
                break;
            }
        }
        // 오른팔의 길이
        heartX = headX;
        while(true){
            if(heartX<n-1 && board[heartY][heartX+1]=='*'){
                rightArmLength++;
                heartX++;
            }
            else{
                break;
            }
        }
        // 몸통의 길이
        heartX = headX;
        while(true){
            if(board[heartY+1][heartX]=='*'){
                bodyLength++;
                heartY++;
            }
            else{
                // 몸통의 끝이면
                bodyY = heartY;
                bodyX = heartX;
                break;
            }
        }
        // 왼다리의 길이
        int leftLegY = bodyY+1;
        int leftLegX = bodyX-1;
        while(true){
            if(leftLegY<n && board[leftLegY][leftLegX]=='*'){
                leftLegLength++;
                leftLegY++;
            }
            else{
                break;
            }
        }
        // 오른다리의 길이
        int rightLegX = bodyX+1;
        int rightLegY = bodyY+1;
        while(true){
            if(rightLegY<n && board[rightLegY][rightLegX]=='*'){
                rightLegLength++;
                rightLegY++;
            }
            else{
                break;
            }
        }
        // 결과 출력
        bw.write(leftArmLength + " " + rightArmLength + " " + bodyLength + " " + leftLegLength + " " + rightLegLength + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}