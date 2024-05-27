package msepulvedas.com.codegen.codegen.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;


import msepulvedas.com.codegen.codegen.model.DatosCodigo;

@Service
public class AztecService {
	
	public String generateAztecCode(DatosCodigo aztecData) {
        String aztecContent = aztecData.toString();
        int width = 250;
        int height = 250;
        Hashtable<EncodeHintType, String> hintFs = new Hashtable<>();
        //hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        AztecWriter aztecWriter = new AztecWriter();
        try {
            BitMatrix bitMatrix = aztecWriter.encode(aztecContent, BarcodeFormat.AZTEC, width, height/*, hints*/);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            byte[] aztecCodeBytes = outputStream.toByteArray();
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(aztecCodeBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
