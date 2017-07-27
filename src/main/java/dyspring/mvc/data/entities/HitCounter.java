package dyspring.mvc.data.entities;

public class HitCounter {

	private int hits;
	
	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * @param hits the hits to set
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}

	public HitCounter() {
		// TODO Auto-generated constructor stub
		System.out.println("Hit counter intantiated.");
	}	

}
