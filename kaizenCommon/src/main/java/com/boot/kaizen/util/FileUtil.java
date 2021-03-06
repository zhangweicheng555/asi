package com.boot.kaizen.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.UUID;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件工具类
 * 
 * @author a-zhangweicheng
 *
 */
public class FileUtil {

	/**
	 * 數據庫 保存 pathname
	 * 
	 * 
	 * 前段 <img alt="" src="/statics/lte/e649f951-b375-4b82-85c6-331738d92117.png">
	 * 
	 * lte 是模塊名字
	 */

	public static String UpFile(MultipartFile file, String filesPath, String modelName) {
		modelName = "image";// 写死处理
		if (file != null) {
			String fileOrigName = file.getOriginalFilename();
			fileOrigName = getOriginalFilename(fileOrigName);
			String pathname = "/" + modelName + "/" + MyDateUtil.getNowDate("yyyyMMddHHmmss") + "_"
					+ UUID.randomUUID().toString() + fileOrigName;
			return saveFile(file, filesPath + pathname, pathname);
		}
		return null;
	}

	/**
	 * 根据上传的文件MultipartFile 原始名字得到上传的文件的名字
	* @Description: TODO
	* @author weichengz
	* @date 2019年3月17日 上午10:53:16
	 */
	public static String getOriginalFilename(String fileOrigName) {
		if (StringUtils.isNoneBlank(fileOrigName)) {
			if (!fileOrigName.contains(".")) {
				throw new IllegalArgumentException("缺少后缀名");
			}
		}
		return fileOrigName.substring(fileOrigName.lastIndexOf("."));
	}
	public static String getFilenameByOriginal(String fileOrigName) {
		if (StringUtils.isNoneBlank(fileOrigName)) {
			if (!fileOrigName.contains(".")) {
				throw new IllegalArgumentException("缺少后缀名");
			}
		}
		return fileOrigName.substring(fileOrigName.lastIndexOf("/")+1);
	}
	
	public static String saveFile(MultipartFile file, String fullname, String pathname) {
		try {
			File targetFile = new File(fullname);
			if (targetFile.exists()) {
				targetFile.delete();
				// return pathname;
			}

			if (!targetFile.getParentFile().exists()) {
				targetFile.getParentFile().mkdirs();
			}
			file.transferTo(targetFile);
			return pathname;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new IOException("文件上传异常");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 
	 * @Description: dbFileName 数据库存储的文件的路径
	 * @author weichengz
	 * @date 2019年2月13日 上午11:57:19
	 */
	public static boolean deleteFileByName(String basePath, String dbFileName) {
		String pathName = basePath + dbFileName;
		File file = new File(pathName);
		if (file.exists()) {
			boolean flag = file.delete();

			if (flag) {
				File[] files = file.getParentFile().listFiles();
				if (files == null || files.length == 0) {
					file.getParentFile().delete();
				}
			}

			return flag;
		}

		return false;
	}

	public static boolean deleteFile(String pathname) {
		File file = new File(pathname);
		if (file.exists()) {
			boolean flag = file.delete();

			if (flag) {
				File[] files = file.getParentFile().listFiles();
				if (files == null || files.length == 0) {
					file.getParentFile().delete();
				}
			}

			return flag;
		}

		return false;
	}

	public static String fileMd5(InputStream inputStream) {
		try {
			return DigestUtils.md5Hex(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String getPath() {
		return "/" + LocalDate.now().toString().replace("-", "/") + "/";
	}

	public static String getPath(String modelName) {
		return "/" + modelName + "/";
	}

	/**
	 * 将文本写入文件
	 * 
	 * @param value
	 * @param path
	 */
	public static void saveTextFile(String value, String path) {
		FileWriter writer = null;
		try {
			File file = new File(path);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			writer = new FileWriter(file);
			writer.write(value);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getText(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}

		try {
			return getText(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String getText(InputStream inputStream) {
		InputStreamReader isr = null;
		BufferedReader bufferedReader = null;
		try {
			isr = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(isr);
			StringBuilder builder = new StringBuilder();
			String string;
			while ((string = bufferedReader.readLine()) != null) {
				string = string + "\n";
				builder.append(string);
			}

			return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	/**
	 * 下载本地文件
	 */
	public static void downLocalFile(javax.servlet.http.HttpServletResponse response, String filePath)
			throws FileNotFoundException {
		File file = new File(filePath);
		if (file.exists()) {
			// 读到流中
			InputStream inStream = new FileInputStream(filePath);// 文件的存放路径
			try {
				String name = UUID.randomUUID().toString().replace("-", "") + filePath.substring(filePath.indexOf("."));
				// 设置输出的格式
				response.reset();
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment; filename=" + name + ";filename*=utf-8");
				// 循环取出流中的数据
				byte[] b = new byte[200];
				int len;
				while ((len = inStream.read(b)) > 0)
					response.getOutputStream().write(b, 0, len);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
