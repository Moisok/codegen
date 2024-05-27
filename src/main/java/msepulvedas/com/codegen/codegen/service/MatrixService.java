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
import com.google.zxing.datamatrix.DataMatrixWriter;

import msepulvedas.com.codegen.codegen.model.DatosCodigo;

@Service
public class MatrixService {
	
	public String generateMatrixCode(DatosCodigo matrixData) {
        String matrixContent = matrixData.toString();
        int width = 250;
        int height = 250;

        Hashtable<EncodeHintType, String> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        DataMatrixWriter dataMatrixWriter = new DataMatrixWriter();
        try {
            BitMatrix bitMatrix = dataMatrixWriter.encode(matrixContent, BarcodeFormat.DATA_MATRIX, width, height, hints);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            byte[] matrixCodeBytes = outputStream.toByteArray();
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(matrixCodeBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
