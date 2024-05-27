package msepulvedas.com.codegen.codegen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.aztec.AztecWriter;

import msepulvedas.com.codegen.codegen.model.DatosCodigo;
import msepulvedas.com.codegen.codegen.service.AztecService;
import msepulvedas.com.codegen.codegen.service.BarcodeService;
import msepulvedas.com.codegen.codegen.service.MatrixService;
import msepulvedas.com.codegen.codegen.service.QrService;

@RestController
@RequestMapping("/generarcodigo")
public class MostrarCodigos {
	
	 @Autowired
	 private QrService qrService;
	 
	 @Autowired
	 private BarcodeService barcodeService;
	 
	 @Autowired
	 private AztecService aztecService;
	 
	 @Autowired
	 private MatrixService matrixService;

	 @PostMapping("/qr")
	  public String recogerDatosQr(@RequestBody DatosCodigo qrData) {
	      String qrCodeBase64 = qrService.generateQrCode(qrData);
	      return qrCodeBase64 != null ? qrCodeBase64 : "Error al generar codigo qr, intentalo de nuevo";
	  }
	 
	 @PostMapping("/barcode")
	  public String recogerDatosBarcode(@RequestBody DatosCodigo barcodeData) {
	      String barcodeCodeBase64 = barcodeService.generateBarcode(barcodeData);
	      return barcodeCodeBase64 != null ? barcodeCodeBase64 : "Error al generar codigo de barras, intentalo de nuevo";
	  }
	 
	 @PostMapping("/aztec")
	  public String recogerDatosAztec(@RequestBody DatosCodigo aztecData) {
	      String barcodeCodeBase64 = aztecService.generateAztecCode(aztecData);
	      return barcodeCodeBase64 != null ? barcodeCodeBase64 : "Error al generar codigo aztec, intentalo de nuevo";
	  }
	 
	 @PostMapping("/matrix")
	  public String recogerDatosMatrix(@RequestBody DatosCodigo matrixData) {
	      String barcodeCodeBase64 = matrixService.generateMatrixCode(matrixData);
	      return barcodeCodeBase64 != null ? barcodeCodeBase64 : "Error al generar codigo matrix, intentalo de nuevo";
	  }
	
	 
	/*@GetMapping("/enviarqr")
	public String pruebas() {
		return "Esto es una prueba 2";
	}*/
	
}
