package top.pancras.剑指offer;

/**
 * Created by pancras on 2018/4/27 0027.
 *
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
 *
 */
public class Test04 {
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(" ".getBytes()[0]);
        System.out.print(switchStr("We are happy"));
        System.out.println();
        char[] chars = str.toCharArray();
        System.out.println(chars[2]);
        System.out.println(change(chars));
    }

    private static String switchStr(String str) {
        return str.replace(" ", "%20");
    }

    private static String change(char[] charArray) {
        int n=charArray.length;

        int count=0;
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]==' '){
                count++;
            }
        }
        if(count==0){
            return null;
        }
        char[] temp=new char[n+2*count];

        int j=n+2*count-1;
        int i=n-1;
        while(i>=0){
            if(charArray[i]==' '){
                temp[j]='0';
                temp[j-1]='2';
                temp[j-2]='%';
                j=j-3;

            }else{
                temp[j]=charArray[i];
                j--;
            }
            i--;
        }

        return new String(temp);

    }
}
