class Solution {
    public int minMoves(String[] classroom, int energy) {
          int m=classroom.length;
        int n=classroom[0].length();
        int sr=0,sc=0;
        int litterCount=0;

        int[][] litterId=new int[m][n];
        for(int[] row:litterId)
            Arrays.fill(row,-1);

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                char ch=classroom[i].charAt(j);

                if(ch=='S') {
                    sr=i;
                    sc=j;
                }

                if(ch=='L') {
                    litterId[i][j]=litterCount++;
                }
            }
        }

        int allCollected=(1<<litterCount)-1;

        boolean[][][][] visited=
            new boolean[m][n][1<<litterCount][energy+1];

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{sr,sc,0,energy,0});
        visited[sr][sc][0][energy]=true;

        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty()) {
            int[] cur=q.poll();

            int r=cur[0];
            int c=cur[1];
            int mask=cur[2];
            int e=cur[3];
            int moves=cur[4];

            if(mask==allCollected)
                return moves;

            for(int d=0;d<4;d++) {
                int nr=r+dr[d];
                int nc=c+dc[d];

                if(nr<0||nr>=m||nc<0||nc>=n)
                    continue;

                if(classroom[nr].charAt(nc)=='X')
                    continue;

                if(e==0)
                    continue;

                int newEnergy=e-1;
                int newMask=mask;

                if(classroom[nr].charAt(nc)=='L') {
                    int id=litterId[nr][nc];
                    newMask|=(1<<id);
                }

                if(classroom[nr].charAt(nc)=='R')
                    newEnergy=energy;

                if(!visited[nr][nc][newMask][newEnergy]) {
                    visited[nr][nc][newMask][newEnergy]=true;
                    q.offer(new int[]{nr,nc,newMask,newEnergy,moves+1});
                }
            }
        }

        return -1;
    }
}