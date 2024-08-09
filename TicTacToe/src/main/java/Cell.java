
public class Cell {
	private MarkType markType;

	public Cell(MarkType markType) {
		this.markType = markType;
	}
	
	public boolean isEmpty() {
		return markType == MarkType.EMPTY;
	}

	public MarkType getMarkType() {
		return markType;
	}

	public void setMarkType(MarkType markType) {
		if(!isEmpty())
			throw new IllegalArgumentException("Cell is already marked");
		this.markType = markType;
	}


	
	
	
}
