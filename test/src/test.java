import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String []args){
        Scanner scan=new Scanner(System.in);
        String s1="bcdedf";
        String s2="cfcdedgh";
        List<String>l1=new ArrayList<String>();
        List<String>l2=new ArrayList<String>();

        for(int i=0;i<s1.length();i++){
            for(int j=i+2;j<s1.length()+1;j++){
                String s=s1.substring(i, j);
                l1.add(s);
            }
        }
        for(int i=0;i<s2.length();i++){
            for(int j=i+2;j<s2.length()+1;j++){
                String s=s2.substring(i, j);
                l2.add(s);
            }
        }
        int max=0;
        String tmp=null;
        for(int i=0;i<l2.size();i++){
            if(l1.contains(l2.get(i))){
                if(l2.get(i).length()>max){
                    max=l2.get(i).length();
                    tmp=l2.get(i);
                }
            }
        }
        System.out.println(tmp+":"+max);
    }

}
