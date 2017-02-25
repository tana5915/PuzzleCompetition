import java.awt.Frame;

public class ContestOrganizer {
	/** the number of rows of contestant */
	public static final int NUM_ROWS = 10;

	/** the number of columns of contestant */
	public static final int CONTESTANTS_PER_ROW = 10;

	/** the two-dimensional array of contestant */
	private Contestant[][] contestants;

	/**
	 * Sorts arr in increasing order by score Postcondition: - arr sorted in
	 * increasing order by score. - Location of each contestant correctly
	 * updated such that column number matches contestant's position in arr.
	 * 
	 * @param arr
	 *            the array to be sorted.
	 */
	public void sort(Contestant[] arr) {
		Contestant temp;
		boolean swap = true;
		while (swap)
		{
			swap=false;
			for (int i = 0; i < arr.length-1; i++) 
			{
				if (arr[i].getScore() > arr[i + 1].getScore()) 
				{
					temp = arr[i];
					arr[i]=arr[i+1];
					arr[i + 1]=temp;
					swap=true;
				}
				
			}
		}
	}

	/**
	 * Sorts each row of contestants into increasing order by score.
	 * Postcondition: Contestant with highest score in row[k] is in the
	 * rightmost column of row[k], 0 <= k < NUM_ROWS
	 */
	public void sortAllRows() {
		for (Contestant[] i : contestants) {
		sort(i);
		}
	}

	/**
	 * Returns name of contestant with highest score Precondition: - Contestants
	 * have not been sorted by score. - Top score is unique - Only one
	 * contestant has the highest score.
	 * 
	 * @return name of contestant with highest score.
	 */
	public String findWinnerName() {
		int highest=Integer.MIN_VALUE;
		
		String winner = null;
		sortAllRows();
		for (int i = 0; i < NUM_ROWS; i++) {
			if(contestants[i][CONTESTANTS_PER_ROW-1].getScore()>highest)
			{
				highest=contestants[i][CONTESTANTS_PER_ROW-1].getScore();
				winner=contestants[i][CONTESTANTS_PER_ROW-1].getName();
			}
			
		}
		
		return winner;
	}
}
