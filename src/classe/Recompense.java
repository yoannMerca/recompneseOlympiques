package classe;

public enum Recompense {
	MEDAILLE_OR("Medaille d'or"),
	MEDAILLE_ARGENT("Medaille d'argent"),
	MEDAILLE_BRONZE("Medaille de bronze");
	String recompense;

	private Recompense(String recompense) {
		this.recompense = recompense;
	}

	public String getRecompense() {
		return recompense;
	}

	public void setRecompense(String recompense) {
		this.recompense = recompense;
	}
}
