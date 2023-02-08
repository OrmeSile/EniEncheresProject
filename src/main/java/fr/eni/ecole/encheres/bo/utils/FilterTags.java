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

	private FilterTags() {
		query = false;
		cat = false;
		isSell = false;
		isBuySelf = false;
		isOpen = true;
		isBuyWon = false;
		isSellPre = false;
		isSellFin = false;
		count = 0;
	}
	public static FilterTags getEmpty(){
		return new FilterTags();
	}

	public FilterTags(boolean query, boolean cat, boolean isSell, boolean isOpen, boolean isBuySelf, boolean isBuyWon, boolean isSellPre, boolean isSellFin) {
		this.query = query;
		this.cat = cat;
		this.isOpen = isOpen;
		this.isSell = isSell;
		if(isSell){
			this.isSellPre = isSellPre;
			this.isSellFin = isSellFin;
			this.isBuySelf = false;
			this.isBuyWon = false;
		}else {
			this.isSellPre = false;
			this.isSellFin = false;
			this.isBuySelf = isBuySelf;
			this.isBuyWon = isBuyWon;
		}
		Stream.of(cat, query, isSell, isBuySelf).forEach(b -> {if(b) count++;});
		if(Stream.of(isBuyWon, isSellPre, isSellFin).anyMatch(x -> x)){
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
