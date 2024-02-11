package com.ggar.core.logging.adapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ResourceBundleService {

	public Map<Path, WatchKey> load(Path root) throws IOException, InterruptedException {
		WatchService watcher = FileSystems.getDefault().newWatchService();
		root.register(watcher, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW);

		WatchKey key;
		while ((key = watcher.take()) != null) {
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
			}
			key.reset();
		}

		return null;
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		ResourceBundleService service = new ResourceBundleService();
		Path root = Path.of("/home/ubuntu/Desktop/test");
		service.load(root);

		service.load(root);
	}
}
