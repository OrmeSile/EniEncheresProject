package fr.eni.ecole.encheres.bo.utils;

import java.util.stream.Stream;

public class FilterTags {
	private final boolean query;
	private final boolean cat;
	private final boolean isSell;
	private final boolean isBuySelf;
	private final boolean isOpen;
	private final boolean isBuyWon;
	private final boolean isSellPre;
	private final boolean isSellFin;
	private int count;

	public FilterTags(boolean query, boolean cat, boolean isSell, boolean isOpen, boolean isBuySelf, boolean isBuyWon, boolean isSellPre, boolean isSellFin) {
		this.query = query;
		this.isSell = isSell;
		this.isOpen = isOpen;
		this.isBuySelf = isBuySelf;
		this.isBuyWon = isBuyWon;
		this.cat = cat;
		this.isSellPre = isSellPre;
		this.isSellFin = isSellFin;
		Stream.of(cat, query, isSell, isBuySelf).forEach(b -> {if(b) count++;});
		if(Stream.of(isOpen, isBuyWon, isSellPre, isSellFin).anyMatch(x -> x)){
			count++;
		}
	}

	public boolean isSellPre() {
		return isSellPre;
	}

	public boolean isSellFin() {
		return isSellFin;
	}

	public boolean isQuery() {
		return query;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isCat() {
		return cat;
	}

	public boolean isSell() {
		return isSell;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public boolean isBuySelf() {
		return isBuySelf;
	}

	public boolean isBuyWon() {
		return isBuyWon;
	}
}
