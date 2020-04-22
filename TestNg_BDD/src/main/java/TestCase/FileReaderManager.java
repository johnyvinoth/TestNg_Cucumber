package TestCase;

import TestCase.ReadConfig;

public class FileReaderManager {
 
 private static FileReaderManager fileReaderManager = new FileReaderManager();
 private static ReadConfig configFileReader;
 
 private FileReaderManager() {
 }
 
 public static FileReaderManager getInstance( ) {
       return fileReaderManager;
 }
 
 public ReadConfig getConfigReader() {
 return (configFileReader == null) ? new ReadConfig() : configFileReader;
 }
}
