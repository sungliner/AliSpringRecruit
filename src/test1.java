import java.util.*;

public class test1
{
    //回溯学习
    public static void dfs(String pre, String s, List<String> list, int index){
            if (index==s.length()){
                list.add(pre);
            }else {
                char ch=s.charAt(index);
                if (!Character.isLetter(ch)){
                    dfs(pre+ch,s,list,index+1);
                }else {
                    ch=Character.toLowerCase(ch);
                    dfs(pre+ch,s,list,index+1);

                    ch=Character.toUpperCase(ch);
                    dfs(pre+ch,s,list,index+1);

                }

            }
    }
    /*public static void main(String[] args) {
            List list=new ArrayList();
            int[] arr=new int[10];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<10;i++){
            arr[i]=scanner.nextInt();
        }
            dfsPuke(arr,0,0,list);
        System.out.println(list.get(0));
    }*/

    /*
    阿里巴巴校园招聘在线笔试3.20场
    有一叠扑克牌，每张牌介于1和10之间
    有四种出牌方法：
    单出1张
    出2张对子
    出五张顺子，如12345
    出三连对子，如112233
    给10个数，表示1-10每种牌有几张，问最少要多少次能出完
     */
    public static void dfsPuke(int[] arr,int step,int index,List<Integer> list){
           if (arr[0]==0&&arr[1]==0&&arr[2]==0&&arr[3]==0&&arr[4]==0&&arr[5]==0
                   &&arr[6]==0&&arr[7]==0&&arr[8]==0&&arr[9]==0){
               list.add(step);
               return;
           }
           if (arr[index]>=2&&arr[index+1]>=2&&arr[index+2]>=2&&index<=8){
               step+=1;
               arr[index]=arr[index]-2;
               arr[index+1]=arr[index+1]-2;
               arr[index+2]=arr[index+2]-2;
               if (arr[index]==0)
                   index++;
               dfsPuke(arr, step, index,list);
        }
           if (arr[index]>=1&&arr[index+1]>=1&&arr[index+2]>=1
                   &&arr[index+3]>=1&&arr[index+4]>=1&&index<=6){
               step+=1;
               arr[index]=arr[index]-1;
               arr[index+1]=arr[index+1]-1;
               arr[index+2]=arr[index+2]-1;
               arr[index+3]=arr[index+3]-1;
               arr[index+4]=arr[index+4]-1;
               if (arr[index]==0){
                   index++;
               }
               dfsPuke(arr, step, index,list);
           }
           if (arr[index]>=2){
               step+=1;
               arr[index]=arr[index]-2;
               if (arr[index]==0){
                   index++;
               }
               dfsPuke(arr, step, index,list);
           }
           if (arr[index]>=1){
               step+=1;
               arr[index]=arr[index]-1;
               if (arr[index]==0){
                   index++;
               }
               dfsPuke(arr, step, index,list);
           }
           if (index<10)
           {    index++;
                dfsPuke(arr, step, index,list);}
    }
    /*
    首先定义上升字符串，对于任意的0<i<len(s)0<i<len(s)0<i<len(s)，s[i]≥s[i−1],比如aaa，abc是，acbd不是
    给n个上升字符串，选择任意个拼起来，问能拼出来的最长上升字符串长度
    * */
    public  static int Getmaxlen(List<String> str){
        Collections.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(o1.length()-1)>(o2.charAt(o2.length()-1))){
                    return 1;
                }
                if(o1.charAt(o1.length()-1)==(o2.charAt(o2.length()-1))){
                    if (o1.charAt(0)>o2.charAt(0)){
                        return 1;
                    }else if (o1.charAt(0)<o2.charAt(0)){
                        return -1;
                    }else {
                        if (o1.length()>o2.length()){
                            return -1;
                        }else
                            return 1;
                    } }
                if (o1.charAt(o1.length()-1)<(o2.charAt(o2.length()-1))){
                    return -1;
                }
                return 0;}
            });
                int dp[]=new int[26];
                for (int i=0;i<26;i++) {
                    dp[i]=0;
                }
                for (int i=0;i<str.size();i++){
                        char endCh=str.get(i).charAt(str.get(i).length()-1);
                        int offset=endCh-'a';

                        char starCh=str.get(i).charAt(0);
                        int curMax=dp[offset];
                        for (int j=0;j+'a'<=starCh;j++){
                            if ( dp[j]+str.get(i).length()>=curMax){
                                curMax= dp[j]+str.get(i).length();
                            }
                        }
                        dp[offset]= curMax>dp[offset]?curMax:dp[offset];
                }
                int max = 0;
                for (int i = 0;i<dp.length;i++){
                    max = max>dp[i]?max:dp[i];
                }
                return max;
            }

    public static void main(String[] args) {
        List list=new ArrayList();

        list.add("be");
        list.add("cdef");
        list.add("aa");
        list.add("aaa");
        System.out.println(Getmaxlen(list));
    }
    }


