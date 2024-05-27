package msepulvedas.com.codegen.codegen.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import msepulvedas.com.codegen.codegen.model.DatosCodigo;

@Service
public class BarcodeService {
	
	public String generateBarcode(DatosCodigo barcodeData) {
        String barcodeContent = barcodeData.toString();
        int width = 250;
        int height = 250;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(barcodeContent, BarcodeFormat.CODE_128, width, height);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            byte[] barcodeBytes = outputStream.toByteArray();
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(barcodeBytes);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
