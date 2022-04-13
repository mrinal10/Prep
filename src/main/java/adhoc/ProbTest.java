package adhoc;

/*Problem statement : Design UI for a hospital admin
        In a hospital ward, there are multiple medical equipments that communicate "vital" information of the patient.
        These vitals are "pushed" from equipment at different frequencies ranging from once per 5 minutes to 1000 times per second.
        As an admin, you always want to look at the most recent vital data for all the patients and data should not be updated any faster than 1 second.

                    Vital1		    Vital2		       Vital3		...		Vital10
        Pt1	       (x=1,y=1)	   (x=1,y=2)	      (x=1,y=3)
        Pt2	        (x=2,y=1)	...
        Pt3	        (x=3,y=1)	...
        ...
        Pt10

        A simple solution is described below. Identify issues with this and fix this solution.


public interface IDataFetcher {

     * (x,y) are the coordinates of the grid where data is to be printed
     * data is the actual output to be printed

     void onUpdate(int x, int y, String data);
}

class DisplayGrid implements IDataFetcher {
   TimeStamp[][] lastDisplayed;
    String[][] updatedDisplay;
    public DisplayGrid() {
        lastDisplayed = new TimeStamp[x][y];
        /*
         * DataSource works on a pub/sub model where in it accepts
         * an object that implements IDataFetcher and pushes data
         * to overriden function onUpdate. For eg:
         * onUpdate(1,2,"NORMAL"); // When Vital2 for Pt1 is updated to "NORMAL"
         * onUpdate(3,1,"125"); // When Vital1 for Pt3 is updated to "125"

        DataSource.connect(this);
    }

    public void refresh() {
        int numRows = lastDisplayed.length;
        int numCols = lastDisplayed[0].length;

        for(int i=0; i<numRows; i++) {
            for (int j = 0; j <numCols; j++) {
                if(updatedDisplay[i][j]!=null) {
                    Synchronized {
                        print(i, j, updatedDisplay[i][j]);
                        updatedDispla[i][j] = null;
                    }
                }
            }
        }
    }

    @Override
    public void onUpdate(int x, int y, String data) {
        updatedDisplay[x][y] = data;
       /* if(lastDisplayed[x][y] + configuredFreq <= currentTimeStamp) {
            print(x, y, data);
            lastDisplayed[x][y] = currentTimeStamp;
        }*/
    /*}

    /*private void print(int x, int y, String data) {

         * Implementation for printing data onto the grid is already done
         * by another developer.
         * This function can be assumed to complete in < 0.01 milliseconds.

    }
} */