
package simplereflex;

public class Agent {

    private int xCoordinate;
    private int yCoordinate;
    private int score = 0;
    private int step = 0;

    public Agent(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public void BeginCleaning(Environment e) {

        while (score < e.getDirtyPlaceCount()) {
            e.showPlaceWithAgent(xCoordinate, yCoordinate);
            if (e.getPlace(xCoordinate, yCoordinate) == 1) {
                e.cleanPlace(xCoordinate, yCoordinate);
                agentMessage(xCoordinate,yCoordinate,false);
                score++;
            } else {
                agentMessage(xCoordinate,yCoordinate,true);
            }
            int nextMovement = nextMove(e);

            switch (nextMovement) {
                case 1:yCoordinate--;break;
                case 2:yCoordinate++;break;
                case 3:xCoordinate--;break;
                case 4:xCoordinate++;break;
                default:break;
            }
            ++step;
        }
        System.out.println("Completed Agent cleaned in " + step + " step, with " + score + " score!");
    }

    int nextMove(Environment e) {
        // i'm generating new way;
        // 1-> left | 2 -> right | 3-> up | 4-> down
        boolean outOfBoundary = true;
        int moveTo = (int) Math.round(Math.random() * (3) + 1);

        while (outOfBoundary) {

            outOfBoundary = false;


            if (yCoordinate == 0 && moveTo == 1 ||
                    (yCoordinate == e.getY() - 1 && moveTo == 2) ||
                    (xCoordinate == e.getX() - 1 && moveTo == 4) ||
                    (xCoordinate == 0 && moveTo == 3)) {
                //works when out of boundary left side
                moveTo = (int) Math.round(Math.random() * (3) + 1);
                outOfBoundary = true;
            }

        }
        // Ok, path is good go next move
        return moveTo;
    }

    void agentMessage(int xCoordinate, int yCoordinate,boolean cleaned ){

        System.out.println("Agent currently at the location " +  xCoordinate + "-" + yCoordinate );

        if(cleaned){
            System.out.println("No, Location with coordinate " + xCoordinate + "-" + yCoordinate + " already clean!");
        }
        else {
            System.out.println("Yes, Location with coordinate " +  xCoordinate + "-" + yCoordinate + " is cleaned");
        }
        System.out.println("----------------------------------------------------------------");
    }

}

