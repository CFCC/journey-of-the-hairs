package com.campcomputer.journeyofthehairs;

import com.campcomputer.journeyofthehairs.entity.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Images {
	private static HashMap<String, byte[]> jaredFiles;

	public static BufferedImage ReadImage(String path) {
		BufferedImage bufferedImage = null;
		CodeSource src = Entity.class.getProtectionDomain().getCodeSource();

		if (src.getLocation().toString().endsWith("jar")) {
			URL url = Images.class.getClassLoader().getResource("images" + path);
			if (url == null) {
				throw new RuntimeException("Couldn't load image: " + path);
			}

			Image image = new ImageIcon(url).getImage();
			if (image == null) {
				return null;
			}

			bufferedImage = getBufferedImage(image);
		} else {
			try {
				URL url = Images.class.getResource(path);
				if (url == null) {
					throw new RuntimeException("Couldn't load image: " + path);
				}

				Image image = new ImageIcon(url).getImage();
				if (image == null) {
					return null;
				}

				bufferedImage = getBufferedImage(image);
			} catch (Exception ex) {
				System.err.println(path);
				ex.printStackTrace();
			}
		}

		return bufferedImage;
	}

	public static List<BufferedImage> ReadFrames(String name) {
		List<BufferedImage> frames = new ArrayList<BufferedImage>();
		CodeSource src = Entity.class.getProtectionDomain().getCodeSource();

		if (src.getLocation().toString().endsWith("jar")) {
			if (jaredFiles == null) {
				loadJarFiles(src);
			}

			try {
				for (String s : jaredFiles.keySet()) {
					if (s.startsWith("images/frames/" + name)) {
						frames.add(ReadImage(jaredFiles.get(s)));
					}
				}
				System.out.println("Loaded " + frames.size() + " frames from jar: " + name);
			} catch (Exception e) {
				System.err.println("Error loading frames from jar: " + name);
			}
		} else {
			File frameDir = new File("images/frames/" + name);

			for (File file : frameDir.listFiles()) {
				if (file.isFile()) {
					frames.add(ReadImage("/frames/" + name + "/" + file.getName()));
				}
			}
		}

		return frames;
	}

	private static BufferedImage getBufferedImage(Image image) {
		BufferedImage bufferedImage;
		bufferedImage = GraphicsEnvironment.getLocalGraphicsEnvironment()
		                                   .getDefaultScreenDevice()
		                                   .getDefaultConfiguration()
		                                   .createCompatibleImage(image.getWidth(null), image.getHeight(null), BufferedImage.TRANSLUCENT);
		bufferedImage.getGraphics().drawImage(image, 0, 0, null);
		return bufferedImage;
	}

	private static BufferedImage ReadImage(byte[] bytes) throws Exception {
		InputStream in = new ByteArrayInputStream(bytes);
		return ImageIO.read(in);
	}

	private static void loadJarFiles(CodeSource src) {
		jaredFiles = new HashMap<String, byte[]>();

		try {
			ZipFile zf = new ZipFile(src.getLocation().getFile());
			HashMap<String, Integer> sizes = new HashMap<String, Integer>();
			Enumeration e = zf.entries();

			while (e.hasMoreElements()) {
				ZipEntry ze = (ZipEntry) e.nextElement();
				sizes.put(ze.getName(), (int) ze.getSize());
			}
			zf.close();

			URL jar = src.getLocation();
			ZipInputStream zis = new ZipInputStream(jar.openStream());
			ZipEntry ze = null;

			while ((ze = zis.getNextEntry()) != null) {
				if (ze.isDirectory()) {
					continue;
				}
				int size = (int) ze.getSize();
				// -1 means unknown size.
				if (size == - 1) {
					size = sizes.get(ze.getName());
				}
				byte[] b = new byte[size];
				int rb = 0;
				int chunk = 0;
				while ((size - rb) > 0) {
					chunk = zis.read(b, rb, size - rb);
					if (chunk == - 1) {
						break;
					}
					rb += chunk;
				}
				jaredFiles.put(ze.getName(), b);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
