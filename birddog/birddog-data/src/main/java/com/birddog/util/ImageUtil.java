package com.birddog.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	/**
	 * Save multiple images on folder
	 * 
	 * @param files
	 * @param leadId
	 * @return list of images name
	 */
	public static List<String> saveImages(MultipartFile[] files, Integer leadId) {
		String fileName = null;
		List<String> imageList = new ArrayList<String>();
		if (files != null && files.length > IConstant.ZERO) {
			for (int i = 0; i < files.length; i++) {
				try {
					if (files[i].getSize() > IConstant.ZERO) {
						fileName = files[i].getOriginalFilename();
						byte[] bytes = files[i].getBytes();
						BufferedOutputStream buffStream = new BufferedOutputStream(
								new FileOutputStream(new File(
										IConstant.BIRDDOG_IMAGES + leadId + "_"
												+ fileName)));
						imageList.add(leadId + "_" + fileName);
						buffStream.write(bytes);
						buffStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return imageList;
	}

	/* single image upload */

	public static String saveReInvestorImage(MultipartFile file, Integer reiId) {
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(

				new FileOutputStream(new File(IConstant.REINVESTOR_IMAGES
						+ reiId + "_" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				return reiId + "_" + fileName;
			} catch (Exception e) {
				return IConstant.FAILED;
			}
		} else {
			return IConstant.EMPTY_FILE;
		}
	}

	public static String saveBirddogImage(MultipartFile file, Integer birddogId) {
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(

				new FileOutputStream(new File(IConstant.BIRDDOG_PROFILE_IMAGES
						+ birddogId + "_" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				return birddogId + "_" + fileName;
			} catch (Exception e) {
				return IConstant.FAILED;
			}
		} else {
			return IConstant.EMPTY_FILE;
		}
	}

	public static String saveSuperAdminImage(MultipartFile file,
			Integer superAdminId) {
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(

				new FileOutputStream(new File(IConstant.SUPER_ADMIN_IMAGES
						+ superAdminId + "_" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				return superAdminId + "_" + fileName;
			} catch (Exception e) {
				return IConstant.FAILED;
			}
		} else {
			return IConstant.EMPTY_FILE;
		}
	}

	public static String uploadSuperAdminVideo(MultipartFile file,
			Integer superAdminId) {
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(

				new FileOutputStream(new File(IConstant.SUPER_ADMIN_VIDEO
						+ superAdminId + "_" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				return superAdminId + "_" + fileName;
			} catch (Exception e) {
				return IConstant.FAILED;
			}
		} else {
			return IConstant.EMPTY_FILE;
		}
	}

	public static String savePdf(MultipartFile file, Integer Id) {
		String fileName = null;
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(

				new FileOutputStream(new File(IConstant.PDF_AND_SW_PATH + Id + "_"
						+ fileName)));
				buffStream.write(bytes);
				buffStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Id + "_" + fileName;
		} else {
			return IConstant.EMPTY_FILE;
		}
	}
	public static void downloadAttachment(String fileName,HttpServletResponse response) {
		try {
			File file = new File(IConstant.PDF_AND_SW_PATH+ "//" + fileName);
			BufferedInputStream inputStream = new BufferedInputStream(
					new FileInputStream(file));
			PrintWriter out = response.getWriter();
			response.setContentType("application/xlsx");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ fileName + "");
			int readData;
			while ((readData = inputStream.read()) != -1) {
				out.write(readData);
			}
			inputStream.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
