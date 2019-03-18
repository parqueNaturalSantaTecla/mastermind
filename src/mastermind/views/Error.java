package mastermind.views;

enum Error {
	
	DUPLICATED("Colores repetidos"),
	WRONG_CHARACTERS("Colores erróneos, tienen que ser: " + Color.allInitials()),
	WRONG_LENGTH("Error en la longitud de la combinación");
	
	private String message;
	
	private Error(String message) {
		this.message = message;
	}
	
	String getMessage() {
		return this.message;
	}
	
}
