import java.util.*;
import java.io.*;

public class _9017{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            // 입력받고 
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] rank = new int[n+1]; // 선수들의 팀 번호와 들어온 순서
            for(int j=1; j<=n; j++){
                rank[j] = Integer.parseInt(st.nextToken());
            }

            HashMap<Integer, ArrayList<Integer>> teams = new HashMap<>();
            // 일단 팀 번호에 해당하는 인원수를 파악하기 위해 인덱스 값을 팀 멤버로 넣는다.
            for(int j=1; j<=n; j++){
                int teamNumber = rank[j];
                if(teams.containsKey(teamNumber)){
                    teams.get(teamNumber).add(j);
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    teams.put(teamNumber, temp);
                }
            }
            // 사이즈가 6인 팀만 남긴다. + 6인팀은 총점 계산
            int entryTeamSize = teams.keySet().size(); // 참가 팀 수
            HashMap<Integer, Integer> teamScores = new HashMap<>();
            ArrayList<Integer> _6memberTeamNumbers = new ArrayList<>(); // 6인 팀들의 번호
            for(int j=1; j<=entryTeamSize; j++){
                // 6인팀이 아닌 경우 삭제
                if(teams.get(j).size()!=6){
                    teams.remove(j);
                }
                // 6인팀인 경우 팀 번호 저장
                else if (teams.get(j).size()==6){
                    _6memberTeamNumbers.add(j);
                }
            }

            // 6인 팀 각 팀의 점수 다시 계산 
            teams = new HashMap<>();
            int realRank = 0;
            for(int j=1; j<=n; j++){
                int teamNumber = rank[j];

                // 6인 팀이 아닌 경우
                if(!_6memberTeamNumbers.contains(teamNumber)){
                    continue;
                }

                realRank++;

                if(teams.containsKey(teamNumber)){
                    teams.get(teamNumber).add(realRank);
                }
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(realRank);
                    teams.put(teamNumber, temp);
                }
            }

            // 6인 팀 각 팀의 점수 계산
            for(int key: teams.keySet()){
                int top4Score = 0;
                for(int j=0; j<4; j++){
                    top4Score += teams.get(key).get(j);
                }
                teamScores.put(key, top4Score);
            }

            // 6인 팀에서 최소 점수합을 찾는다. + 최소 점수합이 같은 팀이 있는지 확인한다.
            int minScore = Integer.MAX_VALUE; // 최소 점수합
            int _5thScore = Integer.MAX_VALUE; // 당시 최소 점수합 팀의 5등 점수
            int winner = 0; // 최소 점수합 팀의 번호
            for(int key: teamScores.keySet()){
                // 해당 팀의 점수합
                int currentScore = teamScores.get(key);

                // 5등 점수를 찾는다.
                int current_5th = teams.get(key).get(4); // 현재 팀의 5등의 점수

                // 최소 점수합과 minScore와 비교 
                    // minScore가 더 작으면 넘어감
                    if(minScore<currentScore){
                        continue;
                    }
                    // minScore가 같으면 5thScore와 비교
                    else if(minScore==currentScore){
                        // 5thScore가 더 작으면 minScore를 5thScore로 업데이트
                        if(_5thScore<current_5th){
                            continue;
                        }
                        // 5번째 선수의 점수가 같다면 넘어감
                        else if(_5thScore==current_5th){
                            continue;
                        }
                        // 5번째 선수의 점수가 더 낮다면 winner,_5thScore를 업데이트
                        else if (_5thScore>=current_5th){
                            winner = key;
                            _5thScore = current_5th;
                        }
                    }
                    // minScore보다 더 작으면 minScore, winner, _5thScore 업데이트
                    else if(minScore>currentScore){
                        minScore = currentScore;
                        _5thScore = current_5th;
                        winner = key;
                    }
            }

            // 결과 bw에 저장
            bw.write(winner+"\n");
        }
        // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }
}