package org.solid.reader;

public class ReaderFactory {
	public static IReader getReaderInstance(String readerType) {
		switch (readerType) {
		case "excel":
			return new ExcelReader();
		case "txt":
			return new TextReader();
		default:
			return null;
		}
	}
}
