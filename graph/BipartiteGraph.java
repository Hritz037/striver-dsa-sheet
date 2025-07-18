class Solution {
    public boolean dfs(int[][] graph, int x,int color[],int toBeColored){
        color[x]=toBeColored;
        for(int i=0;i<graph[x].length;i++){
            if(color[graph[x][i]]==toBeColored)return false;
            else if(color[graph[x][i]]==0){
                if(dfs(graph,graph[x][i],color,toBeColored==1?2:1)==false)return false;
                //remember to return it here if the result is false;
            }
        }return true;

    }
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<color.length;i++){
            if(color[i]==0){
                if(dfs(graph,i,color,1)==false)return false;
            }
        }return true;
    }
}