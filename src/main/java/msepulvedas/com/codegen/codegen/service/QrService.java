package msepulvedas.com.codegen.codegen.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import msepulvedas.com.codegen.codegen.model.DatosCodigo;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Hashtable;

@Service
public class QrService {

    public String generateQrCode(DatosCodigo qrData) {
        String qrContent = qrData.toString();
        int width = 250;
        int height = 250;

        Hashtable<EncodeHintType, String> hintFs = new Hashtable<>();
        //hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, width, height/*, hints*/);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            byte[] qrCodeBytes = outputStream.toByteArray();
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(qrCodeBytes);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

