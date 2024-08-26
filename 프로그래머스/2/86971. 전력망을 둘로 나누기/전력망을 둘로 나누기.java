import java.util.*;

class Solution {
    public int countNode(int [][]edges,int focus, boolean[] visited, int count){  
        //System.out.println(focus);
        for(int i=0;i < edges.length;i++){
            if(!visited[i]){

                if(edges[i][0] == focus){  
                    visited[i]=true;
                    count = countNode(edges,edges[i][1],visited,count+1);
                }
                else if(edges[i][1] == focus){
                    visited[i]=true;
                    count = countNode(edges,edges[i][0],visited,count+1);
                }

            }


        }

        return count;
    }
    public int solution(int n, int[][] wires) {
        int answer = 99999;
//         boolean[] checkVisited = new boolean[wires.length];

//         System.out.println("갯수: "+ countNode(wires,4,checkVisited,1));

        for(int i=0;i<wires.length;i++){    
            int[][] tmp=new int[wires.length-1][2];
            for(int j=0,k=0;j<wires.length-1;j++,k++){
                if(i==j)k++;
                tmp[j][0]=wires[k][0];
                tmp[j][1]=wires[k][1];
            }
            int A = wires[i][0], B=wires[i][1], countA=0, countB =0, countABS=99999;                    
            boolean[] checkVisited = new boolean[wires.length];

            countA = countNode(tmp,A,checkVisited,1);
            countB = countNode(tmp,B,checkVisited,1);

            countABS= Math.abs(countA-countB);
            if(answer>countABS){
                answer=countABS;

            }

        }



        return answer;
    }
}