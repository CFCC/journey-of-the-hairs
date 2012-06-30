package com.campcomputer;

import javax.swing.ImageIcon;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Images {
	public static BufferedImage ReadImage(String path) {
		BufferedImage bufferedImage = null;
		try {
			path = "/" + path;
			URL url = Images.class.getResource(path);
			if (url == null) {
				throw new RuntimeException("Couldn't load image: " + path);
			}

			Image image = new ImageIcon(url).getImage();
			if (image == null)
				return null;

			bufferedImage = GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice().
							getDefaultConfiguration().
							createCompatibleImage(image.getWidth(null), image.getHeight(null), BufferedImage.TRANSLUCENT);
			bufferedImage.getGraphics().drawImage(image, 0, 0, null);
		} catch (Exception ex) {
			System.err.println(path);
			ex.printStackTrace();
		}
		return bufferedImage;
	}
}
