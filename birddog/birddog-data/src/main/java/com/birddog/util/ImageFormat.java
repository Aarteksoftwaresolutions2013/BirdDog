package com.birddog.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class ImageFormat {

    public static String readImage(String name) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File(IConstant.BIRDDOG_IMAGES + name));
        String format = IConstant.JPG;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String imageString = null;
        String encodedImage = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, format, bos);
            byte[] imageBytes = bos.toByteArray();
            encodedImage = base64Encoder.encode(imageBytes);
            imageString = "data:image/" + format + ";base64," + encodedImage;
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String readReiImage(String name) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(new File(IConstant.REINVESTOR_IMAGES + name));
        String format = IConstant.JPG;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String imageString = null;
        String encodedImage = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, format, bos);
            byte[] imageBytes = bos.toByteArray();
            encodedImage = base64Encoder.encode(imageBytes);
            imageString = "data:image/" + format + ";base64," + encodedImage;
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String readBirddogProfileImage(String imageName) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(IConstant.BIRDDOG_PROFILE_IMAGES + imageName));
        String format = IConstant.JPG;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String imageString = null;
        String encodedImage = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, format, bos);
            byte[] imageBytes = bos.toByteArray();
            encodedImage = base64Encoder.encode(imageBytes);
            imageString = "data:image/" + format + ";base64," + encodedImage;
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String readSuperAdminImage(String imageName) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(IConstant.SUPER_ADMIN_IMAGES + imageName));
        String format = IConstant.JPG;
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String imageString = null;
        String encodedImage = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, format, bos);
            byte[] imageBytes = bos.toByteArray();
            encodedImage = base64Encoder.encode(imageBytes);
            imageString = "data:image/" + format + ";base64," + encodedImage;
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

}
