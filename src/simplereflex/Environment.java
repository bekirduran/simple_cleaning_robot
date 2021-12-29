
package simplereflex;


public class Environment {

    public static int[][] place ;
    private int dirtyPlaceCount = 0;
    private final int x;
    private final int y;

    public Environment(int x, int y) {
        this.x = x;
        this.y = y;
        place = new int[this.x][this.y];

        // generating random place
        for(int r=0;r<x;r++){
            for(int c=0;c<y;c++){
                place[r][c]= ((int) Math.round(Math.random()));
                if(place[r][c]==1){
                    dirtyPlaceCount++;
                }
            }
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void showPlaceWithAgent(int agentX, int agentY){

        for(int r=0;r<x;r++){
            for(int c = 0; c<y;c++){

                if(agentX == r && agentY == c){
                    System.out.print("X" + " ");
                }else{
                    System.out.print(place[r][c] + " ");
                }
            }
            System.out.print("\n");
        }
    }

    public int getPlace(int x,int y) {
        return place[x][y];
    }
    
    public void cleanPlace(int x, int y) {
            place[x][y]=0;
    }

    public int getDirtyPlaceCount() {
        return dirtyPlaceCount;
    }
    
    
    
}
