package com.ngpanwei.akka.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AkkaUtil {
	public static void clearJournal() {
		try {
			// FileUtils.deleteDirectory(new File("/Users/pwng/code/akka/akka-sample/target/example"));
			delete(new File("target/example")) ;
			System.out.println("Journal deleted");
		} catch(Exception ignore) {
			System.out.println("Folder does not exist");
		}		
	}
	public static void delete(File f) throws IOException {
		if (f.isDirectory()) {
			for (File c : f.listFiles())
				delete(c);
		}
		if (!f.delete())
			throw new FileNotFoundException("Failed to delete file: " + f);
	}
}
