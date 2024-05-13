import java.io.*;

class _28086{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String answer = "";

        if(input.contains("/")){
            String[] arr = input.split("\\/");
            long number1 = Long.valueOf(arr[0],8);
            long number2 = Long.valueOf(arr[1],8);
            
            if(number2==0){
                System.out.println("invalid");
                System.exit(0);
            }
            
            // 나머지 없는 경우
            if(number1%number2==0){
                answer = Long.toString(number1/number2, 8);
            }
            // 나머지가 있는 경우
            else{
                if((number1>0 && number2>0) || (number1<0 && number2<0)){
                    answer = Long.toString(number1/number2, 8);
                }
                else{
                    answer = Long.toString((number1/number2)-1, 8);
            }
            }
        }
        else if(input.contains("*")){
            String[] arr = input.split("\\*");
            long number1 = Long.valueOf(arr[0],8);
            long number2 = Long.valueOf(arr[1],8);
            answer = Long.toString(number1*number2, 8);
        }
        else if(input.contains("+")){
            String[] arr = input.split("\\+");
            long number1 = Long.valueOf(arr[0],8);
            long number2 = Long.valueOf(arr[1],8);
            answer = Long.toString(number1+number2, 8);
        }
        else if(input.contains("-")){
            String[] arr = input.split("\\-");
            long number1 = 0;
            long number2 = 0;

            // 첫 숫자가 음수면 arr[0]==""
            if(arr[0].equals("")){
                arr[1] = "-"+arr[1];
                number1 = Long.valueOf(arr[1],8);
                number2 = Long.valueOf(arr[2],8);
            }
            else{
                number1 = Long.valueOf(arr[0],8);
                number2 = Long.valueOf(arr[1],8);
            }
            answer = Long.toString(number1-number2, 8);
        }
        else{
            System.out.println("error");
        }
        System.out.println(answer);
    }
}