package com.learn.threads.topic17.q17;

public class ImageProcessorSimulator {

    public String[][] uploadImage(String imageName) {
        System.out.println("Image " + imageName + " uploaded successfully...");

        // Create the 2D array
        String[][] pixelArray2D = new String[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                // Simulate crating pixel 2d array using uploaded image
                String imageId = String.valueOf(y) + String.valueOf(x);
                String pix = imageName + "-" + imageId;

                pixelArray2D[y][x] = pix; // image pixel
                System.out.print("2D Array with " + y + " rows and " + x + " columns:");
                System.out.print(pixelArray2D[y][x] + " ");
                System.out.println();
            }
            System.out.println();
        }
        return pixelArray2D;
    }

    public void processImage(String[][] input, String[][] output, int numThreads) throws InterruptedException {
        int rowCount = input.length;

        Thread[] threads = new Thread[numThreads];
        long[] startTimes = new long[numThreads];
        long[] endTimes = new long[numThreads];

        int rowsPerThread = (int) Math.ceil((double) rowCount / numThreads);

        for (int i = 0; i < numThreads; i++) {
            final int threadIndex = i;
            final int startRow = i * rowsPerThread;
            final int endRow = Math.min(startRow + rowsPerThread, rowCount);

            threads[i] = new Thread(() -> {
                //startTimes[threadIndex] = System.currentTimeMillis();
                startTimes[threadIndex] = System.nanoTime();

                for (int row = startRow; row < endRow; row++) {
                    for (int col = 0; col < input[row].length; col++) {
                        System.out.println("Thread " + threadIndex + " processed pixel " + input[row][col]);
                        output[row][col] = input[row][col] + "-0xFFFF0000";
                    }
                }

                //endTimes[threadIndex] = System.currentTimeMillis();
                endTimes[threadIndex] = System.nanoTime();
                System.out.println("Thread " + threadIndex + " processed rows " + startRow + " to " + (endRow - 1)
                        + " in " + (endTimes[threadIndex] - startTimes[threadIndex]) + " ns");
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long minStart = startTimes[0];
        long maxEnd = endTimes[0];
        for (int i = 1; i < numThreads; i++) {
            if (startTimes[i] < minStart) minStart = startTimes[i];
            if (endTimes[i] > maxEnd) maxEnd = endTimes[i];
        }

        System.out.println("Total Thread Execution Time (start of first to end of last): " + (maxEnd - minStart) + " ns");
    }

    public static void main(String[] args) throws InterruptedException {
        ImageProcessorSimulator simulator = new ImageProcessorSimulator();

        String[][] inputPixels = simulator.uploadImage("ImageOne");
        String[][] outputPixels = new String[3][3];

        long startTime = System.currentTimeMillis();

        simulator.processImage(inputPixels, outputPixels, 2); // Use two threads

        long endTime = System.currentTimeMillis();
        System.out.println("Total Execution Time [main thread]: " + (endTime - startTime) + " ms");

        System.out.println("Processed Image:");
        for (String[] row : outputPixels) {
            for (String pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }

    }

}
