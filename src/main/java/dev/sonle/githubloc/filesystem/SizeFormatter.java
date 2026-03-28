package dev.sonle.githubloc.filesystem;

public class SizeFormatter {

    private static long KB = 1024;
    private static long MB = KB * 1024;
    private static long GB = MB * 1024;

    public String convertSize(long sizeInByte) {
        // if size < 100KB -> get size in KB
        if (sizeInByte < 100 * KB) {
            return String.format("%.2f KB", getSizeInKB(sizeInByte));
        } 
        // if size >= 100KB and < 1GB -> get size in MB
        else if (sizeInByte < GB) {
            return String.format("%.2f MB", getSizeInMB(sizeInByte));
        } 
        // if size >= 1GB, get size in GB
        else {
            return String.format("%.2f GB", getSizeInGB(sizeInByte));
        }
    }

    public float getSizeInKB(long sizeInByte) {
        return (float) sizeInByte / KB;
    }

    public float getSizeInMB(long sizeInByte) {
        return (float) sizeInByte / MB;
    }

    public float getSizeInGB(long sizeInByte) {
        return (float) sizeInByte / GB;
    }
}
