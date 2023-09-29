package lecture.week4;

public class SafeArrayTest {
    public static void main(String[] args) {
        SafeArray array = new SafeArray(4);

//        for(int i=0; i<(array.length); i++){
        for(int i=0; i<(array.length+1); i++){
            // index가 배열의 길이 이상인 경우 종료
            if(i>= array.length){
                break;
            }
            array.put(i,i*10);
        }
        for(int j=0;j<array.length;j++) {
            System.out.printf("array.get(%d)= %d\n", j, array.get(j));
        }
        System.out.printf("index length=%d",array.length);
    }
}
