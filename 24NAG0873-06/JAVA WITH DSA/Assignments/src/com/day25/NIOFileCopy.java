package com.day25;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileCopy {

	public static void main(String[] args) {
		try {
			FileChannel sourceChannel = FileChannel.open(Paths.get("C:\\Users\\Administrator\\Desktop\\Text File\\input.txt"), StandardOpenOption.READ);
			FileChannel destinationChannel = FileChannel.open(Paths.get("dest.txt"),
					StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(sourceChannel.read(buffer) > 0) {
				buffer.flip();
				destinationChannel.write(buffer);
				buffer.clear();
			}
			sourceChannel.close();
			destinationChannel.close();
			System.out.println("File copied successfully.");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
