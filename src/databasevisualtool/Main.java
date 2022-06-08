package databasevisualtool;

import java.net.URL;
/*
import java.nio.file.Path;
import java.nio.file.Paths;
*/

public class Main {
	/*
	Path source = Paths.get("mnist_png.zip");
	Path target = Paths.get("mnist_png");
	*/
	public static void main(String[] args) throws Exception {
		System.out.println("Downloading and extracting. Please wait...");
		URL archiveLocation = new URL("https://www.dl.dropboxusercontent.com/s/m35qr6qezyeq87z/mnist_png.zip?dl=0");
		DownloadFile.downloadFile(archiveLocation, "mnist_png.zip");
		/*
		Path source = Paths.get("SwingMenu\\mnist_png.zip");
		Path target = Paths.get("SwingMenu\\mnist_png");
		ExtractFolder.decompressGzipNio(source, target);
		*/
		ExtractFolder.extractFolder("mnist_png.zip", "res");
		MyFrame myFrame = new MyFrame();
	}

}