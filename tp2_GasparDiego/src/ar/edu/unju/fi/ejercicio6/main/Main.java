package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		FelinoSalvaje tanner = new FelinoSalvaje("Tanner", (byte)20, 186f);
		
		if (Converter.isNotNull(tanner)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			FelinoDomestico felino = converter.convert(tanner);
			converter.mostrarObjeto(felino);
		} else {
            System.out.println("El objeto a convertir es nulo.");
        }
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);
		
		converter.mostrarObjeto(felino1);
	}

}
