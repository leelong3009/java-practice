package com.sample.java8;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) {
		countWord();
	}

	public static void reduction() {
		Stream<Double> values = Stream.generate(Math::random).limit(100);
		List<Integer> intlist = IntStream.range(1, 100).parallel().map(x -> x*2).boxed().collect(Collectors.toList());
		System.out.println(intlist.parallelStream().max(Integer::compare));
	}
	
	public static void countWord() {
		List<String> words = getWordsAsList();
		long countWord = words.parallelStream().filter(w -> w.length() > 12).count();
		System.out.println(countWord);
	}
	
	private static long countConcurrentWithoutStreams(List<String> words) {
        try {
            int cores = Runtime.getRuntime().availableProcessors();
            System.out.println("-- Total cores: " + cores);
            int chunkSize = words.size() / cores;
            List<List<String>> chunks = new LinkedList<>();
            for (int i = 0; i < words.size(); i += chunkSize) {
                chunks.add(words.subList(i, i + Math.min(chunkSize, words.size() - i)));
            }
            ExecutorService pool = Executors.newFixedThreadPool(cores);
            Set<Future<Long>> set = new HashSet<>();
            for (List<String> strings : chunks) {
                Callable<Long> callable = () -> {
                    long chunkCount = 0;
                    for (String string : strings) {
                        if (string.length() > 12) chunkCount++;
                    }
                    return chunkCount;
                };
                Future<Long> future = pool.submit(callable);
                set.add(future);
            }
            long count = 0;
            for (Future<Long> future : set) {
                count += future.get();
            }
            pool.shutdown();
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	private static List<String> getWordsAsList() {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(StreamAPI.class.getResource("/alice.txt").toURI())), StandardCharsets.UTF_8);
            return Arrays.asList(content.split("[\\P{L}]+"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
