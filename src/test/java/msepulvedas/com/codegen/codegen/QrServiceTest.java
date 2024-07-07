package msepulvedas.com.codegen.codegen;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Base64;

import org.junit.jupiter.api.Test;

import msepulvedas.com.codegen.codegen.model.DatosCodigo;
import msepulvedas.com.codegen.codegen.service.QrService;

public class QrServiceTest {
	
	private QrService qrService = new QrService();
	
	@Test
	void testGenerateQrCode() {
		
		// Arrange 
		DatosCodigo datosCoddigo  = new DatosCodigo("Valor1","Valor2","Valor3","Valor4");
		
		// Act
		String qrCode = qrService.generateQrCode(datosCoddigo);
		
		//Assert
		assertNotNull(qrCode);
		
		// Decodificar el Base64 para verificar la imagen si es necesario
        try {
            byte[] imageBytes = Base64.getDecoder().decode(qrCode.substring("data:image/png;base64,".length()));
            // Aquí puedes realizar más validaciones según tus necesidades

            // Por ejemplo, validar el tamaño de la imagen
            assertTrue(imageBytes.length > 0);

        } catch (IllegalArgumentException e) {
            fail("No se pudo decodificar la imagen Base64");
        }
		
	}
	
}
