package com.campcomputer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Images {
	public static BufferedImage ReadImage(String path) {
		URL url = Images.class.getClassLoader().getResource(path);
		if (url == null) {
			throw new RuntimeException("Couldn't load image: " + path);
		}

		Image image = new ImageIcon(url).getImage();
		if (image == null)
			return null;
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice().
							getDefaultConfiguration().
							createCompatibleImage(image.getWidth(null), image.getHeight(null), BufferedImage.TRANSLUCENT);
			bufferedImage.getGraphics().drawImage(image, 0, 0, null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bufferedImage;
	}
}
