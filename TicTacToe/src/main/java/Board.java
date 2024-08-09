

import java.util.Arrays;

public class Board {
	Cell[] cells = new Cell[9];
	
	public Board() {
		//intialize all cells to MARKTYPE.EMPTY
		for(int i=0;i<cells.length;i++) {
			cells[i] = new Cell(MarkType.EMPTY);
		}
	}
	
	public boolean isBoardFull() {
		for(Cell cell : cells) {
			if(cell.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public void setCellMark(int loc, MarkType markType) {
		cells[loc].setMarkType(markType);
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}

	
	
	
}
