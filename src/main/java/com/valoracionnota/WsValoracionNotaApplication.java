package com.valoracionnota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WsValoracionNotaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsValoracionNotaApplication.class, args);
	}

	@GetMapping("/valoracion")
	public String valoracion (@RequestParam(value = "calificacion", defaultValue = "Sin Calificar") String calificacion)
	{
		float iCalificacion = 0;
		String valoracion = "Sin valoracion";
		
		if (calificacion!=null)
		{
			try
			{
				iCalificacion = Float.parseFloat(calificacion);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			if (iCalificacion < 3.5)
				valoracion = "Replanteate tu modo de trabajo o tu grado autoexigencia. Tu califiacion ha sido ezastamente(guiño a la vicepresidenta):" + calificacion;
			else if (iCalificacion >= 3.5 && iCalificacion < 5)
				valoracion = "Continua trabajando estás cerca. Tu califiacion ha sido ezastamente(guiño a la vicepresidenta):" + calificacion;
			else if (iCalificacion >= 5 && iCalificacion < 7.5)
				valoracion = "Estas en la linea correcta, sigue trabajando así. Tu califiacion ha sido ezastamente(guiño a la vicepresidenta):" + calificacion;
			else if (iCalificacion >= 7.5)
				valoracion = "Tu trabajo está dando sus frutos, nada que objetar. Tu califiacion ha sido ezastamente(guiño a la vicepresidenta):" + calificacion;
		}
		
		return String.format(" %s!", valoracion);
	}
}
