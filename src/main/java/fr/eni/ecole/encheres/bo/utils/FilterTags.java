package fr.eni.ecole.encheres.bo.utils;

import java.util.stream.Stream;

public class FilterTags {
	private final boolean query;
	private final boolean cat;
	private final boolean sell;
	private final boolean buySelf;
	private final boolean open;
	private final boolean buyWon;
	private final boolean sellPre;
	private final boolean sellFin;
	private int count;

	private FilterTags() {
		query = false;
		cat = false;
		sell = false;
		buySelf = false;
		open = true;
		buyWon = false;
		sellPre = false;
		sellFin = false;
		count = 0;
	}

	public static FilterTags getVisitor(boolean query, boolean cat){
		return new FilterTags(query, cat, false, true, false, false, false, false);
	}
	public static FilterTags getEmpty(){
		return new FilterTags();
	}

	public FilterTags(boolean query, boolean cat, boolean sell, boolean open, boolean buySelf, boolean buyWon, boolean sellPre, boolean sellFin) {
		this.query = query;
		this.cat = cat;
		this.open = open;
		this.sell = sell;
		if(sell){
			this.sellPre = sellPre;
			this.sellFin = sellFin;
			this.buySelf = false;
			this.buyWon = false;
		}else {
			this.sellPre = false;
			this.sellFin = false;
			this.buySelf = buySelf;
			this.buyWon = buyWon;
		}
		Stream.of(cat, query, sell, buySelf).forEach(b -> {if(b) count++;});
		if(Stream.of(buyWon, sellPre, sellFin).anyMatch(x -> x)){
			count++;
		}
		if(Stream.of(query, cat, sellPre, sellFin, buyWon, buySelf).noneMatch(x -> x)){
			count = 0;
		}
	}

	public boolean isSellPre() {
		return sellPre;
	}

	public boolean isSellFin() {
		return sellFin;
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
		return sell;
	}

	public boolean isOpen() {
		return open;
	}

	public boolean isBuySelf() {
		return buySelf;
	}

	public boolean isBuyWon() {
		return buyWon;
	}

	@Override
	public String toString() {
		return "FilterTags{" +
				"query=" + query +
				", cat=" + cat +
				", isSell=" + sell +
				", isBuySelf=" + buySelf +
				", isOpen=" + open +
				", isBuyWon=" + buyWon +
				", isSellPre=" + sellPre +
				", isSellFin=" + sellFin +
				", count=" + count +
				'}';
	}
}
